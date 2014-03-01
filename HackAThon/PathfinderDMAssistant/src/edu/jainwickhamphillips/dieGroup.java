package edu.jainwickhamphillips;

import android.annotation.SuppressLint;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName="die_group")
public class dieGroup implements Serializable{

	private static final long serialVersionUID = 1L;
	static final int D4=4;
	static final int D6=6;
	static final int D8=8;
	static final int D10=10;
	static final int D12=12;

	@DatabaseField(generatedId = true)
	int id;
	
	@SuppressLint("UseSparseArrays")
	@DatabaseField(dataType = DataType.SERIALIZABLE)
	private Map<Integer,Integer> dice = new HashMap<Integer, Integer>();
	
	@DatabaseField
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
