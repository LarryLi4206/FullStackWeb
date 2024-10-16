package controller.springMVC;

import java.util.List;

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
import util.ProductID;

@Controller
@RequestMapping("/customer")
public class CustomerDataSpring {

	CustomerDataDaoHibernate cdHB=new CustomerDataDaoHibernate();
	//顯示全資料
	@RequestMapping(value="/alldata",method=RequestMethod.GET)
	public ModelAndView getAllData(ModelMap model) {
		List<CustomerData> list=cdHB.getAllCustomerData();
		
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
	
	//顧客註冊頁面
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ModelAndView customerRegister() {
		
		return new ModelAndView("customerRegister","command",CustomerData.class);
	}
	
	//顧客註冊頁面--自動生成ID
	@ModelAttribute("AutoProductCustomerId")
	public String AutoPCustomerId() {
		CustomerData customerdata=cdHB.getFinalCustomerData();
		Integer id=customerdata.getId();
		String auto_id="";
		if(id==null) {
			id=1;
			auto_id="M-000001";
		}else {
			auto_id=new ProductID().productCustomerID(id);
		}
		
		return auto_id;
	}
	
//	@RequestBody
	//顧客登入用
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView CustomerLogin(ModelMap model,@RequestParam String customer_name, @RequestParam String Account , @RequestParam String Password) {
	//public ModelAndView CustomerLogin(@RequestBody CustomerData customerData) {
				
		//System.out.println(customerData.getCustomer_id());
		System.out.println(customer_name);
		System.out.println(Account);
		System.out.println(Password);
		
		List<CustomerData> listCustomerData=cdHB.checkLogin(customer_name,Account,Password);
		//List<CustomerData> listCustomerData=cdHB.checkLogin(customerData.getCustomer_name(),customerData.getAccount(),customerData.getPassword());
		
		if(listCustomerData.isEmpty()) {
			System.out.println("查無此用戶");
			return new ModelAndView("errorPage");
		}
		System.out.println("登入");
		return new ModelAndView("HomePage");
		
	}
	
	
	
}
