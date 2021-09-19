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

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/${API_VERSION}")
public class ReviewController {

	@Autowired
	ReviewService reviewService;

	@ApiOperation(value = "리뷰조회")
	@GetMapping("/review/{review_id}")
	public List<Map<String, Object>> showReview(@PathVariable("review_id") Integer reviewId) {
		return reviewService.showReview(reviewId);
	}

	@PostMapping("/review")
	@ApiOperation(value = "리뷰저장")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "store_id", dataType = "integer", value = "가게 ID", required = true),
		@ApiImplicitParam(name = "sense_rate", dataType = "integer", value = "센스 평점", required = true),
		@ApiImplicitParam(name = "time_rate", dataType = "integer", value = "시간 평점", required = true),
		@ApiImplicitParam(name = "taste_rate", dataType = "integer", value = "맛 평점", required = true),
		@ApiImplicitParam(name = "review", dataType = "string", value = "상세리뷰", required = false)
	})
	public void saveReview(@RequestParam("store_id") Integer storeId,
			@RequestParam("sense_rate") Integer senseRate,
			@RequestParam("time_rate") Integer timeRate,
			@RequestParam("taste_rate") Integer tasteRate,
			@RequestParam("review") String review) {
		
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
	@ApiImplicitParams({
		@ApiImplicitParam(name = "store_id", value = "가게 ID", required = true),
		@ApiImplicitParam(name = "sense_rate", value = "센스 평점", required = true),
		@ApiImplicitParam(name = "time_rate", value = "시간 평점", required = true),
		@ApiImplicitParam(name = "taste_rate", value = "맛 평점", required = true),
		@ApiImplicitParam(name = "review", value = "상세리뷰", required = false, defaultValue = "")
	})
	public void modifyReview(@RequestParam("review_id") Integer reviewId,
			@RequestParam("sense_rate") Integer senseRate,
			@RequestParam("time_rate") Integer timeRate,
			@RequestParam("taste_rate") Integer tasteRate,
			@RequestParam("review") String review) {
		
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
	public void removeReview(@PathVariable("review_id") Integer reviewId) {
		reviewService.removeReview(reviewId);
	}
}
