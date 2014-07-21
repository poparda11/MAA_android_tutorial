package com.myandroidapplication;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainMenu extends ListActivity {
	String classes[]={"Login","MovingText","Time","example3","example4","example5","example6"};
	String names[]={"Login", "Command-line","Czas","No name 1","No name 2","No name 3","No name 4",};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(MainMenu.this,android.R.layout.simple_list_item_1,names));
		//setContentView(R.layout.activity_menu);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String tmp = classes[position];
		Class<?> class1;
		try {
			class1 = Class.forName("com.myandroidapplication."+tmp);
			Intent intent = new Intent(MainMenu.this,class1);
			startActivity(intent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}