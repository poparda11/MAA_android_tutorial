package com.myandroidapplication;

import android.app.Activity;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

public class MovingText extends Activity {
	boolean b = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_moving_text);
		final EditText input = (EditText) findViewById(R.id.command_line_moving_text_input);
		final ToggleButton tb = (ToggleButton) findViewById(R.id.command_line_moving_text_toggle);
		tb.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (tb.isChecked()) {
					input.setInputType(InputType.TYPE_CLASS_TEXT
							| InputType.TYPE_TEXT_VARIATION_PASSWORD);
				} else {
					input.setInputType(InputType.TYPE_CLASS_TEXT);
				}
			}
		});
		final MediaPlayer mySound = MediaPlayer.create(MovingText.this,
				R.raw.guitar);
		final TextView output = (TextView) findViewById(R.id.command_line_moving_text_output);
		final Button ok = (Button) findViewById(R.id.command_line_moving_text_OK);
		ok.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				/*
				 * if (b) { ok.setBackgroundColor(Color.GRAY); b = false; } else
				 * { ok.setBackgroundColor(Color.GREEN); b = true; } try{
				 * output.setGravity(Gravity.LEFT); }catch (Exception e){
				 * e.printStackTrace(); System.out.println("Problemik"); }
				 */
				if (mySound.isPlaying()) {
					mySound.seekTo(0);
				}
				mySound.start();
				String tmp = input.getText().toString();
				if (tmp.equals("left")) {
					output.setGravity(Gravity.LEFT);
				} else if (tmp.equals("right")) {
					output.setGravity(Gravity.RIGHT);
				} else if (tmp.equals("center")) {
					output.setGravity(Gravity.CENTER);
				} else if (tmp.equals("help")) {
					output.setText("Dostepne komendy: left, right, center, help.");
				} else {
					output.setText("help - wyswietla pomoc");
				}
			}

		});
	
	}
}
