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
	
	@GetMapping("/review/{id}")
	public List<Map<String, Object>> getReview(@PathVariable("id") Integer id) {
		return reviewService.getReview(id);
	}
	@PostMapping("/review")
	public void postReview(@RequestParam Map<String, Object> params) {
		reviewService.postReview(params);
	}
	@PutMapping("/review")
	public void putReview(@RequestParam Map<String, Object> params) {
		reviewService.putReview(params);
	}
	@DeleteMapping("/review/{id}")
	public void deleteReview(@PathVariable("id") Integer id) {
		reviewService.deleteReview(id);
	}
}
