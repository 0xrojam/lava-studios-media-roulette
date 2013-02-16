package com.LavaStudios.mediaroulette;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity {

	
	private static final String START = "com.LavaStudios.mediaroulette.START";
	private static final String EDITLIST = "com.LavaStudios.mediaroulette.EDITLIST";
	private static final String ABOUTUS = "com.LavaStudios.mediaroulette.ABOUTUS";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        if(!Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
            Toast.makeText(this, "External SD card not mounted", Toast.LENGTH_LONG).show();
        }
        
        ImageButton start = (ImageButton) findViewById(R.id.startButton);
        ImageButton editList = (ImageButton) findViewById(R.id.editListButton);
        ImageButton about = (ImageButton) findViewById(R.id.aboutButton);
        
        //associates listener for Map Selection button
        start.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) {
		      Intent i = new Intent(START);
              startActivity(i);
			}
        });
        
        editList.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) {
		      Intent i = new Intent(EDITLIST);
              startActivity(i);
			}
        });
        
        about.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) {
		      Intent i = new Intent(ABOUTUS);
              startActivity(i);
			}
        });
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
