package com.honbaber.api.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.honbaber.api.model.StoreModel;

@Repository
@Mapper
public interface StoreMapper {
	List<StoreModel> getStore(Map<String, Object> params);
}
