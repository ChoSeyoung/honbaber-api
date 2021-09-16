package com.honbaber.api.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honbaber.api.mapper.ReviewMapper;

@Service
public class ReviewService implements ReviewMapper{
	@Autowired
	public ReviewMapper mapper;
	
	public List<Map<String, Object>> showReview(Integer reviewId){
		return mapper.showReview(reviewId);
	}
	public Integer saveReview(Map<String, Object> params) {
		return mapper.saveReview(params);
	}
	public Integer modifyReview(Map<String, Object> params) {
		return mapper.modifyReview(params);
	}
	public Integer removeReview(Integer reviewId) {
		return mapper.removeReview(reviewId);
	}
}