package Cua_i_pila;

import java.util.Stack;
import java.util.Scanner;

public class comprovacio {
	public static void main(String[] args) throws Exception {
		// Declaracions
		CuanEnll<Character> cua = new CuanEnll<Character>();
		Stack<Character> pila = new Stack<Character>();
		CuanEnll<Character> cua_copia = new CuanEnll<Character>();
		Stack<Character> pila_copia = new Stack<Character>();
		
		//Comença la prova
		System.out.println("Introdueix la frase que vulguis comprovar:");
		System.out.println("(Acabar la seqüència amb un punt)");
		
		//Llegim les variables
		Scanner sc = new Scanner(System.in);
		char fi  = '.';
		char c = sc.next().charAt(0);
		while (fi != c) {
			if (c != '·' && c != 39 && c != ' ') {
				cua.encuar(c);
				pila.add(c);
			}
			c = sc.next().charAt(0);
		}
		pila_copia = (Stack<Character>)pila.clone();
		cua_copia = (CuanEnll<Character>)cua.clone();
		
		
		if (es_palindrom(pila_copia, cua_copia)) System.out.println("La seqüencia " + cua.toString() + " introduida és palindrom.");
		else System.out.println("La seqüencia " + cua.toString() + " introduida NO és palindrom.");
	}
	
	private static boolean es_palindrom(Stack<Character> pila,CuanEnll<Character> cua) throws Exception {
		boolean palindrom = true;
		char p = pila.pop();
		char c = cua.desencuar();
		while (!pila.isEmpty() && palindrom) {
			if (p == c) {
				p = pila.pop();
				c = cua.desencuar();
			}
			else palindrom = false;
		}
		return palindrom;
	}
}
