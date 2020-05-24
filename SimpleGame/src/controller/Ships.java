package controller;

public class Ships extends Cards {
	
	public Ships(int cost, String name, String faction, Effects effect,Effects effect2, Effects scrapEffect, Effects allyEffect) {
		super(cost, name, faction, effect, effect2, scrapEffect, allyEffect);
	}
	
	public Ships(int cost, String name, String faction, Effects effect,Effects effect2, Effects scrapEffect) {
		super(cost, name, faction, effect, effect2, scrapEffect);
	}
	
	public Ships(int cost, String name, String faction, Effects effect, Effects scrapEffect) {
		super(cost, name, faction, effect, scrapEffect);
	}
	
	public Ships(int cost, String name, String faction, Effects effect) {
		super(cost, name, faction, effect);
	}

	@Override
	public String toString() {
		return "[Ships" + " "+ super.toString();
	}
	
	

	


	
	
}
