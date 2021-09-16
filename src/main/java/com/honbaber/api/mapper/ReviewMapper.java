package com.honbaber.api.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ReviewMapper {
	List<Map<String, Object>> showReview(Integer reviewId);

	Integer saveReview(Map<String, Object> params);

	Integer modifyReview(Map<String, Object> params);

	Integer removeReview(Integer reviewId);
}
