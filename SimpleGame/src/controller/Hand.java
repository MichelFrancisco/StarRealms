package controller;

import java.util.ArrayList;

public class Hand {
	private ArrayList<Cards> hand = new ArrayList<Cards>();
	
	public Hand() {
		hand = new ArrayList<>();
	}
	
	//Ajoute une carte à la main
	public void addCard(Cards card) {
		hand.add(card);
	}
	
	//Retire une carte de la main
	public Cards remove(int x) {
		return hand.remove(x);
	}
	
	//Jète toutes les cartes de la main dans le cimetière
	public void clear(Graveyard grave) {
		for (int i = hand.size(); i != 0; i--) {
			grave.throwCard(hand.get(i-1));
			hand.remove(i-1);
		}
	}
	
	public Cards get(int i) {
		return hand.get(i);
	}
	
	public void printHand() {
		int compte = 1;
		for (Cards cards : hand) {
			System.out.println(compte);
			System.out.println(cards);
			compte += 1;
		}
	}

	@Override
	public String toString() {
		return hand.toString();
	}

	public int size() {
		// TODO Auto-generated method stub
		return hand.size();
	}
	
	
	
}
