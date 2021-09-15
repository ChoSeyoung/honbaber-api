package com.honbaber.api.controller;

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

import com.honbaber.api.service.StoreService;

@RestController
@RequestMapping("/api/${API_VERSION}")
public class StoreController {

	@Autowired
	StoreService storeService;

	@GetMapping("/store")
	public List<Map<String, Object>> showStores(@RequestParam Map<String, Object> params) {
		return storeService.showStores(params);
	}
	
	@GetMapping("/store/{storeId}")
	public Map<String, Object> showStore(@PathVariable("storeId") Integer storeId) {
		return storeService.showStore(storeId);
	}

	@PostMapping("/store")
	public void saveStore(@RequestParam Map<String, Object> params) {
		storeService.saveStore(params);
	}

	@PutMapping("/store/{storeId}")
	public void modifyStore(@PathVariable("storeId") Integer storeId, @RequestParam Map<String, Object> params) {
		params.put("storeId", storeId);
		storeService.saveStore(params);
	}

	@DeleteMapping("/store/{storeId}")
	public void removeStore(@PathVariable("storeId") Integer storeId) {
		storeService.removeStore(storeId);
	}
	
	@GetMapping("/store/detail/{storeId}")
	public List<Map<String, Object>> showStoreDetail(@PathVariable("storeId") Integer storeId) {
		return storeService.showStoreDetail(storeId);
	}

	@PutMapping("/store/detail/{storeId}")
	public void modifyStoreDetail(@PathVariable("storeId") Integer storeId, @RequestParam Map<String, Object> params) {
		params.put("storeId", storeId);
		storeService.modifyStoreDetail(params);
	}

	@GetMapping("/store/{storeId}/menu")
	public List<Map<String, Object>> showMenu(@PathVariable("storeId") Integer storeId) {
		return storeService.showMenu(storeId);
	}

	@PutMapping("/store/{storeId}/menu")
	public void putMenu(@PathVariable("id") Integer storeId, @RequestParam Map<String, Object> params) {
		params.put("storeId", storeId);
		storeService.modifyMenu(params);
	}

	@PostMapping("/store/{storeId}/menu")
	public void postMenu(@PathVariable("id") Integer storeId, @RequestParam Map<String, Object> params) {
		params.put("storeId", storeId);
		storeService.saveMenu(params);
	}

	@DeleteMapping("/store/{storeId}/menu/{menuId}")
	public void deleteMenu(@PathVariable("menuId") Integer menuId) {
		storeService.removeMenu(menuId);
	}
}
