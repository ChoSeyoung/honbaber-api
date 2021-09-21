package com.honbaber.api.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honbaber.api.mapper.StoreMapper;

@Service
public class StoreService implements StoreMapper {
	@Autowired
	private StoreMapper mapper;

	@Override
	public List<Map<String, Object>> showNearStores(Map<String, Object> params) {
		return mapper.showNearStores(params);
	}

	@Override
	public Map<String, Object> showStores(Integer storeId) {
		return mapper.showStores(storeId);
	}

	@Override
	public Integer saveStores(Map<String, Object> params) {
		return mapper.saveStores(params);
	}

	@Override
	public Integer modifyStores(Map<String, Object> params) {
		return mapper.modifyStores(params);
	}

	@Override
	public Integer removeStores(Integer id) {
		return mapper.removeStores(id);
	}

	@Override
	public Map<String, Object> showStoresDetail(Integer storeId) {
		return mapper.showStoresDetail(storeId);
	}

	@Override
	public Integer modifyStoresDetail(Map<String, Object> params) {
		return mapper.modifyStoresDetail(params);
	}

	@Override
	public List<Map<String, Object>> showMenus(Integer storeId) {
		return mapper.showMenus(storeId);
	}

	@Override
	public Integer modifyMenus(Map<String, Object> params) {
		return mapper.modifyMenus(params);
	}

	@Override
	public Integer saveMenus(Map<String, Object> params) {
		return mapper.saveMenus(params);
	}

	@Override
	public Integer removeMenus(Integer menuId) {
		return mapper.removeMenus(menuId);
	}

	@Override
	public List<Map<String, Object>> showReviews(Integer storeId) {
		return mapper.showReviews(storeId);
	}
}
