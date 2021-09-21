package com.honbaber.admin.api.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AdminCategoryMapper {
	public List<Map<String, Object>> showCategories();

	public void saveCategories(Map<String, Object> params);

	public void modifyCategories(Map<String, Object> params);

	public void removeCategories(Integer categoryId);
}
