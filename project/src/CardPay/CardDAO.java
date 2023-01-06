package CardPay;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CardDAO {
	 public   CardDAO() throws Exception{
	       connectDB();
	    }

	    //###########################################################
	    //   DB  control method
	    Connection            con;
	    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "PCreserve";
		String pass = "1234";
		
		 void  connectDB() throws Exception {
	    		Class.forName("oracle.jdbc.driver.OracleDriver");         // 1. 클래스를 메모리에 로딩
	    		con = DriverManager.getConnection(url, user, pass);   // 2. 디비 연결객체 얻어오기
	    }
		 
		  public  void  insert(CardVO vo,int chargetime)  throws Exception{
			  //1.카드결제한거 테이블로 보내야함 (일단 insert)
			  String sql="insert into card(card_code,owner,expiry_date,company,card_number) values(?,?,?,?,?)";
			  PreparedStatement ps=con.prepareStatement(sql);
			  ps.setString(1, vo.getCode());
			  ps.setString(2,vo.getOwner());
			  ps.setString(3, vo.getExpiry());
			  ps.setString(4,vo.getCompany());
			  ps.setString(5,vo.getCardNum());
			  ps.executeUpdate();
//			  ps.close();
					  //paycode 올리긴해야되는데 어디서가져와서 올리지,,? -이게문제임
			  //충전시간에 맞는 요금가져오는 sql문작성 
			  String sql2="select from where"
			  
			  
			 //2.결제정보가져와서 충전시간을 유저테이블로 올려야되고
			//3.충전시간에 맞는 요금을 다시 card_test에가서 뿌려야함 
		  }
}
