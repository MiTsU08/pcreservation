package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.rec.LoginVO;

public class LoginDaoEx {
	public LoginDaoEx() throws Exception {
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

	// 성공 1, 실패 -1, 없음 0
	// 아이디랑 비밀번호를 데이터에서 찾아서 회원인지 아닌지 판별 유무
	public int findByIdAndPassword(String id, String pw) {
		// 1. DB 연결

		try {
			// 2. Query 작성
			String sql = "select ID, password from PC_USER where ID = ? and password = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);

			// 3. Query ? 완성 (index 1번 부터 시작)
			// setString, setInt, setDouble, setTimeStamp 등이 있음.
			ps.setString(1, id);
			ps.setString(2, pw);

			ResultSet rs = ps.executeQuery();
			// 4. Query 실행
			// (1) executeQuery() = select = ResultSet 리턴
			// (2) executeUpdate() = insert, update, delete = 리턴 없음.
			

			// 5. rs는 query한 결과의 첫번째 행(레코드) 직전에 대기중
			// 결과가 count(*) 그룹함수이기 때문에 1개의 행이 리턴됨. while문이 필요 없음.
			if (rs.next()) { // next()함수는 커서를 한칸 내리면서 해당 행에 데이터가 있으면 true, 없으면 false 반환
				
				// 결과가 있다는 것은 해당 아이디와 비번에 매칭되는 값이 있다는 뜻.
				return 1; // 로그인 성공
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1; // 로그인 실패
	}
	// id를 기준으로 관리자인지 아닌지 구분하는 메소드
	public boolean isPossible(String id) throws Exception {
		String sql = "select id from pc_user where id = ? and manager = 'Y'";

		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setString(1, id);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			return true;
		} else {
			return false;
		}

	}
	
	
	
	////
	public int getUsercode(String id) throws Exception{
		int usercode=0;
		String sql="select user_code from pc_user where id=? ";
		PreparedStatement ps=conn.prepareStatement(sql);
//		String id=vo.getId();
		ps.setString(1, id);
		ps.setString(1, id);
		
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			usercode=rs.getInt("user_code");
			
		}
		rs.close();ps.close();
		return usercode;
	}



}
