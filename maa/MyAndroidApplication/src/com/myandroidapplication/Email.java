package com.myandroidapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Email extends Activity {
	EditText _email, _subject,_msg1,_msg2,_msg3,_msg4;
	Button send;
	String s_email,s_subject,s_msg1,s_msg2,s_msg3,s_msg4;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_email);
		_email=(EditText) findViewById(R.id.mail_editText1);
		_subject=(EditText) findViewById(R.id.mail_editText2);
		_msg1=(EditText) findViewById(R.id.mail_editText3); 
		_msg2=(EditText) findViewById(R.id.mail_editText4);
		_msg3=(EditText) findViewById(R.id.mail_editText5);
		_msg4=(EditText) findViewById(R.id.mail_editText6);
		send=(Button)findViewById(R.id.mail_send);
		send.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				getContentfromEditTexts();
				String[] adresses ={s_email};
				String message = "Hi. \n"+s_msg1+"\n"+s_msg2+"\n"+s_msg3+"\n PS:"+s_msg4+"\n";
				
				Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
				emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,adresses);
				emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,s_subject);
				emailIntent.setType("plain/text");
				emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,message);
				startActivity(emailIntent);
				
			}

			private void getContentfromEditTexts() {
				// TODO Auto-generated method stub
				s_email=_email.getText().toString();
				s_subject=_subject.getText().toString();
				s_msg1=_msg1.getText().toString();
				s_msg2=_msg2.getText().toString();
				s_msg3=_msg3.getText().toString();
				s_msg4=_msg4.getText().toString();
			}	
		});
	}
}
