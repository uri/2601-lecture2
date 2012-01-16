package com.uri;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Lecture2aActivity extends Activity {
	/** Called when the activity is first created. */


	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		/* The button */
		Button task1Button = (Button) findViewById(R.id.task_1_button);
		Button task2Button = (Button) findViewById(R.id.task_2_button);
		Button task3Button = (Button) findViewById(R.id.task_3_button);
		
		
		/* Add the listener */
		task1Button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startActivity(
						new Intent(getApplicationContext(),
						Task1.class));
			}
		});
		
		
		task2Button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startActivity(
						new Intent(getApplicationContext(),
						Task2.class));
			}
		});
		
		
		task3Button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startActivity(
						new Intent(getApplicationContext(),
						Task3.class));
			}
		});
		

	}
}