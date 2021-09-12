package com.honbaber.api.model;

import lombok.Builder;
import lombok.Data;

@Data
public class StoreModel {
	private int id;
	private String name;
	private double lat, lng;
	private String tel, post, addr1, addr2;
	private int category, rate, rate_cnt;
	private String signature_menu;
}
