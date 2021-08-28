package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import klasa.Automobil;

public class JTableAutomobil extends AbstractTableModel {
	ArrayList<Automobil> lista;

	public JTableAutomobil(ArrayList<Automobil> lista) {
		super();
		this.lista = lista;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public Object getValueAt(int r, int c) {
		Automobil a = lista.get(r);
		switch (c) {
		case 0:
			return a.getProizvodjac();
		case 1:
			return a.getTip();
		case 2:
			return a.getGodiste();
		case 3:
			return a.getCena();
		default: return "GRESKA";
		}
	}
	
	@Override
	public String getColumnName(int c) {
		switch(c) {
		case 0 : return "Proizvodjac";
		case 1 : return "Tip";
		case 2 : return "Godiste";
		case 3 : return "Cena";
		default : return "Greska!";
		}
	}

}
