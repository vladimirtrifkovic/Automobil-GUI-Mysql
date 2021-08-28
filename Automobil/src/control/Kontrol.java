package control;

import java.sql.SQLException;
import java.util.ArrayList;
import klasa.Automobil;
import model.RadSaBazom;

public class Kontrol {
	private static Kontrol kontrol;
	
	
	private Kontrol() {}
	
	
	public static Kontrol getInstanceOf() {
		if(kontrol == null) {
			kontrol = new Kontrol();
		}
		return kontrol;
	}
	
	
	public void unesiAutomobile(Automobil a) {
		try {
			RadSaBazom.getInstanceOf().unesiAutomobile(a);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Automobil> vratiAutomobile(){
		try {
			return RadSaBazom.getInstanceOf().vratiAutomobile();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
