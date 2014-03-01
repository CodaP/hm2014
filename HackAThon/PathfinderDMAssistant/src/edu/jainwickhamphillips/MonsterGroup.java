package edu.jainwickhamphillips;

public class MonsterGroup {

	private int numMonsters;
	private Monster monsterType;
	private String groupName;
	public MonsterGroup(Monster monsterType, int numMonsters, String groupName){
		this.setNumMonsters(numMonsters);
		this.setMonsterType(monsterType);
		this.setGroupName(groupName);
	}
	public int getNumMonsters() {
		return numMonsters;
	}
	public void setNumMonsters(int numMonsters) {
		//TODO check that numMonsters is a number and not bad value.
		this.numMonsters = numMonsters;
	}
	public Monster getMonsterType() {
		return monsterType;
	}
	public void setMonsterType(Monster monsterType) {
		this.monsterType = monsterType;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
}
