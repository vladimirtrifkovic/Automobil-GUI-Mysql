package klasa;

public class Automobil {
	private String proizvodjac;
	private String tip;
	private int godiste;
	private double cena;
	
	public Automobil(String proizvodjac, String tip, int godiste, double cena) {
		super();
		this.proizvodjac = proizvodjac;
		this.tip = tip;
		this.godiste = godiste;
		this.cena = cena;
	}

	public String getProizvodjac() {
		return proizvodjac;
	}

	public void setProizvodjac(String proizvodjac) {
		this.proizvodjac = proizvodjac;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public int getGodiste() {
		return godiste;
	}

	public void setGodiste(int godiste) {
		this.godiste = godiste;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	@Override
	public String toString() {
		return "proizvodjac=" + proizvodjac + "\tip=" + tip + "\ngodiste=" + godiste + "\ncena=" + cena
				+ "\n********************";
	}
	
	
}
