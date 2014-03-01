package com.example.helloworld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.content.Intent;

public class Activity2 extends ListActivity {
	
	SimpleAdapter adapter;
	List<Map<String,String>> items;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_activity2);
		items = new ArrayList<Map<String,String>>();
		for(int i=0;i<20;i++){
			items.add(new HashMap<String,String>());
			items.get(i).put("name", String.format("%d",i));
		}
		//Map<String,String> footer = new HashMap<String,String>();
		TextView footer = (TextView) findViewById(R.id.message2);
		footer.setText("FOOTER");
		//items.add(footer);
		//this.getListView().addFooterView(footer);
		int[] from = {R.id.message};
		String[] to = {"name"};
		adapter = new SimpleAdapter(this, items, R.layout.main_list, to, from);
		setListAdapter(adapter);
		
		this.getListView().setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(final AdapterView<?> parent, final View view, final int pos,
					long id) {
				
				if(pos != items.size()-1){
				view.animate().setDuration(200).alpha(0).withEndAction(new Runnable(){

					@Override
					public void run() {
						items.remove(pos);
						adapter.notifyDataSetChanged();
						view.setAlpha(1);
					}
					
				});
				}
				else{
					addToEnd("New Thing");
				}

			}			
		});
		this.getListView().setOnLongClickListener(new OnLongClickListener(){

			@Override
			public boolean onLongClick(View arg0) {
				arg0.setVisibility(1);
				return true;
			}
			
		});
		
	}

	private void edit(){
		Intent intent2 = new Intent(this,EditThing.class);
		startActivity(intent2);
	}
	
	public void addToEnd(String arg1){
		items.remove(items.size()-1);
		Map<String,String> new_thing = new HashMap<String,String>();
		Map<String,String> footer = new HashMap<String,String>();

		new_thing.put("name", arg1);
		footer.put("name", "Add new");
		items.add(new_thing);
		items.add(footer);
		adapter.notifyDataSetChanged();
	}
	

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity2, menu);
		return true;
	}


}
