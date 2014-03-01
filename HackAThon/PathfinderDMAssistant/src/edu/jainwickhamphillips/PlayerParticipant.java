package edu.jainwickhamphillips;

public class PlayerParticipant extends FightParticipant {
	
	private PlayerCharacter character;
	
	public PlayerParticipant(PlayerCharacter character){
		this.character=character;
	}
	@Override
	public String getName() {
		return character.toString();
	}
	@Override
	public void rollInitiative() {
		setInitiative(0);
		//has to be filled in by the DM, let the players roll themselves.
	}

}
