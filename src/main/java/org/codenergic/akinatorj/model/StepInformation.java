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

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StepInformation {
	private String question;
	private List<Answer> answers = new ArrayList<>();
	private String step;
	private String progression;
	private String questionid;
	private String infogain;
	private String statusMinibase;
	private List<String> options;

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public String getInfogain() {
		return infogain;
	}

	public void setInfogain(String infogain) {
		this.infogain = infogain;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	public String getProgression() {
		return progression;
	}

	public void setProgression(String progression) {
		this.progression = progression;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getQuestionid() {
		return questionid;
	}

	public void setQuestionid(String questionid) {
		this.questionid = questionid;
	}

	@JsonProperty("status_minibase")
	public String getStatusMinibase() {
		return statusMinibase;
	}

	public void setStatusMinibase(String statusMinibase) {
		this.statusMinibase = statusMinibase;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	@Override
	public String toString() {
		return "StepInformation{" +
				"question='" + question + '\'' +
				", answers=" + answers +
				", step='" + step + '\'' +
				", progression='" + progression + '\'' +
				", questionid='" + questionid + '\'' +
				", infogain='" + infogain + '\'' +
				", statusMinibase='" + statusMinibase + '\'' +
				'}';
	}
}
