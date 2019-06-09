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
package org.codenergic.akinatorj.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewSessionResponse {
	private String completion;
	private NewSessionParameters parameters;

	public String getCompletion() {
		return completion;
	}

	public void setCompletion(String completion) {
		this.completion = completion;
	}

	public NewSessionParameters getParameters() {
		return parameters;
	}

	public void setParameters(NewSessionParameters parameters) {
		this.parameters = parameters;
	}

	public static class NewSessionParameters {
		private Identification identification;
		private StepInformation stepInformation;

		public Identification getIdentification() {
			return identification;
		}

		public void setIdentification(Identification identification) {
			this.identification = identification;
		}

		@JsonProperty("step_information")
		public StepInformation getStepInformation() {
			return stepInformation;
		}

		public void setStepInformation(StepInformation stepInformation) {
			this.stepInformation = stepInformation;
		}
	}
}
