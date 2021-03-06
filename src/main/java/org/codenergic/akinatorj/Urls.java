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
import java.util.HashMap;
import java.util.Map;

import okhttp3.Request;
import okhttp3.Response;

class Urls {
	static final String NEW_SESSION_URL = "https://%s/ws/new_session?callback=jQuery331005089254861332693_%d&partner=1&player=website-desktop&uid_ext_session=%s&frontaddr=%s&constraint=ETAT%%3C%%3E%%27AV%%27&constraint=ETAT<>'AV'";
	static final String ANSWER_URL = "https://%s/ws/answer?callback=jQuery331005089254861332693_%d&session=%s&signature=%s&step=%s&answer=%s";
	static final String WIN_URL = "https://%s/ws/list?callback=jQuery331005089254861332693_%d&session=%s&signature=%s&step=%s";

	private static Map<String, String> servers = new HashMap<>();

	static {
		servers.put("", "srv2.akinator.com:9162");
		servers.put("en", "srv2.akinator.com:9162");
		servers.put("en2", "srv6.akinator.com:9126");
		servers.put("en3", "srv11.akinator.com:9152");
		servers.put("ar", "srv2.akinator.com:9155");
		servers.put("cn", "srv11.akinator.com:9150");
		servers.put("de", "srv14.akinator.com:9283");
		servers.put("es", "srv6.akinator.com:9127");
		servers.put("fr", "srv3.akinator.com:9217");
		servers.put("il", "srv12.akinator.com:9189");
		servers.put("it", "srv9.akinator.com:9214");
		servers.put("jp", "srv11.akinator.com:9172");
		servers.put("kr", "srv2.akinator.com:9156");
		servers.put("nl", "srv9.akinator.com:9215");
		servers.put("pl", "srv14.akinator.com:9282");
		servers.put("pt", "srv2.akinator.com:9161");
		servers.put("ru", "srv12.akinator.com:9190");
		servers.put("tr", "srv3.akinator.com:9211");
	}

	static String getServerUrl(String language) {
		if (language == null) language = "";
		return servers.get(language.toLowerCase().trim());
	}

	static String sendRequest(AkinatorJ akinatorJ, String url) {
		try {
			Request request = new Request.Builder().url(url).build();
			Response response = akinatorJ.getOkHttpClient().newCall(request).execute();
			return response.body().string();
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}

	static <T> T sendRequest(AkinatorJ akinatorJ, String url, Class<T> clazz) {
		try {
			Request request = new Request.Builder().url(url).build();
			Response response = akinatorJ.getOkHttpClient().newCall(request).execute();
			return akinatorJ.getObjectMapper().readValue(parseJsonpBody(response.body().string()), clazz);
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}

	private static String parseJsonpBody(String jsonp) {
		int beginIndex = jsonp.indexOf('(') + 1;
		int endIndex = jsonp.lastIndexOf(')');
		return jsonp.substring(beginIndex, endIndex);
	}
}
