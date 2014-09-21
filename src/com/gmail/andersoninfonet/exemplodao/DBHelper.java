package com.gmail.andersoninfonet.exemplodao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{
	
	public DBHelper(Context ctx){
		super(ctx, "DAO", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE cliente(" +
				   "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
				   "nome VARCHAR (150)," +
				   "renda DOUBLE);");
		
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		if(oldVersion == 1){
			if(newVersion == 2){
				//db.execSQL("ALTER TABLE ADD blablabla");
			}
		}
		
	}
	
}
