
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.LoginDaoEx;
import model.rec.LoginVO;

public class LoginEx extends JFrame {
	JPanel loginPanel = new JPanel();
	JLabel idLabel = new JLabel("아이디 ");
	JLabel pwLabel = new JLabel("비밀번호 ");
	JTextField idText = new JTextField();
	JPasswordField pwText = new JPasswordField();
	
	JButton loginBtn = new JButton("로그인");
	JButton memberbtn = new JButton("회원가입");
	
	LoginDaoEx dao;
	LoginVO vo;
	
	public LoginEx() {
		super("로그인 창!");

		this.setContentPane(loginPanel);
		loginPanel.setLayout(null);
		idLabel.setBounds(0, 10, 112, 27);
		loginPanel.add(idLabel);
		idText.setBounds(135, 10, 167, 27);
		loginPanel.add(idText);
		pwText.setBounds(135, 38, 167, 27);
		loginPanel.add(pwText);
		memberbtn.setBounds(0, 84, 167, 27);
		loginPanel.add(memberbtn);

		// 라벨 가운데 정렬
		idLabel.setHorizontalAlignment(NORMAL);
		loginBtn.setBounds(167, 84, 167, 27);
		loginPanel.add(loginBtn);
		loginBtn.setAutoscrolls(true);
		pwLabel.setBounds(0, 38, 123, 27);
		loginPanel.add(pwLabel);
		pwLabel.setHorizontalAlignment(NORMAL);

		// 로그인 버튼을 눌렀을때
		setSize(350, 150);
		this.setLocationRelativeTo(null);

		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		try {
			dao = new LoginDaoEx();
			System.out.println("대여 디비 연결 성공");
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "대여 DB연결 실패" + e1.getMessage());
			e1.printStackTrace();
		}
		
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = idText.getText().trim();
				String pw = pwText.getText().trim();
				// 회원정보를 찾아서
				int result = dao.findByIdAndPassword(id, pw);
				vo=new LoginVO(id,pw);
				if(result == 1) {
					//회원 정보 리스트 화면 이동과 동시에 id 세션값으로 넘김.
					try {// 관리자 유무 값으로 회원이랑 관리자 구분해서 로그인 진행
						boolean poss = dao.isPossible(id);
						if(poss) {
							int usercode = dao.getUsercode(id);
									
							new Manager_Menu(usercode);
							System.out.println(usercode);
						}else {
							int usercode = dao.getUsercode(id);
							new Customer_Menu(usercode);
							System.out.println(usercode);
							
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "인증 실패 : " + e2.getMessage());
						e2.printStackTrace();
					}
					
					//로그인 성공 메시지
					JOptionPane.showMessageDialog(null, "로그인 성공" + id + "님 환영합니다.");
					//현재 화면 종료
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "로그인에 실패하셨습니다.");
				}

				String login = "";
				
				System.out.println(id + pw);
				
				

				if (id.length() == 0 || pw.length() == 0) {
					JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 입력 하셔야 됩니다.", "아이디나 비번을 입력!",
							JOptionPane.DEFAULT_OPTION);

					return;
				}
				
				
			}
		});

		// 현재 프레임 창 가운데 정렬 setSize를 먼저 해주어야 정상적으로 프레임이 가운데 정렬이 됨!
		setSize(350, 150);
		this.setLocationRelativeTo(null);

		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 회원가입 버튼을 눌렀을때
		memberbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp signup = new SignUp();
				signup.setVisible(true);

			}
		});

	}

	public static void main(String[] args) {
		new LoginEx();
	}
}