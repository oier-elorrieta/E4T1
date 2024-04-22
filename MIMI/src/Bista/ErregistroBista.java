<<<<<<< HEAD

package Bista;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import Modelo.Bezero;
import funtzioak.ErregistratuF;

=======
package Bista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Kontrolador.Konexioa;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
>>>>>>> e9cbff5e7531b321ee6c4b1b7188b027ffb7e917
import java.awt.Insets;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
<<<<<<< HEAD
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Properties;
=======
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
>>>>>>> e9cbff5e7531b321ee6c4b1b7188b027ffb7e917
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
<<<<<<< HEAD
import org.jdatepicker.impl.*;

=======
>>>>>>> e9cbff5e7531b321ee6c4b1b7188b027ffb7e917

public class ErregistroBista extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField txtIzena;
<<<<<<< HEAD
    private JTextField txtAbizena;
=======
    private JTextField txtAbizen;
>>>>>>> e9cbff5e7531b321ee6c4b1b7188b027ffb7e917
    private JTextField txtErabiltzaile;
    private JPasswordField pasahitzaPass;
    private JPasswordField konfirmarPass;
    private JTextField txtJaiotza;
    private JTextField txtErregistro;
    private JTextField txtPremium;
<<<<<<< HEAD
    private Date selectDate;
=======

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ErregistroBista frame = new ErregistroBista();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
>>>>>>> e9cbff5e7531b321ee6c4b1b7188b027ffb7e917

    /**
     * Create the frame.
     */
    public ErregistroBista() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 864, 694);
        SpringLayout springLayout = new SpringLayout();
        getContentPane().setLayout(springLayout);
        
        JLabel lblErregistroa = new JLabel("Erregistroa");
        springLayout.putConstraint(SpringLayout.NORTH, lblErregistroa, 37, SpringLayout.NORTH, getContentPane());
        lblErregistroa.setHorizontalAlignment(SwingConstants.CENTER);
        lblErregistroa.setFont(new Font("Monospaced", Font.PLAIN, 60));
        getContentPane().add(lblErregistroa);
        
        JButton btnAtzera = new JButton("ATZERA");
        springLayout.putConstraint(SpringLayout.WEST, lblErregistroa, 80, SpringLayout.EAST, btnAtzera);
        springLayout.putConstraint(SpringLayout.NORTH, btnAtzera, 63, SpringLayout.NORTH, getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, btnAtzera, 36, SpringLayout.WEST, getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, btnAtzera, 101, SpringLayout.NORTH, getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, btnAtzera, 169, SpringLayout.WEST, getContentPane());
        btnAtzera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        getContentPane().add(btnAtzera);
        
        JLabel lblIzena = new JLabel("Izena:");
        springLayout.putConstraint(SpringLayout.NORTH, lblIzena, 142, SpringLayout.NORTH, getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, lblIzena, 0, SpringLayout.WEST, btnAtzera);
        springLayout.putConstraint(SpringLayout.SOUTH, lblIzena, 63, SpringLayout.SOUTH, btnAtzera);
        springLayout.putConstraint(SpringLayout.EAST, lblIzena, 0, SpringLayout.EAST, btnAtzera);
        lblIzena.setHorizontalAlignment(SwingConstants.CENTER);
        lblIzena.setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().add(lblIzena);
        
        txtIzena = new JTextField();
        springLayout.putConstraint(SpringLayout.NORTH, txtIzena, 26, SpringLayout.SOUTH, lblErregistroa);
        springLayout.putConstraint(SpringLayout.WEST, txtIzena, 6, SpringLayout.EAST, lblIzena);
        springLayout.putConstraint(SpringLayout.SOUTH, txtIzena, -493, SpringLayout.SOUTH, getContentPane());
        getContentPane().add(txtIzena);
        txtIzena.setColumns(10);
        
<<<<<<< HEAD
        txtAbizena = new JTextField();
        springLayout.putConstraint(SpringLayout.NORTH, txtAbizena, 0, SpringLayout.NORTH, lblIzena);
        springLayout.putConstraint(SpringLayout.WEST, txtAbizena, 485, SpringLayout.WEST, getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, txtAbizena, -493, SpringLayout.SOUTH, getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, txtAbizena, -168, SpringLayout.EAST, getContentPane());
        txtAbizena.setColumns(10);
        getContentPane().add(txtAbizena);
