package org.codenergic.akinatorj;

import java.util.Optional;

import org.codenergic.akinatorj.model.ListParameters;
import org.codenergic.akinatorj.model.NewSessionResponse;
import org.codenergic.akinatorj.model.StepInformation;

public interface Session {
	StepInformation answer(int answer);

	StepInformation back();

	AkinatorJ getAkinatorJ();

	default String getCompletion() {
		return getNewSessionResponse().getCompletion();
	}

	default StepInformation getCurrentStepInformation() {
		return getNewSessionResponse().getParameters().getStepInformation();
	}

	NewSessionResponse getNewSessionResponse();

	default double getProgression() {
		return Optional.ofNullable(getCurrentStepInformation().getProgression())
				.map(Double::parseDouble)
				.orElse(.0);
	}

	ListParameters win();
}
