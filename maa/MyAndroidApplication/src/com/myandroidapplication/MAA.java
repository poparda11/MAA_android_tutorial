package com.myandroidapplication;

import com.myandroidapplication.R;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;

public class MAA extends Activity {
	MediaPlayer mySound;
	boolean music;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_maa);
		ImageView image = (ImageView) findViewById(R.id.title_screen);
		// Button login = (Button) findViewById(R.id.login_edit_text);
		SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		music = getPrefs.getBoolean("checkbox", true);

		Runnable watek1 = new Runnable() {
			public void run() {
				try {
					mySound = MediaPlayer.create(MAA.this, R.raw.fanfare2);
					mySound.setLooping(true);
					if(music)
					mySound.start();
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Sound failed");
				}

			}
		};
		Runnable watek2 = new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);// 3800-time of sound
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					Intent startlogin = new Intent(
							"com.myandroidapplication.MENU");
					startActivity(startlogin);
				}
			}
		};
		Thread w1 = new Thread(watek1);
		Thread w2 = new Thread(watek2);
		w2.start();
		w1.start();
		image.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mySound.release();

			}
		});
	}

	@Override
	protected void onPause() {
		super.onPause();
		mySound.release();
		finish();
	}

}