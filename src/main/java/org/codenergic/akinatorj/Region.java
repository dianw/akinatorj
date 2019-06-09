package org.codenergic.akinatorj;

import java.util.HashMap;
import java.util.Map;

public class Region {
	private static Map<String, String> region = new HashMap<>();

	static {
		region.put("", "srv13.akinator.com:9196");
		region.put("en", "srv13.akinator.com:9196");
		region.put("en2", "srv6.akinator.com:9126");
		region.put("ar", "srv2.akinator.com:9155");
		region.put("cn", "srv11.akinator.com:9150");
		region.put("de", "srv7.akinator.com:9241");
		region.put("es", "srv11.akinator.com:9151");
		region.put("fr", "srv12.akinator.com:9185");
		region.put("fr2", "srv3.akinator.com:9167");
		region.put("il", "srv12.akinator.com:9189");
		region.put("it", "srv9.akinator.com:9214");
		region.put("jp", "srv11.akinator.com:9172");
		region.put("kr", "srv2.akinator.com:9156");
		region.put("ns", "srv7.akinator.com:9241");
		region.put("pl", "srv7.akinator.com:9240");
		region.put("pt", "srv2.akinator.com:9161");
		region.put("ru", "srv12.akinator.com:9190");
		region.put("tr", "srv3.akinator.com:9211");
	}

	static String getServer(String language) {
		if (language == null) language = "";
		return region.get(language.toLowerCase().trim());
	}
}
