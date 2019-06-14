package org.codenergic.akinatorj;

import org.codenergic.akinatorj.model.AnswerResponse;
import org.codenergic.akinatorj.model.StepInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Step {
	private static final Logger LOGGER = LoggerFactory.getLogger(Step.class);
	private final Session session;

	Step(Session session) {
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
		LOGGER.debug("Sending answer: {}", answerUrl);
		AnswerResponse answerResponse = Urls.sendRequest(session.getAkinatorJ(), answerUrl, AnswerResponse.class);
		if (!answerResponse.getCompletion().equals("OK")) {
			throw new IllegalStateException("Completion: " + answerResponse.getCompletion());
		}
		LOGGER.debug("Step Information: {}", answerResponse.getParameters());
		return session.updateStep(answerResponse.getParameters(), answerResponse.getCompletion());
	}
}
