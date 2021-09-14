package com.honbaber.api.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ReviewMapper {
	List<Map<String, Object>> getReview(Integer id);
	Integer postReview(Map<String, Object> params);
	Integer putReview(Map<String, Object> params);
	Integer deleteReview(Integer id);
}
