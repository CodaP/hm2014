package edu.jainwickhamphillips;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "player_character")
public class PlayerCharacter {
	
	@DatabaseField(id = true, generatedId = true, canBeNull = false)
	private int id;
	@DatabaseField(canBeNull = false)
	private String name;
	@DatabaseField(columnName="ordinal")
	private int ordinal;
	
	/** DO NOT USE - For ORM */
	PlayerCharacter() {}
	
	public PlayerCharacter(String name){
		this.name=name;
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
	
}
