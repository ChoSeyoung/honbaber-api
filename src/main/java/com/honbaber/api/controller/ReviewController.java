package com.honbaber.api.controller;

import java.util.HashMap;
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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/${API_VERSION}")
public class ReviewController {

	@Autowired
	ReviewService reviewService;

	@ApiOperation(value = "리뷰조회")
	@GetMapping("/review/{review_id}")
	public List<Map<String, Object>> showReview(
			@ApiParam(value = "review_id", name = "리뷰 ID") @PathVariable("review_id") Integer reviewId) {
		return reviewService.showReview(reviewId);
	}

	@PostMapping("/review")
	@ApiOperation(value = "리뷰저장")
	public void saveReview(
			@ApiParam(value = "store_id", name = "가게 ID") @RequestParam("store_id") Integer storeId,
			@ApiParam(value = "sense_rate", name = "센스 평점") @RequestParam("sense_rate") Integer senseRate,
			@ApiParam(value = "time_rate", name = "시간 평점") @RequestParam("time_rate") Integer timeRate,
			@ApiParam(value = "taste_rate", name = "맛 평점") @RequestParam("taste_rate") Integer tasteRate,
			@ApiParam(value = "review", name = "리뷰") @RequestParam(value = "review", required = false) String review) {

		Map<String, Object> params = new HashMap<>();

		params.put("storeId", storeId);
		params.put("senseRate", senseRate);
		params.put("timeRate", timeRate);
		params.put("tasteRate", tasteRate);
		params.put("review", review);

		reviewService.saveReview(params);
	}

	@PutMapping("/review")
	@ApiOperation(value = "리뷰수정")
	public void modifyReview(
			@ApiParam(value = "review_id", name = "리뷰 ID") @RequestParam("review_id") Integer reviewId, 
			@ApiParam(value = "sense_rate", name = "센스 평점") @RequestParam("sense_rate") Integer senseRate,
			@ApiParam(value = "time_rate", name = "시간 평점") @RequestParam("time_rate") Integer timeRate,
			@ApiParam(value = "taste_rate", name = "맛 평점") @RequestParam("taste_rate") Integer tasteRate,
			@ApiParam(value = "review", name = "리뷰") @RequestParam(value = "review", required = false) String review) {

		Map<String, Object> params = new HashMap<>();

		params.put("reviewId", reviewId);
		params.put("senseRate", senseRate);
		params.put("timeRate", timeRate);
		params.put("tasteRate", tasteRate);
		params.put("review", review);

		reviewService.modifyReview(params);
	}

	@DeleteMapping("/review/{review_id}")
	@ApiOperation(value = "리뷰삭제")
	public void removeReview(
			@ApiParam(value = "review_id", name = "리뷰 ID") @PathVariable("review_id") Integer reviewId) {
		reviewService.removeReview(reviewId);
	}
}
