package com.honbaber.api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.honbaber.api.service.ReviewService;

@RestController
@RequestMapping("/api/${API_VERSION}")
public class ReviewController {

	@Autowired
	ReviewService reviewService;

	@GetMapping("/review/{reviewId}")
	public List<Map<String, Object>> showReview(@PathVariable("reviewId") Integer reviewId) {
		return reviewService.showReview(reviewId);
	}

	@PostMapping("/review")
	public void saveReview(@RequestParam Map<String, Object> params) {
		reviewService.saveReview(params);
	}

	@PutMapping("/review")
	public void modifyReview(@RequestParam Map<String, Object> params) {
		reviewService.modifyReview(params);
	}

	@DeleteMapping("/review/{reviewId}")
	public void removeReview(@PathVariable("reviewId") Integer reviewId) {
		reviewService.removeReview(reviewId);
	}
}
