package com.myandroidapplication;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Photo extends Activity implements OnClickListener {

	ImageButton ib;
	Button b;
	ImageView iv;
	Intent i;
	TextView tv;
	int cameraResult;
	final static int cameraData=0;
	Bitmap bmp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_photo);
		initialize();
		InputStream is = getResources().openRawResource(R.drawable.ic_launcher);
		bmp = BitmapFactory.decodeStream(is);
		
		
	}

	private void initialize() {
		iv = (ImageView) findViewById(R.id.photo_imageView1);
		b = (Button) findViewById(R.id.photo_set_wallpaper);
		ib = (ImageButton) findViewById(R.id.photo_takePic);
		tv = (TextView)findViewById(R.id.ready_info);
		b.setOnClickListener(this);
		ib.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.photo_set_wallpaper:
			try {
				getApplicationContext().setWallpaper(bmp);
				tv.setVisibility(View.VISIBLE);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		case R.id.photo_takePic:
			i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(i, cameraData);
			break;

		}
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, final Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode== RESULT_OK){
		
						Bundle extras = data.getExtras();
						bmp = (Bitmap) extras.get("data");
						iv.setImageBitmap(bmp);
	
		}
	}

}
