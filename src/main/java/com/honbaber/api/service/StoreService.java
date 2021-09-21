package com.honbaber.api.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honbaber.api.mapper.StoreMapper;

@Service
public class StoreService implements StoreMapper{
	@Autowired
	private StoreMapper mapper;

	public List<Map<String, Object>> showNearStores(Map<String, Object> params) {
		return mapper.showNearStores(params);
	}

	public Map<String, Object> showStores(Integer storeId) {
		return mapper.showStores(storeId);
	}

	public Integer saveStores(Map<String, Object> params) {
		return mapper.saveStores(params);
	}
	
	public Integer modifyStores(Map<String, Object> params) {
		return mapper.modifyStores(params);
	}
	
	public Integer removeStores(Integer id) {
		return mapper.removeStores(id);
	}
	
	public Map<String, Object> showStoresDetail(Integer storeId) {
		return mapper.showStoresDetail(storeId);
	}
	
	public Integer modifyStoresDetail(Map<String, Object> params) {
		return mapper.modifyStoresDetail(params);
	}

	public List<Map<String, Object>> showMenus(Integer storeId) {
		return mapper.showMenus(storeId);
	}

	public Integer modifyMenus(Map<String, Object> params) {
		return mapper.modifyMenus(params);
	}

	public Integer saveMenus(Map<String, Object> params) {
		return mapper.saveMenus(params);
	}

	public Integer removeMenus(Integer menuId) {
		return mapper.removeMenus(menuId);
	}
}
