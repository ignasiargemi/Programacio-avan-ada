package Exercici2;

import java.util.ArrayList;
import java.util.Scanner;

public class ProblemaCaixaPolvorons{
	
	@SuppressWarnings("resource")
	public static void main(String args[]){
		System.out.println("INTRODUEIX LES DADES NECESSARIES I ET DIRE SI LA CAIXA ES AVORRIDA O NO");
		System.out.println("Tamany de la caixa: ");
		Scanner sc = new Scanner(System.in);
		int mida = sc.nextInt();
		ArrayList<Polvoro> pol = new ArrayList<Polvoro>();
		System.out.println("Ara per a cada polvoro, introdueix el seu tipus");
		for (int i = 0; i < mida; ++i){
			String tipus = sc.next();
			pol.add(new Polvoro(tipus, i));
		}
		
		Caixa caixa = new Caixa(pol, mida, 0);
		if (caixa.EsAvorrida()) System.out.println("Si que és avorrida...polvoró pesat: " +  caixa.getType());
		else System.out.println("No és avorrida");
		System.out.print(caixa.toString());
		
		
	}

}