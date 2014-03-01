package com.example.helloworld;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	int count;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		count = 0;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button button = (Button) findViewById(R.id.button1);
		SharedPreferences data = getPreferences(MODE_PRIVATE);
		count = data.getInt("count",50);
	}
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);
		count = (int) savedInstanceState.getLong("count");
	}
	
	public void sendMessage(View view){
		Intent intent = new Intent(this,Activity2.class);
		startActivity(intent);
	}
	
	


	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		outState.putInt("count",count);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	/* (non-Javadoc)
	 * @see android.app.Activity#onDestroy()
	 */
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		SharedPreferences data = getPreferences(MODE_PRIVATE);
		SharedPreferences.Editor edit = data.edit();
		edit.putInt("count", count);
		edit.commit();
	}
	

}
