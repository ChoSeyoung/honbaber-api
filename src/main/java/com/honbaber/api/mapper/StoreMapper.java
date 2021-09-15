package com.honbaber.api.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface StoreMapper {
	List<Map<String, Object>> getStore(Map<String, Object> params);
	List<Map<String, Object>> getStoreDetail(Integer id);
	Integer closeStore(Integer id);
	List<Map<String, Object>> getMenu(Integer id);
	Integer putMenu(Map<String, Object> params);
	Integer postMenu(Map<String, Object> params);
	Integer deleteMenu(Integer menuId);
}
