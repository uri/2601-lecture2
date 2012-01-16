package com.uri;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;

public class Task2 extends Activity implements Runnable {

	private Handler handler = new Handler();
	private ProgressBar bar;
	private ProgressBar spinner;
	private int counter;
	private Task2 parent;
	
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.task2layout);
		
		/* Init */
		counter = 0;
		
		bar = (ProgressBar)findViewById(R.id.progressBar1);
		bar.setProgress(0);
		
		spinner = (ProgressBar)findViewById(R.id.progressBar2);
		spinner.setProgress(0);
		
		Button b = (Button)findViewById(R.id.task_2_start);
		parent = this;
		
		b.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				new Thread(parent).start();		
			}
		});
		
	}

	public void run() {
		while (counter <= 100) {

			/* Post to the view */
			handler.post(new Runnable() {
				public void run() {
					bar.setProgress(counter);
					spinner.setProgress(counter);
					
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


