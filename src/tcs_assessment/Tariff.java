package tcs_assessment;

import java.sql.Date;

public class Tariff {
	public int tariffId;
	public String tariffName;
	public String planType;
	public double charge;
	public Date validity;
	
	public void setTariffId(int value){
		this.tariffId = value;
	}
	public int getTariffId(){
		return this.tariffId;
	}
	
	public String getTariffName(){
		return this.tariffName;
	}
	public void setTariffName(String value){
		this.tariffName = value;
	}
	
	public String getPlan(){
		return this.planType;
	}
	public void setPlan(String value) throws Exception{
		if(value.equals("Prepaid")|| value.equals("Postpaid")) {
			this.planType = value;
		}
		else {
			throw new Exception("Invalid PlanType, please choose either Prepaid or Postpaid");
		}
				
	}
	
	public double getCharge(){
		return this.charge;
	}
	public void setCharge(double value){
		this.charge = value;
	}
	
	public Date getValidity(){
		return this.validity;
	}
	public void setValidity(Date value){
		this.validity = value;
	}
}