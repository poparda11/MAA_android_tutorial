package com.myandroidapplication;


import android.os.Bundle;
import android.preference.PreferenceActivity;

public class Prefs extends PreferenceActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_prefs);
		addPreferencesFromResource(R.xml.prefs);
	}
}
