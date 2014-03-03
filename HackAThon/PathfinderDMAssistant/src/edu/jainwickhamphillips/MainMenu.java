package edu.jainwickhamphillips;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainMenu extends OrmLiteBaseActivity<Database> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }
   


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to  the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    public void goToMonster(View view){
    	Intent intent = new Intent(this, MonsterListView.class);
    	startActivity(intent);
    }
    
}
