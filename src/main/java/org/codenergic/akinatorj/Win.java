package org.codenergic.akinatorj;

import java.io.IOException;

import org.codenergic.akinatorj.model.ListParameters;
import org.codenergic.akinatorj.model.ListResponse;

class Win {
	private final Session session;

	Win(Session session) {
		this.session = session;
	}

	ListParameters win() throws IOException {
		String winUrl = String.format(Urls.WIN_URL, session.getServer(), session.getSession(),
				session.getSignature(), session.getStep());
		ListResponse listResponse = Urls.sendRequest(session.getAkinatorJ(), winUrl, ListResponse.class);
		session.updateStep(session.getCurrentStepInformation(), listResponse.getCompletion());
		return listResponse.getParameters();
	}
}
