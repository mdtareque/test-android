package com.mtk.test;

import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.EditText;

public class MyParseBroadcastReceiver extends BroadcastReceiver {

	private static final String TAG = "MyCustomReceiver";

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		try {
		      String action = intent.getAction();
		      String channel = intent.getExtras().getString("com.parse.Channel");
		      JSONObject json = new JSONObject(intent.getExtras().getString("com.parse.Data"));
		 
		      Log.d(TAG, "got action " + action + " on channel " + channel + " with:");
		      Iterator itr = json.keys();
		      while (itr.hasNext()) {
		        String key = (String) itr.next();
		        Log.d(TAG, "..." + key + " => " + json.getString(key));
		      }
		/*
		      Intent show = new Intent(context, DisplayMessageActivity.class);
		      EditText editText = (EditText) findViewById(R.id.edit_message);
		      String message = editText.getText().toString();
		      intent.putExtra(EXTRA_MESSAGE, message);
		      startActivity(intent);*/
		} catch (JSONException e) {
			Log.d(TAG, "JSONException: " + e.getMessage());
		}
		
	}

}
