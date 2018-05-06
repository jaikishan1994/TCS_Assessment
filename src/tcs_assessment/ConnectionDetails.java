package tcs_assessment;

public class ConnectionDetails {

	public long mobile;
	public int custId;
	public int tariffId;
	public String connectionType;
	
	public long getMobileNo(){
		return this.mobile;		
	}
	public void setMobileNo(long value){
		this.mobile = value;
	}
	
	public int getCustId(){
		return this.custId;
	}
	public void setCustId(int value){
		this.custId = value;
	}
	public int getTeriffId(){
		return this.tariffId;
	}
    public void setTariffId(int value){
    	this.tariffId = value;
    }
	public String getConnectionType(){
		return this.connectionType;
	}
    public void setConnectionType(String value){
    	this.connectionType = value;
    }
}