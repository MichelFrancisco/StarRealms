package controller;

public class Base extends Cards {
	private final int defense;
	private final boolean outpost;
	
	public Base(int cost, String name, String faction, int defense, Effects effect, Effects effect2, Effects scrapEffect, Effects allyEffect, boolean outpost) {
		super(cost, name, faction, effect, effect2, scrapEffect, allyEffect);
		this.defense = defense;
		this.outpost = outpost;
	}
	
	public Base(int cost, String name, String faction, int defense, Effects effect, Effects effect2, Effects scrapEffect, boolean outpost) {
		super(cost, name, faction, effect, effect2, scrapEffect);
		this.defense = defense;
		this.outpost = outpost;
	}
	
	public Base(int cost, String name, String faction, int defense, Effects effect, Effects scrapEffect, boolean outpost) {
		super(cost, name, faction, effect, scrapEffect);
		this.defense = defense;
		this.outpost = outpost;
	}
	
	public Base(int cost, String name, String faction, int defense, Effects effect, boolean outpost) {
		super(cost, name, faction, effect);
		this.defense = defense;
		this.outpost = outpost;
	}
	
	// Permet de savoir si il s'agit d'un avant-poste
	public boolean isOutpost() {
		return outpost;
	}
	
	//Permet de connaitre le nombre de points de defense de la base
	public int getDef() {
		return defense;
	}
	
	// Permet de connaitre le nom de la base
	@Override
	public String getName() {
		return super.getName();
	}
	
	@Override
	public String toString() {
		return "[Base defense=" + defense + ", outpost=" + outpost + ", "+ super.toString();
	}
	
	
	
	
}
