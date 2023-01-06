package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.DropMode;
import java.awt.SystemColor;
import java.awt.Color;

public class YAK extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtPc;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_2;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField txtPcpc;
	private JTextField txtpc;
	private JTextField textField_12;
	private JTextField txtPc_1;
	private JTextField textField_14;
	private JTextField txtpc_1;
	private final JPanel panel = new JPanel();
	private JTextField textField_13;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YAK frame = new YAK();
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
	public YAK() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 764, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("궁서", Font.BOLD | Font.ITALIC, 15));
		textField.setEditable(false);
		textField.setBounds(62, 10, 370, 21);
		textField.setText("이 창은 PC방 예약프로그램의 이용약관 입니다");
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\uC57D\uAD00\uC5D0 \uB3D9\uC758\uD569\uB2C8\uB2E4");
		btnNewButton.setBounds(446, 416, 290, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uC2EB\uC740\uB370??");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "약관 동의가 필요합니다." );
//				setVisible(false);
				
			}
		});
		Date day= new Date();
		SimpleDateFormat sm= new SimpleDateFormat("yyyy년MM월yy일 hh시mm분ss초");
		String today=sm.format(day);
		btnNewButton_1.setBounds(27, 411, 314, 45);
		contentPane.add(btnNewButton_1);
		panel.setBounds(12, 31, 724, 379);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(0, 10, 45, 21);
		panel.add(textField_1);
		textField_1.setBackground(UIManager.getColor("CheckBox.light"));
		textField_1.setEditable(false);
		textField_1.setText("1.목적");
		textField_1.setColumns(100);
		
		txtPc = new JTextField();
		txtPc.setBounds(0, 27, 422, 21);
		panel.add(txtPc);
		txtPc.setBackground(UIManager.getColor("CheckBox.light"));
		txtPc.setText("\uC774 \uD504\uB85C\uADF8\uB7A8\uC740 'PC\uBC29 \uC608\uC57D\uD504\uB85C\uADF8\uB7A8'\uC73C\uB85C PC\uBC29 \uC2DC\uAC04\uC744 \uC608\uC57D\uD560\uB54C \uC0AC\uC6A9\uB429\uB2C8\uB2E4.");
		txtPc.setEditable(false);
		txtPc.setColumns(100);
		
		textField_3 = new JTextField();
		textField_3.setBounds(0, 78, 353, 21);
		panel.add(textField_3);
		textField_3.setBackground(UIManager.getColor("CheckBox.light"));
		textField_3.setText("\uC774 \uC57D\uAD00\uC740 \uC0AC\uC6A9\uC790\uAC00 \uB3D9\uC758\uD55C \uC2DC\uC810\uC73C\uB85C \uBD80\uD130 \uD6A8\uB825\uC774 \uBC1C\uC0DD\uD569\uB2C8\uB2E4.");
		textField_3.setEditable(false);
		textField_3.setColumns(100);
		
		textField_4 = new JTextField();
		textField_4.setBounds(0, 58, 86, 21);
		panel.add(textField_4);
		textField_4.setBackground(UIManager.getColor("CheckBox.light"));
		textField_4.setText("2.\uC57D\uAD00\uC758 \uD6A8\uB825 ");
		textField_4.setEditable(false);
		textField_4.setColumns(100);
		
		textField_2 = new JTextField();
		textField_2.setBounds(0, 106, 68, 21);
		panel.add(textField_2);
		textField_2.setBackground(UIManager.getColor("CheckBox.light"));
		textField_2.setText("3.\uC774\uC6A9\uC694\uAE08");
		textField_2.setEditable(false);
		textField_2.setColumns(100);
		
		textField_5 = new JTextField();
		textField_5.setBounds(0, 127, 331, 21);
		panel.add(textField_5);
		textField_5.setBackground(UIManager.getColor("CheckBox.light"));
		textField_5.setText("\uC774\uC6A9\uC694\uAE08\uC740 1\uC2DC\uAC04\uB2F9 1,000\uC6D0\uC73C\uB85C \uC608\uC57D\uC218\uC218\uB8CC\uB294 \uBB34\uB8CC\uC785\uB2C8\uB2E4.");
		textField_5.setEditable(false);
		textField_5.setColumns(100);
		
		textField_6 = new JTextField();
		textField_6.setBounds(0, 294, 68, 21);
		panel.add(textField_6);
		textField_6.setBackground(UIManager.getColor("CheckBox.light"));
		textField_6.setText("6.\uC8FC\uC758\uC0AC\uD56D");
		textField_6.setEditable(false);
		textField_6.setColumns(100);
		
		textField_7 = new JTextField();
		textField_7.setBounds(0, 334, 412, 21);
		panel.add(textField_7);
		textField_7.setBackground(UIManager.getColor("CheckBox.light"));
		textField_7.setText("\uC608\uC57D \uD655\uC815\uD6C4 \uC774\uC6A9\uC2DC\uC791 \uC2DC\uAC04\uC73C\uB85C\uBD80\uD130 2\uC2DC\uAC04 \uC774\uC804\uC5D0\uB294 \uD658\uBD88\uC774 \uBD88\uAC00\uB2A5 \uD569\uB2C8\uB2E4.");
		textField_7.setEditable(false);
		textField_7.setColumns(100);
		
		textField_8 = new JTextField();
		textField_8.setBounds(0, 354, 387, 21);
		panel.add(textField_8);
		textField_8.setBackground(UIManager.getColor("CheckBox.light"));
		textField_8.setText("\uC608\uC57D \uD504\uB85C\uADF8\uB7A8 \uC774\uC0C1\uC73C\uB85C \uC778\uD55C \uBB38\uC81C\uC5D0 \uB300\uD558\uC5EC \uC77C\uC808 \uCC45\uC784 \uC9C0\uC9C0 \uC54A\uC2B5\uB2C8\uB2E4.");
		textField_8.setEditable(false);
		textField_8.setColumns(100);
		
		textField_9 = new JTextField();
		textField_9.setBounds(0, 158, 86, 21);
		panel.add(textField_9);
		textField_9.setBackground(UIManager.getColor("CheckBox.light"));
		textField_9.setText("4.\uC11C\uBE44\uC2A4 \uC81C\uACF5");
		textField_9.setEditable(false);
		textField_9.setColumns(100);
		
		textField_10 = new JTextField();
		textField_10.setBounds(0, 176, 314, 21);
		panel.add(textField_10);
		textField_10.setBackground(UIManager.getColor("CheckBox.light"));
		textField_10.setText("\uC11C\uBE44\uC2A4\uB294 \uC0AC\uC6A9\uC790 \uC608\uC57D\uD55C \uC2DC\uAC04\uC5D0 \uC81C\uACF5 \uBC0F \uC774\uC6A9\uAC00\uB2A5 \uD569\uB2C8\uB2E4.");
		textField_10.setEditable(false);
		textField_10.setColumns(100);
		
		textField_11 = new JTextField();
		textField_11.setBounds(0, 207, 86, 21);
		panel.add(textField_11);
		textField_11.setBackground(UIManager.getColor("CheckBox.light"));
		textField_11.setText("5.\uC6A9\uC5B4\uC815\uB9AC");
		textField_11.setEditable(false);
		textField_11.setColumns(100);
		
		txtPcpc = new JTextField();
		txtPcpc.setBounds(0, 225, 387, 21);
		panel.add(txtPcpc);
		txtPcpc.setBackground(UIManager.getColor("CheckBox.light"));
		txtPcpc.setText("PC\uBC29:PC\uB97C \uC774\uC6A9\uD558\uC5EC \uC77C\uC815\uC2DC\uAC04 \uC0AC\uC6A9\uC774 \uAC00\uB2A5\uD55C \uC11C\uBE44\uC2A4\uB97C \uC81C\uACF5\uD558\uB294 \uC7A5\uC18C");
		txtPcpc.setEditable(false);
		txtPcpc.setColumns(100);
		
		txtpc = new JTextField();
		txtpc.setBounds(0, 242, 502, 21);
		panel.add(txtpc);
		txtpc.setBackground(UIManager.getColor("CheckBox.light"));
		txtpc.setText("\uC0AC\uC6A9\uC790:PC\uBC29 \uC608\uC57D\uD504\uB85C\uADF8\uB7A8\uC744 \uC774\uC6A9\uD558\uC5EC \uC2DC\uAC04\uC608\uC57D\uC744 \uD558\uACE0 \uADF8 \uC2DC\uAC04\uC5D0 \uC11C\uBE44\uC2A4\uB97C \uC81C\uACF5 \uBC1B\uB294 \uC0AC\uB78C");
		txtpc.setEditable(false);
		txtpc.setColumns(100);
		
		textField_14 = new JTextField();
		textField_14.setBounds(0, 314, 370, 21);
		panel.add(textField_14);
		textField_14.setBackground(UIManager.getColor("CheckBox.light"));
		textField_14.setText("\uBCF8 \uC11C\uBE44\uC2A4\uB294 \uC608\uACE0 \uC5C6\uC774 \uCDE8\uC18C\uB420 \uC218 \uC788\uC73C\uBA70 \uADF8 \uCC45\uC784\uC744 \uC9C0\uC9C0 \uC54A\uC2B5\uB2C8\uB2E4.");
		textField_14.setEditable(false);
		textField_14.setColumns(100);
		
		txtpc_1 = new JTextField();
		txtpc_1.setBounds(0, 263, 290, 21);
		panel.add(txtpc_1);
		txtpc_1.setBackground(UIManager.getColor("CheckBox.light"));
		txtpc_1.setText("\uC11C\uBE44\uC2A4:PC\uBC29\uC744 \uD574\uB2F9 \uC2DC\uAC04\uB3D9\uC548 \uC774\uC6A9 \uD560 \uC218 \uC788\uB294 \uAD8C\uB9AC");
		txtpc_1.setEditable(false);
		txtpc_1.setColumns(100);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(507, 225, 205, 130);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		textField_12 = new JTextField();
		textField_12.setBounds(0, 0, 68, 21);
		panel_1.add(textField_12);
		textField_12.setBackground(UIManager.getColor("CheckBox.light"));
		textField_12.setText("7.\uD658\uBD88\uADDC\uC815");
		textField_12.setEditable(false);
		textField_12.setColumns(100);
		
		txtPc_1 = new JTextField();
		txtPc_1.setBounds(0, 42, 201, 21);
		panel_1.add(txtPc_1);
		txtPc_1.setBackground(UIManager.getColor("Button.darkShadow"));
		txtPc_1.setText("\uC608\uC57D\uC2DC\uAC04 24\uC2DC\uAC04\uC804 \uCDE8\uC18C\uC218\uC218\uB8CC 0%");
		txtPc_1.setEditable(false);
		txtPc_1.setColumns(100);
		
		textField_13 = new JTextField();
		textField_13.setBounds(0, 70, 201, 21);
		panel_1.add(textField_13);
		textField_13.setText("\uC608\uC57D\uC2DC\uAC04 6\uC2DC\uAC04\uC804 \uCDE8\uC18C\uC218\uC218\uB8CC 20%");
		textField_13.setEditable(false);
		textField_13.setColumns(100);
		textField_13.setBackground(SystemColor.controlHighlight);
		
		textField_15 = new JTextField();
		textField_15.setBounds(0, 109, 201, 21);
		panel_1.add(textField_15);
		textField_15.setText("\uC608\uC57D\uC2DC\uAC04 2\uC2DC\uAC04\uC804 \uCDE8\uC18C\uC218\uC218\uB8CC 100%");
		textField_15.setEditable(false);
		textField_15.setColumns(100);
		textField_15.setBackground(SystemColor.controlHighlight);
		
		textField_16 = new JTextField();
		textField_16.setBounds(0, 91, 201, 21);
		panel_1.add(textField_16);
		textField_16.setText("\uC608\uC57D\uC2DC\uAC04 4\uC2DC\uAC04\uC804 \uCDE8\uC18C\uC218\uC218\uB8CC 30%");
		textField_16.setEditable(false);
		textField_16.setColumns(100);
		textField_16.setBackground(SystemColor.controlHighlight);
		
		textField_17 = new JTextField();
		textField_17.setFont(new Font("함초롬바탕", Font.BOLD | Font.ITALIC, 14));
		textField_17.setText("\uCDE8\uC18C\uC2DC \uCDE8\uC18C \uC218\uC218\uB8CC\uB97C \uBC1B\uC2B5\uB2C8\uB2E4");
		textField_17.setEditable(false);
		textField_17.setColumns(100);
		textField_17.setBackground(Color.RED);
		textField_17.setBounds(0, 20, 201, 21);
		panel_1.add(textField_17);
		 btnNewButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	JOptionPane.showMessageDialog(null, today +"\n 약관에 동의 하셨습니다" );
	            	dispose();
	                
	                
	            }
	        });
		
		
	}
}
