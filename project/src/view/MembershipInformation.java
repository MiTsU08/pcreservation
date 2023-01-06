package view;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MembershipInformation extends JFrame {

   JPanel contentPane;
   JTextField textField_6;
   JTextField textField_7;
   JTextField textField_8;
   JTextField textField_9;
   JTextField textField_10;
   JTextField textField_11;
   JTextField textField_12;
   JTable table;
   DefaultTableModel DtmStorage;
   JTable table_1;
   
   // JTable tableCompleteList;
   
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
	   
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               MembershipInformation frame = new MembershipInformation();
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the frame.
    */
   public MembershipInformation() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 923, 552);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JPanel panel_1 = new JPanel();
      panel_1.setBorder(new TitledBorder("회원정보 수정"));
      panel_1.setBounds(12, 10, 285, 493);
      contentPane.add(panel_1);
      panel_1.setLayout(null);
      
      JLabel lblNewLabel_6 = new JLabel("회원이름");
      lblNewLabel_6.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 12));
      lblNewLabel_6.setBounds(26, 90, 71, 15);
      panel_1.add(lblNewLabel_6);
      
      textField_6 = new JTextField();
      textField_6.setBounds(99, 87, 116, 21);
      textField_6.setColumns(10);
      panel_1.add(textField_6);
      
      JLabel lblNewLabel_1_1 = new JLabel("아이디");
      lblNewLabel_1_1.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 12));
      lblNewLabel_1_1.setBounds(26, 142, 48, 15);
      panel_1.add(lblNewLabel_1_1);
      
      textField_7 = new JTextField();
      textField_7.setEnabled(false);
      textField_7.setBounds(99, 139, 116, 21);
      textField_7.setColumns(10);
      panel_1.add(textField_7);
      
      JLabel lblNewLabel_2_1 = new JLabel("비밀번호");
      lblNewLabel_2_1.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 12));
      lblNewLabel_2_1.setBounds(26, 196, 60, 15);
      panel_1.add(lblNewLabel_2_1);
      
      textField_8 = new JTextField();
      textField_8.setBounds(99, 193, 116, 21);
      textField_8.setColumns(10);
      panel_1.add(textField_8);
      
      JLabel lblNewLabel_3_1 = new JLabel("주민번호");
      lblNewLabel_3_1.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 12));
      lblNewLabel_3_1.setBounds(26, 250, 60, 15);
      panel_1.add(lblNewLabel_3_1);
      
      textField_9 = new JTextField();
      textField_9.setEnabled(false);
      textField_9.setBounds(99, 247, 116, 21);
      textField_9.setColumns(10);
      panel_1.add(textField_9);
      
      JLabel lblNewLabel_4_1 = new JLabel("전화번호");
      lblNewLabel_4_1.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 12));
      lblNewLabel_4_1.setBounds(26, 305, 60, 15);
      panel_1.add(lblNewLabel_4_1);
      
      textField_10 = new JTextField();
      textField_10.setBounds(99, 302, 116, 21);
      textField_10.setColumns(10);
      panel_1.add(textField_10);
      
      JLabel lblNewLabel_5_1 = new JLabel("이메일");
      lblNewLabel_5_1.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 12));
      lblNewLabel_5_1.setBounds(26, 359, 48, 15);
      panel_1.add(lblNewLabel_5_1);
      
      textField_11 = new JTextField();
      textField_11.setBounds(99, 356, 116, 21);
      textField_11.setColumns(10);
      panel_1.add(textField_11);
      
      JButton btnNewButton_1 = new JButton("수정하기");
      btnNewButton_1.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 15));
      btnNewButton_1.setBounds(146, 433, 127, 50);
      panel_1.add(btnNewButton_1);
      
      JLabel lblNewLabel = new JLabel("\uC218\uC815\uD560 \uC815\uBCF4\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694");
      lblNewLabel.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 15));
      lblNewLabel.setBounds(48, 33, 167, 15);
      panel_1.add(lblNewLabel);
      
      JPanel panel = new JPanel();
      panel.setBorder(new TitledBorder("회원정보 조회"));
      panel.setBounds(309, 10, 586, 493);
      contentPane.add(panel);
      panel.setLayout(null);
      
      JLabel lblNewLabel_7 = new JLabel("회원이름");
      lblNewLabel_7.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 14));
      lblNewLabel_7.setBounds(91, 28, 57, 15);
      panel.add(lblNewLabel_7);
      
      textField_12 = new JTextField();
      textField_12.setBounds(153, 25, 286, 21);
      panel.add(textField_12);
      textField_12.setColumns(10);
      
      JButton btnNewButton_2 = new JButton("찾기");
      btnNewButton_2.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 14));
      btnNewButton_2.setBounds(451, 25, 69, 21);
      panel.add(btnNewButton_2);
      
      JScrollPane scrollpane = new JScrollPane();
      scrollpane.setBounds(12, 64, 562, 419);
      panel.add(scrollpane);
      
      
      String[] column= {"","","","","","","",""};
      DtmStorage = new DefaultTableModel(column,0) {
         public boolean isCellEitable(int row,int column) { //테이블 더블클릭시 수정여부 
            return true; //셀수정가능,불가능(return false)
         }
      }; 
      
      
      table = new JTable(DtmStorage);
      table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
      table.setBounds(12, 62, 345, 276);
      table.setAutoCreateRowSorter(true);
      scrollpane.setViewportView(table);
      
      DtmStorage.setColumnIdentifiers(new String[] {"유저코드","아이디","패스워드","이름","주민등록번호","전화번호","이메일","남은시간"});
      
      DtmStorage.addRow(
            new String[] {(String)"1", "immnie", "1234", "kiki", "971030", "01097387005","kikiiiii","1000"});
       table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
         table.getColumnModel().getColumn(0).setPreferredWidth(135);
         table.getColumnModel().getColumn(1).setPreferredWidth(135);
         table.getColumnModel().getColumn(2).setPreferredWidth(135);
         table.getColumnModel().getColumn(3).setPreferredWidth(135);
         table.getColumnModel().getColumn(4).setPreferredWidth(135);
         table.getColumnModel().getColumn(5).setPreferredWidth(135);
      

   }
}