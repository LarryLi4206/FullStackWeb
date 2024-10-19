package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;

import model.CustomerData;

public class CustomerDataDaoHibernate {
	
	public static void main(String[] args) {
		CustomerDataDaoHibernate c_dao=new CustomerDataDaoHibernate();
		CustomerData cutomerData=new CustomerData();
		
		
		List<CustomerData> cd=c_dao.checkLogin("cpu", "cpu1234", "123456");
		System.out.println("==================0001===============");
		//不為空則登入
		if(!cd.isEmpty()) {
			System.out.println("LOGIN SUCESS");
			for(CustomerData ctd:cd) {
				System.out.println(ctd.getId());
				System.out.println(ctd.getCustomer_id());
				System.out.println(ctd.getCustomer_name());
				System.out.println(ctd.getAccount());
				System.out.println(ctd.getPassword());
				System.out.println(ctd.getAddress());
				System.out.println(ctd.getMail_address());
				System.out.println(ctd.getTelephone());
				System.out.println(ctd.getVip());
			}
		}else {
			//
			System.out.println("LOGIN FAIL");
		}
		
		System.out.println("===============0001__1==================");
//		CustomerData cd1_1=cd.stream().findFirst().orElse(null);
//		if(cd1_1!=null) {
//			System.out.println(cd1_1.getId());
//			System.out.println(cd1_1.getCustomer_id());
//			System.out.println(cd1_1.getCustomer_name());
//			System.out.println(cd1_1.getAccount());
//			System.out.println(cd1_1.getPassword());
//			System.out.println(cd1_1.getAddress());
//			System.out.println(cd1_1.getMail_address());
//			System.out.println(cd1_1.getTelephone());
//			System.out.println(cd1_1.getVip());
//			System.out.println("LOGIN SUCESS");
//		}else {
//			System.out.println("LOGIN FAIL");
//		}
		
//		System.out.println("================002=================");
//		
//		List<CustomerData> cd1=c_dao.getAllCustomerData();
//		for(CustomerData cus:cd1) {
//			System.out.println(cus.getAccount()+"/"+cus.getAddress());
//		}
		
		
		System.out.println("================003=================");
//		
//		CustomerData cutomerData_01=new CustomerData("test","test","test","test","test","test","test","test");
//		System.out.println(c_dao.addCustomerData(cutomerData_01));
		
		System.out.println("================004=================");
		cutomerData=c_dao.getFinalCustomerData();
		
		System.out.println(cutomerData.getId());
		System.out.println(cutomerData.getCustomer_id());
		System.out.println("================005=================");
		
		//查符合指定欄位資料
		CustomerData cutomerData02=c_dao.findByCustomerId(cutomerData.getCustomer_id());
//		顯示並更新資料
		if(cutomerData02!=null) {
			System.out.println(cutomerData02.getId());
			System.out.println(cutomerData02.getCustomer_id());
			cutomerData02.setCustomer_name("222");
			cutomerData02.setAccount("333");
			cutomerData02.setPassword("444");
			cutomerData02.setAddress("55512");
			cutomerData02.setMail_address("666");
			cutomerData02.setTelephone("777");
			System.out.println(cutomerData02.getVip());
			
			c_dao.updateCustomerData(cutomerData02);
			System.out.println("LOGIN SUCESS");
		}else {
			System.out.println("LOGIN FAIL");
		}
		
	}
	//驗證OK(兩種語法都行)
	public List<CustomerData> checkLogin(String name,String account,String password){
		//CustomerData customerData=new CustomerData();
		Session mgr=GetConnection.getHibernateConnection();
		
		//原生
		Query query = mgr.createNativeQuery("select * from full_stack01.CustomerData where customer_name= '"+name+"' and account='"+ account+"' and password= '"+password+"'", 
				CustomerData.class);
		
		//JPQL
		Query query1 = mgr.createNativeQuery("select * from CustomerData where customer_name= :customer_name and account= :account and password= :password", 
				CustomerData.class).setParameter("customer_name", name).setParameter("account", account).setParameter("password", password);
		
		return query.getResultList();
		
		
	}
	
	//全部資料--OK
	public List <CustomerData> getAllCustomerData() {
		Session session=GetConnection.getHibernateConnection();
   	 	return session.createQuery("select u from CustomerData u").list();
   
	}
	
	//新增資料--驗證OK
	public CustomerData addCustomerData(CustomerData customerData) {
		Session session=GetConnection.getHibernateConnection();
    	System.out.println("HB--"+customerData.getCustomer_id());
    	try {
    		session.getTransaction().begin();
    		session.persist(customerData);
//    		System.out.println(cd+"add success");
    		session.getTransaction().commit();
    		return customerData;
    	}catch(Exception e){
    		System.out.println("error"+e.getMessage());
    	}
    	
   	 	return null;
   
	}
	
	//找出最後一筆資料回傳物件--驗證OK
	public CustomerData getFinalCustomerData() {
		CustomerData customerData=new CustomerData();
		
		Session session=GetConnection.getHibernateConnection();
   	 	Query query=session.createQuery("select u from CustomerData u ORDER BY u.id DESC",CustomerData.class);
   	 	//排序大到小取第一筆資料
   	 	query.setMaxResults(1);
   	 	//將取得資料轉成物件回傳
   	 	return (CustomerData) query.getSingleResult();
   	 	
	}
	
	//查資料--傳入ID(查詢用)和回傳物件(更新用)
	public CustomerData findByCustomerId(String customer_id) {
		Session hb_session=GetConnection.getHibernateConnection();
		String sql="from CustomerData c where c.customer_id= :Customer_id";
		TypedQuery<CustomerData>  tq_CutomerData=hb_session.createQuery(sql,CustomerData.class);
		tq_CutomerData.setParameter("Customer_id",customer_id);
		
		CustomerData c=tq_CutomerData.getSingleResult();
		if(c!=null) {
			
			return c;
		}
		
		return null;
		
	}
	
	//更新資料--OK
	public void updateCustomerData(CustomerData customerData) {
		Session mgr=GetConnection.getHibernateConnection();
    	
    	try {
    		mgr.getTransaction().begin();
    		mgr.merge(customerData);
    		System.out.println("update success");
    		mgr.getTransaction().commit();
    	}catch(Exception e){
    		//mgr.getTransaction().rollback();
    		System.out.println("fail"+e.getMessage());
    	}
    	
	}
}
