package org.codenergic.akinatorj;

import org.codenergic.akinatorj.model.NewSessionResponse;
import org.codenergic.akinatorj.model.StepInformation;

import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;

class Session {
	private final AkinatorJ akinatorJ;
	private final SessionInfo sessionInfo;
	private final String server;
	private final NewSessionResponse newSessionResponse;

	Session(AkinatorJ akinatorJ, SessionInfo sessionInfo, String server, NewSessionResponse newSessionResponse) {
		this.akinatorJ = akinatorJ;
		this.sessionInfo = sessionInfo;
		this.server = server;
		this.newSessionResponse = newSessionResponse;
	}

	public AkinatorJ getAkinatorJ() {
		return akinatorJ;
	}

	NewSessionResponse getNewSessionResponse() {
		return newSessionResponse;
	}

	ObjectMapper getObjectMapper() {
		return akinatorJ.getObjectMapper();
	}

	OkHttpClient getOkHttpClient() {
		return akinatorJ.getOkHttpClient();
	}

	String getServer() {
		return server;
	}

	String getSession() {
		return newSessionResponse.getParameters().getIdentification().getSession();
	}

	public SessionInfo getSessionInfo() {
		return sessionInfo;
	}

	String getSignature() {
		return newSessionResponse.getParameters().getIdentification().getSignature();
	}

	String getStep() {
		return newSessionResponse.getParameters().getStepInformation().getStep();
	}

	StepInformation updateStep(StepInformation stepInformation) {
		newSessionResponse.getParameters().setStepInformation(stepInformation);
		return stepInformation;
	}
}
