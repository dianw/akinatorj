package org.codenergic.akinatorj;

import org.codenergic.akinatorj.model.ListParameters;
import org.codenergic.akinatorj.model.NewSessionResponse;
import org.codenergic.akinatorj.model.StepInformation;

class SessionImpl implements Session {
	private final AkinatorJ akinatorJ;
	private final SessionInfo sessionInfo;
	private final String server;
	private final NewSessionResponse newSessionResponse;

	SessionImpl(AkinatorJ akinatorJ, SessionInfo sessionInfo, String server, NewSessionResponse newSessionResponse) {
		this.akinatorJ = akinatorJ;
		this.sessionInfo = sessionInfo;
		this.server = server;
		this.newSessionResponse = newSessionResponse;
	}

	@Override
	public StepInformation answer(int answer) {
		return new Step(this).answer(answer);
	}

	@Override
	public StepInformation back() {
		return new Step(this).back();
	}

	@Override
	public AkinatorJ getAkinatorJ() {
		return akinatorJ;
	}

	@Override
	public NewSessionResponse getNewSessionResponse() {
		return newSessionResponse;
	}

	String getServer() {
		return server;
	}

	String getSession() {
		return newSessionResponse.getParameters().getIdentification().getSession();
	}

	SessionInfo getSessionInfo() {
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
		newSessionResponse.setCompletion(completion);
		return stepInformation;
	}

	@Override
	public ListParameters win() {
		return new Win(this).win();
	}
}
