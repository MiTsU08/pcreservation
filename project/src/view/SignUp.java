package view;

import java.awt.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.SignUp1DAO;
import model.rec.SignUp1VO;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JPasswordField pwText;
	private JTextField eMailText;
	private JTextField birthYearText;
	private JPasswordField pwCheckText;
	private JTextField idText;
	private JTextField nameText;
	private JTextField phoneNumberText;

	SignUp1DAO dao;
	SignUp1VO vo;

	JButton signUpbtn, CheckBtn;

//	private boolean membershipProgress = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		this.setTitle("회원가입");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		pwText = new JPasswordField();
		pwText.setBounds(127, 57, 160, 21);
		contentPane.add(pwText);

		JLabel idLabel = new JLabel("\uC544\uC774\uB514");
		idLabel.setBounds(45, 28, 57, 15);
		contentPane.add(idLabel);

		JLabel pwLabel = new JLabel("\uBE44\uBC00\uBC88\uD638");
		pwLabel.setBounds(45, 60, 57, 15);
		contentPane.add(pwLabel);

		JLabel lblNewLabel = new JLabel("\uC804\uD654\uBC88\uD638");
		lblNewLabel.setBounds(45, 207, 57, 15);
		contentPane.add(lblNewLabel);

		eMailText = new JTextField();
		eMailText.setBounds(127, 229, 159, 21);
		contentPane.add(eMailText);
		eMailText.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\uC774\uBA54\uC77C");
		lblNewLabel_1.setBounds(45, 232, 57, 15);
		contentPane.add(lblNewLabel_1);

		JLabel pwChecklabel = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		pwChecklabel.setBounds(45, 91, 84, 15);
		contentPane.add(pwChecklabel);

		signUpbtn = new JButton("\uAC00\uC785\uC644\uB8CC");

		// ======================================================================

		signUpbtn.setBounds(302, 228, 97, 23);
		contentPane.add(signUpbtn);
		signUpbtn.setVisible(false);

		signUpbtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Object o = e.getSource();
				if (o == signUpbtn) { // 회원가입 버튼이 눌렸을 때
					/*
					 * 1. 각 TextField 에서 입력값 얻어오기 2. CustoemrVO 클래스의 setter 메소드를 이용하여 멤버필드에 1번값을 지정
					 * 3. CustoemrDAO 클래스의 insert() 호출 4. 각 TextField 초기화
					 */

					String id = idText.getText(); // 아이디
					String password = pwText.getText(); // 패스워드
					String name = nameText.getText(); // 이름

					String social_num = birthYearText.getText(); // 주민번호
					String tel = phoneNumberText.getText(); //전화번호
					String email = eMailText.getText(); // 이메일

					vo = new SignUp1VO(id, password, name, social_num, tel, email);

					try {
						dao.insert(vo);
						JOptionPane.showMessageDialog(null, name+"(id) :"+id+"님 가입완료 되었습니다");
						System.out.println(vo.toString());
						clearScreen();
						dispose();
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "회원가입 실패 : " + ex.getMessage());
						ex.printStackTrace();

					}

				}
			}
		});

		birthYearText = new JTextField();
		birthYearText.setBounds(127, 170, 159, 21);
		contentPane.add(birthYearText);
		birthYearText.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		lblNewLabel_3.setBounds(45, 173, 57, 15);
		contentPane.add(lblNewLabel_3);

		JLabel nameLabel = new JLabel("\uC774\uB984");
		nameLabel.setBounds(45, 148, 57, 15);
		contentPane.add(nameLabel);

		pwCheckText = new JPasswordField();
		pwCheckText.setBounds(127, 88, 160, 21);
		contentPane.add(pwCheckText);

		idText = new JTextField();
		idText.setBounds(127, 23, 159, 21);
		contentPane.add(idText);
		idText.setColumns(10);

		nameText = new JTextField();
		nameText.setBounds(127, 145, 160, 21);
		contentPane.add(nameText);
		nameText.setColumns(10);

		phoneNumberText = new JTextField();
		phoneNumberText.setBounds(127, 204, 160, 21);
		contentPane.add(phoneNumberText);
		phoneNumberText.setColumns(10);

		CheckBtn = new JButton("\uC911\uBCF5\uD655\uC778");
		CheckBtn.setBounds(302, 24, 97, 23);
		contentPane.add(CheckBtn);

		CheckBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = idText.getText();

				Object o = e.getSource();
				if (o == CheckBtn) { // 중복체크버튼을 누르면
					try {
						if (dao.getIdByCheck(id)) { //아이디가 중복인지 아닌지 확인
							System.out.println("sdsdsdsdsd" + id);
							JOptionPane.showMessageDialog(null, id + "는 사용가능합니다.");
							// 중복아니다.(사용가능)
							signUpbtn.setVisible(true);

						} else { // 중복이다.
							JOptionPane.showMessageDialog(null, id + "는 중복입니다.");
							signUpbtn.setVisible(false);
							return;
						}
					}
					catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});

		try {
			dao = new SignUp1DAO();
			System.out.println("회원 DB 연결 성공");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "회원 DB 연결 실패 : " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public void clearScreen() {
		idText.setText("");
		pwText.setText("");
		pwCheckText.setText("");
		nameText.setText("");
		birthYearText.setText("");
		phoneNumberText.setText("");
		eMailText.setText("");
	}

}
