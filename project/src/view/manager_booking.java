import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class manager_booking extends JPanel {
	JFrame f;
	private JTable table;
	private JTable table_1;
	private DefaultTableModel DtmStorage;
	private DefaultTableModel DtmStorage2;

	revVO rev;
	ReserveDAO revdao;
	private JTextField textcalendarField;
	private JTextField textcalendarField2;
	private JTextField textcalendarField3;
	private JTextField textcalendarField4;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					manager_booking frame = new manager_booking();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public manager_booking() {
		f = new JFrame("관리자_예약관리");
		JPanel p1 = new JPanel();
		p1.setBorder(new TitledBorder("예약검색"));
		p1.setBounds(12, 10, 233, 348);
		p1.setBackground(new Color(255, 255, 255));
		p1.setLayout(null);

		JPanel p2 = new JPanel();
		p2.setBackground(new Color(255, 255, 255));

		JTabbedPane tp = new JTabbedPane();
		tp.setBounds(0, 0, 885, 528);
		tp.add("           예약완료내역", p1);

		// 출력헤더
		JScrollPane scrollpane = new JScrollPane();
		scrollpane.setBounds(25, 64, 806, 416);
		p1.add(scrollpane);

		JButton calendarButton = new JButton("\uAE30\uAC041");
		calendarButton.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 14));
		calendarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textcalendarField.setText(String.valueOf(new DatePick(f).Set_Picked_Date()));
			}
		});
		calendarButton.setBounds(25, 28, 75, 23);
		p1.add(calendarButton);

		textcalendarField = new JTextField();
		textcalendarField.setBounds(112, 29, 116, 21);
		p1.add(textcalendarField);
		textcalendarField.setColumns(10);

		JButton calendarButton2 = new JButton("\uAE30\uAC042");
		calendarButton2.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 14));
		calendarButton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textcalendarField2.setText(String.valueOf(new DatePick(f).Set_Picked_Date()));
			}
		});
		calendarButton2.setBounds(269, 28, 75, 23);
		p1.add(calendarButton2);

		textcalendarField2 = new JTextField();
		textcalendarField2.setBounds(356, 29, 116, 21);
		p1.add(textcalendarField2);
		textcalendarField2.setColumns(10);

		JLabel lblNewLabel = new JLabel("~");
		lblNewLabel.setBounds(242, 32, 23, 15);
		p1.add(lblNewLabel);

		String[] column = { "", "", "", "", "", "" };
		DtmStorage = new DefaultTableModel(column, 0) {
			public boolean isCellEitable(int row, int column) { // 테이블 더블클릭시 수정여부
				return true; // 셀수정가능,불가능(return false)
			}
		};

		JButton btnNewButton = new JButton("\uC870\uD68C\uD558\uAE30");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// 여기서부터
					String startDate = textcalendarField.getText();
					// 이기간까지 조회하기
					String startDate2 = textcalendarField2.getText();

					ReserveDAO revdao = new ReserveDAO();
					ArrayList list = revdao.revSearch2(startDate, startDate2);
					// 조회된데이터개수
					int num = list.size();
					System.out.println(startDate);
					System.out.println(num);

					ArrayList temp = new ArrayList();
					String[] col = { "예약일자", "이름", "컴퓨터 번호", "예약시작시간", "예약종료시간", "예약취소가능" };
					String[][] row = new String[num][6];
					for (int i = 0; i < num; i++) {
						temp = (ArrayList) list.get(i);
						row[i][0] = (String) temp.get(0);
						row[i][1] = (String) temp.get(1);
						row[i][2] = String.valueOf(temp.get(2));
						row[i][3] = (String) temp.get(3);
						row[i][4] = (String) temp.get(4);
						row[i][5] = (String) temp.get(5);
						DtmStorage = new DefaultTableModel(row, col);
						table = new JTable(DtmStorage);
						scrollpane.setViewportView(table);
						// table선택하면 1.값가져오고 2.새로운창띄우기
//							Cancelconfirm cancel= new Cancelconfirm();
						table.addMouseListener((new MouseAdapter() {
							public void mouseClicked(MouseEvent e) {
								try {
									int col = 0;
									int row = table.getSelectedRow();
									// 이게 고유한코드(예약일자)
									String vNum = (String.valueOf(table.getValueAt(row, col)));
									System.out.println(vNum);
									PcDAO pcdao = new PcDAO();
									// 예약일자넣어서 다시 코드로 반환받기
									revVO rev = pcdao.searchCode(vNum);
									// 이게회원코드
									String code = rev.getCode();
									System.out.println(code);
								 Cancelconfirm confirm = new Cancelconfirm(code);
									//confirm.main(column);
									// 몇번째row선택했는지
									// 이정보갖고 이제 여기로 가야됨
								} catch (Exception e12) {
									JOptionPane.showMessageDialog(null, "정보조회실패 : " + e12.getMessage());
								}
							}
						}));
						// getvalueof로 고유값가져와서 또
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "예약조회에 실패하였습니다" + e2.getMessage());
				}
			}
		});

		btnNewButton.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 14));
		btnNewButton.setBounds(493, 28, 97, 23);
		p1.add(btnNewButton);

		tp.add("           예약취소내역", p2);
		p2.setBorder(new TitledBorder("예약취소검색"));
		p2.setLayout(null);
		JScrollPane scrollpane2 = new JScrollPane();
		scrollpane2.setBounds(25, 65, 806, 411);
		p2.add(scrollpane2);
		String[] column2 = { "", "", "", "", "", "" };
		DtmStorage2 = new DefaultTableModel(column2, 0) {
			public boolean isCellEitable(int row, int column) { // 테이블 더블클릭시 수정여부
				return true; // 셀수정가능,불가능(return false)
			}
		};

		// 관리자-예약취소한사람 찾기
		JButton btnNewButton_1 = new JButton("\uC870\uD68C\uD558\uAE30");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// 기간이 애매한데 그냥 예약시작시간기준으로 조회하기
					// 여기서부터
					String startDate3 = textcalendarField3.getText();
					// 이기간까지 조회하기
					String startDate4 = textcalendarField4.getText();

					ReserveDAO revdao = new ReserveDAO();
					ArrayList list = revdao.revSearch3(startDate3, startDate4);

					String[] col = { "이름", "컴퓨터번호", "예약시작시간", "예약종료시간", "예약취소시간", "환불금액" };
					int num = list.size();
					System.out.println(num);
					String[][] row = new String[num][6];
					ArrayList temp = new ArrayList();
					for (int i = 0; i < num; i++) {
						temp = (ArrayList) list.get(i);
						row[i][0] = (String) temp.get(0);
						row[i][1] = String.valueOf(temp.get(1));
						row[i][2] = (String) temp.get(2);
						row[i][3] = (String) temp.get(3);
						row[i][4] = (String) temp.get(4);
						row[i][5] = String.valueOf(temp.get(5));

						DtmStorage2 = new DefaultTableModel(row, col);
						table_1 = new JTable(DtmStorage2);
						scrollpane2.setViewportView(table_1);
					}
				} catch (Exception e3) {
					JOptionPane.showMessageDialog(null, "예약취소조회에 실패하였습니다" + e3.getMessage());
				}
			}
		});

		textcalendarField3 = new JTextField();
		textcalendarField3.setColumns(10);
		textcalendarField3.setBounds(112, 25, 116, 21);
		p2.add(textcalendarField3);

		JButton calendarButton_1 = new JButton("\uAE30\uAC041");
		calendarButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textcalendarField3.setText(String.valueOf(new DatePick(f).Set_Picked_Date()));
			}
		});
		calendarButton_1.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 14));
		calendarButton_1.setBounds(25, 24, 75, 23);
		p2.add(calendarButton_1);

		JLabel lblNewLabel_1 = new JLabel("~");
		lblNewLabel_1.setBounds(240, 27, 23, 15);
		p2.add(lblNewLabel_1);

		JButton calendarButton2_1 = new JButton("\uAE30\uAC042");
		calendarButton2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textcalendarField4.setText(String.valueOf(new DatePick(f).Set_Picked_Date()));
			}
		});
		calendarButton2_1.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 14));
		calendarButton2_1.setBounds(267, 23, 75, 23);
		p2.add(calendarButton2_1);

		textcalendarField4 = new JTextField();
		textcalendarField4.setColumns(10);
		textcalendarField4.setBounds(354, 24, 116, 21);
		p2.add(textcalendarField4);

		btnNewButton_1.setFont(new Font("나눔스퀘어_ac Bold", Font.PLAIN, 14));
		btnNewButton_1.setBounds(491, 23, 97, 23);
		p2.add(btnNewButton_1);
//		 table_1.getColumnModel().getColumn(0).setPreferredWidth(135);
//		 table_1.getColumnModel().getColumn(1).setPreferredWidth(135);
//		 table_1.getColumnModel().getColumn(2).setPreferredWidth(135);
//		 table_1.getColumnModel().getColumn(3).setPreferredWidth(135);
//		 table_1.getColumnModel().getColumn(4).setPreferredWidth(135);
//		 table_1.getColumnModel().getColumn(5).setPreferredWidth(135);

		f.getContentPane().add(tp);
		f.setSize(899, 565);
		f.getContentPane().setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}