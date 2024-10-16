package model;

//產品目錄
public class ProductData {
	private Integer id;
	private String product_id;
	private String product_type;
	private String product_name;
	private Integer price;
	private String addProductDateTime;

	public ProductData() {
		super();
	}

	public ProductData(String product_id, String product_type, String product_name, Integer price,
			String addProductDateTime) {
		super();
		this.product_id = product_id;
		this.product_type = product_type;
		this.product_name = product_name;
		this.price = price;
		this.addProductDateTime = addProductDateTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getProduct_type() {
		return product_type;
	}

	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getAddProductDateTime() {
		return addProductDateTime;
	}

	public void setAddProductDateTime(String addProductDateTime) {
		this.addProductDateTime = addProductDateTime;
	}

}
