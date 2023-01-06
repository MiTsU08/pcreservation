package view;

import java.awt.Choice;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.LoginDaoEx;
import model.RevDAO;
import model.rec.LoginVO;
import model.rec.RevVO;

public class ReserveView extends JFrame /* implements ActionListener */ {

	private JPanel contentPane;
	static JButton selectDateBTN;
	JLabel comselButton1, comselButton2, comselButton3, comselButton4, comselButton5, comselButton6, comselButton7,
			comselButton8, comselButton9, comselButton10, comselButton11, comselButton12, comselButton13,
			comselButton14, comselButton15, comselButton16, comselButton17;
	static JButton revButton_1;
	RevDAO dao;
	LoginDaoEx ldao;
	LoginVO lvo;
	RevVO vo;
	Date day = new Date();
	SimpleDateFormat sm = new SimpleDateFormat("yyyy년MM월yy일 hh시mm분ss초");
	String today = sm.format(day);

	static JButton choiceDate;
	static JTextField J_Text_Field;
	JLabel lblNewLabel;
	JFrame J_Frame;
	JTextField textField;
	private JTextField selectComNo;
	private JLabel lblNewLabel_1, lblNewLabel_2, lblNewLabel_3;
	private JPanel panel_1;
	Choice end, start;
	public String pcInt, Fdate, startTime, endTime, bookcode;


	public static void main(String[] args) {
		ReserveView frame = new ReserveView(5);
		frame.setVisible(true);

		selectDateBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				J_Text_Field.setText(String.valueOf(new DatePick(frame).Set_Picked_Date()));
			}
		});

	}

	public class ResisterForm extends JFrame {
		public ResisterForm() {
			setSize(300, 500);
			setLocation(600, 300);
			setVisible(true);
		}
	}

	public void selectReset() {
		comselButton1.setEnabled(false);
		comselButton2.setEnabled(false);
		comselButton3.setEnabled(false);
		comselButton4.setEnabled(false);
		comselButton5.setEnabled(false);
		comselButton6.setEnabled(false);
		comselButton7.setEnabled(false);
		comselButton8.setEnabled(false);
		comselButton9.setEnabled(false);
		comselButton10.setEnabled(false);
		comselButton11.setEnabled(false);
		comselButton12.setEnabled(false);
		comselButton13.setEnabled(false);
		comselButton14.setEnabled(false);
		comselButton15.setEnabled(false);
		comselButton16.setEnabled(false);
		comselButton17.setEnabled(false);
	}

	public void doneReset() {
		selectReset();
		selectComNo.setText("");
		J_Text_Field.setText("");
		start.select("");
		end.select("");
	}

	public ReserveView(int usercode) {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 765, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton revselectButton = new JButton("예약내역조회");
		revselectButton.setBounds(178, 13, 259, 38);
		getContentPane().add(revselectButton);
//		System.out.println("REVIEW"+lvo.toString());
		revselectButton.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {

			}
		});
//예약 
		revButton_1 = new JButton("\uC608\uC57D\uD558\uAE30");
		revButton_1.setBounds(585, 384, 159, 64);
		getContentPane().add(revButton_1);
		setVisible(true);
		lvo=new LoginVO();
		revButton_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new YAK();
				
				
				pcInt = selectComNo.getText();
				Fdate = J_Text_Field.getText();
				int PCNum = Integer.parseInt(pcInt);
				startTime = Fdate + " " + start.getSelectedItem() + ":00";
				endTime = Fdate + " " + end.getSelectedItem() + ":00";
			
				try {
					ldao = new LoginDaoEx();
					

				} catch (Exception e2) {
					// TODO: handle exception
				}

				
//				userCode = 5;// 임시 코드

				int ch = JOptionPane.showConfirmDialog(null, "예약을 하시겠습니까?", "예약확인", JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE, null);

