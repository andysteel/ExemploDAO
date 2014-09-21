package com.gmail.andersoninfonet.exemplodao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class ClienteDAO {

	private Context context;
	private String table_name = "cliente";
	private String[] colunas = new String[] {"_id","nome","renda"};
	private DBHelper mDBHelper;
	
	public ClienteDAO(Context context){
		this.context = context;
	}
	
	public void close(){
		if(mDBHelper != null){
			mDBHelper.close();
		}
	}
	
	public boolean insert(Cliente cliente){
		Log.d("inicio_insert", "ok");
		SQLiteDatabase db = new DBHelper(context).getWritableDatabase();
		ContentValues ctv = new ContentValues();
		ctv.put("nome", cliente.getNome());
		ctv.put("renda", cliente.getRenda());
		
		return (db.insert(table_name, null, ctv) > 0);
	}
	
	
	public List<Cliente> lista(){
		
		List<Cliente> lista = new ArrayList<Cliente>();
		
		SQLiteDatabase db = new DBHelper(context).getWritableDatabase();
		try{
		Cursor c  = db.query(table_name, colunas, null, null, null, null, null);
		
		while(c.moveToNext()){
			Cliente cliente = new Cliente();
			cliente.setId(c.getInt(c.getColumnIndex("_id")));
			Log.d("final_id", "ok");
			cliente.setNome(c.getString(c.getColumnIndex("nome")));
			cliente.setRenda(c.getDouble(c.getColumnIndex("renda")));
			lista.add(cliente);
		}
		}finally{
			db.close();
		}
		
		return lista;
		
	}
}
