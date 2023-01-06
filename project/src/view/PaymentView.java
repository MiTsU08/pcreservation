package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.PaymentDAO;

// �������� ��
public class PaymentView extends JFrame implements ActionListener {

	JPanel contentPane;
	JLabel lblNewLabel, lblNewLabel_1, lblNewLabel_2;
	JTextField textField;
	static JTextField calendarField1;
	static JTextField calendarField2;
	static JButton calendarButton, calendarButton_2, onedayButton, sevendayButton, monthButton;
	private JButton btnNewButton;
	
	private JTable table;
	private DefaultTableModel paymentList;
	PaymentDAO dao;
	static Date date=new Date();
	static SimpleDateFormat sd=new SimpleDateFormat("yyyy/MM/dd");
	static String today=sd.format(date);
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
	private static String beforeWeek, beforeMonth;
	

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentView frame = new PaymentView();
					frame.setVisible(true);
					
					
					calendarButton.addActionListener(new ActionListener() { // ù��° �޷�
						public void actionPerformed(ActionEvent ae) {
							calendarField1.setText(new CalPick(frame).Set_Picked_Date());
						}
					});
					calendarButton_2.addActionListener(new ActionListener() { // �ι�° �޷�
						public void actionPerformed(ActionEvent ae) {
							calendarField2.setText(new CalPick(frame).Set_Picked_Date());
						}
					});
					onedayButton.addActionListener(new ActionListener() { // �Ϸ� ��ư
						public void actionPerformed(ActionEvent ae) {
							calendarField1.setText(today);
							calendarField2.setText(today);
						}
					});
					sevendayButton.addActionListener(new ActionListener() { // ������ ��ư
						public void actionPerformed(ActionEvent ae) {
							calendarField1.setText(beforeWeek);
							calendarField2.setText(today);
//							calendarField2.setText((Integer)day-7);
						}
					});
					monthButton.addActionListener(new ActionListener() { // �Ѵ� ��ư
						public void actionPerformed(ActionEvent ae) {
							calendarField1.setText(beforeMonth);
							calendarField2.setText(today);
						}
					});

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PaymentView() {
		
		//���� ��
		setVisible(true);
		Calendar week = Calendar.getInstance();
		week.add(Calendar.DATE , -7);
		beforeWeek = new java.text.SimpleDateFormat("yyyy-MM-dd").format(week.getTime());
		
		//�Ѵ� ��
		Calendar mon = Calendar.getInstance();
		mon.add(Calendar.MONTH , -1);
		beforeMonth = new java.text.SimpleDateFormat("yyyy-MM-dd").format(mon.getTime());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		calendarButton = new JButton("�޷�");
		calendarButton.setBounds(140, 22, 35, 35);
		calendarButton.addActionListener(this);
		contentPane.setLayout(null);

		calendarField1 = new JTextField();
		calendarField1.setBounds(12, 27, 116, 21);
		calendarField1.setColumns(10);
		contentPane.add(calendarField1);

		calendarButton.setIcon(new ImageIcon(PaymentView.class.getResource("/images/calendar33.PNG")));
		calendarButton.setBackground(new Color(192, 192, 192));
		contentPane.add(calendarButton);

		lblNewLabel = new JLabel("~");
		lblNewLabel.setBounds(201, 22, 10, 35);
		contentPane.add(lblNewLabel);

		calendarField2 = new JTextField();
		calendarField2.setBounds(237, 27, 116, 21);
		calendarField2.setColumns(10);
		contentPane.add(calendarField2);

		calendarButton_2 = new JButton("�޷�");
		calendarButton_2.setBounds(365, 22, 35, 35);
		calendarButton_2.addActionListener(this);

		calendarButton_2.setIcon(new ImageIcon(PaymentView.class.getResource("/images/calendar33.PNG")));
		calendarButton_2.setBackground(new Color(192, 192, 192));
		contentPane.add(calendarButton_2);

		onedayButton = new JButton("�Ϸ�");
		onedayButton.setBounds(30, 70, 88, 23);
		onedayButton.addActionListener(this);
		contentPane.add(onedayButton);

		sevendayButton = new JButton("������");
		sevendayButton.setBounds(187, 70, 88, 23);
		contentPane.add(sevendayButton);

		monthButton = new JButton("�Ѵ�");
		monthButton.setBounds(351, 70, 88, 23);
		contentPane.add(monthButton);

		lblNewLabel_1 = new JLabel("�� ������� ");
		lblNewLabel_1.setBounds(30, 373, 129, 30);
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(159, 370, 286, 35);
		textField.setFont(new Font("����", Font.PLAIN, 18));
		contentPane.add(textField);
		textField.setColumns(10);

		lblNewLabel_2 = new JLabel("�� �Դϴ�!");
		lblNewLabel_2.setBounds(489, 377, 109, 23);
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_2);

		String[] column = { "", "", "", "", "", "" };
		paymentList = new DefaultTableModel(column, 0) {
			public boolean isCellEitable(int row, int column) { // ���̺� ����Ŭ���� ��������
				return true; // ����������,�Ұ���(return false)
			}
		};

		btnNewButton = new JButton("�˻�");
		btnNewButton.setBounds(489, 26, 97, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 111, 623, 243);
		contentPane.add(scrollPane);

		// ��ư ������ �Ⱓ ��ȸ���� ����Ʈ�� �� �ݾױ��� ���
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	        	 String total="";
				try {
					dao=new PaymentDAO();
					String startDate = calendarField1.getText(); //��ȸ ���� ��¥
					String endDate = calendarField2.getText(); // ��ȸ ������ ��¥

					ArrayList list = dao.paymentListSearch(startDate, endDate);
					// ��ȸ�ȵ����Ͱ���
					int num = list.size();
//					System.out.println(startDate);
//					System.out.println(endDate);
//					System.out.println(num);
					
					total = dao.selectTotal(startDate, endDate);

					ArrayList temp = new ArrayList();
					String[] col = { "�̸�", "��������", "�����ð�", "�����ݾ�" };
					String[][] row = new String[num][4];
					for (int i = 0; i < num; i++) {
						temp = (ArrayList) list.get(i);
						row[i][0] = (String) temp.get(0);
						row[i][1] = (String) temp.get(1);
						row[i][2] = String.valueOf(temp.get(2));
						row[i][3] = String.valueOf(temp.get(3));
						paymentList = new DefaultTableModel(row, col);
						table = new JTable(paymentList);
						scrollPane.setViewportView(table);
					}
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "����������ȸ�� �����Ͽ����ϴ�" + e2.getMessage());
					e2.printStackTrace();
				}
	            textField.setText(total);
			}
		});

	}

	public void actionPerformed(ActionEvent e) {
	}
}
