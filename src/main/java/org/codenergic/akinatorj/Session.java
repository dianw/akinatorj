package org.codenergic.akinatorj;

import java.io.IOException;

import org.codenergic.akinatorj.model.ListParameters;
import org.codenergic.akinatorj.model.NewSessionResponse;
import org.codenergic.akinatorj.model.StepInformation;

public class Session {
	private final AkinatorJ akinatorJ;
	private final SessionInfo sessionInfo;
	private final String server;
	private final NewSessionResponse newSessionResponse;
	private String completion;

	Session(AkinatorJ akinatorJ, SessionInfo sessionInfo, String server, NewSessionResponse newSessionResponse) {
		this.akinatorJ = akinatorJ;
		this.sessionInfo = sessionInfo;
		this.server = server;
		this.newSessionResponse = newSessionResponse;
		this.completion = newSessionResponse.getCompletion();
	}

	public StepInformation answer(int answer) throws IOException {
		return new Step(this).answer(answer);
	}

	public StepInformation back() throws IOException {
		return new Step(this).back();
	}

	public AkinatorJ getAkinatorJ() {
		return akinatorJ;
	}

	public String getCompletion() {
		return completion;
	}

	StepInformation getCurrentStepInformation() {
		return newSessionResponse.getParameters().getStepInformation();
	}

	NewSessionResponse getNewSessionResponse() {
		return newSessionResponse;
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

	StepInformation updateStep(StepInformation stepInformation, String completion) {
		newSessionResponse.getParameters().setStepInformation(stepInformation);
		this.completion = completion;
		return stepInformation;
	}

	public ListParameters win() throws IOException {
		return new Win(this).win();
	}
}
