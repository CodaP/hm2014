package edu.jainwickhamphillips;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="monster_group")
public class MonsterGroup {

	@DatabaseField(generatedId = true)
	private int id;
	@DatabaseField
	private int numMonsters;
	@DatabaseField(foreign = true)
	private Monster monsterType;
	@DatabaseField
	private String groupName;
	@DatabaseField(columnName="ordinal")
	private int ordinal;
	
	/** DO NOT USE - For ORM */
	MonsterGroup() {}
	
	public MonsterGroup(Monster monsterType, int numMonsters, String groupName, int ordinal){
		this.setNumMonsters(numMonsters);
		this.setMonsterType(monsterType);
		this.setGroupName(groupName);
		this.setOrdinal(ordinal);
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
	public int getOrdinal() {
		return ordinal;
	}
	public void setOrdinal(int ordinal) {
		this.ordinal = ordinal;
	}
}
