package Bista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SpringLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;

public class MenuaBista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuaBista frame = new MenuaBista();
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
	public MenuaBista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 913, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane, BorderLayout.NORTH);
		
		JLabel lblMenua = new JLabel("Menua");
		splitPane.setLeftComponent(lblMenua);
		lblMenua.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenua.setFont(new Font("Monospaced", Font.PLAIN, 60));
		
		JPanel panel = new JPanel();
		splitPane.setRightComponent(panel);
		
		JSplitPane splitPane_1 = new JSplitPane();
		panel.add(splitPane_1);
		
		JButton btnAtzera = new JButton("ATZERA");
		btnAtzera.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		splitPane_1.setLeftComponent(btnAtzera);
		
		JButton btnNewButton = new JButton("PROFILA");
		btnNewButton.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		splitPane_1.setRightComponent(btnNewButton);
		
		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_2.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane_2, BorderLayout.CENTER);
		
		JSplitPane splitPane_3 = new JSplitPane();
		splitPane_3.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_2.setRightComponent(splitPane_3);
		
		JSplitPane splitPane_4 = new JSplitPane();
		splitPane_4.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_3.setRightComponent(splitPane_4);
		
		JSplitPane splitPane_5 = new JSplitPane();
		splitPane_5.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_4.setRightComponent(splitPane_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		splitPane_5.setRightComponent(panel_1);
		
		JButton btnNirePlay = new JButton("Nire PlayList-ak");
		btnNirePlay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		splitPane_5.setLeftComponent(btnNirePlay);
		
		JButton btnPDeskubritu = new JButton("Podcastak Deskubritu");
		btnPDeskubritu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		splitPane_4.setLeftComponent(btnPDeskubritu);
		
		JButton btnMDeskubritu = new JButton("Musika Deskubritu");
		btnMDeskubritu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		splitPane_3.setLeftComponent(btnMDeskubritu);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(null);
		splitPane_2.setLeftComponent(panel_2);
	}

}