package controller;

import java.util.ArrayList;

public class Player {
	private int authority;
	private int combat;
	private int trade;
	private Board board;
	private Hand hand;
	private Deck deck;
	private Graveyard grave;

	public Player() {
		authority = 50;
		combat = 0;
		trade = 0;
		board = new Board();
		hand = new Hand();
		deck =  new Deck();
		grave = new Graveyard();
	}

	//Vérifie si le joueur est en vie 
	public boolean isAlive() {
		return authority > 0;
	}

	//Initialise le deck avec les cartes de bases (8 Scouts et 2 Viper)
	public void initDeck() {

		for (int i = 0; i < 8; i++) {
			deck.addCard(new Ships(0,"Scout","Unaligned", new Effects("trade", 1),null, null));
		}

		for (int i = 0; i < 2; i++) {
			deck.addCard(new Ships(0,"Viper","Unaligned", new Effects("combat", 1),null));
		}
		deck.shufDeck();
	}
	
	//Getters
	public int getTrade() {
		return trade;
	}

	public int getCombat() {
		return combat;
	}

	public int getAuthority() {
		return authority;
	}

	public Board getBoard() {
		return board;
	}

	public Hand getHand() {
		return hand;
	}

	public Deck getDeck() {
		return deck;
	}

	public Graveyard getGrave() {
		return grave;
	}

	@Override
	public String toString() {
		return "Player [authority=" + authority + ", combat=" + combat + ", trade=" + trade + "]";
	}
	
	//Permet de gagner des points de combat/commerce/vie
	public void addCombat(int x) {
		combat += x;
	}

	public void addTrade(int x) {
		trade += x;
	}

	public void addAuthority(int x) {
		authority += x;
	}

	// Permet de réinitialiser le joueur à chaque tours
	public void resetPlayer() {
		combat = 0;
		trade = 0;
		board.clear(grave);
		hand.clear(grave);
	}

	// Permet de placer le cimetiere a la place du deck lorsque celui-ci est vide
	public void switchDeck() {
		for (int i = 0; i < grave.size(); i++) {
			deck.addCard(grave.get(i));
		}
		deck.shufDeck();
		grave = new Graveyard();
	}

	//Permet au joueur de placer une carte sur le terrain
	public void playCard(int x) {
		if (hand.size() != 0) {
			Cards card = hand.remove(x-1);
			board.addCard(card);
		}
		else System.out.println("Vous n'avez plus de cartes dans votre main");
	}

	//Fait Piocher une carte du deck
	public void drawCard() {
		hand.addCard(deck.remove(0));
	}

	//Permet d'acheter un exploreur de la pile exploreur
	public void takeExplo(Deck deck) {
		if (trade >= 2) {
		grave.throwCard(deck.remove(0));
		}
		else System.out.println("Vous n'avez pas assez de points de commerce");
		return;
	}

	//Permet d'attaquer une base
	public void atckBase(Base base, Player badGuy) {
		if (combat >= base.getDef()) {
			combat -= base.getDef();
			badGuy.getBoard().remove(base);
			System.out.println("Attaque reussie !");
			System.out.println("Points de combat restants : " + combat);
		}
		else {
			System.out.println("Vous n'avez pas assez de points de combat");
		}
	}
	
	// Getter pour avant-poste
	public ArrayList<Base> getOutpost() {
		ArrayList<Base> outposts = new ArrayList<Base>();
		for (Base base : board.getBases()) {
			if (base.isOutpost()) {
				outposts.add(base);
			}
		}
		return outposts;
	}

}
