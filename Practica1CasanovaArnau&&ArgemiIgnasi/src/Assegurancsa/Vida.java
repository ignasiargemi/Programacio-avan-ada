package Assegurancsa;

import java.util.Arrays;
import java.util.Date;

public class Vida extends Asseguransa{

	public Vida(Date dateEmissio, int numeroPolissa, Client client,
		float impoort, Agent corredor, int edat, String professio, String[] beneficiaris, float cobertura) {
		super(dateEmissio, numeroPolissa, client, impoort, corredor);
		this.edat = edat;
		this.professio = professio;
		this.beneficiaris = new String[1];
		this.cobertura = cobertura;
	
	}
		private int edat;
		private String professio;
		private String beneficiaris[];
		private float cobertura;
		public int getEdat() {
			return edat;
		}
		public void setEdat(int edat) {
			this.edat = edat;
		}
		public String getProfessio() {
			return professio;
		}
		public void setProfessio(String professio) {
			this.professio = professio;
		}
		public String[] getBeneficiaris() {
			return beneficiaris;
		}
		public void setBeneficiaris(String[] beneficiaris) {
			this.beneficiaris = beneficiaris;
		}
		public float getCobertura() {
			return cobertura;
		}
		public void setCobertura(float cobertura) {
			this.cobertura = cobertura;
		}
		
		public void afegirBeneficiari(String nom){
			String []aux = new String[beneficiaris.length+1];
			for (int i = 0; i < aux.length; ++i){
				if (i == aux.length-1) aux[i] = nom;
				else aux[i] = beneficiaris[i];
				
			}
			beneficiaris = aux;
			
		}
		
		public void eliminarBeneficiari(String nom) throws Exception{
			boolean trobat = false;
			String [] aux = new String[beneficiaris.length-1];
			for (int i = 0; i < beneficiaris.length && !trobat; ++i){
				if (beneficiaris[i].equals(nom)){
					trobat = true;
					beneficiaris[i] = null;
					int z = 0;
					
					for (int j = 0; j < beneficiaris.length; ++j){
						if (j != i){
							aux[z] = beneficiaris[j];
							++z;
						}
						else z = j;
						
					}
				}
				if (!trobat) throw new Exception("No hi és."); // excepcio no hi es
			}
			beneficiaris = aux;
			
		}
		
		public String toString() {
			return "Vida [edat=" + edat + ", professio=" + professio
					+ ", beneficiaris=" + Arrays.toString(beneficiaris)
					+ ", cobertura=" + cobertura + ", getDateEmissio()="
					+ getDateEmissio() + ", getNumeroPolissa()="
					+ getNumeroPolissa() + ", getClient()=" + getClient()
					+ ", getImpoort()=" + getImpoort() + ", getCorredor()="
					+ getCorredor() + "]";
		}
		
		
		
		
		
}
