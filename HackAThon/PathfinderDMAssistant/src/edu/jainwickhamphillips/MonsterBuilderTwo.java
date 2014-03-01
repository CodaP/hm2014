package edu.jainwickhamphillips;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MonsterBuilderTwo extends Activity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster_builder_two);
        
    }
	protected void onStart(){
		super.onStart();
		TextView test=(TextView)findViewById(R.id.textView_CRTEST);
        Monster m=(Monster)getIntent().getSerializableExtra("MB-Info-Part-One");
        test.setText(""+m.getCR());
	}
	

}