package edu.jainwickhamphillips;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

import com.j256.ormlite.android.apptools.OrmLiteBaseListActivity;
import com.j256.ormlite.dao.CloseableIterator;

public class MonsterListView extends OrmLiteBaseListActivity<Database> {

	private List<Monster> monsters = new ArrayList<Monster>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_monster_list_view);
		getListView().setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View text, int index,
					long id) {
				Intent intent = new Intent(MonsterListView.this, MonsterViewer.class);
				intent.putExtra("MB-Info-Part-One", monsters.get(index));
				startActivity(intent);
			}
		});
	}
	
	
	public void createMonster(View view) {
		Intent intent = new Intent(this, MonsterBuilderOne.class);
		this.startActivity(intent);
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		try {
			monsters.clear();
			CloseableIterator<Monster> mons = getHelper().getDao(Monster.class).closeableIterator();
			while(mons.hasNext()) {
				monsters.add(mons.next());
			}
			getListView().setAdapter(new ArrayAdapter<Monster>(this, R.layout.list_item, monsters));
		} catch (SQLException e) {
			throw new RuntimeException("Could not get DAO iterator for Monster", e);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.monster_list_view, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
