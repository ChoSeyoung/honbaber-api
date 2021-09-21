package com.honbaber.api.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface StoreMapper {
	List<Map<String, Object>> showNearStores(Map<String, Object> params);
	
	Map<String, Object> showStores(Integer storeId);

	Integer saveStores(Map<String, Object> params);
	
	Integer modifyStores(Map<String, Object> params);
	
	Integer removeStores(Integer id);
	
	List<Map<String, Object>> showStoresDetail(Integer storeId);

	Integer modifyStoresDetail(Map<String, Object> params);
	
	List<Map<String, Object>> showMenus(Integer id);

	Integer modifyMenus(Map<String, Object> params);

	Integer saveMenus(Map<String, Object> params);

	Integer removeMenus(Integer menuId);
}
