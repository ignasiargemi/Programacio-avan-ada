package Exercici2;

public class ProblemaCaixaPolvorons{
	
	public static void main(String args[]){
		System.out.println("COMENÇA L'EXECUCIÓ");
		System.out.println();
		Polvoro p = new Polvoro("xoco", 0123); 
		Polvoro p1 = new Polvoro("xoco", 0124);
		Polvoro p2 = new Polvoro("coco", 0125);
		Polvoro p3 = new Polvoro("xoco", 0126);
		Polvoro p4 = new Polvoro("nata", 0127);
		Polvoro p5 = new Polvoro("xoco", 554);
		Polvoro p6 = new Polvoro("crema", 012);
		Polvoro p7 = new Polvoro("xoco", 024);
		Polvoro p8 = new Polvoro("crema", 023);
		Polvoro p9 = new Polvoro("nata", 24);
		Polvoro p10 = new Polvoro("xoco", 123);
		Polvoro p11 = new Polvoro("xoco", 4);
		Polvoro p12 = new Polvoro("crema", 23);
		Polvoro p13 = new Polvoro("xoco", 012);
		Polvoro p14 = new Polvoro("xoco", 01);
		Polvoro p15 = new Polvoro("xoco", 02);
		
		Polvoro[] box = new Polvoro[16];
		box[0] = p;
		box[1] = p1;
		box[2] = p2;
		box[3] = p3;
		box[4] = p4;
		box[5] = p5;
		box[6] = p6;
		box[7] = p7;
		box[8] = p8;
		box[9] = p9;
		box[10] = p10;
		box[11] = p11;
		box[12] = p12;
		box[13] = p13;
		box[14] = p14;
		box[15] = p15;
		
		Caixa caixa = new Caixa(box, 16, 776);
		if (caixa.EsAvorrida()) System.out.println("Si que és avorrida...polvoró pesat: " +  caixa.getType());
		else System.out.println("No és avorrida");
		System.out.print(caixa.toString());
		
		
	}

}
