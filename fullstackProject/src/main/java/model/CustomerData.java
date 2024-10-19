package model;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="CustomerData")
public class CustomerData implements Serializable{
	@Id
	//自動增長ID設定
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	//customer_id自動加入M開頭文字加ID
	private String customer_id;
	private String customer_name;
	private String account;
	private String password;
	private String address;
	private String mail_address;
	private String telephone;
	private String vip;//一般，銅，金
	
	public CustomerData() {
		super();
	}
	//簡易註冊(初次登入時自動註冊)----需要判斷帳號設定不能重複
	public CustomerData(String customer_name, String account, String password) {
		super();
		this.customer_name = customer_name;
		this.account = account;
		this.password = password;
	}
	
	//後補詳細資料(先拉頁面資料做搜尋在修改欄位資料)
	//customer_id----->再填入詳細資料時自動生成
	public CustomerData(String customer_id, String customer_name, String account, String password,
			String address, String mail_address, String telephone,String vip) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.account = account;
		this.password = password;
		this.address = address;
		this.mail_address = mail_address;
		this.telephone = telephone;
		this.vip = vip;
	}
	
	//以資料表格作物件(Class名稱)進行取值給值
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMail_address() {
		return mail_address;
	}
	public void setMail_address(String mail_address) {
		this.mail_address = mail_address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getVip() {
		return vip;
	}
	public void setVip(String vip) {
		this.vip = vip;
	}
}
