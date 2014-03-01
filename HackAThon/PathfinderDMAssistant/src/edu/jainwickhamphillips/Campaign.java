package edu.jainwickhamphillips;

import java.util.ArrayList;
import java.util.List;
	
public class Campaign {
	private List<PlayerCharacter> characters ;
	private String campaignName;
	
	public Campaign(String name){
		characters=new ArrayList<PlayerCharacter>();
		this.campaignName=name;
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
