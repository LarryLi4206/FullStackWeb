package dao;

import java.util.List;

import org.hibernate.Session;

import model.PositionData;

public class PositionDataDaoHibernate {
	
	public static void main(String[] args) {
		PositionDataDaoHibernate pdd=new PositionDataDaoHibernate();
		
		List<PositionData> list_pdd=pdd.getAllData();
		
		for(PositionData pd:list_pdd) {
			System.out.println(pd.getId());
			System.out.println(pd.getPosition_Code());
			System.out.println(pd.getPosition_name());
		}
		
	}
	
	
	Session ss=GetConnection.getHibernateConnection();
	
	public List<PositionData> getAllData() {
		
		return ss.createQuery("from PositionData").getResultList();//可以使用JPA方式
		//return ss.createQuery("from PositionData").list();// Hibernate的方法
	}
	
	
	

}
