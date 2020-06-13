package view;

import java.util.Scanner;
import controller.Game;

public class Main {
	public static void main(String[] args) {
		Scanner lectureClavier = new Scanner(System.in);
		Game partie = new Game();
		
		Visuel.accueil();
		
		int rep = lectureClavier.nextInt();
		switch(rep) {
			case 1: partie.jvjClassic();
			break;
			
			case 2: partie.jvIAClassic();
			break;
			
			case 3: partie.jvjDeathMatch();
		}	
	}
}





