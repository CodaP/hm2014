package edu.jainwickhamphillips;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "player_character")
public class PlayerCharacter {
	
	@DatabaseField(generatedId = true)
	private int id;
	@DatabaseField(canBeNull = false)
	private String name;
	@DatabaseField(columnName="ordinal")
	private int ordinal;
	@DatabaseField(foreign=true)
	private Campaign owner;
	
	/** DO NOT USE - For ORM */
	PlayerCharacter() {}
	
	public PlayerCharacter(Campaign owner, String name){
		this.setName(name);
		this.setOwner(owner);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String toString(){
		return name;
	}
	public void setName(String newName){
		this.name=newName;
	}

	public int getOrdinal() {
		return ordinal;
	}

	public void setOrdinal(int ordinal) {
		this.ordinal = ordinal;
	}

	public Campaign getOwner() {
		return owner;
	}

	public void setOwner(Campaign owner) {
		this.owner = owner;
	}
	
}
