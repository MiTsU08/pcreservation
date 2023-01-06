package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ReserveDAO {
	
	String booking_code;
	int computer_number;
	int user_code;
	String booking_date;
	String cancelable;
	String b_start_time;
	String b_end_time;
	int service_time;
	
	public String getBooking_code() {
		return booking_code;
	}

	public void setBooking_code(String booking_code) {
		this.booking_code = booking_code;
	}

	public int getComputer_number() {
		return computer_number;
	}

	public void setComputer_number(int computer_number) {
		this.computer_number = computer_number;
	}

	public int getUser_code() {
		return user_code;
	}

	public void setUser_code(int user_code) {
		this.user_code = user_code;
	}

	public String getBooking_date() {
		return booking_date;
	}

	public void setBooking_date(String booking_date) {
		this.booking_date = booking_date;
	}

	public String getCancelable() {
		return cancelable;
	}

	public void setCancelable(String cancelable) {
		this.cancelable = cancelable;
	}

	public String getB_start_time() {
		return b_start_time;
	}

	public void setB_start_time(String b_start_time) {
		this.b_start_time = b_start_time;
	}

	public String getB_end_time() {
		return b_end_time;
	}

	public void setB_end_time(String b_end_time) {
		this.b_end_time = b_end_time;
	}

	public int getService_time() {
		return service_time;
	}

	public void setService_time(int service_time) {
		this.service_time = service_time;
	}

	//db연결
	Connection conn;
	String url = "jdbc:oracle:thin:@192.168.0.6:1521:orcl";
	String user = "PCreserve";
	String pass = "1234";

	   public ReserveDAO() throws Exception {
	      Class.forName("oracle.jdbc.driver.OracleDriver");
	      conn = DriverManager.getConnection(url, user, pass);
	   }
	   
	   //회원이 예약정보조회할떄
	   public ArrayList revSearch(String name)throws Exception{
		   ArrayList list= new ArrayList();
		   Statement stmt = conn.createStatement();

		  String sql="select booking_date,cancelable,computer_number,b_start_time,b_end_time from booking join pc_user using (user_code) where name=?";
		  PreparedStatement ps=conn.prepareStatement(sql);
		  ps.setString(1, name);
		  ResultSet rs =  ps.executeQuery();
		  while(rs.next()) {
			  ArrayList temp = new ArrayList();
			  temp.add(rs.getString("booking_date"));
			  temp.add(rs.getString("cancelable"));
			  temp.add(rs.getInt("computer_number"));
			  temp.add(rs.getString("b_start_time"));
			  temp.add(rs.getString("b_end_time"));
			  
			  list.add(temp);
		  }
		  rs.close();
		  ps.close();
		  
		   return list;
	   }

	   //관리자-기간안에 있는 예약완료자 구하기
	   public ArrayList revSearch2(String startDate,String startDate2)throws Exception{
		   ArrayList list= new ArrayList();
		   Statement stmt = conn.createStatement();
		   
		   //@@@@@where조건절에 완료된사람만보이는 조건절 하나더줘야할거같음
		   String sql="select booking_date,name, computer_number,b_start_time,b_end_time,cancelable "
		   		+ "from booking join pc_user using (user_code)"
		   		+ " where b_start_time>=? and b_start_time<=? ";
		   
		   PreparedStatement ps=conn.prepareStatement(sql);
			  ps.setString(1, startDate);
			  ps.setString(2,startDate2);
			  ResultSet rs =  ps.executeQuery();
			  
			  while(rs.next()) {
				  ArrayList temp = new ArrayList();
				  temp.add(rs.getString("booking_date"));
				  temp.add(rs.getString("name"));
				  temp.add(rs.getInt("computer_number"));
				  temp.add(rs.getString("b_start_time"));
				  temp.add(rs.getString("b_end_time"));
				  temp.add(rs.getString("cancelable"));
				  
				  list.add(temp);
			  }
			  rs.close();
			  ps.close();
			  
			   return list;
	   }
	   
	   //관리자-기간안에 있는 예약취소자 찾기
	   public ArrayList revSearch3(String startDate3,String startDate4)throws Exception{
		   ArrayList list= new ArrayList();
		   Statement stmt = conn.createStatement();
		   
		   String sql="select name, computer_number,b_start_time,b_end_time,cancel_time,refund_charge from booking join pc_user using (user_code) join booking_cancel using (booking_code) where b_start_time>=? and b_start_time<=?";
		   
		   PreparedStatement ps=conn.prepareStatement(sql);
			  ps.setString(1, startDate3);
			  ps.setString(2,startDate4);
			  ResultSet rs =  ps.executeQuery();
			  
			  while(rs.next()) {
				  ArrayList temp = new ArrayList();
				  temp.add(rs.getString("name"));
				  temp.add(rs.getInt("COMPUTER_NUMBER"));
				  temp.add(rs.getString("B_START_TIME"));
				  temp.add(rs.getString("B_END_TIME"));
				  temp.add(rs.getString("CANCEL_TIME"));
				  temp.add(rs.getInt("REFUND_CHARGE"));
				  
				  list.add(temp);
			  }
			  rs.close();
			  ps.close();
		   return list;
	   }
	   
	   //
}
