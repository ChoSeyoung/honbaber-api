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

	public Map<String, Object> showStore(Integer storeId) {
		return mapper.showStore(storeId);
	}

	public Integer saveStore(Map<String, Object> params) {
		return mapper.saveStore(params);
	}
	
	public Integer modifyStore(Map<String, Object> params) {
		return mapper.modifyStore(params);
	}
	
	public Integer removeStore(Integer id) {
		return mapper.removeStore(id);
	}
	
	public List<Map<String, Object>> showStoreDetail(Integer storeId) {
		return mapper.showStoreDetail(storeId);
	}
	
	public Integer modifyStoreDetail(Map<String, Object> params) {
		return mapper.modifyStoreDetail(params);
	}
	
	public List<Map<String, Object>> showStores(Map<String, Object> params) {
		return mapper.showStores(params);
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
