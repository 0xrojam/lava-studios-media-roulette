package com.LavaStudios.mediaroulette;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class EditList extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_list);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_edit_list, menu);
		return true;
	}

}
