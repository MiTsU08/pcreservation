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
		frame.setFont(new Font("����������", Font.PLAIN, 12));
		frame.setForeground(Color.PINK);
		frame.setBounds(100, 100, 558, 397);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnChargeButton = new JButton("�����ϱ�");
		btnChargeButton.setFont(new Font("����������_ac Bold", Font.PLAIN, 12));
		btnChargeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ī����������������� 
				//ī���ȣ
				String CardNum=CardNum1.getText();
				//��ȿ�Ⱓ
				String expiry=monthtext.getText();
				//ī���
				String company=CardcomboBox.getSelectedItem().toString();
				//�������̸�
				String owner=textOwner.getText();
				//������ �����ð�
				int time=(int)TimeComboBox.getSelectedItem();
				
				vo=new CardVO(CardNum,owner,expiry,company,CardNum);
				 
				 
				 try {
					 //�ϴ������ð� int�� �ް��� 
					 int chargetime=(int)TimeComboBox.getSelectedItem();
	    			  //�ּҳѰ�����
	    			  dao.insert(vo,chargetime);
	    			  //�����ݾ�â�� ��ݻѸ��°� ����ٰ��ϱ� 
	    			  System.out.println("���������� �����߽��ϴ�!");
	    			  clearScreen();
	    	  }catch(Exception e1) {
	    		  JOptionPane.showMessageDialog(null, "���� ���� : " + e1.getMessage());
	    	  }
			}

			private void clearScreen() {
				CardNum1.setText("");
				monthtext.setText("");
				//�޺��ڽ��� ������� ���ɵ�����????
				textOwner.setText("");
				//�޺��ڽ� �ΰ����ɵ����� �����ؾ��� ,,~!
				
			}
		});
		
		
		btnChargeButton.setBounds(408, 304, 110, 44);
		frame.getContentPane().add(btnChargeButton);
		
		JLabel lblNewLabel = new JLabel("ī���ȣ");
		lblNewLabel.setFont(new Font("����������_ac Bold", Font.PLAIN, 12));
		lblNewLabel.setBounds(59, 60, 57, 15);
		frame.getContentPane().add(lblNewLabel);
		
		CardNum1 = new JTextField();
		CardNum1.setBounds(126, 57, 249, 21);
		frame.getContentPane().add(CardNum1);
		CardNum1.setColumns(10);
		
		JLabel labelexpiry = new JLabel("��ȿ�Ⱓ");
		labelexpiry.setFont(new Font("����������_ac Bold", Font.PLAIN, 12));
		labelexpiry.setBounds(59, 100, 57, 15);
		frame.getContentPane().add(labelexpiry);
		
		labelCompany = new JLabel("ī���");
		labelCompany.setFont(new Font("����������_ac Bold", Font.PLAIN, 12));
		labelCompany.setBounds(59, 145, 57, 15);
		frame.getContentPane().add(labelCompany);
		
		JComboBox CardcomboBox = new JComboBox();
		CardcomboBox.setBackground(new Color(255, 255, 255));
		CardcomboBox.setFont(new Font("����������_ac Bold", Font.PLAIN, 12));
		CardcomboBox.setModel(new DefaultComboBoxModel(new String[] {"\uCE74\uB4DC\uC0AC\uB97C \uC120\uD0DD\uD574\uC8FC\uC138\uC694", "\uC2E0\uD55C\uCE74\uB4DC", "BC\uCE74\uB4DC", "KB\uAD6D\uBBFC\uCE74\uB4DC", "\uC0BC\uC131\uCE74\uB4DC", "\uD604\uB300\uCE74\uB4DC", "\uB86F\uB370\uCE74\uB4DC", "\uD558\uB098\uCE74\uB4DC", "NH\uB18D\uD611\uCE74\uB4DC", "\uC6B0\uB9AC\uCE74\uB4DC"}));
		CardcomboBox.setBounds(126, 141, 156, 23);
		frame.getContentPane().add(CardcomboBox);
		
		monthtext = new JTextField();
		monthtext.setBounds(126, 97, 53, 21);
		frame.getContentPane().add(monthtext);
		monthtext.setColumns(10);
		
		JLabel labelmonth = new JLabel("\uC6D4/\uB144");
		labelmonth.setFont(new Font("����������_ac Bold", Font.PLAIN, 12));
		labelmonth.setBounds(191, 100, 25, 15);
		frame.getContentPane().add(labelmonth);
		
		labelOwner = new JLabel("�����ڸ�");
		labelOwner.setFont(new Font("����������_ac Bold", Font.PLAIN, 12));
		labelOwner.setBounds(59, 188, 57, 15);
		frame.getContentPane().add(labelOwner);
		
		textOwner = new JTextField();
		textOwner.setBounds(126, 185, 76, 21);
		frame.getContentPane().add(textOwner);
		textOwner.setColumns(10);
		
		labelTime = new JLabel("�����ð�");
		labelTime.setFont(new Font("����������_ac Bold", Font.PLAIN, 12));
		labelTime.setBounds(59, 232, 57, 15);
		frame.getContentPane().add(labelTime);
		
		TimeComboBox = new JComboBox();
		TimeComboBox.setBackground(new Color(255, 255, 255));
		TimeComboBox.setFont(new Font("����������_ac Bold", Font.PLAIN, 12));
		TimeComboBox.setModel(new DefaultComboBoxModel(new String[] {"\uCDA9\uC804\uC2DC\uAC04\uC744 \uC120\uD0DD\uD574\uC8FC\uC138\uC694", "1", "3", "5", "7", "9", "12", "24"}));
		TimeComboBox.setBounds(126, 228, 179, 23);
		frame.getContentPane().add(TimeComboBox);
		
		labelPrice = new JLabel("�����ݾ�");
		labelPrice.setFont(new Font("����������_ac Bold", Font.PLAIN, 12));
		labelPrice.setBounds(59, 275, 57, 15);
		frame.getContentPane().add(labelPrice);
		
		TextPrice = new JTextField();
		TextPrice.setBounds(126, 272, 76, 21);
		frame.getContentPane().add(TextPrice);
		TextPrice.setColumns(10);
		
		lblNewLabel_8 = new JLabel("\uC6D0");
		lblNewLabel_8.setFont(new Font("����������_ac Bold", Font.PLAIN, 12));
		lblNewLabel_8.setBounds(209, 275, 57, 15);
		frame.getContentPane().add(lblNewLabel_8);
	}
}
