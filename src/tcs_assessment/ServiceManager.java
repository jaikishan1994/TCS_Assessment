package tcs_assessment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class ServiceManager {

	private static final String URL = "jdbc:mysql://127.0.0.1:3306/DB_TCS";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "root";

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public void addCustomerAndConnection(Customer custObj,ConnectionDetails connObj,int tariffId){

		String query_test_tariff = "SELECT COUNT([Tariff_Id]) FROM [DB_TCS].[dbo].[tblDB_TCS_Tariff_Dtls]"+
						"WHERE Tariff_Id = " + tariffId;
		
		String query_customer = "INSERT INTO [DB_TCS].[dbo].[tblDB_TCS_Customer_Dtls]" + 
				"  ([Customer_Id],[Customer_Name],[Gender],[Age],[emailId],[Address])"+
				"values ("+custObj.custId +","+ "'"+custObj.custName+"'" +","+ "'"+custObj.gender+"'" + "," +
				custObj.age + "," + "'"+custObj.emailId+"'"+"," + "'"+custObj.address+"'" + ")";
		
		String query_con = "INSERT INTO [DB_TCS].[dbo].[tblDB_TCS_Connection_Dtls]"+
				  "([Mobile_Number],[Customer_Id],[Tariff_Id],[Connection_Type])"+
				"values (" + connObj.mobile + "," + connObj.custId + "," + connObj.tariffId + "," + "'"+connObj.connectionType+"'"+")"; 
						

		try {

			conn = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
			
			stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(query_test_tariff);
			int rows = rs.getInt("Tariff_Id");
				
				rs.close();
				
			if(rows>0) {	/* Validating Tariff_Id */
				rs = stmt.executeQuery(query_customer);	/*Inserting customer data after validation */
				rs.close();
				rs = stmt.executeQuery(query_con); /*Inserting connection data after validation */
				rs.close();
				stmt.close();
				conn.close();
			}
			else {
				throw new Exception("Tariff_Id is not present in the Tariff table, so please make sure it is present in it");
			}
		}catch(Exception msg) {
			System.out.println(msg);
		}
	}
	public ArrayList<ResultSet> getAllTariff(long value){
		
			ArrayList<ResultSet> output = new ArrayList <ResultSet>();

			String query = "SELECT [T].[Tariff_Id],[T].[Tariff_NAme],[T].Plan_Type,[T].Charge,[T].[Validity]"+
				"FROM [DB_TCS].[dbo].[tblDB_TCS_Tariff_Dtls] AS T JOIN [DB_TCS].[dbo].[tblDB_TCS_Connection_Dtls] C"+
				"ON [C].[Tariff_Id] = [T].[Tariff_Id]"+
				"WHERE [C].[Mobile_Number] = " + value;
			
			ResultSet res = null;
			
			try {
				conn = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
				
				stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
				rs = stmt.executeQuery(query);
				
				res = stmt.getResultSet();
				
				System.out.println("TariffId \t TariffName \t PlanType \t Charge \t Validity");
					while(rs.next()) {
						int Tariff_Id = rs.getInt("Tariff_Id");
						String Tariff_Name = rs.getString("Tariff_NAme");
						String Plan_Type = rs.getString("Plan_Type");
						double Charge = rs.getDouble("Charge");
						Date Validity = rs.getDate("Validity");
						stmt.getResultSet();
						
						System.out.println(Tariff_Id + "\t" + Tariff_Name + "\t" + Plan_Type + "\t" + Charge + "\t" + Validity);
					}
					rs.close();
					stmt.close();
					conn.close();
			}catch(Exception msg) {
				System.out.println(msg);
			}	
		return (ArrayList<ResultSet>) res;
		
	}
	public void changeTariff(long mobileNumber,int tariffID){
		
		String query_validate = "SELECT COUNT([Tariff_Id]) FROM  [DB_TCS].[dbo].[tblDB_TCS_Tariff_Dtls]"+
				  "WHERE [Tariff_Id] = "+tariffID;
		
		String query_changeTariff = "UPDATE [DB_TCS].[dbo].[tblDB_TCS_Connection_Dtls]" + 
				" SET [Tariff_Id] =" + tariffID + " WHERE [Mobile_Number] = " + mobileNumber;
		
		try {

			conn = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
			
			stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(query_validate);
			int rows = rs.getInt("Tariff_Id");
				
				rs.close();
				
			if(rows>0) {	/* Validating Tariff_Id */
				rs = stmt.executeQuery(query_changeTariff);	/*Updating Tariff Plan of the customer */
				rs.close();
				stmt.close();
				conn.close();
			}
			else {
				throw new Exception("Tariff_Id is not present in the Tariff table, so please make sure it is present in it");
			}
		}catch(Exception msg) {
			System.out.println(msg);
		}
		
	}
	
	public static void main(String args[]) 
	{
		Customer custObj = new Customer();
		ConnectionDetails connObj = new ConnectionDetails();
		Tariff tariffId = new Tariff();
	}
}
