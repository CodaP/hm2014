package edu.jainwickhamphillips;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "campaign")
public class Campaign {
	
	@DatabaseField(generatedId = true)
	private int id;
	
	//TODO:ORM LIST
	private List<PlayerCharacter> characters = null;
	@ForeignCollectionField(eager=true, orderColumnName="ordinal", orderAscending=true)
	private ForeignCollection<PlayerCharacter> charactersFC;
	
	@DatabaseField
	private String campaignName;
	public Campaign(){
		//left null for martins reasons
	}
	
	public Campaign(String name){
		characters=new ArrayList<PlayerCharacter>();
		this.campaignName=name;
	}
	
	public void setupDisplay() {
		if (characters != null)
			return;
		characters = new ArrayList<PlayerCharacter>();
		CloseableIterator<PlayerCharacter> pcs = charactersFC.closeableIterator();
		while(pcs.hasNext()) {
			characters.add(pcs.next());
		}
		try {pcs.close();} catch (SQLException e) {}
	}
	
	public void setName(String newName){
		campaignName=newName;
	}
	public String toString(){
		return campaignName;
	}
	public void addPlayerToCampaign(PlayerCharacter pc){
		if(!characters.contains(pc))
			characters.add(pc);
		//TODO: say PC is already in the campaign.
	}
	public void removePlayerFromCampaign(PlayerCharacter pc){
		if(characters.contains(pc))
			characters.remove(pc);
		//TODO: tell player the char is not in the list
	}
	public List<PlayerCharacter> getCampaignList(){
		return characters;
	}
}
