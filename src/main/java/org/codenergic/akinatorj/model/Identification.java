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

public class Identification {
	private long channel;
	private String session;
	private String signature;
	private String challengeAuth;

	@JsonProperty("challenge_auth")
	public String getChallengeAuth() {
		return challengeAuth;
	}

	public void setChallengeAuth(String challengeAuth) {
		this.challengeAuth = challengeAuth;
	}

	public long getChannel() {
		return channel;
	}

	public void setChannel(long channel) {
		this.channel = channel;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	@Override
	public String toString() {
		return "Identification{" +
				"channel=" + channel +
				", session='" + session + '\'' +
				", signature='" + signature + '\'' +
				", challengeAuth='" + challengeAuth + '\'' +
				'}';
	}
}
