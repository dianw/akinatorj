package org.codenergic.akinatorj;

import java.io.IOException;

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

	StepInformation answer(int answer) throws IOException {
		if (answer < 0 || answer > 4)
			throw new IllegalArgumentException("Answer must be between 0 to 4");
		String answerUrl = String.format(Urls.ANSWER_URL, session.getServer(), session.getSession(),
				session.getSignature(), session.getStep(), String.valueOf(answer));
		LOGGER.debug("Sending answer: {}", answerUrl);
		AnswerResponse answerResponse = Urls.sendRequest(session.getAkinatorJ(), answerUrl, AnswerResponse.class);
		if (!answerResponse.getCompletion().equals("OK")) {
			throw new IllegalStateException("Completion: " + answerResponse.getCompletion());
		}
		LOGGER.debug("Step Information: {}", answerResponse.getParameters());
		return session.updateStep(answerResponse.getParameters());
	}
}
