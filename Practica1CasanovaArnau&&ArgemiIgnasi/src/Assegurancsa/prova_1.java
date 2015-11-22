package Assegurancsa;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class prova_1 {

	public static void main(String[] args) throws Exception {
		Companyia ArnauAs = new Companyia("Arnau", "caca",9876454,0);
		Agent arnauFucker = new Agent("Arnau","pipi",1234,56789,"laGarriga",2,4559.0f,"AD3456ER");
		ArnauAs.addAgent(arnauFucker);
		Agent ignasi = new Agent("Ignasi","crak",12346,567689,"lAmetlla",2,45659.0f,"AD34556ER");
		ArnauAs.addAgent(ignasi);
		Client c = new Client("Jajaja", "pet", 4566,87643245,"lAmetlla","56644R656");
		//Asseguransa prim = new Asseguransa(new Date(1954,6,7),12345,c,23445.6f,ignasi);
		Client a = new Client("Jajaja", "pet", 4566,87643245,"Granu","56644rR656");
		//Asseguransa sec = new Asseguransa(new Date(1997,6,7),12345,a,23445.6f,ignasi);
		Client b = new Client("Jajaja", "pet", 4566,87643245,"Granu","44R656");
		//Asseguransa ter = new Asseguransa(new Date(1994,6,7),12345,b,23445.6f,arnauFucker);
		Client d = new Client("Jajaja", "pet", 4566,87643245,"Granu","5644R656");
		Llar quar = new Llar(new Date(1994,6,7),12345,d,232445.6f,arnauFucker,"pepe",566.0f,212.0f);
		Llar qur = new Llar(new Date(1994,6,7),123456,d,234345.6f,ignasi,"pep",566.0f,212.0f);
		Llar qar = new Llar(new Date(1994,0,7),123457,d,234445.6f,arnauFucker,"pepe",566.0f,212.0f);
		Vehicle vehi = new Vehicle(new Date(1974,6,7),123445,b,23445.6f,ignasi,"5677F",18,56.0f);
		TotRisc tot = new TotRisc (new Date(1994,5,6),125345,b,23445.6f,arnauFucker,"5647F",18,56444.0f,777.8f,4);
		String atr[] = {"Avila","Burgos","León","Palencia","Salamanca",
				   "Segovia","Soria","Valladolid","Zamora"};
		Vida vid = new Vida(new Date(2004,4,6), 24242, d, 7499.0f, ignasi, 24, "Metge", atr, 6.4f);
		Vida vidw = new Vida(new Date(2004,4,6), 244242, d, 7499.0f, ignasi, 24, "Metge", atr, 56.74f);
		Vida vide = new Vida(new Date(2004,4,6), 242442, d, 7499.0f, ignasi, 24, "Metge", atr, 45.4f);
		//ArnauAs.addAsseguransa(prim);
		//ArnauAs.addAsseguransa(sec);
		//ArnauAs.addAsseguransa(ter);
		ArnauAs.addAsseguransa(quar);
		ArnauAs.addAsseguransa(qar);
		ArnauAs.addAsseguransa(qur);
		ArnauAs.addAsseguransa(tot);
		ArnauAs.addAsseguransa(vehi);
		ArnauAs.addAsseguransa(vid);
		ArnauAs.addAsseguransa(vidw);
		ArnauAs.addAsseguransa(vide);
		//System.out.println(ArnauAs.quantesAssegurancesVehicleTotRisc());
		//System.out.println(ArnauAs.quantsClients("Granu"));
		/*
		public Vida(Date dateEmissio, int numeroPolissa, Client client,
		float impoort, Agent corredor, int edat, String professio, String[] beneficiaris) {
		super(dateEmissio, numeroPolissa, client, impoort, corredor);
		this.edat = edat;
		this.professio = professio;
		this.beneficiaris = new String[1];
		
		
		
		TreeMap<Integer,Agent> nou = (TreeMap<Integer, Agent>) ArnauAs.calculComissio(5);
		Iterator it = nou.keySet().iterator();
		while (it.hasNext()) {
			Integer key = (Integer) it.next();
			System.out.println("Clau " + key.toString() + " Valor "+ nou.get(key).toString());
		}
		*/
		/*
		TreeMap<Integer,String> map = new TreeMap<Integer,String>();
		map.put(1, "Casillas");		map.put(15, "Ramos");
		map.put(3, "Pique");		map.put(5, "Puyol");
		map.put(11, "Capdevila");	map.put(14, "Xabi Alonso");
		map.put(16, "Busquets");	map.put(8, "Xavi Hernandez");
		map.put(18, "Pedrito");		map.put(6, "Iniesta");
		map.put(7, "Villa");
		
		Map<Integer, Agent> nou = ArnauAs.calculComissio(7);
		for (Integer x : nou.keySet()){
			System.out.println(x.toString() + " " + nou.get(x).toString());
		}
		*/
		/*
		System.out.println(ArnauAs.assegurances[4].toString());
		ArnauAs.modificacioBonificacioPenalitzacio(123445, 27);
		System.out.println(ArnauAs.assegurances[4].toString());
		*/
		//System.out.println(ArnauAs.asseguransaMesCobertura(ignasi));
		/*
		for (int i = 0; i < ArnauAs.assegurances.length; ++i) {
			System.out.println(ArnauAs.assegurances[i].getDateEmissio().getMonth());
		}
		*/
		//System.out.println(ArnauAs.tipusAsseguransaMesContractada());
		System.out.println("Fi");
	}

}
