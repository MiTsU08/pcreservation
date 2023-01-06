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
		 * 1. ����̹��� ����̹��޴����� ��� 2. ���� ��ü ������
		 */

		Class.forName(driver); // Ŭ������ �޸𸮿� �ε�
		conn = DriverManager.getConnection(url, user, pass); // ��� ���ᰴü ������
	}
	// ȸ�������� �ϸ� �����ͺ��̽��� �ش� ������ ���� �Ѿ�� �޼ҵ�
	public void insert(SignUp1VO vo) throws Exception {
		/*
		 * 1. sql �ۼ��ϱ� ( insert �� �ۼ� : ����ʵ带 ������ �����Ͽ� ) 2. sql ���۰�ü ������ (
		 * PreparedStatement�� �� ������ �� ) 3. sql ���� ( �������� ?�� ���� ) 4. �ݱ� ( Connection�� ������
		 * �ȵ� )
		 */
		// prepared? ����??
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
	// ���̵� �ߺ�üũ �޼ҵ�
	public boolean getIdByCheck(String id) throws Exception{
			
			String sql = "SELECT id FROM PC_USER WHERE id=?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
//				System.out.println(id);
				return false; // ���ڵ尡 �����ϸ� false
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
