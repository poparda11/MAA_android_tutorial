package com.myandroidapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
public class SQLView extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sqlview);
		TextView tv = (TextView)findViewById(R.id.tvSQLInfo);
		HotOrNot info = new HotOrNot(this);
		info.open();
		String data = info.getData();
		info.close();
		tv.setText(data);
	}
}
