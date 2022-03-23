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

		System.out.println("Cuantes colonies voldras?");
		int colonies=e.nextInt();
		//manual
		if (eleccio=='m') {
			
			manual(colonies, t);
			
			imprimirt(t);
	
			System.out.println("Cuantes instancies desitges?");
			int instan=e.nextInt();
			int s=1;
			
			while(s<=instan) {
				vaciot2(t2);
				
				t2(t, t2);
				imprimirt(t);
				System.out.println("instancia nº -->" + s);
				System.out.println();
				t=t2;
			s++;
			}
	    }
		
		//automatic
		else if (eleccio=='a') {
			
			auto(colonies, t);
			
			imprimirt(t);

			System.out.println("Cuantes instancies desitges?");
			int instan=e.nextInt();
			int s=1;
			while(s<=instan) {
				vaciot2(t2);
				imprimirt2(t2);
				System.out.println();
				
				t2(t, t2);
				t=t2;
				imprimirt(t);
				System.out.println("instancia nº -->" + s);
				System.out.println();
			s++;
			}
		}
		
		else {
			System.out.println("Introdueix 'm' per manual o 'a' per automatic!!!");
			System.exit(0);
		}
	}
	
	public int dimensio() {
		int dimensio=e.nextInt();
		return dimensio;
	}
	
	public char [][] t2(char [][] t, char [][] t2) {
		int nV=0;
		for(int fila=0;fila<t.length;fila++) {
		  for(int col=0; col<t.length;col++) {
			  nV=0;
			  if(fila+1<t.length) {
				  if(t[	fila+1][col]=='x') {
					  nV++;
				  }
			  }
			  if(fila-1>=0) {
				  if(t[fila-1][col]=='x') {
					  nV++;
			  	  }
			  }
			  if(col+1<t.length) {	  
				  if(t[fila][col+1]=='x') {
					  nV++;
				  }
			  }
			  if(col-1>=0) {	  
				  if(t[fila][col-1]=='x') {
					  nV++;
				  }	
			  }
			  //Diagonals
			  if(fila+1<t.length && col+1<t.length) {
				  if(t[fila+1][col+1]=='x') {
					  nV++;
				  }	
			  }
			  
			  if(fila+1<t.length && col-1>=0) {
				  if(t[fila+1][col-1]=='x') {
					  nV++;
				  }	
			  }
			  
			  if(fila-1>=0 && col+1<t.length) {
				  if(t[fila-1][col+1]=='x') {
					  nV++;
				  }	
			  }
			  
			  if(fila-1>=0 && col-1>=0) {
				  if(t[fila-1][col-1]=='x') {
					  nV++;
				  }	
			  }
			  //Creacio-destruccio
			  if (nV==3) {
				  t2[fila][col]='x';
			  }
			  else if (nV==2) {
				  if(t[fila][col]=='x') {
					  t2[fila][col]='x';
				  }
				  else {
					  t2[fila][col]=' ';
				  }
			  }
			  else if (nV>3) {
				  t2[fila][col]=' ';
			  }
			  else  if (nV<2) {
				  t2[fila][col]=' ';
			  }
		  }
		}
		return t2;
	}