package com.mtk.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.Toast;

public class DisplayCalActivity extends Activity {
	public final static String EXTRA_MESSAGE = "com.mtk.test.date";
	CalendarView cal;
	
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_display_cal);
	        
	        cal = (CalendarView) findViewById(R.id.calendarView1);
	        
	        cal.setOnDateChangeListener(new OnDateChangeListener() {
				
			@Override
			public void onSelectedDayChange(CalendarView view, int year, int month,
					int dayOfMonth) {
				// TODO Auto-generated method stub
				String selectedDate = dayOfMonth+"/"+(month)+"/"+year;
//				Toast.makeText(getBaseContext(),"Selected Date is\n\n" +
//					selectedDate, Toast.LENGTH_LONG).show();
				
				Intent intent = new Intent("com.mtk.test.SINGLE_DAY");
				intent.putExtra(EXTRA_MESSAGE, selectedDate);
				startActivity(intent);

			}
		});
	    }
	 
	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        getMenuInflater().inflate(R.menu.display_message, menu);
	        return true;
	    }
}
