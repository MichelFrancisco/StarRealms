package view;


import controller.Base;
import controller.Deck;
import controller.Effects;
import controller.Player;
import controller.Ships;
import controller.Shop;

public class MainTest {
	public static void main(String[] args) {
		
		Ships s1 = new Ships(6,"Battle Blob","Blob", new Effects("combat", 8),null, new Effects("combat", 4), new Effects("draw",1));
		Ships s2 = new Ships(3,"Ram","Blob", new Effects("combat", 5),null, new Effects("trade", 3),new Effects("combat",2));
		Ships s3 = new Ships(2,"Trade Pod","Blob", new Effects("trade", 3), null,null,new Effects("combat",2));
		Base b1 = new Base(3,"Blob Wheel","Blob",5, new Effects("combat", 1), new Effects("trade", 3) ,true);
		
		Ships s4 = new Ships(2,"Corvette","Star Empire", new Effects("combat", 1), null,new Effects("draw", 1),new Effects("combat",2));
		Ships s5 = new Ships(7,"Dreadnaught","Star Empire", new Effects("combat", 7), new Effects("draw", 1), new Effects("combat", 5));
		Base b2 = new Base(4,"Space Station","Star Empire",4, new Effects("combat", 2),null, new Effects("trade", 4),new Effects("combat",2) ,true);
		Base b3 = new Base(5,"War World","Star Empire",4,new Effects("combat",3), null, null, new Effects("combat",4),true);
		
		Ships s9 = new Ships(6,"Flagship","Trade Federation",new Effects("combat",5),new Effects("draw",1),null, new Effects("authority",5));
		Ships s8 = new Ships(1,"Federation Shuttle","Trade Federation",new Effects("trade",2),null,null,new Effects("authority",4));
		Ships s7 = new Ships(3,"Embassy Yacht","Trade Federation",new Effects("trade",2),new Effects("authority",3));
		Ships s6 = new Ships(2,"Cutter","Trade Federation",new Effects("trade",2),new Effects("authority",4),null, new Effects("combat",4));
		
		
		Ships s10 = new Ships(1,"Blob Fighter","Blob",new Effects("combat",3),null,null,new Effects("draw",1));
		Ships s11 = new Ships(7,"Mothership","Blob",new Effects("combat",6),new Effects("draw",1),null,new Effects("draw",1));
		
		Ships s12 = new Ships(7,"ZEUBI","Blob",new Effects("scrapDeck",1),null,null,null);
		Ships s13 = new Ships(2,"Test","testo",new Effects("or", new Effects("scrapGrave",1), new Effects("draw",0)));
		
		Deck deckShop = new Deck();
		Deck deckExplo = new Deck();
		Deck missionDeck = new Deck();
		missionDeck.addMission(missionDeck);
		
		deckExplo.fillExplo();
		Shop shop = new Shop();
		Player p1 = new Player();
		Player p2 = new Player();

		p1.drawMission(missionDeck);
		p1.drawMission(missionDeck);
		p1.drawMission(missionDeck);
		
		System.out.println(p1.getHand());
	
	}
}