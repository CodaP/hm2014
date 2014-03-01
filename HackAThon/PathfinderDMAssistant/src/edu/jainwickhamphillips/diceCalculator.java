package edu.jainwickhamphillips;

import java.util.ArrayList;
import java.util.List;

public  class diceCalculator {
	private static double totalDamage=0;
	private static int diceType;
	private static int d12,d10,d8,d6,d4;
	
	public static dieGroup calculateDice(int damage, double variance){
		d12=d10=d8=d6=d4=0;
		totalDamage=0;
		int diceDamage;
		int constantDamage;
		variance/=100;
		diceDamage=(int)(variance*damage +.5);
		
		if(damage<3 || diceDamage<3){ //if damage/diceDamage is less than 3, no dice can add to equal it.
			constantDamage=damage;
			return(new dieGroup(constantDamage,d12,d10,d8,d6,d4));
		}	

		int primaryDieNum=getDieNum(diceDamage, variance); //holds number of the primary die type
		double temp=variance;
		while(primaryDieNum==0){
			temp+=.1;
			if(temp>=1)
				temp=1;
			primaryDieNum+=getDieNum(diceDamage, temp); //ensures primaryDieNum has a value != 0
			
		}
		int primaryDieType=diceType;
		totalDamage+=(primaryDieNum*(1+diceType)/2.0);
		
		
		int secondaryDieNum=getDieNum((int)(diceDamage-totalDamage),variance+.2); //+.2
		int secondaryDieType=diceType;
		totalDamage+=(secondaryDieNum*(1+diceType)/2.0); //secondary
		temp=.4;
		if(secondaryDieNum==0){ //bounds check assign vars
			secondaryDieNum=getDieNum((int)(diceDamage-totalDamage),variance+temp);
		}
		temp=.6; //bounds check assign vars
		if(secondaryDieNum==0){
			secondaryDieNum=getDieNum((int)(diceDamage-totalDamage),variance+temp);
		}
		
		
	
		assignValue(primaryDieType, primaryDieNum);
		assignValue(secondaryDieType, secondaryDieNum);
		constantDamage=damage-(int)totalDamage;
		


		return new dieGroup(constantDamage,d12,d10,d8,d6,d4);
		
	}
	private static int getDieNum(int damage, double variance){
		int[] numberOfDice = new int[5];
		numberOfDice[0]=(int)(damage/((1+dieGroup.D12)/2.0)); 	//d12
		numberOfDice[1]=(int)(damage/((1+dieGroup.D10)/2.0)); 	//d10
		numberOfDice[2]=(int)(damage/((1+dieGroup.D8)/2.0));  	//d8
		numberOfDice[3]=(int)(damage/((1+dieGroup.D6)/2.0));		//d6
		numberOfDice[4]=(int)(damage/((1+dieGroup.D4)/2.0));		//d4
		int index=(int)(variance*4.999) ; //gives me best fit. 
		
		if(index==0)
			diceType=12;
		else if(index==1)
			diceType=10;
		else if(index==2)
			diceType=8;
		else if(index==3)
			diceType=6;
		else if(index==4)
			diceType=4;
		
		return numberOfDice[index];
		
	}
	private static void assignValue(int diceType, int numDice){
		if(diceType==12)
			d12+=numDice;
		if(diceType==10)
			d10+=numDice;
		if(diceType==8)
			d8+=numDice;
		if(diceType==6)
			d6+=numDice;
		if(diceType==4)
			d4+=numDice;
	}
	
}
