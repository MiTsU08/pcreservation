package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.rec.SignUp1VO;

public class SignUp1DAO {
	PreparedStatement ps;
	ResultSet rs;

	public SignUp1DAO() throws Exception {
		connectDB();
	}

	// DB control method
	Connection conn = null;
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.0.6:1521:orcl";
	String user = "PCreserve";
	String pass = "1234";

	void connectDB() throws Exception {
		/*
		 * 1. 드라이버를 드라이버메니저에 등록 2. 연결 객체 얻어오기
		 */

		Class.forName(driver); // 클래스를 메모리에 로딩
		conn = DriverManager.getConnection(url, user, pass); // 디비 연결객체 얻어오기
	}
	// 회원가입을 하면 데이터베이스에 해당 데이터 값이 넘어가는 메소드
	public void insert(SignUp1VO vo) throws Exception {
		/*
		 * 1. sql 작성하기 ( insert 문 작성 : 멤버필드를 변수로 지정하여 ) 2. sql 전송객체 얻어오기 (
		 * PreparedStatement가 더 적합할 듯 ) 3. sql 전송 ( 전송전에 ?로 지정 ) 4. 닫기 ( Connection은 닫으면
		 * 안됨 )
		 */
		// prepared? 연결??
		String sql = "INSERT INTO PC_USER(USER_CODE, ID, PASSWORD, NAME, SOCIAL_NUM, TEL, EMAIL,MANAGER)"
				+ "VALUES(CODE_SEQ.nextval, ?,?,?,?,?,?,'N')";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, vo.getId());
		ps.setString(2, vo.getPassword());
		ps.setString(3, vo.getName());
		ps.setString(4, vo.getSocial_num());
		ps.setString(5, vo.getTel());
		ps.setString(6, vo.getEmail());

		ps.executeUpdate();

		ps.close();

	}
	// 아이디 중복체크 메소드
	public boolean getIdByCheck(String id) throws Exception{
			
			String sql = "SELECT id FROM PC_USER WHERE id=?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
//				System.out.println(id);
				return false; // 레코드가 존재하면 false
			} else {
				return true; 
			}
	}// getIdByCheck()
	
	public void dbClose() {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
		} catch (Exception e) {
			System.out.println(e + "=> dbClose fail");
		}
	}// dbClose() ---

}
