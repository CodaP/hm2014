package edu.jainwickhamphillips;

import java.util.HashMap;
import java.util.Map;



public class dieGroup {
	private Map<Integer,Integer> dice = new HashMap<Integer, Integer>();
	static final int D4=4;
	static final int D6=6;
	static final int D8=8;
	static final int D10=10;
	static final int D12=12;
	private int damageConstant;
	
	public dieGroup(){
		dice.put(D4,0);
		dice.put(D6,0);
		dice.put(D8,0);
		dice.put(D10,0);
		dice.put(D12,0);
		damageConstant=0;
	}
	public dieGroup(int d4,int d6, int d8, int d10, int d12, int constant){
		dice.put(D4,d4);
		dice.put(D6,d6);
		dice.put(D8,d8);
		dice.put(D10,d10);
		dice.put(D12,d12);
		damageConstant=constant;
	}

	public String toString(){
		String diceList=""+damageConstant;
		for(Map.Entry<Integer, Integer> entry:dice.entrySet()){
			if(entry.getValue()!=0)
			diceList+="+ "+entry.getValue()+ "d"+entry.getKey();
		}
		return diceList;
	}
	
}
