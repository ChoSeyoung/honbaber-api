package com.honbaber.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honbaber.api.mapper.StoreMapper;
import com.honbaber.api.model.StoreModel;

@Service
public class StoreService {
	@Autowired
	public StoreMapper mapper;
	
	public List<StoreModel> getStore(){
		return mapper.getStore();
	}
}
