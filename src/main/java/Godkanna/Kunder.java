package Godkanna;

public class Kunder {
	private String namn; //Namn på kund
	private String betyg; //Betyg som kund ger utförd städning, t ex "Mycket nöjd"
	private String typ; //Typ av städning, t ex "Toppstädning"
	private String kommentar; //Fält för frivillig kommentar som kunden kan lämna på utförd städning


	//En jävla massa getters och setter för ovanstående strings

	public String getNamn() {
		return namn;
	}

	public void setNamn(String namn) {
		this.namn = namn;
	}

	public String getBetyg() {
		return betyg;
	}

	public void setBetyg(String betyg) {
		this.betyg = betyg;
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public String getKommentar() {
		return kommentar;
	}

	public void setKommentar(String kommentar) {
		this.kommentar = kommentar;
	}


}
