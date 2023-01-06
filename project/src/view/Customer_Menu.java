package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import model.rec.LoginVO;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Customer_Menu {

   private JFrame frame;

//   /**
//    * Launch the application.
//    */
//   public static void main(String[] args) {
//      EventQueue.invokeLater(new Runnable() {
//         public void run() {
//            try {
//               Customer_Menu window = new Customer_Menu();
//               window.frame.setVisible(true);
//            } catch (Exception e) {
//               e.printStackTrace();
//            }
//         }
//      });
//   }

   /**
    * 
    * Create the application.
    */
   public Customer_Menu(int usercode) {
      initialize(usercode);
      
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize(int usercode) {
      frame = new JFrame();
      frame.setBounds(100, 100, 598, 440);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);
      frame.setVisible(true);
      
      JButton button_1 = new JButton("\uC608\uC57D\uD558\uAE30");
      button_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            new YAK();
        	 new ReserveView(usercode);
         }
      });
      button_1.setBounds(214, 86, 140, 36);
      frame.getContentPane().add(button_1);
      
      JButton button = new JButton("\uCDA9\uC804\uD558\uAE30");//충전하기
      button.setBounds(214, 170, 140, 36);
      frame.getContentPane().add(button);
      
      JButton btnMyInfo = new JButton("My Info");//회원정보
      btnMyInfo.setBounds(214, 257, 140, 36);
      frame.getContentPane().add(btnMyInfo);
   }
}