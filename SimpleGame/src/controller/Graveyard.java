package controller;

import java.util.ArrayList;

public class Graveyard {
	private ArrayList<Cards> grave = new ArrayList<Cards>();
	
	public Graveyard() {
		grave = new ArrayList<>();
	}
	
	//Ajoute une carte au cimeti�re
	public void throwCard(Cards card) {
		grave.add(card);
	}
	
	public void remove(int x) {
		grave.remove(x);
	}
	
	public void printGrave() {
		int compte = 1;
		for (Cards cards : grave) {
			System.out.println(cards);
			System.out.println(compte);
			compte += 1;
		}
	}
	
	@Override
	public String toString() {
		return grave.toString();
	}

	public int size() {
		// TODO Auto-generated method stub
		return grave.size();
	}

	public Cards get(int i) {
		// TODO Auto-generated method stub
		return grave.get(i);
	}
	
}
