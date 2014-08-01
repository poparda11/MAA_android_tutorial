package com.myandroidapplication;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainMenu extends ListActivity {

	String classes[] = { "Login", "MovingText", "Time", "Email", "Photo","SQLiteExample" };
	String names[] = { "Login", "Command-line", "Czas", "E-mail", "Aparat","Baza SQLite" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// fullscreen
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);// setFlags(flag,mask);
		// filling list
		setListAdapter(new ArrayAdapter<String>(MainMenu.this,
				android.R.layout.simple_list_item_1, names));

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String tmp = classes[position];
		Class<?> class1;
		try {
			class1 = Class.forName("com.myandroidapplication." + tmp);
			Intent intent = new Intent(MainMenu.this, class1);
			startActivity(intent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater blowUp = getMenuInflater();
		blowUp.inflate(R.menu.cool_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.menu_about_us:
			Intent i = new Intent("com.myandroidapplication.ABOUT");
			startActivity(i);
			break;
		case R.id.menu_preferences:
			Intent j = new Intent("com.myandroidapplication.PREFS");
			startActivity(j);
			break;
		case R.id.menu_exit:
			finish();
			break;
		}
		return false;
		// return super.onOptionsItemSelected(item);
	}

}