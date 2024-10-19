package model;

//產品目錄
public class ProductData {
	private Integer id;
	//確認商品賣家是誰登記的--用來呈現某一個賣家有多少商品
	private String storeID;
	//自動生成
	private String product_id;
	//商品種類
	private String product_type;
	//商品照片
	private String product_image;
	//商品名稱
	private String product_name;
	//定價
	private double price;
	//存貨
	private Integer amount;
	
	private String addProductDateTime;

	public ProductData() {
		super();
	}

	
}
