package edu.jainwickhamphillips;

import java.sql.SQLException;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;

public class MonsterBuilderTwo extends OrmLiteBaseActivity<Database> {

	private final int[] HIDAMAGE = new int[]{4,7,10,13,16,20,25,30,35,40,45,50,55,60,65,70,80,90,100,110,120};
	private final int[] LOWDAMAGE = new int[]{3,5,7,9,12,15,18,22,26,30,33,37,40,45,48,52,60,67,75,82,90};
	private Monster curMonster;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster_builder_two);
        
    }
	protected void onStart(){
		super.onStart();
        Monster m=(Monster)getIntent().getSerializableExtra("MB-Info-Part-One");
        curMonster=m;
	}
	

	public void save(View v) {
		String name=((EditText)findViewById(R.id.editText_monsterName)).getText().toString();
		if(name==null){
			Toast toast = Toast.makeText(getApplicationContext(), "Please enter a name.", Toast.LENGTH_SHORT);
			toast.show();
			return;
		}
		name=name.trim();
		if(name.length()==0){
			Toast toast = Toast.makeText(getApplicationContext(), "Please enter a name.", Toast.LENGTH_SHORT);
			toast.show();
			return;
		}
        SeekBar damage=(SeekBar)findViewById(R.id.seekBar_Damageslider);
        SeekBar variance=(SeekBar)findViewById(R.id.seekBar_Varianceslider);
        SeekBar initiative=(SeekBar)findViewById(R.id.seekBar_Initiativeslider);
        curMonster.setVariance(variance.getProgress());
        curMonster.setInitiative(getModifier(0,10,initiative.getProgress())); //in the future get a function to determine min an max initiative values
        curMonster.setDamage(getModifier(LOWDAMAGE[curMonster.getCR()-1],HIDAMAGE[curMonster.getCR()-1],damage.getProgress()));
        curMonster.setName(name);
        
        try {
        	this.getHelper().getDao(dieGroup.class).create(curMonster.getDamage());
			this.getHelper().getDao(Monster.class).create(curMonster);
		} catch (SQLException e) {
			throw new RuntimeException("Failed to save Monster", e);
		}
        
        Intent intent = new Intent(this, MonsterListView.class);
        startActivity(intent);
	}
	private int getModifier(double low, double hi, double percentage){
		percentage/=100;
		return(int)(hi*percentage + low*(1-percentage)+.5);
		
	}
	
	

}