package controller;

import java.util.ArrayList;

public class Shop {
	private ArrayList<Cards> shop = new ArrayList<Cards>();
	
	public Shop() {
		shop = new ArrayList<>();
	}
	
	//Permet d'ajout� une carte au shop
	public void addCard(Cards card) {
		shop.add(card);
	}
	
	//Permet d'acheter une carte du shop et la place dans le cimetiere
	public void buyCard(int x,Player p) {
		x--;
		if(p.getTrade() < shop.get(x).getCost()) {
			System.out.println("Pas assez de points de commerce !");
			return;
		}
		p.getGrave().throwCard(shop.get(x));
		p.addTrade(shop.get(x).getCost()*-1);
		shop.remove(shop.get(x));
	}
	
	//rempli le shop lorsqu'une carte est achet�
	public void fillShop(Deck deck) {
		while(shop.size()<5) {
			Cards card = deck.remove(0);
			shop.add(card);
		}
	}
	
	public int size() {
		return shop.size();
	}
	
	public Cards get(int i) {
		return shop.get(i);
	}

	@Override
	public String toString() {
		return shop.toString();
	}
	
	
}
