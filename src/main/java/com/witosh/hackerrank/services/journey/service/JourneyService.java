package com.witosh.hackerrank.services.journey.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class JourneyService {

	public int checkRubbishBinJourney() {
		List<Double> list = Arrays.asList(1.01, 1.01, 1.01, 1.4, 2.4, 2.7, 2.9);
		int journeyCounter = 0;
		double weightTemp = 0;

		for (double weight : list) {
			weightTemp += weight;
			if (weightTemp > 3) {
				weightTemp = weight;
				journeyCounter += 1;
			}
		}

		// Add one more journey for any remaining weight
		if (weightTemp > 0) {
			journeyCounter += 1;
		}

		return journeyCounter;
	}
}
