package edu.jainwickhamphillips;

import java.util.ArrayList;
import java.util.List;

public class Fight {

	private List<FightParticipant> fighters;
	private String fightName;
	
	public Fight(String name){
		fighters=new ArrayList<FightParticipant>();
		setFightName(name);
	}

	public void addFighter(FightParticipant fighter){
		fighters.add(fighter); 
		//TODO: MAKE SURE NEWFIGHTERS IS OKAY TO ADD TO GROUP.
	}
	public void removeFighter(FightParticipant fighter){
		if(fighters.contains(fighter))
			fighters.remove(fighter);
	}
	public String getFightName() {
		return fightName;
	}

	public void setFightName(String fightName) {
		this.fightName = fightName;
	}
}
