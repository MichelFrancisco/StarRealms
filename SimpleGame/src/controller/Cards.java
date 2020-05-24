package controller;


public class Cards {
	
	private final int cost;
	private final String name;
	private final String faction;
	private final Effects effect;
	private Effects effect2;
	private Effects scrapEffect;
	private Effects allyEffect;

	public Cards(int cost, String name, String faction, Effects effect) {
		this.cost = cost;
		this.name = name;
		this.faction = faction;
		this.effect = effect;
		this.effect2 = null;
		this.scrapEffect = null;
		this.allyEffect = null;
	}
	
	public Cards(int cost, String name, String faction, Effects effect, Effects effect2) {
		this(cost,name,faction,effect);
		this.effect2 = effect2;
		
	}
	
	public Cards(int cost, String name, String faction, Effects effect, Effects effect2, Effects scrapEffect) {
		this(cost,name,faction,effect,effect2);
		this.scrapEffect = scrapEffect;
	}
	
	public Cards(int cost, String name, String faction, Effects effect, Effects effect2, Effects scrapEffect, Effects allyEffect) {
		this(cost,name,faction,effect,effect2,scrapEffect);
		this.allyEffect = allyEffect;
	}
	
	
	
	// Getters des cartes
	public Effects getEffect() {
		return effect;
	}
	
	public Effects getEffect2() {
		return effect2;
	}
	
	public int getCost() {
		return cost;
	}
	
	public Effects getScrapEffect() {
		return scrapEffect;
	}
	
	public String getFaction() {
		return faction;
	}
	
	public Effects getAllyEffect() {
		return allyEffect;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		String effet = "";
		String effet2 = "";
		String effetAlly = "";
		String effetScrap = "";
		
		if (getEffect() != null) {
			effet = "\neffet : " + getEffect().getTarget() +"("+ getEffect().getValue() + ")";
		}
		if (getEffect2() != null) {
			effet2 =  "\neffet 2 : " + getEffect2().getTarget() + "(" + getEffect2().getValue() + ")";
		}
		if (getAllyEffect() != null) {
			effetAlly = "\neffet allié : " + getAllyEffect().getTarget() + "(" + getAllyEffect().getValue() + ")";
		}
		if (getScrapEffect() != null) {
			effetScrap = "\neffet scrap : " + getScrapEffect().getTarget() + "(" + getScrapEffect().getValue() + ")";		
		}
					
		return "\n" + name +"\nfaction: " + faction+  "\ncoût: " + cost + effet + effet2 + effetAlly + effetScrap + "]\n-----------------------\n";
	}
	
	
}
