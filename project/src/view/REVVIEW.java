package view;

import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class REVVIEW extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					REVVIEW frame = new REVVIEW();
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
	public REVVIEW() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 476);
		getContentPane().setLayout(null);

		JButton revButton = new JButton("예약하기");
		revButton.setBounds(10, 51, 122, 23);
		getContentPane().add(revButton);

		
		
		JButton revSerButton = new JButton("예약내역조회");
		revSerButton.setBounds(128, 51, 116, 23);
		getContentPane().add(revSerButton);

		List list = new List();
		list.setBounds(10, 82, 349, 334);
		getContentPane().add(list);

		JLabel lblNewLabel = new JLabel("예약일자");
		lblNewLabel.setBounds(369, 82, 57, 15);
		final JTextField J_Text_Field = new JTextField(20);
		JButton choiceDate = new JButton("날짜 선택");
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
				J_Text_Field.setText(new (J_Frame).Set_Picked_Date());
				getContentPane().add(lblNewLabel);
				
				{
				JLabel lblNewLabel_1 = new JLabel("\uC885\uB8CC\uC2DC\uAC04");
				lblNewLabel_1.setBounds(369, 254, 57, 15);
				getContentPane().add(lblNewLabel_1);
				
				JLabel lblNewLabel_1_1 = new JLabel("\uC2DC\uC791\uC2DC\uAC04");
				lblNewLabel_1_1.setBounds(369, 210, 57, 15);
				getContentPane().add(lblNewLabel_1_1);
				
				Choice end = new Choice();
				end.setBounds(432, 248, 116, 21);
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
				
				Choice start = new Choice();
				start.setBounds(432, 210, 116, 23);
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
				revSerButton_1.setBounds(378, 381, 140, 46);
				getContentPane().add(revSerButton_1);
				
				JCheckBox ycheck = new JCheckBox("약관 동의");
				ycheck.setBounds(403, 331, 115, 23);
				getContentPane().add(ycheck);
				
				JPanel panel = new JPanel();
				panel.setBounds(451, 82, 149, 106);
				getContentPane().add(panel);
				
				
				
				
			}
		});
	}

	
		
	}

