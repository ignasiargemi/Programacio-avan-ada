package Assegurancsa;

public abstract class Persona {
	
	public Persona(String nom, String adreca, long telefon, long dNI,
			String poblacio) {
		super();
		this.nom = nom;
		this.adreca = adreca;
		this.telefon = telefon;
		DNI = dNI;
		this.poblacio = poblacio;
	}
	
	private String nom;
	private String adreca;
	private long telefon;
	private long DNI;
	private String poblacio;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdreca() {
		return adreca;
	}
	public void setAdreca(String adreca) {
		this.adreca = adreca;
	}
	public long getTelefon() {
		return telefon;
	}
	public void setTelefon(long telefon) {
		this.telefon = telefon;
	}
	public long getDNI() {
		return DNI;
	}
	public void setDNI(long dNI) {
		DNI = dNI;
	}
	public String getPoblacio() {
		return poblacio;
	}
	public void setPoblacio(String poblacio) {
		this.poblacio = poblacio;
	}
	public String toString() {
		return "Persona [getNom()=" + getNom() + ", getAdreca()=" + getAdreca()
				+ ", getTelefon()=" + getTelefon() + ", getDNI()=" + getDNI()
				+ ", getPoblacio()=" + getPoblacio() + "]";
	}
	
}
