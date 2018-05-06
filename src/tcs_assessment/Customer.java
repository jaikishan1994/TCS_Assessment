package tcs_assessment;

public class Customer {
	public int custId;
	public String custName;
	public char gender;
	public int age;
	public String emailId;
	public String address;
	
	public String getCustName(){
		return this.custName;
	}
	public void setCustName(String value){
		this.custName = value;
	}
	
	public int getCustId(){
		return this.custId;
	}
	public void setCustId(int value){
		this.custId = value;
	}
	
	public char getGender(){
		return this.gender;
	}
	public void setGender(char value) throws Exception{
		if(value == 'M' || value == 'F') {
			this.gender = value;	
		}
		else {
			throw new Exception("Invalid Gender, Please enter either of the values 'M' or 'F'. ");
		}
		
	}
	
	public int getAge(){
		return this.age;
	}
	public void setAge(int value) throws Exception{
		if(value > 18) {
			this.age = value;
		}
		else {
			throw new Exception("Invalid Age, Please enter age greater than 18.");
		}
	}
	
	public String getEmailId(){
		return this.emailId;
	}
	public void setEmailId(String value){
		this.emailId = value;
	}
	
	public String getAddress(){
		return this.address;
	}
	public void setAddress(String value){
		this.address = value;
	}
}