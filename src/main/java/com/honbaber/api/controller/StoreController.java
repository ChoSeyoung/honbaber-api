package com.honbaber.api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.honbaber.api.service.StoreService;

@RestController
@RequestMapping("/api/${API_VERSION}")
public class StoreController {

	@Autowired
	StoreService storeService;
	
	@GetMapping("/store")
	public List<Map<String, Object>> getStore(@RequestParam Map<String, Object> params) {
		return storeService.getStore(params);
	}
	@GetMapping("/store/detail/{id}")
	public List<Map<String, Object>> getStoreDetail(@PathVariable("id") Integer id) {
		return storeService.getStoreDetail(id);
	}
	@PutMapping("/store/close/{id}")
	public void closeStore(@PathVariable("id") Integer id) {
		storeService.closeStore(id);
	}
}
