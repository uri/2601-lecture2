package com.uri;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Task1 extends Activity implements Runnable {

	private Handler handler = new Handler();
	private EditText textfield;
	private int counter;
	
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.task1layout);
		
		/* Init */
		counter = 0;
		textfield = (EditText)findViewById(R.id.editText1);
		Button b = (Button)findViewById(R.id.task_1_start);
		final Task1	parent = this;
		
		b.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				new Thread(parent).start();		
			}
		});
		
	}

	
	
	public void run() {
		while (counter <= 60) {

			/* Post to the view */
			handler.post(new Runnable() {
				public void run() {
					textfield.setText("" + counter);
				}
			});

			/* Sleep for a 1000ms */
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}

			/* Incrementy the counter */
			counter++;
		}
		counter = 0;

	}

}
