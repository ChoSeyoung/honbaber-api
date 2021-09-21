package com.honbaber.admin.api.controller;

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

import com.honbaber.admin.api.service.AdminCategoryService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/admin")
public class CategoryController {
	
	@Autowired
	AdminCategoryService adminCategoryService;
	
	@GetMapping("/categories")
	@ApiOperation(value = "카테고리 조회")
	public List<Map<String, Object>> showCategories(){
		return adminCategoryService.showCategories(); 
	}
	
	@PostMapping("/categories")
	@ApiOperation(value = "카테고리 입력")
	public void saveCategories(
			@ApiParam(value = "category", name = "카테고리명") @RequestParam("category") String category,
			@ApiParam(value = "icon", name = "아이콘") @RequestParam("icon") String icon) {
		
		Map<String, Object> params = new HashMap<>();

		params.put("category", category);
		params.put("icon", icon);
		
		adminCategoryService.saveCategories(params);
	}
	
	@PutMapping("/categories/{categoryId}")
	@ApiOperation(value = "카테고리 수정")
	public void modifyCategories(
			@ApiParam(value = "categoryId", name = "카테고리 ID") @PathVariable("categoryId") Integer categoryId,
			@ApiParam(value = "category", name = "카테고리명") @RequestParam("category") String category,
			@ApiParam(value = "icon", name = "아이콘") @RequestParam("icon") String icon) {
		
		Map<String, Object> params = new HashMap<>();

		params.put("categoryId", categoryId);
		params.put("category", category);
		params.put("icon", icon);
		
		adminCategoryService.modifyCategories(params);
	}
	
	@DeleteMapping("/categories/{categoryId}")
	@ApiOperation(value = "카테고리 삭제")
	public void removeCategories(
			@ApiParam(value = "categoryId", name = "카테고리 ID") @PathVariable("categoryId") Integer categoryId) {
		
		adminCategoryService.removeCategories(categoryId);
	}
}