=======
        txtAbizen = new JTextField();
        springLayout.putConstraint(SpringLayout.NORTH, txtAbizen, 0, SpringLayout.NORTH, lblIzena);
        springLayout.putConstraint(SpringLayout.WEST, txtAbizen, 485, SpringLayout.WEST, getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, txtAbizen, -493, SpringLayout.SOUTH, getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, txtAbizen, -168, SpringLayout.EAST, getContentPane());
        txtAbizen.setColumns(10);
        getContentPane().add(txtAbizen);
>>>>>>> e9cbff5e7531b321ee6c4b1b7188b027ffb7e917
        
        JLabel lblAbizena = new JLabel("Abizena:");
        springLayout.putConstraint(SpringLayout.EAST, txtIzena, -16, SpringLayout.WEST, lblAbizena);
        springLayout.putConstraint(SpringLayout.NORTH, lblAbizena, 0, SpringLayout.NORTH, lblIzena);
        springLayout.putConstraint(SpringLayout.WEST, lblAbizena, 386, SpringLayout.WEST, getContentPane());
<<<<<<< HEAD
        springLayout.putConstraint(SpringLayout.EAST, lblAbizena, -6, SpringLayout.WEST, txtAbizena);
=======
        springLayout.putConstraint(SpringLayout.EAST, lblAbizena, -6, SpringLayout.WEST, txtAbizen);
>>>>>>> e9cbff5e7531b321ee6c4b1b7188b027ffb7e917
        lblAbizena.setHorizontalAlignment(SwingConstants.CENTER);
        lblAbizena.setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().add(lblAbizena);
        
        JLabel lblErabiltzailea = new JLabel("Erabiltzailea:");
        springLayout.putConstraint(SpringLayout.NORTH, lblErabiltzailea, 188, SpringLayout.NORTH, getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, lblErabiltzailea, 0, SpringLayout.WEST, btnAtzera);
        springLayout.putConstraint(SpringLayout.EAST, lblErabiltzailea, 0, SpringLayout.EAST, btnAtzera);
        lblErabiltzailea.setHorizontalAlignment(SwingConstants.CENTER);
        lblErabiltzailea.setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().add(lblErabiltzailea);
        
        txtErabiltzaile = new JTextField();
        springLayout.putConstraint(SpringLayout.NORTH, txtErabiltzaile, 30, SpringLayout.SOUTH, txtIzena);
        springLayout.putConstraint(SpringLayout.WEST, txtErabiltzaile, 0, SpringLayout.WEST, txtIzena);
        springLayout.putConstraint(SpringLayout.EAST, txtErabiltzaile, -478, SpringLayout.EAST, getContentPane());
        txtErabiltzaile.setColumns(10);
        getContentPane().add(txtErabiltzaile);
        
        JLabel lblPasahitza = new JLabel("Pasahitza:");
        springLayout.putConstraint(SpringLayout.NORTH, lblPasahitza, 29, SpringLayout.SOUTH, lblErabiltzailea);
        springLayout.putConstraint(SpringLayout.WEST, lblPasahitza, 0, SpringLayout.WEST, btnAtzera);
        springLayout.putConstraint(SpringLayout.SOUTH, lblPasahitza, -394, SpringLayout.SOUTH, getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, lblPasahitza, 0, SpringLayout.EAST, btnAtzera);
        lblPasahitza.setHorizontalAlignment(SwingConstants.CENTER);
        lblPasahitza.setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().add(lblPasahitza);
        
        pasahitzaPass = new JPasswordField();
        springLayout.putConstraint(SpringLayout.NORTH, pasahitzaPass, 243, SpringLayout.NORTH, getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, txtErabiltzaile, -31, SpringLayout.NORTH, pasahitzaPass);
        springLayout.putConstraint(SpringLayout.WEST, pasahitzaPass, 0, SpringLayout.WEST, txtIzena);
        springLayout.putConstraint(SpringLayout.EAST, pasahitzaPass, -478, SpringLayout.EAST, getContentPane());
        getContentPane().add(pasahitzaPass);
        
        JLabel lblKonfirmatu = new JLabel("Konfirmatu:");
        springLayout.putConstraint(SpringLayout.NORTH, lblKonfirmatu, 31, SpringLayout.SOUTH, lblPasahitza);
        springLayout.putConstraint(SpringLayout.WEST, lblKonfirmatu, 0, SpringLayout.WEST, btnAtzera);
        springLayout.putConstraint(SpringLayout.SOUTH, lblKonfirmatu, -341, SpringLayout.SOUTH, getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, lblKonfirmatu, 169, SpringLayout.WEST, getContentPane());
        lblKonfirmatu.setHorizontalAlignment(SwingConstants.CENTER);
        lblKonfirmatu.setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().add(lblKonfirmatu);
        
        konfirmarPass = new JPasswordField();
        springLayout.putConstraint(SpringLayout.NORTH, konfirmarPass, 296, SpringLayout.NORTH, getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, pasahitzaPass, -33, SpringLayout.NORTH, konfirmarPass);
        springLayout.putConstraint(SpringLayout.WEST, konfirmarPass, 175, SpringLayout.WEST, getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, konfirmarPass, 0, SpringLayout.EAST, txtIzena);
        getContentPane().add(konfirmarPass);
        
        JLabel lblJaoitza = new JLabel("Jaiotze data:");
        springLayout.putConstraint(SpringLayout.NORTH, lblJaoitza, 39, SpringLayout.SOUTH, lblKonfirmatu);
        springLayout.putConstraint(SpringLayout.WEST, lblJaoitza, 36, SpringLayout.WEST, getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, lblJaoitza, -280, SpringLayout.SOUTH, getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, lblJaoitza, 0, SpringLayout.EAST, btnAtzera);
        lblJaoitza.setHorizontalAlignment(SwingConstants.CENTER);
        lblJaoitza.setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().add(lblJaoitza);
        
