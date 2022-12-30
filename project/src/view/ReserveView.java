package view;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import view.View.DatePick;

public class ReserveView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	static JButton choiceDate;
	static JTextField J_Text_Field;
	JLabel lblNewLabel;
	   JFrame J_Frame;
	   int DATE_MONTH = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
	    int DATE_YEAR = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);;
	    JLabel J_Label = new JLabel("", JLabel.CENTER);
	    String DATE_DAY = "";
	    JDialog J_Dialog;
	    JButton[] J_Button = new JButton[49];
	    
	    public DatePick(JFrame J_Frame_Parent) {
	        J_Dialog = new JDialog();
	        J_Dialog.setModal(true);
	        String[] Header = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
	        JPanel J_Panel1 = new JPanel(new GridLayout(7, 7));
	        J_Panel1.setPreferredSize(new Dimension(700, 120));

	        for (int i = 0; i < J_Button.length; i++) {
	            final int selection = i;
	            J_Button[i] = new JButton();
	            J_Button[i].setFocusPainted(false);
	            J_Button[i].setBackground(Color.white);
	            if (i > 6)
	                J_Button[i].addActionListener(new ActionListener() {
	                    public void actionPerformed(ActionEvent ae) {
	                        DATE_DAY = J_Button[selection].getActionCommand();
	                        J_Dialog.dispose();
	                    }
	                });
	            if (i < 7) {
	                J_Button[i].setText(Header[i]);
	                J_Button[i].setForeground(Color.red);
	            }
	            J_Panel1.add(J_Button[i]);
	        }
	        JPanel J_Panel2 = new JPanel(new GridLayout(1, 3));
	        JButton Previous_Button = new JButton("<< Previous");
	        Previous_Button.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent ae) {
	                DATE_MONTH--;
	                Display_Date();
	            }
	        });
	        J_Panel2.add(Previous_Button);
	        J_Panel2.add(J_Label);
	        JButton Next_Button = new JButton("Next >>");
	        Next_Button.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent ae) {
	                DATE_MONTH++;
	                Display_Date();
	            }
	        });
	        J_Panel2.add(Next_Button);
	        J_Dialog.add(J_Panel1, BorderLayout.CENTER);
	        J_Dialog.add(J_Panel2, BorderLayout.SOUTH);
	        J_Dialog.pack();
	        J_Dialog.setLocationRelativeTo(J_Frame_Parent);
	        Display_Date();
	        J_Dialog.setVisible(true);
	    }

	    public void Display_Date() {
	        for (int i = 7; i < J_Button.length; i++)
	            J_Button[i].setText("");
	        java.text.SimpleDateFormat Simple_Date_Format = new java.text.SimpleDateFormat(
	                "yyyy MM");
	        java.util.Calendar Calendar = java.util.Calendar.getInstance();
	        Calendar.set(DATE_YEAR, DATE_MONTH, 1);
	        int Day_Of_Week = Calendar.get(java.util.Calendar.DAY_OF_WEEK);
	        int Days_In_Month = Calendar.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
	        for (int i = 6 + Day_Of_Week, Day = 1; Day <= Days_In_Month; i++, Day++)
	            J_Button[i].setText("" + Day);
	        J_Label.setText(Simple_Date_Format.format(Calendar.getTime()));
	        J_Dialog.setTitle("Date Picker");
	    }

	    public String Set_Picked_Date() {
	        if (DATE_DAY.equals(""))
	            return DATE_DAY;
	        java.text.SimpleDateFormat Simple_Date_Format = new java.text.SimpleDateFormat(
	                "yyyy-MM-dd");
	        java.util.Calendar Calendar = java.util.Calendar.getInstance();
	        Calendar.set(DATE_YEAR, DATE_MONTH, Integer.parseInt(DATE_DAY));
	        return Simple_Date_Format.format(Calendar.getTime());
	    }

	public static void main(String[] args) {
		ReserveView frame = new ReserveView();
		frame.setVisible(true);
		choiceDate.addActionListener(new ActionListener() {
			
		     public void actionPerformed(ActionEvent ae) {
	                J_Text_Field.setText(new DatePick(J_Frame).Set_Picked_Date());
	            }
	        });
          
			
			
			
	}
			
			
			

	

	public ReserveView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JButton revButton = new JButton("예약하기");
		revButton.setBounds(10, 23, 122, 23);
		getContentPane().add(revButton);

		JButton revSerButton = new JButton("예약내역조회");
		revSerButton.setBounds(144, 23, 116, 23);
		getContentPane().add(revSerButton);

		List list = new List();
		list.setBounds(10, 69, 318, 287);
		getContentPane().add(list);

		 lblNewLabel = new JLabel("예약일자");
		lblNewLabel.setBounds(369, 82, 57, 15);
		final JTextField J_Text_Field = new JTextField(20);
		 choiceDate = new JButton("날짜 선택");
		JPanel J_Panel = new JPanel();
		
		J_Panel.add(lblNewLabel);
		J_Panel.add(J_Text_Field);
		J_Panel.add(choiceDate);
		J_Frame = new JFrame();
		J_Frame.getContentPane().add(J_Panel);
		J_Frame.pack();
		J_Frame.setVisible(true);

		contentPane.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("\uC2DC\uC791\uC2DC\uAC04");
		lblNewLabel_1_1.setBounds(348, 224, 70, 15);
		getContentPane().add(lblNewLabel_1_1);

		Choice end = new Choice();
		end.setBounds(424, 243, 81, 21);
		getContentPane().add(end);
		end.add("0시");
		end.add("1시");
		end.add("2시");
		end.add("3시");
		end.add("4시");
		end.add("5시");
		end.add("6시");
		end.add("7시");
		end.add("8시");
		end.add("9시");
		end.add("10시");
		end.add("11시");
		end.add("12시");
		end.add("13시");
		end.add("14시");
		end.add("15시");
		end.add("16시");
		end.add("17시");
		end.add("18시");
		end.add("19시");
		end.add("20시");
		end.add("21시");
		end.add("22시");
		end.add("23시");
		JLabel lblNewLabel_1 = new JLabel("\uC885\uB8CC\uC2DC\uAC04");
		lblNewLabel_1.setBounds(348, 249, 70, 15);
		getContentPane().add(lblNewLabel_1);

		Choice start = new Choice();
		start.setBounds(424, 218, 81, 21);
		getContentPane().add(start);
		start.add("0시");
		start.add("1시");
		start.add("2시");
		start.add("3시");
		start.add("4시");
		start.add("5시");
		start.add("6시");
		start.add("7시");
		start.add("8시");
		start.add("9시");
		start.add("10시");
		start.add("11시");
		start.add("12시");
		start.add("13시");
		start.add("14시");
		start.add("15시");
		start.add("16시");
		start.add("17시");
		start.add("18시");
		start.add("19시");
		start.add("20시");
		start.add("21시");
		start.add("22시");
		start.add("23시");

		JButton revSerButton_1 = new JButton("\uC608\uC57D\uD558\uAE30");
		revSerButton_1.setBounds(470, 292, 159, 64);
		getContentPane().add(revSerButton_1);

		JCheckBox ycheck = new JCheckBox("약관 동의");
		ycheck.setBounds(359, 299, 106, 51);
		getContentPane().add(ycheck);

		JLabel lblNewLabel_1_1_1 = new JLabel("\uC608\uC57D\uB0A0\uC9DC");
		lblNewLabel_1_1_1.setBounds(348, 131, 68, 15);
		contentPane.add(lblNewLabel_1_1_1);

		JTextArea txtrSd = new JTextArea();
		txtrSd.setText("\uC608\uC57D\uC77C\uC744 \uC120\uD0DD\uD558\uC138\uC694");
		txtrSd.setEditable(false);
		txtrSd.setBounds(414, 126, 140, 24);
		contentPane.add(txtrSd);

	}
}
