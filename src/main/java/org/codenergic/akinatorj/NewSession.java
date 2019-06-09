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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.codenergic.akinatorj.model.NewSessionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import okhttp3.Request;
import okhttp3.Response;

public class NewSession {
	private static final Pattern SESSION_PATTERN = Pattern.compile("var uid_ext_session = '(.*)'\\;\\n.*var frontaddr = '(.*)'\\;");
	private static final Logger LOGGER = LoggerFactory.getLogger(NewSession.class);
	private AkinatorJ akinatorJ;

	NewSession(AkinatorJ akinatorJ) {
		this.akinatorJ = akinatorJ;
	}

	NewSessionResponse newSession(String language) throws IOException {
		SessionInfo sessionInfo = getSessionInfo();
		String server = Region.getServer(language);
		String newSessionUrl = String.format(Urls.NEW_SESSION_URL, server, sessionInfo.getUid(), sessionInfo.getFrontAddr());
		LOGGER.debug("Requesting new session: {}", newSessionUrl);
		Request request = new Request.Builder().url(newSessionUrl).build();
		Response response = akinatorJ.getOkHttpClient().newCall(request).execute();
		NewSessionResponse newSessionResponse = akinatorJ.getObjectMapper().readValue(response.body().bytes(), NewSessionResponse.class);
		if (!newSessionResponse.getCompletion().equals("OK")) {
			throw new IllegalStateException("Completion: " + newSessionResponse.getCompletion());
		}
		return newSessionResponse;
	}

	SessionInfo getSessionInfo() throws IOException {
		Request request = new Request.Builder().url("https://en.akinator.com/game").build();
		Response response = akinatorJ.getOkHttpClient().newCall(request).execute();
		if (response.code() != 200) {
			throw new IllegalStateException("Response code: " + response.code());
		}
		String responseBody = response.body().string();
		Matcher matcher = SESSION_PATTERN.matcher(responseBody);
		if (!matcher.find()) {
			LOGGER.debug("Response body: \n{}", responseBody);
			throw new IllegalStateException("Cannot find uid and frontaddr");
		}
		String uid = matcher.group(1);
		String frontaddr = matcher.group(2);
		LOGGER.debug("Session info: uid={}, frontaddr={}", uid, frontaddr);
		return new SessionInfo(uid, frontaddr);
	}


}
