package com.witosh.hackerrank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.witosh.hackerrank.services.journey.service.JourneyService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class JourneyCounterController {

	private final JourneyService journeyService;

	@GetMapping("/journey")
	public Integer checkJourney() {
		return journeyService.checkRubbishBinJourney();
	}
}
