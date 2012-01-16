package com.uri;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;

public class Task3 extends Activity {

	private static int SLEEP_TIME = 10;
	private static int COUNTER_BOUND = 1000;

	private Handler handler = new Handler();

	private ProgressBar progressApple;
	private ProgressBar progressBagel;

	private Thread threadApple;
	private Thread threadBagel;

	private int counterApple;
	private int counterBagel;

	private boolean applePriorityHigh;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.task3layout);

		counterApple = 0;
		counterBagel = 0;

		applePriorityHigh = true;

		Button b = (Button) findViewById(R.id.task_3_button);
		Button swap = (Button) findViewById(R.id.swap);
		
		progressApple = (ProgressBar)findViewById(R.id.task_3_progress_apple);
		progressBagel = (ProgressBar)findViewById(R.id.task_3_progress_bagel);

		/* Set the listeners */
		// Start button
		b.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				threadApple.start();
				threadBagel.start();
			}
		});

		// Swap Button
		swap.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if (!applePriorityHigh) {
					threadApple.setPriority(Thread.MAX_PRIORITY);
					threadBagel.setPriority(Thread.MIN_PRIORITY);
				} else {
					threadBagel.setPriority(Thread.MAX_PRIORITY);
					threadApple.setPriority(Thread.MIN_PRIORITY);
				}

				applePriorityHigh = !applePriorityHigh;
			}
		});

		/* Apple Thread */
		threadApple = new Thread(new Runnable() {
			public void run() {
				while (counterApple <= COUNTER_BOUND) {
					handler.post(new Runnable() {
						public void run() {
							progressApple.setProgress(counterApple);
						}
					});

					// Update the progress
					counterApple++;

					try {
						Thread.sleep(SLEEP_TIME);
					} catch (InterruptedException e) {
					}
				}

				counterApple = 0;
			}
		});

		/* Bagel thread */
		threadBagel = new Thread(new Runnable() {
			public void run() {
				while (counterBagel <= COUNTER_BOUND) {
					handler.post(new Runnable() {
						public void run() {
							progressBagel.setProgress(counterBagel);
						}
					});

					// Update the progress
					counterBagel++;

					try {
						Thread.sleep(SLEEP_TIME);
					} catch (InterruptedException e) {
					}

				}

				counterBagel = 0;
			}
		});

	}

}