//				if (selectComNo == null) {
//					JOptionPane.showMessageDialog(null, "컴퓨터를 선택해주세요");
//					return;
//				} else if (J_Text_Field == null) {
//					JOptionPane.showMessageDialog(null, "예약일 선택해주세요");
//					return;
//				} else if (startTime == "") {
//					JOptionPane.showMessageDialog(null, "시작시간 선택해주세요");
//					return;
//				} else if (endTime == "") {
//					JOptionPane.showMessageDialog(null, "종료시간 선택해주세요");
//					return;
//				} else {
				if (ch == 0) {
//					vo = new RevVO();
					vo = new RevVO(usercode, PCNum, Fdate, startTime, endTime);
					String st = startTime.substring(11, 13) + "시";
					String et = endTime.substring(11, 13) + "시";
					try {

						dao = new RevDAO();
						dao.PCreservation(vo);
//							dao.BookDone(vo);
//
						doneReset();
						System.out.println(vo.toString());
						JOptionPane.showMessageDialog(null, "예약완료 되었습니다 " + "\nPC번호:" + PCNum + "\n예약일:" + Fdate
								+ "\n시작시간:" + st + "\n종료시간:" + et + "\n 예약완료일:\n[" + today + "]");
//						new BookedView(); // 새창

					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "예약실패 :" + e2.getMessage());
						System.out.println("캐치" + vo.toString());
						e2.getStackTrace();
					}

				} else {
					JOptionPane.showMessageDialog(null, "다시 예약해주세요~");
				}
			}

