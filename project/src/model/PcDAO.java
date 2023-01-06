package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.rec.CustomerVO;

public class PcDAO {

	// �������
	String user_code;
	String id;
	String password;
	String name;
	String social_num;
	String tel;
	String email;
	int usable_time;
	String manager;

	// getter and setter
	public String getUser_code() {
		return user_code;
	}

	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSocial_num() {
		return social_num;
	}

	public void setSocial_num(String social_num) {
		this.social_num = social_num;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUsable_time() {
		return usable_time;
	}

	public void setUsable_time(int usable_time) {
		this.usable_time = usable_time;
	}

	public String isManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	// #####################
	Connection conn;
	String url = "jdbc:oracle:thin:@192.168.0.6:1521:orcl";
	String user = "PCreserve";
	String pass = "1234";

	public PcDAO() throws Exception {
		/*
		 * ============================================ ������ �Լ� - DB ���� 1. ����̹��� �ε� 2.
		 * Connection ������
		 */
		Class.forName("oracle.jdbc.driver.OracleDriver"); // 1. Ŭ������ �޸𸮿� �ε�
		conn = DriverManager.getConnection(url, user, pass);// 2. ��� ���ᰴü ������
	}

	public userVO searchName(String name) throws Exception {
		String sql = "select id,password,social_num,tel,email from pc_user where name=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		userVO vo = new userVO();
		while (rs.next()) {
			vo.setId(rs.getString("id"));
			vo.setPassword(rs.getString("password"));
			vo.setSocialNum(rs.getString("social_num"));
			vo.setTel(rs.getString("tel"));
			vo.setEmail(rs.getString("email"));
		}
		rs.close();
		ps.close();
		return vo;
	}

	public void modify(String name, userVO2 vo2) throws Exception {
		String sql = "update pc_user set password=?,tel=?,email=? where name=? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, vo2.getPassword());
		ps.setString(2, vo2.getTel());
		ps.setString(3, vo2.getEmail());
		ps.setString(4, name);

		ps.executeUpdate();
		ps.close();
	}

	// 1.�����ϰ�쿡 �ٳ�����
	public ArrayList infoallsearch() throws Exception {
		ArrayList list = new ArrayList();
		Statement stmt = conn.createStatement();

		String sql = "select user_code, id,password,name,social_num,tel,email,usable_time from pc_user";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("user_code"));
			temp.add(rs.getString("id"));
			temp.add(rs.getString("password"));
			temp.add(rs.getString("name"));
			temp.add(rs.getString("social_num"));
			temp.add(rs.getString("tel"));
			temp.add(rs.getString("email"));
			temp.add(rs.getInt("usable_time"));

			list.add(temp);
		}
		rs.close();
		ps.close();

		return list;
	}

//2. �̸� �˻��ϸ� �̸��� �´� ������ ������
	public ArrayList infosearch(String name) throws Exception {
		ArrayList list = new ArrayList();
		Statement stmt = conn.createStatement();

		String sql = "select user_code, id,password,name,social_num,tel,email,usable_time from pc_user where name=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("user_code"));
			temp.add(rs.getString("id"));
			temp.add(rs.getString("password"));
			temp.add(rs.getString("name"));
			temp.add(rs.getString("social_num"));
			temp.add(rs.getString("tel"));
			temp.add(rs.getString("email"));
			temp.add(rs.getInt("usable_time"));

			list.add(temp);
		}
		rs.close();
		ps.close();

		return list;
	}

	// 3.�̸����޾ƿͼ� ��������
	public userVO3 infonamesearch(String name) throws Exception {
		String sql = "select id,password,social_num,name,tel,email from pc_user where name=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		userVO3 vo3 = new userVO3();
		while (rs.next()) {
			vo3.setId(rs.getString("id"));
			vo3.setPassword(rs.getString("password"));
			vo3.setSocialNum(rs.getString("social_num"));
			vo3.setName(rs.getString("name"));
			vo3.setTel(rs.getString("tel"));
			vo3.setEmail(rs.getString("email"));
		}
		rs.close();
		ps.close();
		return vo3;
	}

	// 3-1.�̸������� ���̺����������ͼ����ϸ� ��������
	public userVO3 infonamesearch2_1(String vNum) throws Exception {
		String sql = "select id,password,social_num,name,tel,email from pc_user where user_code=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, vNum);
		ResultSet rs = ps.executeQuery();
		userVO3 vo3 = new userVO3();
		while (rs.next()) {
			vo3.setId(rs.getString("id"));
			vo3.setPassword(rs.getString("password"));
			vo3.setSocialNum(rs.getString("social_num"));
			vo3.setName(rs.getString("name"));
			vo3.setTel(rs.getString("tel"));
			vo3.setEmail(rs.getString("email"));
		}
		rs.close();
		ps.close();
		return vo3;
	}

	// �ϳ��� �Է¾��ϸ� �������ѱ�� �޼���
	public userVO4 informationsearch2(String id) throws Exception {
		String sql = "select password,name,tel,email from pc_user where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		userVO4 vo4 = new userVO4();
		while (rs.next()) {
			vo4.setPassword(rs.getString("password"));
			vo4.setName(rs.getString("name"));
			vo4.setTel(rs.getString("tel"));
			vo4.setEmail(rs.getString("email"));
		}
		rs.close();
		ps.close();
		return vo4;
	}

	// ������-ȸ�����������Ѱ� DB�� �ѱ��
	public void modify2(String id, userVO4 vo4) throws Exception {
		String sql = "update pc_user set password=?,name=?,tel=?,email=? where id=? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, vo4.getPassword());
		ps.setString(2, vo4.getName());
		ps.setString(3, vo4.getTel());
		ps.setString(4, vo4.getEmail());
		ps.setString(5, id);

		ps.executeUpdate();
		ps.close();
	}

	// �����ð� ��ȸ�ϱ�
	public userVO5 searchTime(String name) throws Exception {
		String sql = "select usable_time from pc_user where name=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		userVO5 vo5 = new userVO5();
		while (rs.next()) {
			vo5.setTime(rs.getInt("usable_time"));
		}
		return vo5;
	}

	// ���̿�ð� ��ȸ�ϱ�
	public userTime searchTime2(String name) throws Exception {
		String sql = "select sum(to_char(USING_END_TIME,'HH24')-to_char(USING_START_TIME,'HH24')) as sum from using_history"
				+ " where user_code=(select user_code from pc_user where name=?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		userTime ut = new userTime();

		while (rs.next()) {
			ut.setTime(rs.getString("sum"));
		}
		return ut;
	}
	
	//1��6�� 
	//����ð����� �����ڵ尡������
	public revVO searchCode(String vNum) throws Exception{
		String sql="select user_code from booking where to_char(booking_date,'YYYY-MM-DD HH24:MI:ss')=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, vNum);
		ResultSet rs = ps.executeQuery();
		 revVO  rev = new revVO();
		while (rs.next()) {
			rev.setCode(rs.getString("user_code"));
		}
		return rev;
	}
	
	

}
