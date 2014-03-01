package edu.jainwickhamphillips;

public class PlayerCharacter {
	private String name;
	public PlayerCharacter(String name){
		this.name=name;
	}
	public String toString(){
		return name;
	}
	public void setName(String newName){
		this.name=newName;
	}
	
}
