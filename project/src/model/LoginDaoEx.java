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
		 * 1. ����̹��� ����̹��޴����� ��� 2. ���� ��ü ������
		 */

		Class.forName(driver); // Ŭ������ �޸𸮿� �ε�
		conn = DriverManager.getConnection(url, user, pass); // ��� ���ᰴü ������
	}

	// ���� 1, ���� -1, ���� 0
	// ���̵�� ��й�ȣ�� �����Ϳ��� ã�Ƽ� ȸ������ �ƴ��� �Ǻ� ����
	public int findByIdAndPassword(String id, String pw) {
		// 1. DB ����

		try {
			// 2. Query �ۼ�
			String sql = "select ID, password from PC_USER where ID = ? and password = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);

			// 3. Query ? �ϼ� (index 1�� ���� ����)
			// setString, setInt, setDouble, setTimeStamp ���� ����.
			ps.setString(1, id);
			ps.setString(2, pw);

			ResultSet rs = ps.executeQuery();
			// 4. Query ����
			// (1) executeQuery() = select = ResultSet ����
			// (2) executeUpdate() = insert, update, delete = ���� ����.
			

			// 5. rs�� query�� ����� ù��° ��(���ڵ�) ������ �����
			// ����� count(*) �׷��Լ��̱� ������ 1���� ���� ���ϵ�. while���� �ʿ� ����.
			if (rs.next()) { // next()�Լ��� Ŀ���� ��ĭ �����鼭 �ش� �࿡ �����Ͱ� ������ true, ������ false ��ȯ
				
				// ����� �ִٴ� ���� �ش� ���̵�� ����� ��Ī�Ǵ� ���� �ִٴ� ��.
				return 1; // �α��� ����
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1; // �α��� ����
	}
	// id�� �������� ���������� �ƴ��� �����ϴ� �޼ҵ�
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
