package Assegurancsa;

import java.util.Date;

public class Llar extends Asseguransa{
	
	private String adresaAssegurat;
	private float valorContingut;
	private float valorContinent;
	
	public Llar(Date dateEmissio, int numeroPolissa, Client client,
			float impoort, Agent corredor, String adresaAssegurat, float valorContingut, float valorContinent) {
		super(dateEmissio, numeroPolissa, client, impoort, corredor);
		this.adresaAssegurat = adresaAssegurat;
		this.valorContingut = valorContingut;
		this.valorContinent = valorContinent;
	}
	
	public Llar(Date dateEmissio, int numeroPolissa, Client client,
			float impoort, Agent corredor, String adresaAssegurat, float valorContingut){
		this(dateEmissio, numeroPolissa, client, impoort, corredor, adresaAssegurat, valorContingut, 0);
	}
	
	public String getAdresaAssegurat() {
		return adresaAssegurat;
	}
	public void setAdresaAssegurat(String adresaAssegurat) {
		this.adresaAssegurat = adresaAssegurat;
	}
	public float getValorContingut() {
		return valorContingut;
	}
	public void setValorContingut(float valorContingut) {
		this.valorContingut = valorContingut;
	}
	public float getValorContinent() {
		return valorContinent;
	}
	public void setValorContinent(float valorContinent) {
		this.valorContinent = valorContinent;
	}

	public String toString() {
		return "Llar [adresaAssegurat=" + adresaAssegurat + ", valorContingut="
				+ valorContingut + ", valorContinent=" + valorContinent
				+ ", getDateEmissio()=" + getDateEmissio()
				+ ", getNumeroPolissa()=" + getNumeroPolissa()
				+ ", getClient()=" + getClient() + ", getImpoort()="
				+ getImpoort() + ", getCorredor()=" + getCorredor() + "]";
	}
	
	
}
