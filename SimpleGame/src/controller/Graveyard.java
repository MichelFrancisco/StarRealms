package controller;

import java.util.ArrayList;

public class Graveyard {
	private ArrayList<Cards> grave = new ArrayList<Cards>();
	
	public Graveyard() {
		grave = new ArrayList<>();
	}
	
	//Ajoute une carte au cimetière
	public void throwCard(Cards card) {
		grave.add(card);
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
