package com.myandroidapplication;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SQLiteExample extends Activity implements OnClickListener {

	Button sqlUpdate, sqlView, sqlGetInfo, sqlModify, sqlDelete;
	EditText sqlName, sqlHotness, sqlRow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sqlite_example);

		sqlUpdate = (Button) findViewById(R.id.bSQLUpdate);
		sqlView = (Button) findViewById(R.id.bSQLOpenView);
		sqlName = (EditText) findViewById(R.id.et_SQLName);
		sqlHotness = (EditText) findViewById(R.id.etSQLHotness);

		sqlView.setOnClickListener(this);
		sqlUpdate.setOnClickListener(this);
		// ---------------------------------------------------
		sqlGetInfo = (Button) findViewById(R.id.bSQLInfo);
		sqlModify = (Button) findViewById(R.id.bSQLEditEntry);
		sqlDelete = (Button) findViewById(R.id.bSQLDeleteEntry);
		sqlRow = (EditText) findViewById(R.id.etSQLRowID);
		sqlGetInfo.setOnClickListener(this);
		sqlModify.setOnClickListener(this);
		sqlDelete.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bSQLUpdate:
			boolean didItWork = true;
			try {
				String name = sqlName.getText().toString();
				String hotness = sqlHotness.getText().toString();
				HotOrNot entry = new HotOrNot(SQLiteExample.this);
				entry.open();
				entry.createEntry(name, hotness);
				entry.close();
			} catch (Exception e) {
				didItWork = false;
				String error = e.toString();
				Dialog d = new Dialog(this);
				d.setTitle("Sad :/");
				TextView tv = new TextView(this);
				tv.setText(error);
				d.setContentView(tv);
				d.show();
			} finally {
				if (didItWork) {
					// dialog!!!!!
					Dialog d = new Dialog(this);
					d.setTitle("Fuck yea!");
					TextView tv = new TextView(this);
					tv.setText("Everything's work OK!");
					d.setContentView(tv);
					d.show();
				}
			}
			break;
		case R.id.bSQLOpenView:
			Intent i = new Intent("com.myandroidapplication.SQLVIEW");
			startActivity(i);
			break;
		case R.id.bSQLInfo:
			String s = sqlRow.getText().toString();
			long l = Long.parseLong(s);
			HotOrNot hon = new HotOrNot(this);
			hon.open();
			String returnedName = hon.getName(l);
			String returnedHotness = hon.getHotness(l);
			hon.close();
			if (returnedName.equals(null)) {
				sqlName.setText("No info");
				sqlHotness.setText("Sorry");
			} else {
				sqlName.setText(returnedName);
				sqlHotness.setText(returnedHotness);
			}

			break;
		case R.id.bSQLEditEntry:
			String mName = sqlName.getText().toString();
			String mHotness = sqlHotness.getText().toString();
			String sRow = sqlRow.getText().toString();
			long lRow = Long.parseLong(sRow);
			HotOrNot ex = new HotOrNot(this);
			ex.open();
			ex.updateEntry(lRow,mName,mHotness);
			ex.close();
			break;
		case R.id.bSQLDeleteEntry:
			String sRow1 = sqlRow.getText().toString();
			long lRow1 = Long.parseLong(sRow1);
			HotOrNot ex1 = new HotOrNot(this);
			ex1.open();
			ex1.deleteEntry(lRow1);
			ex1.close();
			break;
		}
	}

}
