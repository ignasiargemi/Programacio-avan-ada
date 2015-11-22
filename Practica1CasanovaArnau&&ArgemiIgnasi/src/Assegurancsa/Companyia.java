package Assegurancsa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;



public class Companyia{
	
	private Asseguransa [] assegurances;
	private int quantesAssegurances;
	private List<Agent> agents;
	private String nom;
	private String adresa;
	private long telefon;
	private Node clients;
	
	
	private class Node{
		private Client inf;
		private Node seg;
		
		public Node(Client inf){this(inf,null);}
		public Node(Client inf, Node seg){
			this.inf = inf;
			this.seg=seg;
		}
		
		
		
	}
	
	private  Node Eliminar(Node p){
		if (p==null) return p;
		p = p.seg;
		Node aux = p;
		while (aux.seg != null){
			aux.seg = aux.seg.seg;
			aux = aux.seg;
		}
		return p;
	}
	
	
	public Companyia(String nom, String adresa, long telefon, int quantesAssegurances){
		this.nom = nom;
		this.adresa = adresa;
		this.telefon = telefon;
		this.quantesAssegurances = quantesAssegurances;
		this.assegurances = new Asseguransa[0];
		this.agents = new ArrayList();
	}

	public int getQuantesAssegurances() {
		return quantesAssegurances;
	}

	public void setQuantesAssegurances(int quantesAssegurances) {
		this.quantesAssegurances = quantesAssegurances;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public long getTelefon() {
		return telefon;
	}

	public void setTelefon(long telefon) {
		this.telefon = telefon;
	}
	
	
	public void addAsseguransa(Asseguransa a) throws Exception{
		Asseguransa [] aux=new Asseguransa[assegurances.length + 1];
		for (int i = 0; i < assegurances.length; ++i){
			aux[i] = assegurances[i];
			++quantesAssegurances;
			if (assegurances[i] == a) throw new Exception("La asseguran�a ja hi es!");
		
		}
		aux[assegurances.length] = a;
		assegurances = aux;
		Node a1 = clients;
		boolean trobat = false;
		if (clients == null) {
			clients = new Node(a.getClient());
		}
		else {
			while (a1.seg != null && !trobat){
				if (a.getClient().equals(a1.inf)){
					trobat = true;
				}
				else a1 = a1.seg;
			}
			if (!trobat) {
				a1 = clients;
				while (a1.seg != null) a1 = a1.seg;
				a1.seg = new Node(a.getClient());
			}
		}
	}
	
	public void remAsseguransa(Asseguransa a) throws Exception{
		Asseguransa [] aux = new Asseguransa[assegurances.length - 1];
		int z = 0, i;
		boolean trobat = false;
		for (i = 0; i < assegurances.length && !trobat; ++i){
			
			if (assegurances[i] == a){
				trobat = true;
				--quantesAssegurances;
			}
			else{
				aux[z] = assegurances[i];
				++z;
			}
			
		}
		if (!trobat) throw new Exception("No es pot eliminar una asseguran�a que no hi es!");
		else {
			for (int j = i+1; j < assegurances.length && trobat; ++j){
			aux[j-1] = assegurances[j];
		}
		assegurances = aux;
		}
		
		trobat = false;
		for (int k = 0; k < assegurances.length && !trobat; ++k){
			if (assegurances[k].getClient().equals(a.getClient())) trobat = true;
			}
		if (!trobat){
			Node a2 = clients;
			while(a2.seg != null && !trobat){
				if (clients.inf.equals(a.getClient())){
					trobat = true;
					Eliminar(a2);
				}
				a2 = a2.seg;
			}
			
		}
		
	}
	
	public void addAgent(Agent a) throws Exception{
		if (!agents.contains(a)) agents.add(a);
		else throw new Exception("Aquest agent ja hi es!");
	}
	
	public void remAgent(Agent a){
		if (agents.contains(a)) agents.remove(a);
		else
			try {
				throw new Exception("L'agent que volem eliminar no hi es!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	
	public Map<Integer, Agent> calculComissio(int mes){
		Map<Integer, Agent> retorn = new TreeMap<Integer, Agent>();
		for (int i = 0; i < assegurances.length; ++i){
			if(assegurances[i].getDateEmissio().getMonth() == mes-1){
				retorn.put(assegurances[i].getNumeroPolissa(), assegurances[i].getCorredor());
			}
		}
		return retorn;
	}
	
	int quantesAssegurancesVehicleTotRisc(){
		int cont = 0;
		for (int i = 0; i < assegurances.length; ++i){
			if (assegurances[i] instanceof TotRisc) ++cont;
		}
		return cont;
	}
	
	int quantesAssegurancesVehicleTotRisc(int franquicia){
		int cont = 0;
		for (int i = 0; i < assegurances.length; ++i){
			if (assegurances[i] instanceof TotRisc){
				if (((TotRisc)assegurances[i]).getFranquicia() > franquicia) ++cont;
			}
		}
		return cont;
	}
	
	int quantsClients(String poblacio){
		Node aux = clients;
		int cont = 0;
		while(aux.seg != null){
			if (aux.inf.getPoblacio().equals(poblacio)) cont++;
			aux = aux.seg;
		}
		return cont;	
	}
	
	void modificacioBonificacioPenalitzacio(int polissa, float increment) throws Exception{
		for (int i = 0; i < assegurances.length; ++i){
			if (assegurances[i] instanceof Vehicle && assegurances[i].getNumeroPolissa() == polissa){
				if (increment > 0) ((Vehicle)assegurances[i]).incrementaBonificacions((int)increment);
				else ((Vehicle)assegurances[i]).decrementaBonificacions((int)increment);
			}
		}
	}

	float asseguransaMesCobertura(Agent agent){
		float max = 0;
		for (int i = 0; i < assegurances.length; ++i){
			if (assegurances[i] instanceof Vida && assegurances[i].getCorredor().equals(agent)){
				if (((Vida)assegurances[i]).getCobertura() > max) max = ((Vida)assegurances[i]).getCobertura();
			}
		}
		return max;
	}
	
	String tipusAsseguransaMesContractada(){
		String retorn = "";
		int contLlar = 0, contV = 0, contVida = 0;
		for (int i = 0; i < assegurances.length; ++i){
			if (assegurances[i] instanceof Vehicle) ++contV;
			else if (assegurances[i] instanceof Llar) ++contLlar;
			else ++contVida;
		}
		if (contV > contLlar && contV > contVida) retorn = "Vehicle";
		else if(contLlar > contV && contLlar > contVida) retorn = "Llar";
		else retorn = "Vida";
		return retorn;
	}
 }

