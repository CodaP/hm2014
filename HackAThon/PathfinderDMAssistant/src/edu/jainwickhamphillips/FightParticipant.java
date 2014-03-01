package edu.jainwickhamphillips;

public abstract class FightParticipant {

	private int initiative;
	
	public abstract String getName();
	
	public int getInitiative() {
		return initiative;
	}
	public void setInitiative(int initiative) {
		this.initiative = initiative;
	}
	public abstract void rollInitiative();
}
