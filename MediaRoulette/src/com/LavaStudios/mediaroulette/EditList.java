package com.LavaStudios.mediaroulette;

import java.io.*;

import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;
import android.os.Bundle;
import android.app.Activity;

public class EditList extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_list);

		final EditText enterTxt = (EditText) findViewById(R.id.enterText);
		final EditText displayTxt = (EditText) findViewById(R.id.listText);

		ImageButton enterBtn = (ImageButton) findViewById(R.id.enterButton);
		ImageButton clearBtn = (ImageButton) findViewById(R.id.clearButton);

		enterBtn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// write on SD card file data in the text box
				try {
					File myFile = new File("/sdcard/mediaroulette.txt");
					if (!myFile.exists())
						myFile.createNewFile();

					Toast.makeText(getBaseContext(),
							"Added " + enterTxt.getText(), Toast.LENGTH_SHORT)
							.show();

					FileInputStream fIn = new FileInputStream(myFile);
					BufferedReader myReader = new BufferedReader(
							new InputStreamReader(fIn));
					String aDataRow = "";
					String aBuffer = "";
					while ((aDataRow = myReader.readLine()) != null) {
						aBuffer += aDataRow + "\n";
					}
					aBuffer += enterTxt.getText();
					displayTxt.setText(aBuffer);

					FileOutputStream fOut = new FileOutputStream(myFile);
					OutputStreamWriter myOutWriter = new OutputStreamWriter(
							fOut);
					myOutWriter.append(aBuffer);
					myOutWriter.close();
					fOut.close();
				} catch (Exception e) {
					Toast.makeText(getBaseContext(), e.getMessage(),
							Toast.LENGTH_SHORT).show();
				}
				enterTxt.setText("");
				enterTxt.setHint(null);

			}// onClick
		}); // entrBtn

		clearBtn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				File myFile = new File("/sdcard/mediaroulette.txt");

				if (myFile.exists())
					myFile.delete();

				try {
					myFile.createNewFile();
				} catch (IOException e) {
					Toast.makeText(getBaseContext(), e.getMessage(),
							Toast.LENGTH_SHORT).show();
				}
				
				Toast.makeText(getBaseContext(), "List Cleared",
						Toast.LENGTH_SHORT).show();
				displayTxt.setText("");
			} // onClick
		}); // clearBtn

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_edit_list, menu);
		return true;
	}

}
