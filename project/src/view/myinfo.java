package view;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.PcDAO;
import model.ReserveDAO;
import model.rec.userVO;
import model.rec.userVO2;
import model.rec.userVO5;

public class myinfo {

	JFrame f;

	private JFrame frame;
	private JTextField textnameField;
	private JTextField textidField;
	private JTextField textSocialNumField;
	private JTextField textTelField;
	private JTextField textEmailField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_2;
	private JTextField textTimeField;
	private JTable table;
	private JTable table2;
	private DefaultTableModel DtmStorage;
	private DefaultTableModel DtmStorage2;
	private JTextField textidField3;
	SimpleDateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일 hh시mm분ss초");

	Date day = new Date();

	PcDAO dao;
	ReserveDAO revdao;
	userVO vo;
	userVO2 vo2;
	userVO5 vo5;
	userTime ut;
	private JTextField textDateField;
	private JTextField textTimeField2;
	private JLabel lblNewLabel_4_1;

	/**
	 * Create the application.
	 */
	public myinfo() {
		f = new JFrame("탭 예제");
		f.setTitle("\uB0B4\uC815\uBCF4");
		f.getContentPane().setBackground(new Color(255, 255, 255));
		JPanel p2 = new JPanel();
		p2.setBackground(new Color(255, 255, 255));
		JPanel p3 = new JPanel();

		p3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					// 현재날짜가져오기
					String date = df.format(day);
					lblNewLabel_4_1 = new JLabel(date);
					textDateField.setText(String.valueOf(date));
					// 남은시간 가져오기
					PcDAO dao = new PcDAO();
					String name = textnameField.getText();
					userVO5 vo5 = dao.searchTime(name);
					userTime ut = dao.searchTime2(name);
					// 남은시간
					textTimeField.setText(String.valueOf(vo5.getTime()));
					// 총이용시간
					textTimeField2.setText(ut.getTime());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "정보조회실패 : " + e2.getMessage());
				}
			}
		});

		JPanel p4 = new JPanel();
		p3.setBackground(new Color(255, 255, 255));
		JTabbedPane tp = new JTabbedPane();
		tp.setBackground(new Color(255, 255, 255));
		tp.setBounds(0, 0, 608, 500);
		tp.add("          내정보수정", p2);
		p2.setLayout(null);

		JLabel lblNewLabel = new JLabel("님 반갑습니다 ♡");
		lblNewLabel.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 20));
		lblNewLabel.setBounds(292, 23, 145, 37);
		p2.add(lblNewLabel);

		textnameField = new JTextField();
		textnameField.setBounds(141, 25, 139, 37);
		p2.add(textnameField);
		textnameField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
		lblNewLabel_1.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(12, 102, 57, 15);
		p2.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_1_1.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(12, 160, 57, 15);
		p2.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		lblNewLabel_1_2.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(12, 218, 95, 15);
		p2.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_2_1 = new JLabel("\uC8FC\uBBFC\uB4F1\uB85D\uBC88\uD638");
		lblNewLabel_1_2_1.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 15));
		lblNewLabel_1_2_1.setBounds(12, 273, 111, 15);
		p2.add(lblNewLabel_1_2_1);

		JLabel lblNewLabel_1_2_2 = new JLabel("\uC804\uD654\uBC88\uD638");
		lblNewLabel_1_2_2.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 15));
		lblNewLabel_1_2_2.setBounds(12, 325, 57, 15);
		p2.add(lblNewLabel_1_2_2);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("\uC774\uBA54\uC77C");
		lblNewLabel_1_2_1_1.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1.setBounds(12, 377, 57, 15);
		p2.add(lblNewLabel_1_2_1_1);

		textidField = new JTextField();
		textidField.setEditable(false);
		textidField.setBounds(81, 100, 116, 21);
		p2.add(textidField);
		textidField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel(
				"\uBE44\uBC00\uBC88\uD638 \uD2C0\uB9AC\uBA74 \uD2C0\uB838\uB2E4\uACE0 \uB098\uC624\uAC8C\uD558\uAE30");
		lblNewLabel_2.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 12));
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setBounds(245, 219, 211, 15);
		p2.add(lblNewLabel_2);

		textSocialNumField = new JTextField();
		textSocialNumField.setEditable(false);
		textSocialNumField.setBounds(117, 271, 116, 21);
		p2.add(textSocialNumField);
		textSocialNumField.setColumns(10);

		textTelField = new JTextField();
		textTelField.setBounds(81, 323, 116, 21);
		p2.add(textTelField);
		textTelField.setColumns(10);

		textEmailField = new JTextField();
		textEmailField.setBounds(81, 375, 116, 21);
		p2.add(textEmailField);
		textEmailField.setColumns(10);

		// 정보수정하기
		JButton btnNewButton = new JButton("\uC218\uC815\uD558\uAE30");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PcDAO dao = new PcDAO();
					String name = textnameField.getText();
					// 수정한 비밀번호값
					String password = passwordField.getText();
					// 수정한 비밀번호 확인값
					String passwordconfirm = passwordField_1.getText();
					// 수정된 전화번호값
					String tel = textTelField.getText();
					// 수정된 이메일값
					String email = textEmailField.getText();
					vo2 = new userVO2(password, tel, email);
					// 전화번호나 이메일이 하나라도 비워져있는경우
					if (email.equals("") || tel.equals("")) {
						JOptionPane.showMessageDialog(null, "수정할값을 입력해주세요 !");
						return;
					}
					if (email.equals("") && tel.equals("")) {
						JOptionPane.showMessageDialog(null, "수정할값을 입력해주세요 !");
						return;
						// 비밀번호창이랑 비밀번호확인창이 비워져있을경우
					}
					if (password.equals("")) {
						userVO vo = dao.searchName(name);
						passwordField.setText(vo.getPassword());
						passwordField_1.setText(vo.getPassword());
						return;
					}
					if (passwordconfirm.equals("")) {
						JOptionPane.showMessageDialog(null, "비밀번호확인창에 입력해주세요");
						return;
					}
					if (password.equals("") && passwordconfirm.equals("")) {
						userVO vo = dao.searchName(name);
						passwordField.setText(vo.getPassword());
						passwordField_1.setText(vo.getPassword());
						return;
						// 비밀번호랑 비밀번호확인창에 있는 값이 다를경우
					}
					if (!password.equals(passwordconfirm)) {
						JOptionPane.showMessageDialog(null, "비밀번호가 동일하지않습니다");
						return;
						// 근데 비밀번호 수정되버림.. 실화냐...?
					}
					if (!password.equals(passwordconfirm) && email.equals("") || tel.equals("")) {
						// 비밀번호랑 비밀번호확인창이랑 다르고 이메일이나 전화번호중에 정보가 비워져있을경우
						JOptionPane.showMessageDialog(null, "수정정보를 확인해주세요");
						return;
					} else {
						dao.modify(name, vo2);
						JOptionPane.showMessageDialog(null, "정보수정완료~");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "정보수정에 실패하였습니다 " + e2.getMessage());
				}
			}
		});

		btnNewButton.setBounds(454, 409, 137, 52);
		p2.add(btnNewButton);

		passwordField = new JPasswordField();
		passwordField.setBounds(81, 158, 116, 21);
		p2.add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(117, 216, 116, 21);
		p2.add(passwordField_1);

		JButton btnNewButton_1 = new JButton("\uC815\uBCF4\uC870\uD68C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PcDAO dao = new PcDAO();
					String name = textnameField.getText();
					userVO vo = dao.searchName(name);
					textidField.setText(vo.getId());
					passwordField.setText(vo.getPassword());
					passwordField_1.setText(vo.getPassword());
					textSocialNumField.setText(vo.getSocialNum());
					textTelField.setText(vo.getTel());
					textEmailField.setText(vo.getEmail());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "정보조회실패 : " + e2.getMessage());
				}
			}
		});

		btnNewButton_1.setBounds(314, 409, 123, 52);
		p2.add(btnNewButton_1);

		Bounds(117, 216, 116, 21);
		p2.add(passwordField_1);

		tp.add("           시간조회", p3);
		p3.setLayout(null);

		JLabel lblNewLabel_7_1 = new JLabel("\uB0A8\uC558\uC2B5\uB2C8\uB2E4");
		lblNewLabel_7_1.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 15));
		lblNewLabel_7_1.setBounds(269, 76, 73, 24);
		p3.add(lblNewLabel_7_1);

		JLabel lblNewLabel_6_1 = new JLabel("\uC2DC\uAC04");
		lblNewLabel_6_1.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 15));
		lblNewLabel_6_1.setBounds(237, 72, 37, 32);
		p3.add(lblNewLabel_6_1);

		textTimeField = new JTextField();
		textTimeField.setColumns(10);
		textTimeField.setBounds(152, 79, 73, 21);
		p3.add(textTimeField);

		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon(myinfo.class.getResource("/image/eb6f98e3825ddf6ba9bad7d5d17323e3.jpg")));
		lblNewLabel_8.setBounds(107, 182, 484, 279);
		p3.add(lblNewLabel_8);

		JLabel lblNewLabel_6_2 = new JLabel("\uC2DC\uAC04");
		lblNewLabel_6_2.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 15));
		lblNewLabel_6_2.setBounds(237, 108, 37, 32);
		p3.add(lblNewLabel_6_2);

		JLabel lblNewLabel_7_2 = new JLabel("\uC774\uC6A9\uD558\uC168\uC2B5\uB2C8\uB2E4 ");
		lblNewLabel_7_2.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 15));
		lblNewLabel_7_2.setBounds(269, 112, 148, 24);
		p3.add(lblNewLabel_7_2);

		textDateField = new JTextField();
		textDateField.setBounds(12, 10, 330, 51);
		p3.add(textDateField);
		textDateField.setColumns(10);

		textTimeField2 = new JTextField();
		textTimeField2.setBounds(152, 114, 73, 21);
		p3.add(textTimeField2);
		textTimeField2.setColumns(10);
		f.getContentPane().add(tp);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(140, 19, 143, 38);


		JLabel lblNewLabel_3_1 = new JLabel("\uB2D8 \uBC18\uAC11\uC2B5\uB2C8\uB2E4 \u2661");
		lblNewLabel_3_1.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(288, 24, 130, 23);


		JLabel lblNewLabel_4 = new JLabel("\uB0A0\uC9DC\uB098\uC624\uAC8C\uD558\uB294\uCE78");
		lblNewLabel_4.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(288, 97, 108, 23);


		JLabel lblNewLabel_5 = new JLabel("\uAE30\uC900");
		lblNewLabel_5.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(402, 100, 57, 19);


		JLabel lblNewLabel_6 = new JLabel("\uC2DC\uAC04");
		lblNewLabel_6.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(362, 138, 37, 32);


		JLabel lblNewLabel_7 = new JLabel("\uC774\uC6A9\uD558\uC168\uC2B5\uB2C8\uB2E4 ");
		lblNewLabel_7.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(392, 142, 148, 24);


		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setIcon(new ImageIcon(myinfo.class.getResource("/image/eb6f98e3825ddf6ba9bad7d5d17323e3.jpg")));
		lblNewLabel_9.setBounds(93, 183, 510, 278);


		tp.add("          예약정보조회", p4);

		//
		p4.setBackground(new Color(255, 255, 255));
		p4.setLayout(null);
		JScrollPane scrollpane = new JScrollPane();
		scrollpane.setBounds(12, 83, 579, 378);
		p4.add(scrollpane);
		String[] column = { "", "", "", "", "" };
		DtmStorage = new DefaultTableModel(column, 0) {
			// 테이블 더블클릭시 수정여부
			public boolean isCellEitable(int row, int column) {
				// 클릭하면 취소할수있게 만들기
				return true; // 셀수정가능,불가능(return false)
			}
		};

		JButton btnNewButton_2 = new JButton("\uC870\uD68C\uD558\uAE30");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// 내정보조회한다음에 하면 되는데 바로는 안됨..ㅜ
					// 이거는 로그인하면 고칠수있을것같기도해서 패스
					PcDAO dao = new PcDAO();
					ReserveDAO revdao = new ReserveDAO();
					String name = textnameField.getText();
					userVO vo = dao.searchName(name);
					textidField3.setText(vo.getId());

					ArrayList list = revdao.revSearch(name);
					int num = list.size();
					// 예약정보없으면
					if (num == 0) {
						JOptionPane.showMessageDialog(null, "예약정보가 없습니다.");
					}
					ArrayList temp = new ArrayList();
					String[] col = { "예약일자", "예약취소가능여부", "컴퓨터 번호", "예약시작시간", "예약종료시간" };
					String[][] row = new String[num][5];
					System.out.println(num);
					for (int i = 0; i < num; i++) {
						temp = (ArrayList) list.get(i);
						row[i][0] = (String) temp.get(0);
						row[i][1] = (String) temp.get(1);
						row[i][2] = String.valueOf(temp.get(2));
						row[i][3] = (String) temp.get(3);
						row[i][4] = (String) temp.get(4);
						DtmStorage = new DefaultTableModel(row, col);
						table = new JTable(DtmStorage);
						scrollpane.setViewportView(table);
					}

				} catch (Exception e4) {
					JOptionPane.showMessageDialog(null, "예약조회에 실패하였습니다" + e4.getMessage());
				}
			}

		});

		textidField3 = new JTextField();
		textidField3.setBounds(312, 26, 168, 30);
		p4.add(textidField3);
		textidField3.setColumns(10);

		btnNewButton_2.setBounds(490, 25, 101, 31);
		p4.add(btnNewButton_2);

		f.setSize(624, 537);
		f.getContentPane().setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initialize();
	}

	private void Bounds(int i, int j, int k, int l) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new myinfo();

	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}