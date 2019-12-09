package bridalwear;

import java.sql.SQLException;

public class Customer {
	private String firstname;
	private String lastname;
	private String email;
	private String address;
	private String street;
	private String city;
	private String state;
	//private Integer zipcode;
	private String mobile;
	//private Integer phone;
	private String creditcard;
	private String expired;
	private Integer no;
	
	public String getFirstName(){
		return firstname;
	}
    public void setFirstName(String firstname) {
    	this.firstname = firstname;
    }
    public String getLastName(){
		return lastname;
	}
    public void setLastName(String lastname) {
    	this.lastname = lastname;
    }
    public String getEmail(){
		return email;
	}
    public void setEmail(String email) {
    	this.email = email;
    }
    
    public String getMobile() {
    	return mobile;
    }
    public void setMobile(String mobile) {
    	this.mobile = mobile;
    }
    public String getAddress() {
    	return address;
    }
    public void setAddress(String address) {
    	this.address = address;
    }
    public String getStreet(){
		return street;
	}
    public void setStreet(String street) {
    	this.street = street;
    }
    public String getCity(){
		return city;
	}
    public void setCity(String city) {
    	this.city = city;
    }
    public String getState() {
    	return state;
    }
    public void setState(String state) {
    	this.state = state;
    }
    public String getCreditcard(){
		return creditcard;
	}
    public void setCreditCard(String creditcard) {
    	this.creditcard = creditcard;
    }
    public String getExpired(){
		return expired;
	}
    public void setExpired(String expired) {
    	this.expired = expired;
    }
    public Integer getNo() {
    	return no;
    }
    public void setNo(Integer no) {
    	this.no = no;
    }
    
  public String genInsertSql(){
	  try
	  {
		  MysqlUtils mysql= new MysqlUtils();
		  int maxno =mysql.queryMaxNo();
		  maxno=maxno+1;
		  this.no=maxno;
		  String s="INSERT INTO customer(no,firstname,lastname,email,mobile,address,street,city,state,creditcard,expired)values(" + maxno + ",'" + this.firstname +"','"+ this.lastname +"','"+ this.email +"','"+ this.mobile +"','"+ this.address+"','"+ this.street +"','"+ this.city +"','"+ this.state +"','"+ this.creditcard +"','"+ this.expired +"')";		  
		  return s;
	  
	  }catch (SQLException e){
		  e.printStackTrace();
		  
	  }
    
     return "";
}
}