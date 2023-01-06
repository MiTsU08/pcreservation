package view;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Manager_Menu {

	   private JFrame frame;

	   /**
	    * Launch the application.
	    */
	   public static void main(String[] args) {
	      EventQueue.invokeLater(new Runnable() {
	         public void run() {
	            try {
	            	Manager_Menu window = new Manager_Menu(23);
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
	   public Manager_Menu(int usercode) {
	      initialize(usercode);
	   }

	   /**
	    * Initialize the contents of the frame.
	    */
	   private void initialize(int usercode) {
	      frame = new JFrame();
	      frame.setTitle("\uAD00\uB9AC\uC790 \uBA54\uB274");
	      frame.getContentPane().setBackground(new Color(255, 255, 255));
	      frame.setBounds(100, 100, 654, 438);
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.getContentPane().setLayout(null);
	      frame.setVisible(true);
	      
	      JButton btnNewButton = new JButton("ȸ������ ����");
	      btnNewButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            new MembershipInformation();
	         }
	      });
//	      add(btnNewButton);

	      btnNewButton.setBackground(new Color(255, 255, 255));
	      btnNewButton.setFont(new Font("����������_ac Bold", Font.PLAIN, 12));
	      btnNewButton.setBounds(231, 37, 157, 40);
	      frame.getContentPane().add(btnNewButton);
	      
	      JButton btnNewButton_1 = new JButton("��ǻ�� ����");
	      btnNewButton_1.setBackground(new Color(255, 255, 255));
	      btnNewButton_1.setFont(new Font("����������_ac Bold", Font.PLAIN, 12));
	      btnNewButton_1.setBounds(231, 105, 157, 40);
	      frame.getContentPane().add(btnNewButton_1);
	      
	      JButton btnNewButton_2 = new JButton("�������� ����");
	      btnNewButton_2.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
//	            new manager_booking();
	         }
	      });
	      
	      btnNewButton_2.setBackground(new Color(255, 255, 255));
	      btnNewButton_2.setFont(new Font("����������_ac Bold", Font.PLAIN, 12));
	      btnNewButton_2.setBounds(231, 177, 157, 40);
	      frame.getContentPane().add(btnNewButton_2);
	      
	      JButton btnNewButton_3 = new JButton("�������� ����");
	      btnNewButton_3.setBackground(new Color(255, 255, 255));
	      btnNewButton_3.setFont(new Font("����������_ac Bold", Font.PLAIN, 12));
	      btnNewButton_3.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 new PaymentView();
	         }
	      });
	      btnNewButton_3.setBounds(231, 250, 157, 40);
	      frame.getContentPane().add(btnNewButton_3);
	      
	      JButton btnNewButton_4 = new JButton("�湮�� ���");
	      btnNewButton_4.setBackground(new Color(255, 255, 255));
	      btnNewButton_4.setFont(new Font("����������_ac Bold", Font.PLAIN, 12));
	      btnNewButton_4.setBounds(231, 320, 157, 40);
	      frame.getContentPane().add(btnNewButton_4);
	   }

	}