package com.honbaber.admin.api.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.honbaber.admin.api.mapper.AdminCategoryMapper;

public class AdminCategoryService implements AdminCategoryMapper{

	@Autowired
	private AdminCategoryMapper adminCategoryMapper;
	
	@Override
	public List<Map<String, Object>> showCategories() {
		return adminCategoryMapper.showCategories();
	}

	@Override
	public void saveCategories(Map<String, Object> params) {
		adminCategoryMapper.saveCategories(params);
	}

	@Override
	public void modifyCategories(Map<String, Object> params) {
		adminCategoryMapper.modifyCategories(params);
	}

	@Override
	public void removeCategories(Integer categoryId) {
		adminCategoryMapper.removeCategories(categoryId);
	}

}
