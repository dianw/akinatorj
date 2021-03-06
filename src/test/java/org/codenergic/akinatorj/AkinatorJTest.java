/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.codenergic.akinatorj;

import org.codenergic.akinatorj.model.ListParameters;
import org.codenergic.akinatorj.model.StepInformation;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import static org.assertj.core.api.Assertions.assertThat;

public class AkinatorJTest {
	private final AkinatorJ akinatorJ;

	public AkinatorJTest() {
		HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
		httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
		akinatorJ = new AkinatorJ(new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build(),
				new ObjectMapper());
	}

	@Test
	public void testNewSessionAndAnswer() {
		Session session = akinatorJ.newSession("en");
		assertThat(session).isInstanceOf(SessionImpl.class);
		assertThat(((SessionImpl) session).getSessionInfo().getUid()).isNotBlank()
				.containsPattern("[0-9a-fA-F]{8}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{12}");
		assertThat(((SessionImpl) session).getSessionInfo().getFrontAddr()).isNotBlank();
		assertThat(session.getNewSessionResponse().getCompletion()).isEqualTo("OK");
		assertThat(session.getNewSessionResponse().getParameters().getStepInformation().getStep()).isEqualTo("0");
		assertThat(session.getCompletion()).isEqualTo("OK");
		assertThat(session.getProgression()).isLessThanOrEqualTo(.0);

		StepInformation stepInformation = session.answer(0);
		assertThat(stepInformation.getStep()).isEqualTo("1");
		assertThat(session.getCurrentStepInformation()).isEqualTo(stepInformation);
		assertThat(session.getProgression()).isGreaterThan(.0);

		StepInformation backStepInformation = session.back();
		assertThat(session.getCurrentStepInformation()).isEqualTo(backStepInformation);

		session.answer(0);
		ListParameters listParameters = session.win();
		assertThat(listParameters.getElements()).isNotNull();
	}
}