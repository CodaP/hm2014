package edu.jainwickhamphillips;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

public class MonsterBuilderOne extends Activity {
	//http://paizo.com/PRD/monsters/monsterCreation.html
	//STATS AS SORTED BY CR VALUE, CR 1 IS POSITION 0, CR 20 IS POSITION 19.
	private final int[] HITPOINTS = new int[]{15,20,30,40,55,70,85,100,115,130,145,160,180,200,220,240,270,300,330,370};
	private final int[] ARMORCLASS = new int[]{12,14,15,17,18,19,20,21,23,24,25,27,28,29,30,31,32,33,34,36};
	private final int[] HIGHATTACK = new int[]{2,4,6,8,10,12,13,15,17,18,19,21,22,23,24,26,27,28,29,30};
	private final int[] LOWATTACK = new int[]{1,3,4,6,7,8,10,11,12,13,14,15,16,17,18,19,20,21,22,23};
	
	private final int[] PRIMARYDC = new int[]{11,12,13,14,15,15,16,17,18,18,19,20,21,21,22,23,24,24,25,26,27};
	private final int[] SECONDARYDC = new int[]{8,9,9,10,10,11,11,12,12,13,13,14,15,15,16,16,17,18,18,19,20};
	private final int[] GOODSAVE = new int[]{3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,20,21,22};
	private final int[] POORSAVE = new int[]{0,1,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,16,17};
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster_builder_one);
    }
	public void advancePage(View view){
		Log.d("Test","Start Advance Page");
		Intent intent = new Intent(this, MonsterBuilderTwo.class);
		Log.d("Test","middle Advance Page");
		Monster toSend=getMonsterData();
		if(toSend==null){
			return;
		}
		Log.d("Test","other middle Advance Page");
		intent.putExtra("MB-Info-Part-One", toSend);
		Log.d("Test","end Advance Page");
		startActivity(intent);
	}
	private Monster getMonsterData(){
		EditText crValue=(EditText)findViewById(R.id.EditView_CRnumber);
		int challengeRating=Integer.parseInt(crValue.getText().toString());
		if(challengeRating<1 || challengeRating>20){
			Toast toast = Toast.makeText(getApplicationContext(), "CR must be between 1 and 20", Toast.LENGTH_SHORT);
			toast.show();
			return null;
		}
		Log.d("Test","Start monster");
		Monster toPass=new Monster();
		Log.d("Test","end monster Page");
		
		
		SeekBar hpBar=(SeekBar)findViewById(R.id.seekBar_HPslider);
		SeekBar ac=(SeekBar)findViewById(R.id.seekBar_ACslider);
		SeekBar attack=(SeekBar)findViewById(R.id.seekBar_Attackslider);
		
		SeekBar primaryDC=(SeekBar)findViewById(R.id.seekBar_PrimaryDCslider);
		SeekBar secondaryDC=(SeekBar)findViewById(R.id.seekBar_SecondaryDCslider);
		SeekBar goodSave=(SeekBar)findViewById(R.id.seekBar_GoodSaveslider);
		SeekBar poorSave=(SeekBar)findViewById(R.id.seekBar_PoorSaveslider);
		Log.d("Test","got Sieks");
		
		


			
		Log.d("Test","got int");
		toPass.setCR(challengeRating);
		toPass.setHealth(getModifier(HITPOINTS[challengeRating-1]*.7,HITPOINTS[challengeRating-1]*1.3,hpBar.getProgress()));
		//hp ranges from 70 to 130%
		toPass.setAC(getModifier(ARMORCLASS[challengeRating-1]*.8,ARMORCLASS[challengeRating-1]*1.2,ac.getProgress()));
		//AC ranges from 80 to 120%
		toPass.setAttack(getModifier(LOWATTACK[challengeRating-1],HIGHATTACK[challengeRating-1],attack.getProgress()));
		//attack ranges from pre defined values
		
		toPass.setPrimaryDC(getModifier(PRIMARYDC[challengeRating-1]*.8,PRIMARYDC[challengeRating-1]*1.2,primaryDC.getProgress()));
		//primaryDC ranges from 80 to 120%
		toPass.setSecondaryDC(getModifier(SECONDARYDC[challengeRating-1]*.8,SECONDARYDC[challengeRating-1]*1.2,secondaryDC.getProgress()));
		//secondaryDC ranges from 80 to 120%
		toPass.setGoodSave(getModifier(GOODSAVE[challengeRating-1]*.9,GOODSAVE[challengeRating-1]*1.1,goodSave.getProgress()));
		//goodSave ranges from 90 to 110%
		toPass.setPoorSave(getModifier(POORSAVE[challengeRating-1]*.9,POORSAVE[challengeRating-1]*1.1,poorSave.getProgress()));
		//poorSave ranges from 90 to 110%
		Log.d("Test","Set values");
		return toPass;
	}
	private int getModifier(double low, double hi, double percentage){
		percentage/=100;
		return(int)(hi*percentage + low*(1-percentage)+.5);
		
	}
	
}
