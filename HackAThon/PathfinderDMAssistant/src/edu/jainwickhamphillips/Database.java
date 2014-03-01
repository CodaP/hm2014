package edu.jainwickhamphillips;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class Database extends OrmLiteSqliteOpenHelper {

	private static final String DATABASE_NAME = "PathfinderDMAssist.db";
	private static final int DATABASE_VERSION = 1;
	
	public Database(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION,
			    R.raw.ormlite_config);
	}

	@Override
	public void onCreate(SQLiteDatabase db, ConnectionSource conn) {
		try {
			TableUtils.createTableIfNotExists(conn, Campaign.class);
			TableUtils.createTableIfNotExists(conn, dieGroup.class);
			TableUtils.createTableIfNotExists(conn, Encounter.class);
			TableUtils.createTableIfNotExists(conn, Monster.class);
			TableUtils.createTableIfNotExists(conn, MonsterGroup.class);
			TableUtils.createTableIfNotExists(conn, PlayerCharacter.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, ConnectionSource arg1, int arg2,
			int arg3) {
		//NOPE
		onCreate(arg0, arg1);
	}

}
