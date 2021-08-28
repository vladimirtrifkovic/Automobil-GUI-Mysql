package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.Kontrol;
import klasa.Automobil;
import model.JTableAutomobil;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
public class JFRAutomobil extends JFrame {

	private JPanel contentPane;
	private JTextField txtTip;
	private JTextField txtGodinaProizvodnje;
	private JTextField txtCena;
	private JTable table;
	private JButton btnPrikazi;
	private JButton btnUnos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFRAutomobil frame = new JFRAutomobil();
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
	public JFRAutomobil() {
		setTitle("Automobil");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 22, 250, 276);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblProizvodjac = new JLabel("Proizvodjac:");
		lblProizvodjac.setBounds(10, 27, 72, 13);
		panel.add(lblProizvodjac);
		
		JComboBox comboTipoviAutomobila = new JComboBox();
		comboTipoviAutomobila.setModel(new DefaultComboBoxModel(new String[] {"Audi", "Opel", "Renault", "Bmw", "Fiat", "Mercedes"}));
		comboTipoviAutomobila.setBounds(117, 23, 104, 21);
		panel.add(comboTipoviAutomobila);
		
		JLabel lblTip = new JLabel("Tip:");
		lblTip.setBounds(10, 67, 45, 13);
		panel.add(lblTip);
		
		txtTip = new JTextField();
		txtTip.setBounds(117, 64, 104, 19);
		panel.add(txtTip);
		txtTip.setColumns(10);
		
		JLabel lblGodinaProizvodnje = new JLabel("Godina proizvodnje:");
		lblGodinaProizvodnje.setBounds(10, 110, 91, 13);
		panel.add(lblGodinaProizvodnje);
		
		txtGodinaProizvodnje = new JTextField();
		txtGodinaProizvodnje.setBounds(117, 107, 96, 19);
		panel.add(txtGodinaProizvodnje);
		txtGodinaProizvodnje.setColumns(10);
		
		JLabel lblCena = new JLabel("Cena:");
		lblCena.setBounds(10, 145, 45, 13);
		panel.add(lblCena);
		
		txtCena = new JTextField();
		txtCena.setBounds(117, 145, 96, 19);
		panel.add(txtCena);
		txtCena.setColumns(10);
		
		btnUnos = new JButton("Unos");
		btnUnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String proizvodjac = comboTipoviAutomobila.getSelectedItem().toString();
					String tip = txtTip.getText().trim();
					String godS = txtGodinaProizvodnje.getText().trim();
					String cenaS = txtCena.getText().trim();
					int godiste = Integer.parseInt(godS);
					double cena = Double.parseDouble(cenaS);
					
					Automobil a = new Automobil(proizvodjac, tip, godiste, cena);
					Kontrol.getInstanceOf().unesiAutomobile(a);
					
					JOptionPane.showMessageDialog(getContentPane(), "Uspesno ste unjeli automobil");
					
					txtTip.setText("");
					txtGodinaProizvodnje.setText("");
					txtCena.setText("");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(getContentPane(), "Greska prilikom unosa " + e2.getMessage());
				}
			}
		});
		
		btnUnos.setBounds(64, 192, 85, 21);
		panel.add(btnUnos);
		
		btnPrikazi = new JButton("Prikazi");
		btnPrikazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Automobil> lista = Kontrol.getInstanceOf().vratiAutomobile();
				
				JTableAutomobil  model = new JTableAutomobil(lista);
				table.setModel(model);
			}
		});
		btnPrikazi.setBounds(82, 350, 85, 21);
		contentPane.add(btnPrikazi);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(286, 22, 326, 270);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Proizvodjac", "Tip", "Godiste", "Cena"
			}
		));
		
		scrollPane.setViewportView(table);
	}
}
