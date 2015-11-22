package Assegurancsa;

import java.util.Date;

public class Asseguransa {
	
	public Asseguransa(Date dateEmissio, int numeroPolissa, Client client,
			float impoort, Agent corredor) {
		
		this.dateEmissio = dateEmissio;
		this.numeroPolissa = numeroPolissa;
		this.client = client;
		this.impoort = impoort;
		this.corredor = corredor;
	}
	
	public Asseguransa(Date dateEmissio, int numeroPolissa, Client client, float impoort){
		this(dateEmissio, numeroPolissa, client, impoort, null);
	}
	
	private Date dateEmissio;
	private int numeroPolissa;
	private Client client;
	private float impoort;
	private Agent corredor;
	public Date getDateEmissio() {
		return dateEmissio;
	}
	public void setDateEmissio(Date dateEmissio) {
		this.dateEmissio = dateEmissio;
	}
	public int getNumeroPolissa() {
		return numeroPolissa;
	}
	public void setNumeroPolissa(int numeroPolissa) {
		this.numeroPolissa = numeroPolissa;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public float getImpoort() {
		return impoort;
	}
	public void setImpoort(float impoort) {
		this.impoort = impoort;
	}
	public Agent getCorredor() {
		return corredor;
	}
	public void setCorredor(Agent corredor) {
		this.corredor = corredor;
	}
	public String toString() {
		return "Assegurança [getDateEmissio()=" + getDateEmissio()
				+ ", getNumeroPolissa()=" + getNumeroPolissa()
				+ ", getClient()=" + getClient() + ", getImpoort()="
				+ getImpoort() + ", getCorredor()=" + getCorredor() + "]";
	}


	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asseguransa other = (Asseguransa) obj;
		if (numeroPolissa != other.numeroPolissa)
			return false;
		return true;
	}
	
	

}
