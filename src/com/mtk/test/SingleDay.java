package com.mtk.test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class SingleDay extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_single_day);
		// Get the message from the intent
		Intent intent = getIntent();
		String selectedDate = intent
				.getStringExtra(DisplayCalActivity.EXTRA_MESSAGE);
		String[] tokens = selectedDate.split("/");
		int dd = Integer.parseInt(tokens[0]);
		int mm = Integer.parseInt(tokens[1]);
		int yyyy = Integer.parseInt(tokens[2]);
/*		@SuppressWarnings("deprecation")
		String dayOfTheWeek = (String) 
				android.text.format.DateFormat.format("EEEE", new Date(yyyy,mm,dd));
		
		Calendar c = Calendar.getInstance();
		c.setTime(new Date(yyyy,mm,dd));
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		*/
		
		TimeZone MyTimezone = TimeZone.getDefault();
		Calendar calendar = new GregorianCalendar(MyTimezone);
		calendar.set(yyyy, mm, dd);

//		String month_name=calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault());//Locale.US);
		String day_name=calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());//Locale.US);
		
		TextView selectedDateTextView = (TextView) findViewById(R.id.selectedDate);
		selectedDateTextView.setText(selectedDate + " - "+day_name) ;
		
		
		/*TextView r1c2 = (TextView) findViewById(R.id.row1col2);
		r1c2.setText(selectedDate + dayOfTheWeek) ;
		
		TextView r2c2 = (TextView) findViewById(R.id.row2col2);
		r2c2.setText(month_name + day_name) ;
		*/
/*		// Create the text view
		TextView textView = new TextView(this);
		textView.setTextSize(40);
		textView.setText(message);

		// Set the text view as the activity layout
		setContentView(textView);*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.single_day, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_single_day,
					container, false);
			return rootView;
		}
	}
	 */

}
