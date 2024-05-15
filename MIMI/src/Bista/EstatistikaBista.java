package Bista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import funtzioak.BistakArgitaratu;
import java.awt.FlowLayout;

public class EstatistikaBista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public EstatistikaBista() {
		setResizable(false);
		//setIconImage(Toolkit.getDefaultToolkit().getImage(MenuaBista.class.getResource("/media.img/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 913, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(5, 5, 887, 125);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane);
		
		JLabel lblMenua = new JLabel("Estatistikak");
		splitPane.setLeftComponent(lblMenua);
		lblMenua.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenua.setFont(new Font("Monospaced", Font.PLAIN, 60));
		
		JPanel panel = new JPanel();
		splitPane.setRightComponent(panel);
		
		JButton btnAtzera = new JButton("ATZERA");
		btnAtzera.setBounds(400, 6, 85, 27);
		btnAtzera.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BistakArgitaratu.AdminMenuaJoan();
				dispose();
			}
		});
		panel.setLayout(null);
		panel.add(btnAtzera);
		
		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_2.setBounds(5, 124, 887, 316);
		splitPane_2.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane_2);
		
		JSplitPane splitPane_3 = new JSplitPane();
		splitPane_3.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_2.setRightComponent(splitPane_3);
		
		JSplitPane splitPane_4 = new JSplitPane();
		splitPane_4.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_3.setRightComponent(splitPane_4);
		
		JSplitPane splitPane_5 = new JSplitPane();
		splitPane_5.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_4.setRightComponent(splitPane_5);
		
		JButton btnPDeskubritu = new JButton("Top Entzundakoak");
		btnPDeskubritu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				dispose();
			}
		});
		btnPDeskubritu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		splitPane_4.setLeftComponent(btnPDeskubritu);
		
		JButton btnMKudeatu = new JButton("Top Gustuko Podcastak");
		btnMKudeatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnMKudeatu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		splitPane_3.setLeftComponent(btnMKudeatu);
		
		JButton btnNewButton = new JButton("Top Gustuko Abestiak");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		splitPane_5.setLeftComponent(btnNewButton);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_5.setRightComponent(splitPane_1);
		
		JPanel panel_1 = new JPanel();
		splitPane_1.setRightComponent(panel_1);
		
		JButton btnNewButton_1 = new JButton("Top Playlist");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		splitPane_1.setLeftComponent(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(null);
		splitPane_2.setLeftComponent(panel_2);
	}
	}

