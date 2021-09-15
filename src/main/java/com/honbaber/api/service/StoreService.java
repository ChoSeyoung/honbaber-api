package com.honbaber.api.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honbaber.api.mapper.StoreMapper;

@Service
public class StoreService {
	@Autowired
	public StoreMapper mapper;
	
	public List<Map<String, Object>> getStore(Map<String, Object> params){
		return mapper.getStore(params);
	}
	public List<Map<String, Object>> getStoreDetail(Integer id){
		return mapper.getStoreDetail(id);
	}
	public Integer closeStore(Integer id) {
		return mapper.closeStore(id);
	}
	public List<Map<String, Object>> getMenu(Integer id){
		return mapper.getMenu(id);
	}
	public Integer putMenu(Map<String, Object> params) {
		return mapper.putMenu(params);
	}
	public Integer postMenu(Map<String, Object> params) {
		return mapper.postMenu(params);
	}
	public Integer deleteMenu(Integer menuId) {
		return mapper.deleteMenu(menuId);
	}
}
