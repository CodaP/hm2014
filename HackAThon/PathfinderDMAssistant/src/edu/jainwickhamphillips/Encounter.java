package edu.jainwickhamphillips;

import java.util.ArrayList;
import java.util.List;

public class Encounter {
	
	private List<MonsterGroup> groups;
	private String encounterName;
	public Encounter(String encounterName){
		groups=new ArrayList<MonsterGroup>();
		setEncounterName(encounterName);
	}
	public void addMonsterGroup(MonsterGroup newGroup){
		String groupName = findName(newGroup.getMonsterType().toString()); //gets the name for the group to be added
		newGroup.setGroupName(groupName); //sets the name for the group to be added
		groups.add(newGroup); //no checking because you can have multiple of the same group
	}
	public void removeMonsterGroup(MonsterGroup removedGroup){
		if(groups.contains(removedGroup))
			groups.remove(removedGroup);
		//TODO: throw message if nothing is removed.
	}
	public String getEncounterName() {
		return encounterName;
	}
	public void setEncounterName(String encounterName) {
		this.encounterName = encounterName;
	}
	private String findName(String name){ 
		int iteration=2;
		for(int x=0; x<groups.size(); x++){
			if(groups.get(x).toString().equals(name)){
				name=name+""+iteration; //converts it to new name.
				iteration++;
				x=-1;
			}
			
		}
		return name;
	}
}
