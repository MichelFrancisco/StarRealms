package controller.united;

import controller.Cards;
import controller.Effects;

public class Heroes extends Cards{

	public Heroes(int cost, String name, String faction, Effects effect,Effects effect2, Effects scrapEffect) {
		super(cost, name, faction, effect, effect2, scrapEffect);
	}
	
	@Override
	public String toString() {
		return "[Heroes" + " "+ super.toString();
	}
}
