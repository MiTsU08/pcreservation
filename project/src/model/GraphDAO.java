package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import model.rec.GraphVO;


public class GraphDAO {
	

	   public GraphDAO() throws Exception {
	      connectDB();
	   }

	   
	   // DB control method
	   Connection conn = null;
	   String driver = "oracle.jdbc.driver.OracleDriver";
	   String url = "jdbc:oracle:thin:@192.168.0.6:1521:orcl";
	   String user = "PCreserve";
	   String pass = "1234";

	   void connectDB() throws Exception {
	      Class.forName(driver); // 클래스를 메모리에 로딩
	      conn = DriverManager.getConnection(url, user, pass); // 디비 연결객체 얻어오기
	   }

	   public GraphVO graph() throws Exception{
		   String sql = "SELECT COUNT(USER_CODE)\"시간대별 이용자수\" FROM USING_HISTORY GROUP BY USING_CODE";
				   GraphVO gr = new GraphVO();
				   Statement stmt = conn.createStatement();
				   
				   ResultSet rs = stmt.executeQuery(sql);
				   if(rs.next()) {
						  gr.setUSING_HISTORY_CODE(rs.getString("USING_HISTORY_CODE"));
						  gr.setUSER_CODE(rs.getInt("USER_CODE"));
						  gr.setUSING_START_TIME(rs.getDate("USING_START_TIME"));
						  gr.setUSING_END_TIME(rs.getDate("USING_END_TIME"));
				   }
				   rs.close();
				   stmt.close();
				   return gr;
	   }
}
