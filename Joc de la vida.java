import java.util.Scanner;
public class Joc {
	Scanner e=new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Joc p = new Joc();
		System.out.println("Benvigut al Joc de la vida :)");
		p.principal();
	}
	
	public void principal() {
		System.out.println("Voldras inserir de manera manual les colonies o automatic: \nmanual[m] automatic[a]");
		char eleccio=e.next().charAt(0);
		
		System.out.println("Introdueix el nombre de filas i columnes que voldras:");
		int filas=dimensio();

		
		char [][] t=new char[filas][filas];
		char [][] t2=new char[filas][filas];

    }
}    