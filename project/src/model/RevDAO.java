package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import model.rec.RevVO;

public class RevDAO {

	Connection conn;
//	static Connection con;
	String URL = "jdbc:oracle:thin:@192.168.0.6:1521:orcl";
	String user = "PCreserve";
	String pass = "1234";

	public RevDAO() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");//
		conn = DriverManager.getConnection(URL, user, pass);//
	}

	public void PCreservation(RevVO vo) throws Exception {

//		System.out.println(vo.toString());
		String sql = "insert into booking(booking_code, computer_number, user_code, booking_date,  b_start_time, b_end_time) "
				+ "values('BOK'||code_seq.nextval,?,?,sysdate,to_date(?,'yyyy/mm/dd hh24:mi:ss'),to_date(?,'yyyy/mm/dd hh24:mi:ss'))";

		PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		ResultSet rs=ps.getGeneratedKeys();
		
		ps.setInt(1, vo.getPCNum());
		ps.setInt(2, vo.getUserCode());
		ps.setString(3, vo.getBookStart());
		ps.setString(4, vo.getBookend());

		ps.executeUpdate();
		ps.close();
		
		

		System.out.println("예약" + vo.toString());

	}
	
	
	
	public void BookDone(RevVO vo) throws Exception{
		
		String bookcode=checkBookSeq(vo);
		String sql="select * from pc_user p, booking b where p.user_code=b.user_code"
		               + " and b.booking_code='BOK'||?";
		
		
//		Statement sm=conn.createStatement();
		PreparedStatement ps=conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, bookcode);
		
		
		ResultSet rs=ps.executeQuery();
//		ResultSet rs=sm.executeQuery(sql);
		
		
		if(rs.next()) {//이름,예약일,시작,종료,컴번
			vo.setUserName(rs.getString("name"));
			vo.setBookStart(rs.getString("b_start_time"));
			vo.setBookend(rs.getString("b_end_time"));
			vo.setPCNum(rs.getInt("computer_number"));
		}
		rs.close();
		ps.close();
//		sm.close(); 
		System.out.println("완료"+vo.toString());
		
		
	}
	public String checkBookSeq(RevVO vo)throws Exception{
		String sql="select 'BOK'||code_Seq.CURRVAL from dual";
		
		Statement st=conn.createStatement();
		
		ResultSet rs=st.executeQuery(sql);
		if(rs.next()) {
			vo.setBookCode(rs.getString("CURRVAL"));
			
		}
		rs.close();st.close();
		String code=vo.getBookCode();
		return code;
	}

}
