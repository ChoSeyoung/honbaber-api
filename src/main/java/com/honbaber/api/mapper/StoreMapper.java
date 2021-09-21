package com.honbaber.api.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface StoreMapper {
	Map<String, Object> showStore(Integer storeId);

	Integer saveStore(Map<String, Object> params);
	
	Integer modifyStore(Map<String, Object> params);
	
	Integer removeStore(Integer id);
	
	List<Map<String, Object>> showStoreDetail(Integer storeId);

	Integer modifyStoreDetail(Map<String, Object> params);
	
	List<Map<String, Object>> showStores(Map<String, Object> params);

	List<Map<String, Object>> showMenus(Integer id);

	Integer modifyMenus(Map<String, Object> params);

	Integer saveMenus(Map<String, Object> params);

	Integer removeMenus(Integer menuId);
}
