package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.ReserveDAO;
import model.rec.RevVO;
import model.rec.priceVO;

public class Cancelconfirm {

	private JFrame frame;
	RevVO rev;
	ReserveDAO revdao;
	priceVO pvo;

	public Cancelconfirm(String code) {
		initialize(code);
	}

	private void initialize(String code) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JButton YbtnNewButton = new JButton("Y");
		YbtnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println("code" + code);
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "oops~" + e2.getMessage());
				}
			}
		});
		
		YbtnNewButton.setBounds(93, 164, 97, 23);
		frame.getContentPane().add(YbtnNewButton);

		JButton NbtnNewButton = new JButton("N");
		NbtnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		NbtnNewButton.setBounds(257, 164, 97, 23);
		frame.getContentPane().add(NbtnNewButton);

		JLabel lblNewLabel = new JLabel("\uC815\uB9D0 \uC608\uC57D\uC744 \uCDE8\uC18C\uD560\uAE4C\uC694?");
		lblNewLabel.setBounds(156, 63, 141, 80);
		frame.getContentPane().add(lblNewLabel);
	}
}
