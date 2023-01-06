package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.rec.PaymentVO;

// 결제내역 DAO
public class PaymentDAO {
	public PaymentDAO() throws Exception{
		connectDB();
	}
	
	// DB 연결
	Connection conn = null;
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.0.6:1521:orcl";
	String user = "PCreserve";
	String pass = "1234";

	void connectDB() throws Exception{
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, pass);
	}
	
	// 기간 내 리스트 출력하는 메소드
	public ArrayList paymentListSearch(String startDate,String endDate)throws Exception{
        ArrayList list= new ArrayList();
        
        String sql="SELECT NAME, PAY_DATE, CHARGE_TIME, CHARGE_AMOUNT"
        		+ " FROM PAYMENT P, CHARGE C, PC_USER PU"
        		+ " WHERE P.RECHARGE_TIME_CODE = C.CHARGE_CODE AND P.USER_CODE = PU.USER_CODE"
        		+ " AND PAY_DATE >= ? AND PAY_DATE <= ? ";
        
        PreparedStatement ps=conn.prepareStatement(sql);
          ps.setString(1, startDate);
          ps.setString(2, endDate);
          
          ResultSet rs =  ps.executeQuery();
          
          while(rs.next()) {
             ArrayList temp = new ArrayList();
             
             temp.add(rs.getString("NAME"));
             temp.add(rs.getString("PAY_DATE"));
             temp.add(rs.getInt("CHARGE_TIME"));
             temp.add(rs.getString("CHARGE_AMOUNT"));
             
             list.add(temp);
          }
          rs.close();
          ps.close();
          
          
           return list;
     }
	
	// 기간 내 총금액 출력하는 메소드
	public String selectTotal(String startDate, String endDate)throws Exception {
		String TOTAL="";
		String sql = "SELECT SUM(CHARGE_AMOUNT) AS TOTAL FROM PAYMENT P, CHARGE C, PC_USER PU"
				+ " WHERE P.RECHARGE_TIME_CODE = C.CHARGE_CODE AND P.USER_CODE = PU.USER_CODE "
				+ " AND PAY_DATE >= ? AND PAY_DATE <= ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, startDate);
		ps.setString(2, endDate);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			TOTAL = String.valueOf(rs.getInt("TOTAL"));
			
		}
		return TOTAL;
	}

	
}
