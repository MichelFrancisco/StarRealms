package controller;

import java.util.ArrayList;

public class Board {
	private ArrayList<Cards> board = new ArrayList<Cards>();
	
	public Board() {
		board = new ArrayList<>();
	}
	
	// Ajoute une carte sur le terrain
	public void addCard(Cards card) {
		board.add(card);
	}
	
	// Applique les effets des cartes sur le terrain
	public void allEffects(Player p, Player badGuy) {
		for (Cards cards : board) {
			cards.getEffect().applyEffect(p,badGuy);
			if (cards.getEffect2() != null) {
				cards.getEffect2().applyEffect(p,badGuy);
			}
		}
	}
	
	// Permet de retirer une base du terrain
	public void remove(Base base) {
		board.remove(base);
	}
	
	//Permet d'appliquer les effets scrap
	public void scrap(int x,Player p,Player badGuy) {
		if (board.get(x-1).getScrapEffect() != null) {
			board.get(x-1).getScrapEffect().applyEffect(p,badGuy);
		}
		board.remove(board.get(x-1));
	}
	
	// Cherche si il y a une base du meme nom que a carte rechercher sur le terrain
	public Base findCard(String name) {
		for (Cards cards : board) {
			if (cards.getName().compareTo(name) == 0 && cards instanceof Base) {
				return (Base) cards;
			}
		}
		return new Base(0, "Bouclier anti erreur", "ça marche !", 0, null, false);
	}
	
	// Cherche sur le terrain si il y a une carte de la meme faction que la carte posée
	public boolean searchAlly(Cards c) {
		ArrayList<Cards> testBoard = new ArrayList<Cards>();
		for (Cards card : board) {
			testBoard.add(card);
		}
		testBoard.remove(c);
		for (Cards cards : testBoard) {
			if(c.getFaction().compareTo(cards.getFaction()) == 0) return true;
		}
		return false;
	}
	
	// Applique l'effet allié de la carte
	public void allyEffect(Player p,Player badGuy) {
		for (Cards cards : board) {
			if (cards.getAllyEffect() != null && searchAlly(cards) == true) {
				cards.getAllyEffect().applyEffect(p,badGuy);
			}
		}
	}
	
	// Permet de vider le terrain et d'envoyer les cartes dans le cimetière
	public void clear(Graveyard grave) {
		for (int i = board.size(); i != 0; i--) {
			if(board.get(i-1) instanceof Ships) {
				grave.throwCard(board.get(i-1));
				board.remove(i-1);
			}
		}
	}
	
	public int getLength() {
		return board.size();
	}
	
	// Cherche si il y a une base sur le terrain
	public ArrayList<Base> getBases() {
		ArrayList<Base> bases = new ArrayList<Base>();
		for (int i = board.size(); i != 0; i--) {
			if(board.get(i-1) instanceof Base) {
				Base b = (Base) board.get(i-1);
				bases.add(b);
			}
		}
		return bases;
	}
	
	@Override
	public String toString() {
		return board.toString();
	}
	
	public Base get(int i) {
        return (Base) board.get(i);
    }

}
