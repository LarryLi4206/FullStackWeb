package controller.springMVC;

import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.CustomerDataDaoHibernate;
import model.CustomerData;
import model.CustomerLoginData;
import util.ProductID;

@Controller
@RequestMapping("/customer")
public class CustomerDataSpring {

	CustomerDataDaoHibernate cdHB = new CustomerDataDaoHibernate();
	
	//跳註冊頁面
	@RequestMapping(value="/page",method=RequestMethod.GET)
	public String turnpage(Model model) {
		
		return "register";
	}
	
	//跳更新頁面
	@RequestMapping(value="/renew",method=RequestMethod.GET)
	public String turnUpdatepage(Model model) {
			
		return "update";
	}
	
	
	// 顧客註冊頁面
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String customerRegister(Model model, @RequestBody CustomerData customerdata) {
		
		//驗證資料是否重複
		//System.out.println(customerdata.getId());
		System.out.println(customerdata.getCustomer_id());
		System.out.println(customerdata.getCustomer_name());
		System.out.println(customerdata.getAccount());
		System.out.println(customerdata.getPassword());
		System.out.println(customerdata.getAddress());
		System.out.println(customerdata.getMail_address());
		System.out.println(customerdata.getTelephone());
		System.out.println(customerdata.getVip());
		
		//cdHB.addCustomerData(customerdata);
		if(cdHB.addCustomerData(customerdata)!=null) {
			return "homePages";
			
		}else {
			return "errorPage";
			
		}
		
			
	}
	
	
	// 顯示全資料
	@RequestMapping(value = "/alldata", method = RequestMethod.GET)
	public ModelAndView getAllData(ModelMap model) {
		List<CustomerData> list = cdHB.getAllCustomerData();

//		for(CustomerData c:list) {
//			model.addAttribute("id",c.getId());
//			model.addAttribute("Customer_id",c.getCustomer_id());
//			model.addAttribute("Customer_name",c.getCustomer_name());
//			model.addAttribute("Account",c.getAccount());
//			model.addAttribute("Password",c.getPassword());
//			model.addAttribute("Address",c.getAddress());
//			model.addAttribute("Mail_address",c.getMail_address());
//			model.addAttribute("Telephone",c.getTelephone());
//			model.addAttribute("Vip",c.getVip());
//			
//		}
		model.addAttribute("listCustomerData", list);
		return new ModelAndView("customer");

	}

	// 顧客註冊頁面--自動生成ID
	@ModelAttribute("AutoProductCustomerId")
	public String AutoPCustomerId() {
		CustomerData customerdata = cdHB.getFinalCustomerData();
		Integer id = customerdata.getId();
		String auto_id = "";
		if (id == null) {
			id = 1;
			auto_id = "M-000001";
		} else {
			auto_id = new ProductID().productCustomerID(id);
		}

		return auto_id;
	}

	// 顧客登入用
	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String CustomerLogin(Model model,@RequestParam String name, @RequestParam String account , @RequestParam String password) {
	public ModelAndView CustomerLogin(HttpSession session,@RequestBody CustomerLoginData customerLoginData, Model model) {
			
//		List<CustomerData> listCustomerData=cdHB.checkLogin(name,account,password);
		List<CustomerData> listCustomerData = cdHB.checkLogin(customerLoginData.getName(),
				customerLoginData.getAccount(), customerLoginData.getPassword());
		//Test
		for(CustomerData cc:listCustomerData) {
			System.out.println("登入驗證");
			System.out.println(cc.getId());
//			System.out.println(cc.getCustomer_id());
//			System.out.println(cc.getCustomer_name());
//			System.out.println(cc.getAccount());
//			System.out.println(cc.getPassword());
//			System.out.println(cc.getAddress());
//			System.out.println(cc.getMail_address());
//			System.out.println(cc.getTelephone());
//			System.out.println(cc.getVip());
		}
		
		//List<CustomerData>轉換成物件--當成session物件
		if (!listCustomerData.isEmpty()) {
			//將list<物件>，轉換為一般物件內容並確定只有一筆資料不然顯示為null
			CustomerData cust_session=listCustomerData.stream().findFirst().orElse(null);
			session.setAttribute("Logindata", cust_session);
			System.out.println("登入");
			//return new ModelAndView("update");
			return new ModelAndView("homePages","command",CustomerData.class);
		} else{
			
			System.out.println("查無此用戶");
			//回首頁
			return new ModelAndView("errorPage");
		}
	}
	
	//更新資料
	@RequestMapping(value="/cupdate",method=RequestMethod.PUT)
	public String CustomerUpdateData(@RequestBody CustomerData customerDataUP,HttpSession session,Model model) {
		CustomerData sessionData=(CustomerData) session.getAttribute("Logindata");
		if(sessionData!=null) {
			System.out.println("session exists");
		}else {
			System.out.println("session not exists");
		}
		System.out.println("更新的會員ID:"+sessionData.getCustomer_id());
		System.out.println("更新驗證");
		//拉出修改的資料
		CustomerData findCustomerData=cdHB.findByCustomerId(sessionData.getCustomer_id());
		//將輸入資料修改
		findCustomerData.setCustomer_name(customerDataUP.getCustomer_name());
		findCustomerData.setAccount(customerDataUP.getAccount());
		findCustomerData.setPassword(customerDataUP.getPassword());
		findCustomerData.setAddress(customerDataUP.getAddress());
		findCustomerData.setMail_address(customerDataUP.getMail_address());
		findCustomerData.setTelephone(customerDataUP.getTelephone());
		
		//輸入資料測試
		//System.out.println(customerData.getCustomer_id());
		System.out.println(customerDataUP.getCustomer_name());
		System.out.println(customerDataUP.getAccount());
		System.out.println(customerDataUP.getPassword());
		System.out.println(customerDataUP.getAddress());
		System.out.println(customerDataUP.getMail_address());
		System.out.println(customerDataUP.getTelephone());
		System.out.println(customerDataUP.getVip());
		//更新資料
		cdHB.updateCustomerData(findCustomerData);
		//return ResponseEntity.ok("success");
		return "homePages";
	}
	
}
