package org.codenergic.akinatorj;

import org.codenergic.akinatorj.model.AnswerResponse;
import org.codenergic.akinatorj.model.StepInformation;

class Step {
	private final SessionImpl session;

	Step(SessionImpl session) {
		this.session = session;
	}

	StepInformation answer(int answer) {
		if (answer < 0 || answer > 4)
			throw new IllegalArgumentException("Answer must be between 0 to 4");
		return sendAnswer(answer);
	}

	StepInformation back() {
		if ("0".equals(session.getCurrentStepInformation().getStep())) {
			throw new IllegalStateException("You're in the first question");
		}
		return sendAnswer(-1);
	}

	private StepInformation sendAnswer(int answer) {
		String answerUrl = String.format(Urls.ANSWER_URL, session.getServer(), session.getSession(),
				session.getSignature(), session.getStep(), String.valueOf(answer));
		AnswerResponse answerResponse = Urls.sendRequest(session.getAkinatorJ(), answerUrl, AnswerResponse.class);
		if (!answerResponse.getCompletion().equals("OK")) {
			throw new IllegalStateException("Completion: " + answerResponse.getCompletion());
		}
		return session.updateStep(answerResponse.getParameters(), answerResponse.getCompletion());
	}
}