<<<<<<< HEAD

        UtilDateModel model = new UtilDateModel();
        Properties properties = new Properties();
        properties.put("text.today", "Hoy");
        properties.put("text.month", "Mes");
        properties.put("text.year", "Año");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
        
        Calendar today = Calendar.getInstance();
        model.setDate(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH));
        model.setSelected(true);
        datePanel.getModel().setSelected(true);


        model.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("value".equals(evt.getPropertyName())) {
                	selectDate = (Date) evt.getNewValue(); // Actualizar la fecha seleccionada
                    if (selectDate != null && selectDate.before(today.getTime())) {
                        model.setDate(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH));
                        model.setSelected(true);
                    }
                }
            }
        });


        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());
        springLayout.putConstraint(SpringLayout.NORTH, datePicker, 3, SpringLayout.NORTH, lblJaoitza);
        springLayout.putConstraint(SpringLayout.WEST, datePicker, 0, SpringLayout.WEST, txtIzena);
        springLayout.putConstraint(SpringLayout.EAST, datePicker, 0, SpringLayout.EAST, txtIzena);
        datePicker.setBounds(150, 100, 150, 30);
        getContentPane().add(datePicker);
=======
        txtJaiotza = new JTextField();
        springLayout.putConstraint(SpringLayout.NORTH, txtJaiotza, 357, SpringLayout.NORTH, getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, konfirmarPass, -41, SpringLayout.NORTH, txtJaiotza);
        springLayout.putConstraint(SpringLayout.WEST, txtJaiotza, 0, SpringLayout.WEST, txtIzena);
        springLayout.putConstraint(SpringLayout.EAST, txtJaiotza, -478, SpringLayout.EAST, getContentPane());
        txtJaiotza.setColumns(10);
        getContentPane().add(txtJaiotza);
