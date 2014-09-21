package com.gmail.andersoninfonet.exemplodao;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ClienteAdapter extends BaseAdapter{
	
	private List<Cliente> lista;
	private Context context;
	
	public ClienteAdapter(Context context, List<Cliente> cliente){
		this.lista = cliente;
		this.context =  context;
	}
	

	@Override
	public int getCount() {
		return lista.size();
	}

	@Override
	public Object getItem(int position) {
		return lista.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		Cliente cliente = lista.get(position);
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View v = inflater.inflate(R.layout.main, null);
		
		TextView txtV1 = (TextView) v.findViewById(R.id.txtV1);
		txtV1.setText(String.valueOf(cliente.getId()));
		
		TextView txtV2 = (TextView) v.findViewById(R.id.txtV2);
		txtV2.setText(cliente.getNome());
		
		TextView txtV3 = (TextView) v.findViewById(R.id.txtV3);
		txtV3.setText(String.valueOf(cliente.getRenda()));
		Log.d("getView", "ok");
				
		return v;
	}

	
}
