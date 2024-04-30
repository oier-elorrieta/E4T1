package Bista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Erreproduktorea extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Erreproduktorea() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1009, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAtzera = new JButton("ATZERA");
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAtzera.setBounds(10, 11, 128, 23);
		contentPane.add(btnAtzera);
		
		JButton btnProfila = new JButton("");
		btnProfila.setBounds(855, 11, 128, 23);
		contentPane.add(btnProfila);
		
		JLabel lblNewLabel = new JLabel("Musika Erreproduktorea");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(148, 15, 697, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblIrudi = new JLabel("");
		lblIrudi.setBounds(252, 65, 471, 290);
		contentPane.add(lblIrudi);
		
		JButton btnMenu = new JButton("Menua");
		btnMenu.setBounds(252, 366, 89, 23);
		contentPane.add(btnMenu);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.setBounds(450, 366, 89, 23);
		contentPane.add(btnPlay);
		
		JButton btnAbestiAtzera = new JButton("<");
		btnAbestiAtzera.setBounds(351, 366, 89, 23);
		contentPane.add(btnAbestiAtzera);
		
		JButton btnAbestiAurrera = new JButton(">");
		btnAbestiAurrera.setBounds(548, 366, 89, 23);
		contentPane.add(btnAbestiAurrera);
		
		JButton btnLike = new JButton("    ❤️");
		btnLike.setBounds(647, 366, 76, 23);
		contentPane.add(btnLike);
		
		JLabel lblInfo = new JLabel("");
		lblInfo.setBounds(148, 401, 670, 60);
		contentPane.add(lblInfo);
	}
}
