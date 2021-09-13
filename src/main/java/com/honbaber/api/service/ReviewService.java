package com.honbaber.api.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honbaber.api.mapper.ReviewMapper;

@Service
public class ReviewService {
	@Autowired
	public ReviewMapper mapper;
	
	public List<Map<String, Object>> getReview(Integer id){
		return mapper.getReview(id);
	}
	public Integer postReview(Map<String, Object> params) {
		return mapper.postReview(params);
	}
}
