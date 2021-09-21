package com.honbaber.api.controller;

import java.util.HashMap;
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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/${API_VERSION}")
public class StoreController {

	@Autowired
	StoreService storeService;

	@GetMapping("/stores")
	@ApiOperation("다중 가게 정보 조회(주변 가게 정보 조회)")
	public List<Map<String, Object>> showStores(@RequestParam Map<String, Object> params) {
		return storeService.showStores(params);
	}
	
	@GetMapping("/store/{store_id}")
	@ApiOperation("단일 가게 정보 조회")
	public Map<String, Object> showStore(
			@ApiParam(value = "store_id", name = "가게 ID") @PathVariable("store_id") Integer storeId) {
		return storeService.showStore(storeId);
	}

	@PostMapping("/store")
	@ApiOperation("가게 정보 등록")
	public void saveStore(
			@ApiParam(value = "name", name = "가게명") @RequestParam("name") String name,
			@ApiParam(value = "img", name = "가게 이미지 URL") @RequestParam("img") String img,
			@ApiParam(value = "lat", name = "위도") @RequestParam("lat") double lat,
			@ApiParam(value = "lng", name = "경도") @RequestParam("lng") double lng,
			@ApiParam(value = "tel", name = "전화번호") @RequestParam(value = "tel", required = false) String tel,
			@ApiParam(value = "post", name = "우편번호") @RequestParam("post") String post,
			@ApiParam(value = "addr1", name = "기본주소") @RequestParam("addr1") String addr1,
			@ApiParam(value = "addr2", name = "상세주소") @RequestParam(value = "addr2", required = false) String addr2,
			@ApiParam(value = "category", name = "카테고리 ID(CATEGORY 테이블 참조)") @RequestParam("category") Integer category,
			@ApiParam(value = "signatureMenu", name = "대표메뉴(콤마로 여러개 작성가능)") @RequestParam(value = "signatureMenu", required = false) String signatureMenu,
			@ApiParam(value = "isClosedStore", name = "폐업여부 | 0: 정상, 1: 폐업") @RequestParam("isClosedStore") Integer isClosedStore) {
		
		Map<String, Object> params = new HashMap<>();
		
		params.put("name", name);
		params.put("img", img);
		params.put("lat", lat);
		params.put("lng", lng);
		params.put("tel", tel);
		params.put("post", post);
		params.put("addr1", addr1);
		params.put("addr2", addr2);
		params.put("category", category);
		params.put("signature_menu", signatureMenu);
		params.put("isClosedStore", isClosedStore);
		
		storeService.saveStore(params);
	}

	@PutMapping("/store/{store_id}")
	@ApiOperation("가게 정보 수정")
	public void modifyStore(
			@ApiParam(value = "store_id", name = "가게 ID") @PathVariable("store_id") Integer storeId, 
			@ApiParam(value = "name", name = "가게명") @RequestParam("name") String name,
			@ApiParam(value = "img", name = "가게 이미지 URL") @RequestParam("img") String img,
			@ApiParam(value = "lat", name = "위도") @RequestParam("lat") double lat,
			@ApiParam(value = "lng", name = "경도") @RequestParam("lng") double lng,
			@ApiParam(value = "tel", name = "전화번호") @RequestParam(value = "tel", required = false) String tel,
			@ApiParam(value = "post", name = "우편번호") @RequestParam("post") String post,
			@ApiParam(value = "addr1", name = "기본주소") @RequestParam("addr1") String addr1,
			@ApiParam(value = "addr2", name = "상세주소") @RequestParam(value = "addr2", required = false) String addr2,
			@ApiParam(value = "category", name = "카테고리 ID(CATEGORY 테이블 참조)") @RequestParam("category") Integer category,
			@ApiParam(value = "signatureMenu", name = "대표메뉴(콤마로 여러개 작성가능)") @RequestParam(value = "signatureMenu", required = false) String signatureMenu) {
		
		Map<String, Object> params = new HashMap<>();
		
		params.put("storeId", storeId);
		params.put("name", name);
		params.put("img", img);
		params.put("lat", lat);
		params.put("lng", lng);
		params.put("tel", tel);
		params.put("post", post);
		params.put("addr1", addr1);
		params.put("addr2", addr2);
		params.put("category", category);
		params.put("signature_menu", signatureMenu);
		
		storeService.saveStore(params);
	}

	@DeleteMapping("/store/{store_id}")
	@ApiOperation("가게 정보 삭제")
	public void removeStore(
			@ApiParam(value="store_id", name="가게 ID") @PathVariable("store_id") Integer storeId) {
		
		storeService.removeStore(storeId);
	}
	
	@GetMapping("/store/detail/{store_id}")
	@ApiOperation("가게 상세 정보 조회")
	public List<Map<String, Object>> showStoreDetail(
			@ApiParam(value="store_id", name="가게 ID") @PathVariable("store_id") Integer storeId) {
		
		return storeService.showStoreDetail(storeId);
	}

	@PutMapping("/store/detail/{storeId}")
	public void modifyStoreDetail(@PathVariable("storeId") Integer storeId, @RequestParam Map<String, Object> params) {
		params.put("storeId", storeId);
		storeService.modifyStoreDetail(params);
	}

	@GetMapping("/store/{store_id}/menus")
	@ApiOperation("가게 메뉴 정보 조회")
	public List<Map<String, Object>> showMenus(
			@ApiParam(value="store_id", name="가게 ID") @PathVariable("store_id") Integer storeId) {
		
		return storeService.showMenus(storeId);
	}

	@PostMapping("/store/{storeId}/menus")
	public void saveMenus(@PathVariable("storeId") Integer storeId, @RequestParam Map<String, Object> params) {
		params.put("storeId", storeId);
		storeService.saveMenus(params);
	}

	@PutMapping("/store/{storeId}/menus")
	public void modifyMenus(@PathVariable("storeId") Integer storeId, @RequestParam Map<String, Object> params) {
		params.put("storeId", storeId);
		storeService.modifyMenus(params);
	}
	
	@DeleteMapping("/store/{store_id}/menus/{menu_id}")
	@ApiOperation("가게 메뉴 정보 삭제")
	public void removeMenus(
			@ApiParam(value="menu_id", name="가게 ID") @PathVariable("menu_id") Integer menuId) {
		
		storeService.removeMenus(menuId);
	}
}
