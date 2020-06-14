package view;

import controller.Effects;
import controller.Player;
import controller.Shop;

public class Visuel {
	public static void menu() {
		System.out.println("Que voulez vous faire ?");
		System.out.println("[1] Acheter une carte");
		System.out.println("[2] Détruire une carte");
		System.out.println("[3] Voir mon plateau");
		System.out.println("[4] Attaquer");
		System.out.println("[5] Afficher mon statut et celui de l'adversaire");
		System.out.println("[6] Finir mon tour");
	}
	
	public static void statut(Player player,Player badGuy) {
		System.out.println("------------------------Vous---------------------------------");
		System.out.println("Authority : " + player.getAuthority());
		System.out.println("Trade : " + player.getTrade());
		System.out.println("Combat : " + player.getCombat());
		System.out.println("Bases en jeu : " + player.getBoard().getBases() + "\n");
		
		System.out.println("---------------------Adversaire-----------------------------");
		System.out.println("Authority : " + badGuy.getAuthority());
		System.out.println("Bases en jeu : \n" + badGuy.getBoard().getBases());
		System.out.println("-------------------------------------------------------------");
	}
	
	public static void statut(Player p) {
		System.out.println("Authority : " + p.getAuthority());
		System.out.println("Trade : " + p.getTrade());
		System.out.println("Combat : " + p.getCombat());
		System.out.println("Bases en jeu : " + p.getBoard().getBases() + "\n");
	}
	
	public static void poser() {
		System.out.println("Voulez vous poser une carte ?");
		System.out.println("[1] Oui");
		System.out.println("[2] Non");
		System.out.println("[3] Tout poser");
	}
	
	public static void accueil() {
		System.out.println("Bonjour et Bienvenue dans :");
		System.out.println("  ____  _               ____            _               \r\n" + 
				" / ___|| |_ __ _ _ __  |  _ \\ ___  __ _| |_ __ ___  ___ \r\n" + 
				" \\___ \\| __/ _` | '__| | |_) / _ \\/ _` | | '_ ` _ \\/ __|\r\n" + 
				"  ___) | || (_| | |    |  _ <  __/ (_| | | | | | | \\__ \\\r\n" + 
				" |____/ \\__\\__,_|_|    |_| \\_\\___|\\__,_|_|_| |_| |_|___/\r\n" + 
				"                                                        ");
		System.out.println("Quelle type de partie voulez vous faire ?");
		System.out.println("[1] Partie Joueur VS Joueur");
		System.out.println("[2] Partie Joueur VS IA");
		System.out.println("[3] Partie Joueur VS Joueur DeathMatch");

	}
	
	public static void ChoixEffet(Effects e1, Effects e2) {
		System.out.println("Quel effet voulez vous utiliser ?");
		System.out.printf("[1] %s: %d %n" ,e1.getTarget(), e1.getValue());
		if(e2.getValue() != 0) System.out.printf("[2] %s: %d %n" ,e2.getTarget(), e2.getValue());
		else System.out.println("[2] Rien du tout");
	}
	
	public static void ScrapTrade(Shop shop) {
		System.out.println("Quelle carte voulez-vous scrap ?");
		shop.printShop();
	}
	
	public static void ScrapDeck(Player p) {
		System.out.println("Quelle carte voulez-vous scrap ?");
		p.getDeck().printDeck();
	}
	
	public static void ScrapHand(Player p) {
		System.out.println("Quelle carte voulez-vous scrap ?");
		p.getHand().printHand();
	}
	
	public static void ScrapGrave(Player p) {
		System.out.println("Quelle carte voulez-vous scrap ?");
		p.getGrave().printGrave();
	}
	
	public static void Explorer() {
		System.out.print(", [Ships \ncost=2, \nname=Explorer, \nfaction=Unaligned] \n-----------------------\n");
	}
	
	public static void extension() {
		System.out.println("Choissisez l'extension de cartes");
		System.out.println("[1] Extension de base");
		System.out.println("[2] Extension United");
		System.out.println("[3] Extension Colony Wars");
	}
}