//			}
		
		});
		System.out.println("예약화"+usercode);

		JPanel J_Panel_1 = new JPanel();
		J_Panel_1.setBounds(450, 310, 286, 33);
		contentPane.add(J_Panel_1);
		J_Panel_1.setLayout(null);

		JLabel J_Label_1 = new JLabel("\uC608\uC57D\uC77C");
		J_Label_1.setBounds(12, 8, 67, 15);
		J_Panel_1.add(J_Label_1);

		J_Text_Field = new JTextField(20); // 받은 날짜 출력칸
		J_Text_Field.setBounds(91, 5, 75, 21);
		J_Panel_1.add(J_Text_Field);

		selectDateBTN = new JButton("\uB0A0\uC9DC\uC120\uD0DD");// 날짜 선택 버튼

		selectDateBTN.setBounds(178, 4, 97, 23);
		J_Panel_1.add(selectDateBTN);

		JPanel panel = new JPanel();
		panel.setBounds(12, 56, 425, 408);
		contentPane.add(panel);
		panel.setLayout(null);

		comselButton1 = new JLabel("1");
		comselButton1.setEnabled(false);
		comselButton1.setBounds(12, 291, 60, 57);
		comselButton1.setIcon(new ImageIcon(ReserveView.class.getResource("/img/PCUSE.png")));
		panel.add(comselButton1);
		comselButton1.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				selectComNo.setText(String.valueOf(1));
				selectReset();
				comselButton1.setEnabled(true);
			}

		});
		comselButton2 = new JLabel("2");
		comselButton2.setEnabled(false);
		comselButton2.setBounds(12, 243, 60, 57);
		comselButton2.setIcon(new ImageIcon(ReserveView.class.getResource("/img/PCUSE.png")));
		panel.add(comselButton2);
		comselButton2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e2) {
				selectComNo.setText(String.valueOf(2));
				selectReset();
				comselButton2.setEnabled(true);
			}

		});

		comselButton3 = new JLabel("3");
		comselButton3.setEnabled(false);
		comselButton3.setBounds(12, 190, 60, 51);
		comselButton3.setIcon(new ImageIcon(ReserveView.class.getResource("/img/PCUSE.png")));
		panel.add(comselButton3);
		comselButton3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e3) {
				selectComNo.setText(String.valueOf(3));
				selectReset();
				comselButton3.setEnabled(true);
			}

		});

		comselButton4 = new JLabel("4");
		comselButton4.setEnabled(false);
		comselButton4.setBounds(12, 139, 60, 57);
		comselButton4.setIcon(new ImageIcon(ReserveView.class.getResource("/img/PCUSE.png")));
		panel.add(comselButton4);
		comselButton4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e4) {
				selectComNo.setText(String.valueOf(4));
				selectReset();
				comselButton4.setEnabled(true);
			}
		});

		comselButton5 = new JLabel("5");
		comselButton5.setEnabled(false);
		comselButton5.setBounds(192, 66, 60, 57);
		comselButton5.setIcon(new ImageIcon(ReserveView.class.getResource("/img/PCUSE.png")));
		panel.add(comselButton5);
		comselButton5.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e5) {
				selectComNo.setText(String.valueOf(5));
				selectReset();
				comselButton5.setEnabled(true);
			}
		});

		comselButton6 = new JLabel("6");
		comselButton6.setEnabled(false);
		comselButton6.setBounds(253, 66, 60, 57);
		comselButton6.setIcon(new ImageIcon(ReserveView.class.getResource("/img/PCUSE.png")));
		panel.add(comselButton6);
		comselButton6.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e6) {
				selectComNo.setText(String.valueOf(6));
				selectReset();
				comselButton6.setEnabled(true);
			}
		});

		comselButton7 = new JLabel("7");
		comselButton7.setEnabled(false);
		comselButton7.setBounds(312, 66, 60, 57);
		comselButton7.setIcon(new ImageIcon(ReserveView.class.getResource("/img/PCUSE.png")));
		panel.add(comselButton7);
		comselButton7.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e7) {
				selectComNo.setText(String.valueOf(7));
				selectReset();
				comselButton7.setEnabled(true);
			}
		});
		comselButton8 = new JLabel("8");
		comselButton8.setEnabled(false);
		comselButton8.setBounds(185, 159, 60, 51);
		comselButton8.setIcon(new ImageIcon(ReserveView.class.getResource("/img/PCUSE.png")));
		panel.add(comselButton8);
		comselButton8.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e8) {
				selectComNo.setText(String.valueOf(8));
				selectReset();
				comselButton8.setEnabled(true);
			}
		});

		comselButton9 = new JLabel("9");
		comselButton9.setEnabled(false);
		comselButton9.setBounds(246, 156, 60, 57);
		comselButton9.setIcon(new ImageIcon(ReserveView.class.getResource("/img/PCUSE.png")));
		panel.add(comselButton9);
		comselButton9.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e9) {
				selectComNo.setText(String.valueOf(9));
				selectReset();
				comselButton9.setEnabled(true);
			}
		});

		comselButton10 = new JLabel("10");
		comselButton10.setEnabled(false);
		comselButton10.setBounds(185, 215, 67, 51);
		comselButton10.setIcon(new ImageIcon(ReserveView.class.getResource("/img/PCUSE.png")));
		panel.add(comselButton10);
		comselButton10.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e10) {
				selectComNo.setText(String.valueOf(10));
				selectReset();
				comselButton10.setEnabled(true);
			}
		});

		comselButton11 = new JLabel("11");
		comselButton11.setEnabled(false);
		comselButton11.setBounds(246, 212, 72, 57);
		comselButton11.setIcon(new ImageIcon(ReserveView.class.getResource("/img/PCUSE.png")));
		panel.add(comselButton11);
		comselButton11.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e11) {
				selectComNo.setText(String.valueOf(11));
				selectReset();
				comselButton11.setEnabled(true);
			}
		});

		comselButton12 = new JLabel("12");
		comselButton12.setEnabled(false);
		comselButton12.setBounds(305, 159, 67, 51);
		comselButton12.setIcon(new ImageIcon(ReserveView.class.getResource("/img/PCUSE.png")));
		panel.add(comselButton12);
		comselButton12.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e12) {
				selectComNo.setText(String.valueOf(12));
				selectReset();
				comselButton12.setEnabled(true);
			}
		});

		comselButton13 = new JLabel("13");
		comselButton13.setEnabled(false);
		comselButton13.setBounds(305, 212, 67, 57);
		comselButton13.setIcon(new ImageIcon(ReserveView.class.getResource("/img/PCUSE.png")));
		panel.add(comselButton13);
		comselButton13.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e13) {
				selectComNo.setText(String.valueOf(13));
				selectReset();
				comselButton13.setEnabled(true);
			}
		});

		comselButton14 = new JLabel("14");
		comselButton14.setEnabled(false);
		comselButton14.setBounds(147, 291, 67, 57);
		panel.add(comselButton14);
		comselButton14.setIcon(new ImageIcon(ReserveView.class.getResource("/img/PCUSE.png")));
		panel.add(comselButton14);
		comselButton14.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e13) {
				selectComNo.setText(String.valueOf(14));
				selectReset();
				comselButton14.setEnabled(true);
			}
		});

		comselButton15 = new JLabel("15");
		comselButton15.setEnabled(false);
		comselButton15.setBounds(208, 291, 72, 57);
		panel.add(comselButton15);
		comselButton15.setIcon(new ImageIcon(ReserveView.class.getResource("/img/PCUSE.png")));
		comselButton15.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e13) {
				selectComNo.setText(String.valueOf(15));
				selectReset();
				comselButton15.setEnabled(true);
			}
		});

		comselButton16 = new JLabel("16");
		comselButton16.setEnabled(false);
		comselButton16.setBounds(267, 291, 67, 57);
		panel.add(comselButton16);
		comselButton16.setIcon(new ImageIcon(ReserveView.class.getResource("/img/PCUSE.png")));
		comselButton16.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e13) {
				selectComNo.setText(String.valueOf(16));
				selectReset();
				comselButton16.setEnabled(true);
			}
		});
		comselButton17 = new JLabel("17");
		comselButton17.setEnabled(false);
		comselButton17.setBounds(12, 41, 67, 57);
		panel.add(comselButton17);
		comselButton17.setIcon(new ImageIcon(ReserveView.class.getResource("/img/PCUSE.png")));
		comselButton17.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e13) {
				selectComNo.setText(String.valueOf(17));
				selectReset();
				comselButton17.setEnabled(true);
			}
		});

		lblNewLabel_1 = new JLabel("\uCE74\uC6B4\uD130");
		lblNewLabel_1.setBounds(277, 332, 215, 93);
		panel.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("\uCEF4\uD4E8\uD130 \uC88C\uC11D\uB3C4");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_2.setEnabled(false);
		lblNewLabel_2.setBounds(147, 41, 200, 15);
		panel.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel(
				"\uC608\uC57D \uD558\uC2E4 \uCEF4\uD4E8\uD130\uB97C \uC120\uD0DD\uD574\uC8FC\uC138\uC694");
		lblNewLabel_3.setFont(new Font("궁서체", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3.setEnabled(false);
		lblNewLabel_3.setBounds(25, 10, 383, 27);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(-53, 10, 524, 398);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setIcon(new ImageIcon(ReserveView.class.getResource("/img/pclo.png")));

		selectComNo = new JTextField(20);
		selectComNo.setFont(new Font("굴림", Font.BOLD, 27));
		selectComNo.setBounds(524, 384, 63, 64);
		selectComNo.setEditable(false);
		contentPane.add(selectComNo);

		JLabel J_Label_1_1 = new JLabel("선택한 컴퓨터");
		J_Label_1_1.setBounds(442, 397, 96, 39);
		contentPane.add(J_Label_1_1);

		panel_1 = new JPanel();
		panel_1.setBounds(450, 342, 286, 39);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel startTimeLabel = new JLabel("\uC2DC\uC791\uC2DC\uAC04");
		startTimeLabel.setBounds(12, 10, 54, 21);
		panel_1.add(startTimeLabel);

		end = new Choice();
		end.setBounds(198, 10, 78, 21);
		panel_1.add(end);
		JLabel endTimeLabel = new JLabel("\uC885\uB8CC\uC2DC\uAC04");
		endTimeLabel.setBounds(144, 13, 70, 15);
		panel_1.add(endTimeLabel);

		start = new Choice();
		start.setBounds(72, 10, 70, 21);
		panel_1.add(start);

		JLabel comselButton7_1 = new JLabel("");
		comselButton7_1.setEnabled(false);
		comselButton7_1.setBounds(327, 13, 636, 435);
		contentPane.add(comselButton7_1);
		comselButton7_1.setIcon(new ImageIcon(ReserveView.class.getResource("/img/20181015000119.jpg")));
//		int time[23]= {"","00:00","01:00","02:00","03:00","04:00","05:00","06:00","07:00","08:00","09:00","10:00",
//	"11:00","12:00","13:00","14:00",
//				"15:00","16:00","17:00","18:00","19:00","20:00","21:00","22:00","23:00"};

		start.add("시간선택");
		start.add("");
		start.add("00:00");
		start.add("01:00");
		start.add("02:00");
		start.add("03:00");
		start.add("04:00");
		start.add("05:00");
		start.add("06:00");
		start.add("07:00");
		start.add("08:00");
		start.add("09:00");
		start.add("10:00");
		start.add("11:00");
		start.add("12:00");
		start.add("13:00");
		start.add("14:00");
		start.add("15:00");
		start.add("16:00");
		start.add("17:00");
		start.add("18:00");
		start.add("19:00");
		start.add("20:00");
		start.add("21:00");
		start.add("22:00");
		start.add("23:00");

		end.add("시간선택");
		end.add("");
		end.add("00:00");
		end.add("01:00");
		end.add("02:00");
		end.add("03:00");
		end.add("04:00");
		end.add("05:00");
		end.add("06:00");
		end.add("07:00");
		end.add("08:00");
		end.add("09:00");
		end.add("10:00");
		end.add("11:00");
		end.add("12:00");
		end.add("13:00");
		end.add("14:00");
		end.add("15:00");
		end.add("16:00");
		end.add("17:00");
		end.add("18:00");
		end.add("19:00");
		end.add("20:00");
		end.add("21:00");
		end.add("22:00");
		end.add("23:00");


	}
}
