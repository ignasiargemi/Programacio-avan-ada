
package Exercici2;

import java.util.ArrayList;

public class Caixa {
	
	//Atributs
	private int nombreElements;
	private int caixaId;
	private ArrayList<Polvoro> polvorons;
	String type;
	
	//Creadors
	public Caixa(ArrayList<Polvoro> p, int nombreElements, int caixaId){
		this.polvorons = p;
		this.nombreElements = nombreElements;
		this.caixaId = caixaId;
	}

	//Getters i Setters
	public int getNombreElements() {return nombreElements;}
	public void setNombreElements(int nombreElements) {this.nombreElements = nombreElements;}
	public int getCaixaId() {return caixaId;}
	public void setCaixaId(int caixaId) {this.caixaId = caixaId;}
	public String getType() {return type;}
	public void setType(String type) {this.type = type;}
	public ArrayList<Polvoro> getPolvorons() {return polvorons;}
	public void setPolvorons(ArrayList<Polvoro> polvorons) {this.polvorons = polvorons;}
	
	//ToString
	public String toString() {
		String retorn = "Caixa [nombreElements=" + nombreElements + ", caixaId=" + caixaId + "]\n";
		retorn += "Llista de polvorons:\n";
		for (int i = 0; i < polvorons.size(); ++i) 
			retorn += (i+1) + ". " + polvorons.get(i).toString() + "\n";
		
		retorn += "S'ha retornat correctament tots els polvorons de la caixa.\n";
		return retorn;
	}

	public boolean EsAvorrida() {
		boolean avorrit = false;
		for (int i = 0; i < this.polvorons.size()/2+1 && !avorrit; ++i)
			if (AvorritRec(this.polvorons.get(i),this.polvorons,0,this.polvorons.size()-1) > polvorons.size()/2) {
				this.type = this.polvorons.get(i).getTipus();
				avorrit = true;
			}
		return avorrit;
	}

	private int AvorritRec(Polvoro p, ArrayList<Polvoro> polvorons, int inici, int fi) {
		int mig = (fi+inici)/2;
		if (fi == inici) {
			if (p.equals(polvorons.get(inici))) return 1;
			else return 0;
		}
		else return AvorritRec(p,polvorons,inici,mig) + AvorritRec(p,polvorons,mig+1,fi);
	}
}