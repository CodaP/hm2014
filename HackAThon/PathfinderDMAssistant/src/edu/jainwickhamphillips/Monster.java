package edu.jainwickhamphillips;

public class Monster {
	
	private int challengeRating;
	private int health;
	private int armorClass;
	private int attack;
	private dieGroup damage; //dice set? 
	private int primaryDC;
	private int secondaryDC;
	private int goodSave;
	private int poorSave;
	private double variance; //values from 0-1
	private int initiative;
	
	public Monster(){
		
	}
	public Monster(int cr, int hp, int ac, int attack, dieGroup damage, int pDC, int sDC, int gs, int ps, int var, int ini){
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

}