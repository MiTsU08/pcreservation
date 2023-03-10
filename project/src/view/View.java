package view;

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
import javax.swing.JTable;
import javax.swing.JTextField;

public class View extends JFrame {
	private JTable table;
	private JPanel contentPane;

	/**
	 * .
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();	
				}
			}
		});
	}
	class DatePick {
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
	                "MMMM yyyy");
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
	                "dd-MM-yyyy");
	        java.util.Calendar Calendar = java.util.Calendar.getInstance();
	        Calendar.set(DATE_YEAR, DATE_MONTH, Integer.parseInt(DATE_DAY));
	        return Simple_Date_Format.format(Calendar.getTime());
	    }


	/**
	 * Create the frame.
	 */
	public View() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 476);
		getContentPane().setLayout(null);

		JButton revButton = new JButton("????????");
		revButton.setBounds(10, 51, 122, 23);
		getContentPane().add(revButton);

		JButton revSerButton = new JButton("????????????");
		revSerButton.setBounds(128, 51, 116, 23);
		getContentPane().add(revSerButton);

		List list = new List(); 
		list.setBounds(10, 82, 349, 334);
		getContentPane().add(list);

		JLabel lblNewLabel = new JLabel("????????");
		lblNewLabel.setBounds(369, 82, 57, 15);
		final JTextField J_Text_Field = new JTextField(20);
		JButton choiceDate = new JButton("???? ????");
		JPanel J_Panel = new JPanel();
		J_Panel.add(lblNewLabel);
		J_Panel.add(J_Text_Field);
		J_Panel.add(choiceDate);
		final JFrame J_Frame = new JFrame();
		J_Frame.getContentPane().add(J_Panel);
		J_Frame.pack();
		J_Frame.setVisible(true);
		choiceDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				J_Text_Field.setText(new DatePick(J_Frame).Set_Picked_Date());
			}
		});
	}

	getContentPane().add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("\uC885\uB8CC\uC2DC\uAC04");
		lblNewLabel_1.setBounds(369, 254, 57, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uC2DC\uC791\uC2DC\uAC04");
		lblNewLabel_1_1.setBounds(369, 210, 57, 15);
		getContentPane().add(lblNewLabel_1_1);
		
		Choice end = new Choice();
		end.setBounds(432, 248, 116, 21);
		getContentPane().add(end);
		end.add("0??");
		end.add("1??");
		end.add("2??");
		end.add("3??");
		end.add("4??");
		end.add("5??");
		end.add("6??");
		end.add("7??");
		end.add("8??");
		end.add("9??");
		end.add("10??");
		end.add("11??");
		end.add("12??");
		end.add("13??");
		end.add("14??");
		end.add("15??");
		end.add("16??");
		end.add("17??");
		end.add("18??");
		end.add("19??");
		end.add("20??");
		end.add("21??");
		end.add("22??");
		end.add("23??");
		
		Choice start = new Choice();
		start.setBounds(432, 210, 116, 23);
		getContentPane().add(start);
		start.add("0??");
		start.add("1??");
		start.add("2??");
		start.add("3??");
		start.add("4??");
		start.add("5??");
		start.add("6??");
		start.add("7??");
		start.add("8??");
		start.add("9??");
		start.add("10??");
		start.add("11??");
		start.add("12??");
		start.add("13??");
		start.add("14??");
		start.add("15??");
		start.add("16??");
		start.add("17??");
		start.add("18??");
		start.add("19??");
		start.add("20??");
		start.add("21??");
		start.add("22??");
		start.add("23??");
		
		JButton revSerButton_1 = new JButton("\uC608\uC57D\uD558\uAE30");
		revSerButton_1.setBounds(378, 381, 140, 46);
		getContentPane().add(revSerButton_1);
		
		JCheckBox ycheck = new JCheckBox("???? ????");
		ycheck.setBounds(403, 331, 115, 23);
		getContentPane().add(ycheck);
		
		JPanel panel = new JPanel();
		panel.setBounds(451, 82, 149, 106);
		getContentPane().add(panel);
		

		
		
	
		
	}
}