>>>>>>> e9cbff5e7531b321ee6c4b1b7188b027ffb7e917
        
        JLabel lblErregistro = new JLabel("Erregistro data:");
        springLayout.putConstraint(SpringLayout.NORTH, lblErregistro, 40, SpringLayout.SOUTH, lblJaoitza);
        springLayout.putConstraint(SpringLayout.WEST, lblErregistro, 0, SpringLayout.WEST, btnAtzera);
        springLayout.putConstraint(SpringLayout.SOUTH, lblErregistro, -218, SpringLayout.SOUTH, getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, lblErregistro, 0, SpringLayout.EAST, btnAtzera);
        lblErregistro.setHorizontalAlignment(SwingConstants.CENTER);
        lblErregistro.setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().add(lblErregistro);
        
<<<<<<< HEAD
        DateTimeFormatter gaurkoData = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      
        
        txtErregistro = new JTextField(LocalDate.now().format(gaurkoData));
        txtErregistro.setEditable(false);
        springLayout.putConstraint(SpringLayout.NORTH, txtErregistro, 418, SpringLayout.NORTH, getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, txtErregistro, -41, SpringLayout.NORTH, txtErregistro);
=======
        txtErregistro = new JTextField();
        springLayout.putConstraint(SpringLayout.NORTH, txtErregistro, 418, SpringLayout.NORTH, getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, txtJaiotza, -41, SpringLayout.NORTH, txtErregistro);
>>>>>>> e9cbff5e7531b321ee6c4b1b7188b027ffb7e917
        springLayout.putConstraint(SpringLayout.WEST, txtErregistro, 0, SpringLayout.WEST, txtIzena);
        springLayout.putConstraint(SpringLayout.EAST, txtErregistro, -478, SpringLayout.EAST, getContentPane());
        txtErregistro.setColumns(10);
        getContentPane().add(txtErregistro);
        
        JLabel lblPremium = new JLabel("Premium muga:");
        springLayout.putConstraint(SpringLayout.NORTH, lblPremium, 36, SpringLayout.SOUTH, lblErregistro);
        springLayout.putConstraint(SpringLayout.WEST, lblPremium, 0, SpringLayout.WEST, btnAtzera);
        lblPremium.setHorizontalAlignment(SwingConstants.CENTER);
        lblPremium.setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().add(lblPremium);
        
        txtPremium = new JTextField();
<<<<<<< HEAD
        txtPremium.setEditable(false);
=======
>>>>>>> e9cbff5e7531b321ee6c4b1b7188b027ffb7e917
        springLayout.putConstraint(SpringLayout.SOUTH, txtErregistro, -37, SpringLayout.NORTH, txtPremium);
        springLayout.putConstraint(SpringLayout.NORTH, txtPremium, 4, SpringLayout.NORTH, lblPremium);
        springLayout.putConstraint(SpringLayout.WEST, txtPremium, 0, SpringLayout.WEST, txtIzena);
        springLayout.putConstraint(SpringLayout.SOUTH, txtPremium, -158, SpringLayout.SOUTH, getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, txtPremium, -478, SpringLayout.EAST, getContentPane());
        txtPremium.setColumns(10);
        getContentPane().add(txtPremium);
        
        JLabel lblHizkuntza = new JLabel("Hizkuntza:");
        springLayout.putConstraint(SpringLayout.NORTH, lblHizkuntza, 31, SpringLayout.SOUTH, lblPremium);
        springLayout.putConstraint(SpringLayout.WEST, lblHizkuntza, 0, SpringLayout.WEST, btnAtzera);
        springLayout.putConstraint(SpringLayout.SOUTH, lblHizkuntza, 53, SpringLayout.SOUTH, lblPremium);
        springLayout.putConstraint(SpringLayout.EAST, lblHizkuntza, 0, SpringLayout.EAST, btnAtzera);
        lblHizkuntza.setHorizontalAlignment(SwingConstants.CENTER);
        lblHizkuntza.setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().add(lblHizkuntza);
        
<<<<<<< HEAD
      
        JComboBox cmbHizkuntza = new JComboBox(ErregistratuF.HizkuntzaAtera());
=======
        JComboBox cmbHizkuntza = new JComboBox(HizkuntzaAtera());
