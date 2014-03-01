package edu.jainwickhamphillips;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "encounter")
public class Encounter {
	
	@DatabaseField(generatedId = true)
	private int id;
	
	private List<MonsterGroup> groups = null;
	@ForeignCollectionField(eager=true, orderColumnName="ordinal", orderAscending=true)
	private ForeignCollection<MonsterGroup> groupsFC;
	
	@DatabaseField
	private String encounterName;
	
	/** DO NOT USE - For ORM */
	Encounter() {}
	
	public Encounter(String encounterName){
		groups=new ArrayList<MonsterGroup>();
		setEncounterName(encounterName);
	}
	
	public void setupDisplay() {
		if (groups != null)
			return;
		groups = new ArrayList<MonsterGroup>();
		CloseableIterator<MonsterGroup> mgs = groupsFC.closeableIterator();
		while(mgs.hasNext()) {
			groups.add(mgs.next());
		}
		try {mgs.close();} catch (SQLException e) {}
	}
	
	public void addMonsterGroup(Monster m){
		String groupName = findName(m.toString()); //gets the name for the group to be added
		MonsterGroup newGroup = new MonsterGroup(this, m, 1, groupName, groups.size());
		groups.add(newGroup); //no checking because you can have multiple of the same group
		//TODO:ORM - Save new MG
	}
	public void removeMonsterGroup(MonsterGroup removedGroup){
		if(groups.contains(removedGroup))
			groups.remove(removedGroup);
		//TODO: throw message if nothing is removed.
		//TODO: decrement ordinals
		//TODO: fix broken links after delete
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
