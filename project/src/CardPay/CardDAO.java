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
	    		Class.forName("oracle.jdbc.driver.OracleDriver");         // 1. Ŭ������ �޸𸮿� �ε�
	    		con = DriverManager.getConnection(url, user, pass);   // 2. ��� ���ᰴü ������
	    }
		 
		  public  void  insert(CardVO vo,int chargetime)  throws Exception{
			  //1.ī������Ѱ� ���̺�� �������� (�ϴ� insert)
			  String sql="insert into card(card_code,owner,expiry_date,company,card_number) values(?,?,?,?,?)";
			  PreparedStatement ps=con.prepareStatement(sql);
			  ps.setString(1, vo.getCode());
			  ps.setString(2,vo.getOwner());
			  ps.setString(3, vo.getExpiry());
			  ps.setString(4,vo.getCompany());
			  ps.setString(5,vo.getCardNum());
			  ps.executeUpdate();
//			  ps.close();
					  //paycode �ø����ؾߵǴµ� ��𼭰����ͼ� �ø���,,? -�̰Թ�����
			  //�����ð��� �´� ��ݰ������� sql���ۼ� 
			  String sql2="select from where"
			  
			  
			 //2.�������������ͼ� �����ð��� �������̺�� �÷��ߵǰ�
			//3.�����ð��� �´� ����� �ٽ� card_test������ �ѷ����� 
		  }
}
