package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.CustomerData;

public class CustomerDataDaoJPA {
	
	public static void main(String[] args) {
		CustomerDataDaoJPA c_dao=new CustomerDataDaoJPA();
		CustomerData cutomerData=new CustomerData();
		
		
		List<CustomerData> cd=c_dao.checkLogin("cpu", "cpu1234", "123456");
//		System.out.println("==================0001===============");
//		//不為空則登入
//		if(!cd.isEmpty()) {
//			System.out.println("LOGIN SUCESS");
//			for(CustomerData ctd:cd) {
//				System.out.println(ctd.getId());
//				System.out.println(ctd.getCustomer_id());
//				System.out.println(ctd.getCustomer_name());
//				System.out.println(ctd.getAccount());
//				System.out.println(ctd.getPassword());
//				System.out.println(ctd.getAddress());
//				System.out.println(ctd.getMail_address());
//				System.out.println(ctd.getTelephone());
//				System.out.println(ctd.getVip());
//			}
//		}else {
//			//
//			System.out.println("LOGIN FAIL");
//		}
		
		System.out.println("===============0001__1==================");
		CustomerData cd1_1=cd.stream().findFirst().orElse(null);
		if(cd1_1!=null) {
			System.out.println(cd1_1.getId());
			System.out.println(cd1_1.getCustomer_id());
			System.out.println(cd1_1.getCustomer_name());
			System.out.println(cd1_1.getAccount());
			System.out.println(cd1_1.getPassword());
			System.out.println(cd1_1.getAddress());
			System.out.println(cd1_1.getMail_address());
			System.out.println(cd1_1.getTelephone());
			System.out.println(cd1_1.getVip());
			System.out.println("LOGIN SUCESS");
		}else {
			System.out.println("LOGIN FAIL");
		}
		
		System.out.println("================002=================");
		
		List<CustomerData> cd1=c_dao.getAllCustomerData();
		for(CustomerData cus:cd1) {
			System.out.println(cus.getAccount()+"/"+cus.getAddress());
		}
		
		
		System.out.println("================003=================");
//		
//		CustomerData cutomerData_01=new CustomerData("test","test","test","test","test","test","test","test");
//		System.out.println(c_dao.addCustomerData(cutomerData_01));
		
		System.out.println("================004=================");
		cutomerData=c_dao.getFinalCustomerData();
		
		System.out.println(cutomerData.getId());
		System.out.println(cutomerData.getCustomer_id());
		System.out.println("================005=================");
		
		c_dao.updateData(new CustomerData(cutomerData.getCustomer_id(),"12test","12test","12test","test","test","test","test"));
		
		
	}
	//驗證OK(兩種語法都行)
	public List<CustomerData> checkLogin(String name,String account,String password){
		//CustomerData customerData=new CustomerData();
		EntityManager mgr=GetConnection.getJPAConnection();
		
		//原生
		Query query = mgr.createNativeQuery("select * from full_stack01.CustomerData where customer_name= '"+name+"' and account='"+ account+"' and password= '"+password+"'", 
				CustomerData.class);
		
		//JPQL
		Query query1 = mgr.createNativeQuery("select * from full_stack01.CustomerData where customer_name= ? and account= ? and password= ?", 
				CustomerData.class).setParameter(1, name).setParameter(2, account).setParameter(3, password);
	
		return query1.getResultList();
		
		
	}
	
	//全部資料
	public List <CustomerData> getAllCustomerData() {
    	EntityManager mgr=GetConnection.getJPAConnection();
   	 	return mgr.createQuery("select u from CustomerData u").getResultList();
   
	}
	
	//新增資料--驗證OK
	public CustomerData addCustomerData(CustomerData customerData) {
    	EntityManager mgr=GetConnection.getJPAConnection();
    	
    	try {
    		mgr.getTransaction().begin();
    		CustomerData cd=mgr.merge(customerData);
    		System.out.println(cd+"add success");
    		mgr.getTransaction().commit();
    		return cd;
    	}catch(Exception e){
    		
    	}
    	
   	 	return null;
   
	}
	
	//找出最後一筆資料回傳物件--驗證OK
	public CustomerData getFinalCustomerData() {
		CustomerData customerData=new CustomerData();
		
		EntityManager mgr=GetConnection.getJPAConnection();
   	 	Query query=mgr.createQuery("select u from CustomerData u ORDER BY u.id DESC",CustomerData.class);
   	 	//排序大到小取第一筆資料
   	 	query.setMaxResults(1);
   	 	//將取得資料轉成物件回傳
   	 	return (CustomerData) query.getSingleResult();
   	 	
	}
	//更新資料--傳入ID(查詢用)和物件(更新用)
	public CustomerData updateData(CustomerData customerData) {
		EntityManager mgr=GetConnection.getJPAConnection();
		
		//行不通
//		Query query = mgr.createNativeQuery("select * from full_stack01.CustomerData where customer_id= ?", 
//				CustomerData.class).setParameter(1, customer_id);
//		
		Query query = mgr.createNativeQuery("select * from full_stack01.CustomerData where customer_id= ?", 
				CustomerData.class).setParameter(1 , customerData.getCustomer_id());
		
		CustomerData list_cd=(CustomerData) query.getSingleResult();
		//CustomerData cust=list_cd.stream().findFirst().orElse(null);
		
		if(list_cd!=null) {
			mgr.getTransaction().begin();
			CustomerData cd=mgr.merge(customerData);
			mgr.getTransaction().commit();
			System.out.println("success");
			return cd;
		}else {
			System.out.println("fail");
			return null;
		}
		
	}
	
	
	
}
