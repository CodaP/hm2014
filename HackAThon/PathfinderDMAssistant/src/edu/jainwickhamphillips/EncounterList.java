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
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.j256.ormlite.android.apptools.OrmLiteBaseListActivity;
import com.j256.ormlite.dao.CloseableIterator;

public class EncounterList extends OrmLiteBaseListActivity<Database> {

	private List<Encounter> encounters = new ArrayList<Encounter>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_encounter_list);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.encounter_list, menu);
		return true;
	}

	public void newEncounter(View v) {
		EditText nameField = (EditText) findViewById(R.id.editText_encounterName);
		String name = nameField.getText().toString();
		name = name.trim();
		if (!"".equals(name)) {
			Encounter enc = new Encounter(name);
			try {
				getHelper().getDao(Encounter.class).create(enc);
			} catch (SQLException e) {
				throw new RuntimeException("Could not create Encounter", e);
			}
			Intent intent = new Intent(this, EncounterEdit.class);
			intent.putExtra("encounterId", enc.getId());
			startActivity(intent);
		}
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		try {
			encounters.clear();
			CloseableIterator<Encounter> mons = getHelper().getDao(Encounter.class).closeableIterator();
			while(mons.hasNext()) {
				encounters.add(mons.next());
			}
			getListView().setAdapter(new ArrayAdapter<Encounter>(this, R.layout.list_item, encounters));
		} catch (SQLException e) {
			throw new RuntimeException("Could not get DAO iterator for Monster", e);
		}
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
