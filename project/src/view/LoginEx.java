
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
	JLabel idLabel = new JLabel("���̵� ");
	JLabel pwLabel = new JLabel("��й�ȣ ");
	JTextField idText = new JTextField();
	JPasswordField pwText = new JPasswordField();
	
	JButton loginBtn = new JButton("�α���");
	JButton memberbtn = new JButton("ȸ������");
	
	LoginDaoEx dao;
	LoginVO vo;
	
	public LoginEx() {
		super("�α��� â!");

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

		// �� ��� ����
		idLabel.setHorizontalAlignment(NORMAL);
		loginBtn.setBounds(167, 84, 167, 27);
		loginPanel.add(loginBtn);
		loginBtn.setAutoscrolls(true);
		pwLabel.setBounds(0, 38, 123, 27);
		loginPanel.add(pwLabel);
		pwLabel.setHorizontalAlignment(NORMAL);

		// �α��� ��ư�� ��������
		setSize(350, 150);
		this.setLocationRelativeTo(null);

		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		try {
			dao = new LoginDaoEx();
			System.out.println("�뿩 ��� ���� ����");
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "�뿩 DB���� ����" + e1.getMessage());
			e1.printStackTrace();
		}
		
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = idText.getText().trim();
				String pw = pwText.getText().trim();
				// ȸ�������� ã�Ƽ�
				int result = dao.findByIdAndPassword(id, pw);
				vo=new LoginVO(id,pw);
				if(result == 1) {
					//ȸ�� ���� ����Ʈ ȭ�� �̵��� ���ÿ� id ���ǰ����� �ѱ�.
					try {// ������ ���� ������ ȸ���̶� ������ �����ؼ� �α��� ����
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
						JOptionPane.showMessageDialog(null, "���� ���� : " + e2.getMessage());
						e2.printStackTrace();
					}
					
					//�α��� ���� �޽���
					JOptionPane.showMessageDialog(null, "�α��� ����" + id + "�� ȯ���մϴ�.");
					//���� ȭ�� ����
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "�α��ο� �����ϼ̽��ϴ�.");
				}

				String login = "";
				
				System.out.println(id + pw);
				
				

				if (id.length() == 0 || pw.length() == 0) {
					JOptionPane.showMessageDialog(null, "���̵� �Ǵ� ��й�ȣ�� �Է� �ϼž� �˴ϴ�.", "���̵� ����� �Է�!",
							JOptionPane.DEFAULT_OPTION);

					return;
				}
				
				
			}
		});

		// ���� ������ â ��� ���� setSize�� ���� ���־�� ���������� �������� ��� ������ ��!
		setSize(350, 150);
		this.setLocationRelativeTo(null);

		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ȸ������ ��ư�� ��������
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