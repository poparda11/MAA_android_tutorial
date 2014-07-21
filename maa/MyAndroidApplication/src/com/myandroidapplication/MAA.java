package com.myandroidapplication;

import com.myandroidapplication.R;
import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MAA extends Activity {
	MediaPlayer mySound;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_maa);
		ImageView image = (ImageView)findViewById(R.id.title_screen);
		//Button login = (Button) findViewById(R.id.login_edit_text);
	
		Runnable watek1 = new Runnable(){
			public void run(){
				try{
				mySound = MediaPlayer.create(MAA.this, R.raw.fanfare2); 
				mySound.setLooping(true);
				mySound.start();
				}catch(Exception e){
					e.printStackTrace();
					System.out.println("Sound failed");
				}
				
			}
		};		
		Runnable watek2 = new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(3800);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					Intent startlogin = new Intent("com.myandroidapplication.MENU");
					startActivity(startlogin);
				}
			}
		};
		Thread w1= new Thread(watek1);
		Thread w2= new Thread(watek2);
		w2.start();
		w1.start();image.setOnClickListener(new View.OnClickListener() {
			
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