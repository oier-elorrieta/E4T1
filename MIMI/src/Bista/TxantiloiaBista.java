package Bista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class TxantiloiaBista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	public TxantiloiaBista() {
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 633);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});
		btnAtzera.setBounds(5, 5, 177, 36);
		contentPane.add(btnAtzera);

		// Hay
		JButton btnPerfil = new JButton("Erabiltzaile.getIzena()");
		btnPerfil.setBounds(572, 5, 177, 36);
		contentPane.add(btnPerfil);

	}
}
