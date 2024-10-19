package model;

public class WebStoreData {
	private Integer id;
	//成為賣家一定是會員，會有顧客ID
	//同顧客註冊時的資料作對應
	private String customer_id;
	//成為賣家一定會有ID-根據賣家數量自動生成(用來跟商品ID做對應)
	//可以在商品查符合storeID的賣家有多少商品
	private String storeId;
	//店家名稱
	private String storeName;
	//註冊時自動記錄--用來呈現開店多久
	private String createTime;
	
	
	
	
	
	
	
}
