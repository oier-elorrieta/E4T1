package Bista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import funtzioak.Konexioa;
import funtzioak.LoginF;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class LoginBista extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldErabiltzailea;
    private JPasswordField passwordFieldPasahitza;

    public LoginBista() {
//      setIconImage(Toolkit.getDefaultToolkit().getImage(LoginBista.class.getResource(Aldagaiak.ikonoLogo)));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1280, 720);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setResizable(false);
        
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JPanel Titulua = new JPanel();
        contentPane.add(Titulua, BorderLayout.NORTH);
        Titulua.setLayout(new BorderLayout(0, 0));
        
        JLabel lblTitulua = new JLabel("Login"); 
        lblTitulua.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulua.setFont(new Font("Monospaced", Font.PLAIN, 60));
        Titulua.add(lblTitulua, BorderLayout.NORTH);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);
        
        textFieldErabiltzailea = new JTextField();
        textFieldErabiltzailea.setBounds(657, 150, 163, 20);
        panel.add(textFieldErabiltzailea);
        textFieldErabiltzailea.setColumns(10);
        
        JButton btnLog = new JButton("Login");
        btnLog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
                
                try {
					LoginF.LoginKomprobatu(textFieldErabiltzailea, passwordFieldPasahitza);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
            }
        });
        btnLog.setBounds(532, 352, 115, 36);
        panel.add(btnLog);
        
        passwordFieldPasahitza = new JPasswordField();
        
        passwordFieldPasahitza.addKeyListener(new KeyAdapter() {
        @Override

        public void keyPressed(KeyEvent e) {

            if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                // Simular el clic en el botón cuando se presiona Enter

                btnLog.doClick();
                // Deitu login botoia click funtzioa
            }

        }

    });
    
    //
    
        
        passwordFieldPasahitza.setBounds(657, 210, 163, 20);
        panel.add(passwordFieldPasahitza);
        
        
        JButton btnErregistro = new JButton("Erregistratu");
        btnErregistro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                try {
                    ErregistroBista frame = new ErregistroBista();
                    frame.setVisible(true);
                    dispose();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnErregistro.setBounds(657, 352, 119, 36);
        panel.add(btnErregistro);
        
        JLabel lblNewLabel = new JLabel("Erabiltzailea: ");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel.setBounds(532, 153, 89, 14);
        panel.add(lblNewLabel);
        
        JLabel lblPasahitza = new JLabel("Pasahitza:");
        lblPasahitza.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblPasahitza.setBounds(532, 211, 89, 14);
        panel.add(lblPasahitza);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 12));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Bezeroa", "Administratzailea"}));
        comboBox.setBounds(657, 280, 163, 22);
        panel.add(comboBox);
    }
    
    


	

}