>>>>>>> e9cbff5e7531b321ee6c4b1b7188b027ffb7e917
        springLayout.putConstraint(SpringLayout.NORTH, cmbHizkuntza, 29, SpringLayout.SOUTH, txtPremium);
        springLayout.putConstraint(SpringLayout.WEST, cmbHizkuntza, 0, SpringLayout.WEST, txtIzena);
        springLayout.putConstraint(SpringLayout.SOUTH, cmbHizkuntza, 51, SpringLayout.SOUTH, txtPremium);
        springLayout.putConstraint(SpringLayout.EAST, cmbHizkuntza, 0, SpringLayout.EAST, txtIzena);
        getContentPane().add(cmbHizkuntza);
        
        JButton btnGorde = new JButton("GORDE");
        btnGorde.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
            	
            	//java.sql.Date sqlDate = new java.sql.Date();
//  ----------------------------------------------------------------------------------- Hay que añadir un insert -----------------------------------------------------------------------------------------
                Bezero erregistroBezero = new Bezero();
                
                erregistroBezero.setIzena(txtIzena.getText());
                erregistroBezero.setAbizena(txtAbizena.getText());
                erregistroBezero.setErabiltzaile(txtErabiltzaile.getText());
                erregistroBezero.setPasahitza(pasahitzaPass.getText());
                erregistroBezero.setJaioData(selectDate);
                erregistroBezero.setErregisData((Date)ErregistratuF.StringtoDate(txtErregistro.getText()));
                erregistroBezero.setIzena(txtIzena.getText());

            	
            	try {
=======
//  ----------------------------------------------------------------------------------- Hay que añadir un insert -----------------------------------------------------------------------------------------
                try {
>>>>>>> e9cbff5e7531b321ee6c4b1b7188b027ffb7e917
                    LoginBista frame = new LoginBista();
                    frame.setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                dispose();
            }
        });
        springLayout.putConstraint(SpringLayout.NORTH, btnGorde, -52, SpringLayout.SOUTH, getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, btnGorde, 0, SpringLayout.WEST, btnAtzera);
        springLayout.putConstraint(SpringLayout.SOUTH, btnGorde, -29, SpringLayout.SOUTH, getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, btnGorde, 0, SpringLayout.EAST, txtIzena);
        getContentPane().add(btnGorde);
        
        JButton btnErosi = new JButton("EROSI PREMIUM");
<<<<<<< HEAD
        btnErosi.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		//premiunErosi();
        		
        	}
        });
        springLayout.putConstraint(SpringLayout.NORTH, btnErosi, 0, SpringLayout.NORTH, btnGorde);
        springLayout.putConstraint(SpringLayout.WEST, btnErosi, 0, SpringLayout.WEST, txtAbizena);
=======
        springLayout.putConstraint(SpringLayout.NORTH, btnErosi, 0, SpringLayout.NORTH, btnGorde);
        springLayout.putConstraint(SpringLayout.WEST, btnErosi, 0, SpringLayout.WEST, txtAbizen);
>>>>>>> e9cbff5e7531b321ee6c4b1b7188b027ffb7e917
        springLayout.putConstraint(SpringLayout.EAST, btnErosi, -29, SpringLayout.EAST, getContentPane());
        getContentPane().add(btnErosi);
    }
    
<<<<<<< HEAD
   
}
=======
    public String[] HizkuntzaAtera () {
    	String [] hiz = null;
    	int cont = 0;
    	 try (Connection con = Konexioa.konexioa()) {
             String countSql = "SELECT COUNT(*) AS total FROM Hizkuntza";
             try (PreparedStatement sta = con.prepareStatement(countSql)) {
                 try (ResultSet res = sta.executeQuery()) {
                     if (res.next()) {
                         cont = res.getInt("total");
                     }
                 }
             }

             hiz = new String[cont];

             String kontsulta = "SELECT idHizkuntza FROM Hizkuntza";
             try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {
                 try (ResultSet rs = pstmt.executeQuery()) {
                     int index = 0;
                     while (rs.next()) {
                     	String id = rs.getString("idHizkuntza");
                         

                         hiz[index] = id;
                         index++;
                     }
                 }
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }

         return hiz;
    }
}
>>>>>>> e9cbff5e7531b321ee6c4b1b7188b027ffb7e917
