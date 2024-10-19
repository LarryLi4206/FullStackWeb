package util;

public class ProductID {

	public static void main(String[] args) {
		 System.out.println(new ProductID().productCustomerID(10));

	}
	
	
	public String productCustomerID(int id)
	{	
		id=id+1;
		String c_id=String.valueOf(id);
		
		if(c_id.length()==1) {
			c_id="M-00000"+c_id;
			return c_id;
		}else if(c_id.length()==2) {
			c_id="M-0000"+c_id;
			return c_id;
		}else if(c_id.length()==3) {
			c_id="M-000"+c_id;
			return c_id;
		}else if(c_id.length()==4) {
			c_id="M-00"+c_id;
			return c_id;
		}else if(c_id.length()==5) {
			c_id="M-0"+c_id;
			return c_id;
		}
		
		return c_id;
	}
	public String productStoreID(int id)
	{	
		id=id+1;
		String c_id=String.valueOf(id);
		
		if(c_id.length()==1) {
			c_id="S-00000"+c_id;
			return c_id;
		}else if(c_id.length()==2) {
			c_id="S-0000"+c_id;
			return c_id;
		}else if(c_id.length()==3) {
			c_id="S-000"+c_id;
			return c_id;
		}else if(c_id.length()==4) {
			c_id="S-00"+c_id;
			return c_id;
		}else if(c_id.length()==5) {
			c_id="S-0"+c_id;
			return c_id;
		}
		
		return c_id;
	}
	
	public String autoProductID(int id)
	{	
		id=id+1;
		String c_id=String.valueOf(id);
		
		if(c_id.length()==1) {
			c_id="P-00000"+c_id;
			return c_id;
		}else if(c_id.length()==2) {
			c_id="P-0000"+c_id;
			return c_id;
		}else if(c_id.length()==3) {
			c_id="P-000"+c_id;
			return c_id;
		}else if(c_id.length()==4) {
			c_id="S-00"+c_id;
			return c_id;
		}else if(c_id.length()==5) {
			c_id="P-0"+c_id;
			return c_id;
		}
		
		return c_id;
	}
	
	
}
