package model;

public class MemberData {
	//新增員工不能簡易註冊，直接完整註冊(同頁面但是必須判斷員工OR客戶)
	private Integer id;
	//需要設計(老闆BM(最高權限),人資PM(新增修改查詢全部人事資料確認客戶VIP資格),會計CM(改產品價格),一般員工AM(負責銷售)
	//
	private String member_id;
	private String position;
	private String member_name;
	private String account;
	private String password;
	private String address;
	private String mail_address;
	private String telephone;
	
	public MemberData() {
		super();
	}
	
	//員工使用修改個人資料
	public MemberData(String member_id, String position, String member_name, String account, String password,
			String address, String mail_address, String telephone) {
		super();
		this.member_id = member_id;
		this.position = position;
		this.member_name = member_name;
		this.account = account;
		this.password = password;
		this.address = address;
		this.mail_address = mail_address;
		this.telephone = telephone;
	}
	//人資使用設定member_id，position，member_name(帳號密碼先使用預設--員工編號)方法判斷如為預設員工請更改
	public MemberData(String member_id, String position, String member_name, String account, String password) {
		super();
		this.member_id = member_id;
		this.position = position;
		this.member_name = member_name;
		this.account = account;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
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
	
}
