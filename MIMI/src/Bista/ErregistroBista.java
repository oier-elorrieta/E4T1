
package Bista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import DatuBasea.BezeroDao;
import Modelo.FreeBezero;
import Modelo.PremiumBezeroa;
import funtzioak.BistakArgitaratu;
import funtzioak.ErregistratuF;

public class ErregistroBista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtIzena;

	private JTextField txtAbizena;

	private JTextField txtErabiltzaile;
	private JPasswordField pasahitzaPass;
	private JPasswordField konfirmarPass;
	private JTextField txtErregistro;
	private JTextField txtPremium;
	private FreeBezero erregistroBezero;
	private Date selectDate;
	private PremiumBezeroa berriaPre;
	private JButton btnErosi;
	private JButton btnGorde;

	
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
				BistakArgitaratu.loginJoan();
				dispose();
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
		txtIzena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				denaBeteta();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, txtIzena, 26, SpringLayout.SOUTH, lblErregistroa);
		springLayout.putConstraint(SpringLayout.WEST, txtIzena, 6, SpringLayout.EAST, lblIzena);
		springLayout.putConstraint(SpringLayout.SOUTH, txtIzena, -493, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(txtIzena);
		txtIzena.setColumns(10);

		txtAbizena = new JTextField();
		txtAbizena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				denaBeteta();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, txtAbizena, 0, SpringLayout.NORTH, lblIzena);
		springLayout.putConstraint(SpringLayout.WEST, txtAbizena, 485, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, txtAbizena, -493, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtAbizena, -168, SpringLayout.EAST, getContentPane());
		txtAbizena.setColumns(10);
		getContentPane().add(txtAbizena);

		JLabel lblAbizena = new JLabel("Abizena:");
		springLayout.putConstraint(SpringLayout.EAST, txtIzena, -16, SpringLayout.WEST, lblAbizena);
		springLayout.putConstraint(SpringLayout.NORTH, lblAbizena, 0, SpringLayout.NORTH, lblIzena);
		springLayout.putConstraint(SpringLayout.WEST, lblAbizena, 386, SpringLayout.WEST, getContentPane());

		springLayout.putConstraint(SpringLayout.EAST, lblAbizena, -6, SpringLayout.WEST, txtAbizena);

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
		txtErabiltzaile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				denaBeteta();
				
			}
		});
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
		pasahitzaPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				denaBeteta();
			}
		});
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
		konfirmarPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				denaBeteta();
			}
		});
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

		UtilDateModel model = new UtilDateModel();
		Properties properties = new Properties();
		properties.put("text.today", "Hoy");
		properties.put("text.month", "Mes");
		properties.put("text.year", "Año");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);

		Calendar today = Calendar.getInstance();
        today.add(Calendar.YEAR, -14); // Gutxienez 14 urte eduki behar ditu
		model.setDate(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH));
		model.setSelected(true);
		datePanel.getModel().setSelected(true);

		model.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if ("value".equals(evt.getPropertyName())) {
					selectDate = (Date) evt.getNewValue();
					if (selectDate != null && selectDate.after(today.getTime())) {
						model.setDate(today.get(Calendar.YEAR), today.get(Calendar.MONTH),
								today.get(Calendar.DAY_OF_MONTH));
						model.setSelected(true);
					}
				}
			}
		});

		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());
		datePicker.getJFormattedTextField().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				denaBeteta();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, datePicker, 3, SpringLayout.NORTH, lblJaoitza);
		springLayout.putConstraint(SpringLayout.WEST, datePicker, 0, SpringLayout.WEST, txtIzena);
		springLayout.putConstraint(SpringLayout.EAST, datePicker, 0, SpringLayout.EAST, txtIzena);
		datePicker.setBounds(150, 100, 150, 30);
		getContentPane().add(datePicker);

		JLabel lblErregistro = new JLabel("Erregistro data:");
		springLayout.putConstraint(SpringLayout.NORTH, lblErregistro, 40, SpringLayout.SOUTH, lblJaoitza);
		springLayout.putConstraint(SpringLayout.WEST, lblErregistro, 0, SpringLayout.WEST, btnAtzera);
		springLayout.putConstraint(SpringLayout.SOUTH, lblErregistro, -218, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblErregistro, 0, SpringLayout.EAST, btnAtzera);
		lblErregistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblErregistro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().add(lblErregistro);

		

		txtErregistro = new JTextField(LocalDate.now().format(ErregistratuF.LocalDateFormatua()));
		txtErregistro.setEditable(false);
		springLayout.putConstraint(SpringLayout.NORTH, txtErregistro, 418, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, txtErregistro, -41, SpringLayout.NORTH, txtErregistro);
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

		LocalDate premiumMuga = LocalDate.now().plusYears(1);
		txtPremium = new JTextField(premiumMuga.format(ErregistratuF.LocalDateFormatua()));
		txtPremium.setEditable(false);
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

		JComboBox cmbHizkuntza = new JComboBox(BezeroDao.HizkuntzaAtera());
		springLayout.putConstraint(SpringLayout.NORTH, cmbHizkuntza, 29, SpringLayout.SOUTH, txtPremium);
		springLayout.putConstraint(SpringLayout.WEST, cmbHizkuntza, 0, SpringLayout.WEST, txtIzena);
		springLayout.putConstraint(SpringLayout.SOUTH, cmbHizkuntza, 51, SpringLayout.SOUTH, txtPremium);
		springLayout.putConstraint(SpringLayout.EAST, cmbHizkuntza, 0, SpringLayout.EAST, txtIzena);
		getContentPane().add(cmbHizkuntza);
		JTextField AukeratuHizkuntza = new JTextField(3);
		AukeratuHizkuntza.setText("ES");
		cmbHizkuntza.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AukeratuHizkuntza.setText(cmbHizkuntza.getSelectedItem().toString());
				denaBeteta();

			}
		});

		btnGorde = new JButton("Segui free");
		btnGorde.setEnabled(false);
		btnGorde.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				

				erregistroBezero = new FreeBezero();
				
				
				 if(ErregistratuF.PasahitzaBerdina(pasahitzaPass, konfirmarPass) == true && BezeroDao.Bezeroaexistitu(txtErabiltzaile) == true) {

				ErregistratuF.sortuBezeroa(erregistroBezero, txtIzena, txtAbizena, txtErabiltzaile, pasahitzaPass,
						selectDate, txtErregistro, AukeratuHizkuntza);

				try {
					BezeroDao.InsertFree(erregistroBezero);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				BistakArgitaratu.loginJoan();
				dispose();
			}
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnGorde, -52, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnGorde, 0, SpringLayout.WEST, btnAtzera);
		springLayout.putConstraint(SpringLayout.SOUTH, btnGorde, -29, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnGorde, 0, SpringLayout.EAST, txtIzena);
		getContentPane().add(btnGorde);

		btnErosi = new JButton("EROSI PREMIUM");
		btnErosi.setEnabled(false);
		btnErosi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				berriaPre = new PremiumBezeroa();
				
				
				 if(ErregistratuF.PasahitzaBerdina(pasahitzaPass, konfirmarPass) == true && BezeroDao.Bezeroaexistitu(txtErabiltzaile) == true) {

				ErregistratuF.PremiumErosi(premiumMuga, txtIzena, txtAbizena, txtErabiltzaile,
						pasahitzaPass, selectDate, txtErregistro, AukeratuHizkuntza, berriaPre);

				try {
					BezeroDao.InsertPremium(berriaPre);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				BistakArgitaratu.loginJoan();
				dispose();
			}
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnErosi, 0, SpringLayout.NORTH, btnGorde);
		springLayout.putConstraint(SpringLayout.WEST, btnErosi, 0, SpringLayout.WEST, txtAbizena);
		springLayout.putConstraint(SpringLayout.NORTH, btnErosi, 0, SpringLayout.NORTH, btnGorde);
		springLayout.putConstraint(SpringLayout.EAST, btnErosi, -29, SpringLayout.EAST, getContentPane());
		getContentPane().add(btnErosi);
	}

	public void denaBeteta() {
		boolean erosi = !txtIzena.getText().isEmpty() && !txtAbizena.getText().isEmpty()
				&& !txtErabiltzaile.getText().isEmpty() && !(pasahitzaPass.getPassword().length == 0)
				&& !(konfirmarPass.getPassword().length == 0);
		btnErosi.setEnabled(erosi);
		btnGorde.setEnabled(erosi);
	}

}
