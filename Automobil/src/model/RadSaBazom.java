package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import klasa.Automobil;

public class RadSaBazom {
	
	private static RadSaBazom rsb;
	
	private RadSaBazom() {}
	
	public static RadSaBazom getInstanceOf() {
		if(rsb == null) {
			rsb = new RadSaBazom();
		}
		return rsb;
	}

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connect = DriverManager.getConnection("jdbc:mysql://localhost/automobil1", "root", "");
	}

	public ArrayList<Automobil> vratiAutomobile() throws ClassNotFoundException, SQLException {
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU
		ArrayList<Automobil> lista = new ArrayList<Automobil>();

		connect();
		preparedStatement = connect.prepareStatement("SELECT * FROM `automobili`");

		// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI
		// preparedStatement.setString(1, o.getJmbg());

		preparedStatement.execute();

		// ****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO
		resultSet = preparedStatement.getResultSet();

		while (resultSet.next()) {
			String proizvodjac = resultSet.getString("proizvodjac");
			String tip = resultSet.getString("tip");
			int godiste = resultSet.getInt("godiste");
			double cena = resultSet.getDouble("cena");

			Automobil a = new Automobil(proizvodjac, tip, godiste, cena);

			lista.add(a);
		}
		// ****KRAJ KRAJ OBRADE ResultSet-a

		close();
		return lista;
	}

	public void unesiAutomobile(Automobil a) throws ClassNotFoundException, SQLException {
		connect();
		preparedStatement = connect.prepareStatement("INSERT INTO `automobili`(`proizvodjac`, `tip`, `godiste`, `cena`) VALUES (?, ?, ?, ?)");
		
		preparedStatement.setString(1, a.getProizvodjac());
		preparedStatement.setString(2, a.getTip());
		preparedStatement.setInt(3, a.getGodiste());
		preparedStatement.setDouble(4, a.getCena());
		preparedStatement.execute();

		close();
	}

	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
