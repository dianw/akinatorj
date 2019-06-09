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

import org.codenergic.akinatorj.model.NewSessionResponse;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AkinatorJTest {
	private AkinatorJ akinatorJ = new AkinatorJ();

	@Test
	public void testNewSession() throws IOException {
		NewSession newSession = new NewSession(akinatorJ);
		SessionInfo sessionInfo = newSession.getSessionInfo();
		assertThat(sessionInfo.getUid()).isNotBlank()
				.containsPattern("[0-9a-fA-F]{8}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{12}");
		assertThat(sessionInfo.getFrontAddr()).isNotBlank();

		NewSessionResponse resp = newSession.newSession("");
		assertThat(resp.getCompletion()).isEqualTo("OK");
	}
}
