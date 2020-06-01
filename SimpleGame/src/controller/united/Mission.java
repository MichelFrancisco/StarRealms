package controller.united;

import java.util.Objects;

import controller.Cards;

public class Mission extends Cards{
	private final String objective;
	private final String reward;
	private final boolean done;
	
	public Mission(String name, String objective, String reward) {
		super(0,name,"Unaligned",null);
		this.objective = Objects.requireNonNull(objective);
		this.reward = Objects.requireNonNull(reward);
		this.done = false;
	}
	
	// Faire un joueur compteur qui permet de savoir ce qu'il se passe à chaque tour 
	
	public void validateMission() {
		switch(super.getName()) {
		case "Ally": ally();
			break;
		case "Armada":
			break;
		case "Colonize":
			break;
		case "Convert":
			break;
		case "Defend":
			break;
		case "Diversify":
			break;
		case "Dominate":
			break;
		case "Exterminate":
			break;
		case "Influence":
			break;
		case "Monopolize":
			break;
		case "Rule":
			break;
		case "Unite":
			break;
		}
	}
	
	public void ally() {
	
	}
	
	public void armada() {
		
	}
	
	public void colonize() {
		
	}
	
	public void convert() {
		
	}
	
	public void defend() {
		
	}
	
	public void diversify() {
		
	}
	
	public void dominate() {
		
	}
	
	public void exterminate() {
		
	}
	
	public void influence() {
		
	}
	
	public void monopolize() {
		
	}
	
	public void rule() {
		
	}
	
	public void unite() {
		
	}
	
	@Override
	public String toString() {
		return "\nMission : " + super.getName() + "\nObjective : " + objective + "\nReward : " + reward + "\n---------------------";
	}
	
	
}
