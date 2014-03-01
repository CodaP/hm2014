package edu.jainwickhamphillips;

public class MonsterParticipant extends FightParticipant {

	private MonsterGroup monsters;
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return monsters.getMonsterType().toString();
	}
	@Override
	public void rollInitiative() {
		int roll=(int) (Math.random()*21) + monsters.getMonsterType().getInitiative();
		setInitiative(roll);
	}
	
	

}
