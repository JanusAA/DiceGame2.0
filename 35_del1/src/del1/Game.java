package del1;

import java.util.Scanner;
import del1.Dice;
import del1.DiceCup;
import del1.Player;
import desktop_resources.GUI;

public class Game {

	public static void main(String[] args) {

		
		
		//Opretter scannere
		Scanner scanname = new Scanner(System.in);
		Scanner scanconfirm = new Scanner(System.in);
		Scanner scanroll = new Scanner(System.in);
		
		//Opretter to instanser af Player
		Player p1 = new Player("Spiller 1", 0);
		Player p2 = new Player("spiller 2", 0);

		//Opretter instans af DiceCup
		DiceCup d6 = new DiceCup();
		
		//Opretter int "points" som bruges med d6 som caller på RollDiceCup og genere 
		int points;
		String confirm = "";

		System.out.println("Velkommen til terningspillet");
		System.out.println("Terningspillet er et spil mellem 2 personer. Det gælder om at få 40 point først." +"\n" + "Hvis begge spillere har over 40 point, er det spilleren med højest point som vinder ");
		System.out.println("Regler: ved slag med to terninger summeres øjnene, som lægges til ens point." +"\n" + "Ved point på 40 eller derover vindes spillet.");

		do {
			System.out.println("\n" + "Spiller 1 indtast dit navn:");
			p1.setName(scanname.nextLine());

			System.out.println("Du har indtastet >>" + p1.getName() + "<< indtast >>Y<< for at bekræfte, eller retur for at rette navnet.");
			confirm = scanconfirm.nextLine();
			confirm.toUpperCase();

		}while(!(confirm.equalsIgnoreCase("Y")));

		do {
			System.out.println("\n" + "Spiller 2 indtast dit navn:");
			p2.setName(scanname.nextLine());

			System.out.println("Du har indtastet >>" + p2.getName() + "<< indtast >>Y<< for at bekræfte, eller retur for at rette navnet.");
			confirm = scanconfirm.nextLine();
			confirm.toUpperCase();

		}while(!(confirm.equalsIgnoreCase("Y")));
		

		// I do-while løkken kaster vi terningerne og tilføjer pointene til balancen.
		do {
			
			
			System.out.println("\n" + "Spiller " + p1.getName() + " slå med rafflebærgeret ved at trykke på enter");


			// Scanneren som "pauser" programmet og lader spilleren vælge hvornår han/hun ønsker at kaste terningerne. 
			String inp = scanroll.nextLine();

			
			points = d6.rollDiceCup();
			if (points == 2){
				System.out.println(p1.getName() + " desværre du mister alle dine point");
				p1.setBalance(0);
			}else
			p1.addToCurrentBalance(points);
			System.out.println("Du slog: " + points + " Du har " + p1.getBalance() + " point i alt");
			

			
			System.out.println("\n" + "Spiller " + p2.getName() + " slå med rafflebærgeret ved at trykke på enter");

		 
			String inp2 = scanroll.nextLine();


			points = d6.rollDiceCup();
			if (points == 2){
				System.out.println(p2.getName() + " desværre du mister alle dine point");
				p2.setBalance(0);
			}else
			p2.addToCurrentBalance(points);
			System.out.println("Du slog: " + points + " Du har " + p2.getBalance() + " point i alt");

		}while(!(p1.getBalance() >= 40 || p2.getBalance() >= 40));

		System.out.println("");
		
		if (p1.getBalance() > p2.getBalance())
			System.out.println("Tillykke " + p1.getName() + " - Du har vundet");
		else if (p2.getBalance() > p1.getBalance())
			System.out.println("Tillykke " + p2.getName() + " - Du har vundet");
		else if (p1.getBalance() == p2.getBalance())
			System.out.println("Spillet ender uafgjort - I har begge lige mange point");


		System.out.println(p1 + "\t" + p2);
		

		scanname.close();
		scanconfirm.close();
		scanroll.close();
		
	}

}
