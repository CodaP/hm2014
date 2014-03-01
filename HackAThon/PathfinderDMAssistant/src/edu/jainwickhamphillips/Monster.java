package edu.jainwickhamphillips;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;

public class Monster implements Serializable {
	
	private static final long serialVersionUID = 6510943296975272639L;

	@DatabaseField(generatedId = true)
	private int id;
	@DatabaseField
	private int challengeRating;
	@DatabaseField
	private int health;
	@DatabaseField
	private int armorClass;
	@DatabaseField
	private int attack;
	@DatabaseField(foreign = true)
	private dieGroup damage; //dice set? 
	@DatabaseField
	private int primaryDC;
	@DatabaseField
	private int secondaryDC;
	@DatabaseField
	private int goodSave;
	@DatabaseField
	private int poorSave;
	@DatabaseField
	private double variance; //values from 0-1
	@DatabaseField
	private int initiative;
	@DatabaseField
	private String name;
	@DatabaseField(dataType = DataType.SERIALIZABLE)
	private ArrayList<String> skills = new ArrayList<String>();
	@DatabaseField(dataType = DataType.SERIALIZABLE)
	private ArrayList<String> spells = new ArrayList<String>();
	
	/** DO NOT USE - For ORM */
	Monster() {}
	
	public Monster(String name,int cr, int hp, int ac, int attack, dieGroup damage, int pDC, int sDC, int gs, int ps, int var, int ini){
		challengeRating=cr;
		health=hp;
		armorClass=ac;
		this.attack=attack;
		this.damage=damage;
		primaryDC=pDC;
		secondaryDC=sDC;
		goodSave=gs;
		poorSave=ps;
		variance=var;
		initiative=ini;
		this.setName(name);
	}
	public void addSkill(String s){
		if(!skills.contains(s))
			skills.add(s);
	}
	public void removeSkill(String s){
		if(skills.contains(s))
			skills.remove(s);
	}
	public List<String> getSkills(){
		return skills;
	}
	public void addSpell(String s){
		if(!spells.contains(s))
			spells.add(s);
	}
	public void removeSpell(String s){
		if(spells.contains(s))
			spells.remove(s);
	}
	public List<String> getSpells(){
		return spells;
	}
	
	public void setCR(int cr){
		challengeRating=cr;
	}
	public int getCR(){
		return challengeRating;
	}
	public void setHealth(int health){
		this.health=health;
	}
	public int getHealth(){
		return health;
	}
	public void setAC(int ac){
		armorClass=ac;
	}
	public int getAC(){
		return armorClass;
	}
	public void setAttack(int attack){
		this.attack=attack;
	}
	public int getAttack(){
		return attack;
	}
	public void setDamage(int dam){
		this.damage=diceCalculator.calculateDice(dam,variance);
	}
	public dieGroup getDamage(){
		return damage;
	}
	public void setPrimaryDC(int primaryDC){
		this.primaryDC=primaryDC;
	}
	public int getPrimaryDC(){
		return primaryDC;
	}
	public void setSecondaryDC(int secondaryDC){
		this.secondaryDC=secondaryDC;
	}
	public int getSecondaryDC(){
		return secondaryDC;
	}
	public void setGoodSave(int goodSave){
		this.goodSave=goodSave;
	}
	public int getGoodSave(){
		return goodSave;
	}
	public void setPoorSave(int poorSave){
		this.poorSave=poorSave;
	}
	public int getPoorSave(){
		return poorSave;
	}
	public double getVariance() {
		return variance;
	}
	public void setVariance(double variance) {
		this.variance = variance;
	}
	public int getInitiative() {
		return initiative;
	}
	public void setInitiative(int initiative) {
		this.initiative = initiative;
	}
	public String toString() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
