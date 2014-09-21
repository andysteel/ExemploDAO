package com.gmail.andersoninfonet.exemplodao;

import android.os.Bundle;

import android.app.ListActivity;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends ListActivity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ClienteDAO dao = new ClienteDAO(this);
		Cliente cliente = new Cliente();
		cliente.setNome("Anderson");
		cliente.setRenda(5000.0);
		dao.insert(cliente);
		
		setListAdapter(new ClienteAdapter(this, dao.lista()));
		
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Cliente c  = (Cliente) l.getItemAtPosition(position);
	}
	

}
