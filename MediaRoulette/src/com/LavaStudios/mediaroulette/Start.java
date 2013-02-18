package com.LavaStudios.mediaroulette;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Vector;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Start extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wheel_start);
		
        final RotateAnimation animation = new RotateAnimation(0.0f, 360.0f, Animation.RELATIVE_TO_SELF, 0.5f, 
        		Animation.RELATIVE_TO_SELF, 0.5f);  
        animation.setInterpolator(new LinearInterpolator());
        animation.setRepeatCount(3);
        animation.setDuration(600);
       
        final TextView result = (TextView) findViewById(R.id.resultField);
        
        final ImageView wheelImage = (ImageView) findViewById(R.id.wheelImage); 
        wheelImage.setOnClickListener(new OnClickListener() 
        {
        	
        	@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
        		result.setText("");
        		MediaPlayer chime;
        		chime = MediaPlayer.create(Start.this, R.raw.wheelsfx);
        		chime.start();
        		
				wheelImage.startAnimation(animation);
				Vector<String> strs = new Vector<String>();
				try {
					File myFile = new File("/sdcard/mediaroulette.txt");

					FileInputStream fIn = new FileInputStream(myFile);
					BufferedReader myReader = new BufferedReader(
							new InputStreamReader(fIn));
					String aDataRow = "";
					while ((aDataRow = myReader.readLine()) != null) {
						strs.add(aDataRow);
					}
					myReader.close();
				} catch (Exception e) {
					Toast.makeText(getBaseContext(), e.getMessage(),
							Toast.LENGTH_SHORT).show();
				}
				Random rndm = new Random();
				int randomNum = rndm.nextInt(strs.size());
				
				final String selection = strs.get(randomNum);
				
				//to delay all result before wheel's done spinning
				final Handler handler = new Handler();
				handler.postDelayed(new Runnable() {
				  @Override
				  public void run() {
				    //Do something after 3000ms
					  result.setText(selection);
				  }
				}, 3000);
				
				
				
					
			}
        });

        
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.wheel_start, menu);
		return true;
	}

}
