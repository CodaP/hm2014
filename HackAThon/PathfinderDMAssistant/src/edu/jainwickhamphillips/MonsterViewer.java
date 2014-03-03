package edu.jainwickhamphillips;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;

public class MonsterViewer extends OrmLiteBaseActivity<Database>{

	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster_viewer);
        
    }
	protected void onStart(){
		super.onStart();
        Monster m=(Monster)getIntent().getSerializableExtra("MB-Info-Part-One");
        
        String challengeRating="Challenge Rating: "+m.getCR();
        ((TextView)findViewById(R.id.textView_CR)).setText(challengeRating);
        
        String health="Hit Points: "+m.getHealth();
        ((TextView)findViewById(R.id.textView_HP)).setText(health);
        
        String armorClass="Armor Class (AC): "+m.getAC();
        ((TextView)findViewById(R.id.textView_AC)).setText(armorClass);
        
        String attack="Attack: "+ m.getAttack();
        ((TextView)findViewById(R.id.textView_attack)).setText(attack);
        
        String damage="Damage: "+m.getDamage();
        ((TextView)findViewById(R.id.textView_damage)).setText(damage);
        
        String primaryDC="Primary DC: "+m.getPrimaryDC();
        ((TextView)findViewById(R.id.textView_primaryDC)).setText(primaryDC);
        
        String secondaryDC="Secondary DC: "+m.getSecondaryDC();
        ((TextView)findViewById(R.id.textView_secondaryDC)).setText(secondaryDC);
        
        String goodSave="Good Save: "+m.getGoodSave();
        ((TextView)findViewById(R.id.textView_goodSave)).setText(goodSave);
        
        String poorSave="Poor Save: "+m.getPoorSave();
        ((TextView)findViewById(R.id.textView_poorSave)).setText(poorSave);
        
        String initiative="Initiative: "+m.getInitiative();
        ((TextView)findViewById(R.id.textView_initiative)).setText(initiative);
        
        String name=m.toString();
        ((TextView)findViewById(R.id.textView_nameDescription)).setText(name);
	}
}
