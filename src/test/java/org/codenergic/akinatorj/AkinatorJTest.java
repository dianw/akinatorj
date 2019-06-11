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

import java.io.IOException;

import org.codenergic.akinatorj.model.StepInformation;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AkinatorJTest {
	private AkinatorJ akinatorJ = new AkinatorJ();

	@Test
	public void testNewSessionAndAnswer() throws IOException {
		Session session = akinatorJ.newSession("");
		assertThat(session.getSessionInfo().getUid()).isNotBlank()
				.containsPattern("[0-9a-fA-F]{8}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{12}");
		assertThat(session.getSessionInfo().getFrontAddr()).isNotBlank();
		assertThat(session.getNewSessionResponse().getCompletion()).isEqualTo("OK");
		assertThat(session.getNewSessionResponse().getParameters().getStepInformation().getStep()).isEqualTo("0");

		Step step = new Step(session);
		StepInformation stepInformation = step.answer(0);
		assertThat(stepInformation.getStep()).isEqualTo("1");
		assertThat(session.getCurrentStepInformation()).isEqualTo(stepInformation);

		StepInformation backStepInformation = step.back();
		assertThat(backStepInformation.getStep()).isEqualTo("0");
		assertThat(session.getCurrentStepInformation()).isEqualTo(backStepInformation);
	}
}