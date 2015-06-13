package com.acnr.sw7timer;

import java.util.Date;
import java.util.GregorianCalendar;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Date today  = new GregorianCalendar().getTime();
		Date release = new GregorianCalendar(2015, 11, 18).getTime();
		
		long diff = release.getTime() - today.getTime();
		long nHours = diff / (1000 * 60 *60 ); 
		long nDays  = diff / (1000 * 60 * 60 * 24);
				
		Log.i("SW7", today.toString());
		Log.i("SW7", release.toString());
		Log.i("SW7", nHours + " hours left.");
		Log.i("SW7", nDays + " days left.");
		
		TextView tvCounter = (TextView) findViewById(R.id.textCounter);
		tvCounter.setText("in "+ nDays + " days.");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_about) {
			Log.i("SW7", "About was selected.");
			Toast about = Toast.makeText(getBaseContext(), "App#2 from 1st assignment\nPlayful Science of Android Apps\ncourse on coursera.org - 2014\nFOR PEER-REVIEW ONLY", Toast.LENGTH_LONG);
			about.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
			about.show();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
