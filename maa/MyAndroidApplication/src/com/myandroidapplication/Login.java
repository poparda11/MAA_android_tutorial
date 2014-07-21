package com.myandroidapplication;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends Activity {
	
	Integer counter=0;
	Button zaloguj;
	TextView display;
	Button default1;
	EditText login;
	EditText password;
	MediaPlayer mySound;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		zaloguj=(Button)findViewById(R.id.button_zaloguj);
		display=(TextView)findViewById(R.id.counterek);
		login=(EditText)findViewById(R.id.login_edit_text);
		password=(EditText)findViewById(R.id.password_edit_text);
		default1=(Button)findViewById(R.id.button_deafult);
		mySound = MediaPlayer.create(Login.this, R.raw.guitar);
		zaloguj.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//if(!mySound.isPlaying()){
				if(mySound.isPlaying()){
					mySound.seekTo(0);
				}
				mySound.start();//}
				counter++;
				display.setText("Visited "+counter+" times.");
			}
		});
		default1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				login.setText("Admin");
				password.setText("Haselko");
			}
		});
		
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		mySound.release();
	}
}