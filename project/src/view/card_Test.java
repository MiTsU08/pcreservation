package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import CardPay.CardDAO;
import CardPay.CardVO;

public class card_Test {

	private JFrame frame;
	private JTextField CardNum1;
	private JLabel labelexpiry;
	private JLabel labelCompany;
	private JLabel labelmonth;
	private JTextField monthtext;
	private JLabel labelOwner;
	private JTextField textOwner;
	private JLabel labelTime;
	private JComboBox CardcomboBox;
	private JComboBox TimeComboBox;
	private JLabel labelPrice;
	private JTextField TextPrice;
	private JLabel lblNewLabel_8;
	
	 CardVO vo;
	 CardDAO dao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 card_Test window = new card_Test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public  card_Test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setTitle("\uCDA9\uC804\uD558\uAE30");
		frame.setFont(new Font("나눔스퀘어", Font.PLAIN, 12));
		frame.setForeground(Color.PINK);
		frame.setBounds(100, 100, 558, 397);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnChargeButton = new JButton("충전하기");
		btnChargeButton.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 12));
		btnChargeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//카드결제정보가져오기 
				//카드번호
				String CardNum=CardNum1.getText();
				//유효기간
				String expiry=monthtext.getText();
				//카드사
				String company=CardcomboBox.getSelectedItem().toString();
				//소유자이름
				String owner=textOwner.getText();
				//선택한 충전시간
				int time=(int)TimeComboBox.getSelectedItem();
				
				vo=new CardVO(CardNum,owner,expiry,company,CardNum);
				 
				 
				 try {
					 //일단충전시간 int로 받겠음 
					 int chargetime=(int)TimeComboBox.getSelectedItem();
	    			  //주소넘겨줬음
	    			  dao.insert(vo,chargetime);
	    			  //결제금액창에 요금뿌리는거 여기다가하기 
	    			  System.out.println("충전성공에 성공했습니다!");
	    			  clearScreen();
	    	  }catch(Exception e1) {
	    		  JOptionPane.showMessageDialog(null, "충전 실패 : " + e1.getMessage());
	    	  }
			}

			private void clearScreen() {
				CardNum1.setText("");
				monthtext.setText("");
				//콤보박스는 원래대로 어케돌리지????
				textOwner.setText("");
				//콤보박스 두개어케돌릴지 생각해야함 ,,~!
				
			}
		});
		
		
		btnChargeButton.setBounds(408, 304, 110, 44);
		frame.getContentPane().add(btnChargeButton);
		
		JLabel lblNewLabel = new JLabel("카드번호");
		lblNewLabel.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 12));
		lblNewLabel.setBounds(59, 60, 57, 15);
		frame.getContentPane().add(lblNewLabel);
		
		CardNum1 = new JTextField();
		CardNum1.setBounds(126, 57, 249, 21);
		frame.getContentPane().add(CardNum1);
		CardNum1.setColumns(10);
		
		JLabel labelexpiry = new JLabel("유효기간");
		labelexpiry.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 12));
		labelexpiry.setBounds(59, 100, 57, 15);
		frame.getContentPane().add(labelexpiry);
		
		labelCompany = new JLabel("카드사");
		labelCompany.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 12));
		labelCompany.setBounds(59, 145, 57, 15);
		frame.getContentPane().add(labelCompany);
		
		JComboBox CardcomboBox = new JComboBox();
		CardcomboBox.setBackground(new Color(255, 255, 255));
		CardcomboBox.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 12));
		CardcomboBox.setModel(new DefaultComboBoxModel(new String[] {"\uCE74\uB4DC\uC0AC\uB97C \uC120\uD0DD\uD574\uC8FC\uC138\uC694", "\uC2E0\uD55C\uCE74\uB4DC", "BC\uCE74\uB4DC", "KB\uAD6D\uBBFC\uCE74\uB4DC", "\uC0BC\uC131\uCE74\uB4DC", "\uD604\uB300\uCE74\uB4DC", "\uB86F\uB370\uCE74\uB4DC", "\uD558\uB098\uCE74\uB4DC", "NH\uB18D\uD611\uCE74\uB4DC", "\uC6B0\uB9AC\uCE74\uB4DC"}));
		CardcomboBox.setBounds(126, 141, 156, 23);
		frame.getContentPane().add(CardcomboBox);
		
		monthtext = new JTextField();
		monthtext.setBounds(126, 97, 53, 21);
		frame.getContentPane().add(monthtext);
		monthtext.setColumns(10);
		
		JLabel labelmonth = new JLabel("\uC6D4/\uB144");
		labelmonth.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 12));
		labelmonth.setBounds(191, 100, 25, 15);
		frame.getContentPane().add(labelmonth);
		
		labelOwner = new JLabel("소유자명");
		labelOwner.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 12));
		labelOwner.setBounds(59, 188, 57, 15);
		frame.getContentPane().add(labelOwner);
		
		textOwner = new JTextField();
		textOwner.setBounds(126, 185, 76, 21);
		frame.getContentPane().add(textOwner);
		textOwner.setColumns(10);
		
		labelTime = new JLabel("충전시간");
		labelTime.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 12));
		labelTime.setBounds(59, 232, 57, 15);
		frame.getContentPane().add(labelTime);
		
		TimeComboBox = new JComboBox();
		TimeComboBox.setBackground(new Color(255, 255, 255));
		TimeComboBox.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 12));
		TimeComboBox.setModel(new DefaultComboBoxModel(new String[] {"\uCDA9\uC804\uC2DC\uAC04\uC744 \uC120\uD0DD\uD574\uC8FC\uC138\uC694", "1", "3", "5", "7", "9", "12", "24"}));
		TimeComboBox.setBounds(126, 228, 179, 23);
		frame.getContentPane().add(TimeComboBox);
		
		labelPrice = new JLabel("결제금액");
		labelPrice.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 12));
		labelPrice.setBounds(59, 275, 57, 15);
		frame.getContentPane().add(labelPrice);
		
		TextPrice = new JTextField();
		TextPrice.setBounds(126, 272, 76, 21);
		frame.getContentPane().add(TextPrice);
		TextPrice.setColumns(10);
		
		lblNewLabel_8 = new JLabel("\uC6D0");
		lblNewLabel_8.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 12));
		lblNewLabel_8.setBounds(209, 275, 57, 15);
		frame.getContentPane().add(lblNewLabel_8);
	}
}
