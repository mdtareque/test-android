package com.mtk.test;

import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyParseBroadcastReceiver extends BroadcastReceiver {

	private static final String TAG = "MyCustomReceiver";

	@Override
	public void onReceive(Context context, Intent intent) {
		try {
		      String action = intent.getAction();
		      String channel = intent.getExtras().getString("com.parse.Channel");
		      JSONObject json = new JSONObject(intent.getExtras().getString("com.parse.Data"));
		 
		      Log.d(TAG, "got action " + action + " on channel " + channel + " with:");
		      Iterator<?> itr = json.keys();
		      while (itr.hasNext()) {
		        String key = (String) itr.next();
		        Log.d(TAG, "..." + key + " => " + json.getString(key));
		        if(key.equals("name")) {
		        	DisplayMessageActivity.VAR=json.getString(key);
		        }
		      }
		      
		      
		      // Notification part
		      // Prepare intent which is triggered if the
		      // notification is selected
		      Intent notifyIntent = new Intent();
		      PendingIntent pIntent = PendingIntent.getActivity(context, 0, notifyIntent, 0);
		      
		      String subjectCode = "abc"; //dbAdapter.getSubjectCode(lec_id);
		      // Build notification
		      // Actions are just fake
		      Notification noti = new Notification.Builder(context)
		          .setContentTitle("Lecture Cancelled !!!")
		          .setContentText(subjectCode + " has been cancelled for ...")
		          .setContentIntent(pIntent).setSmallIcon(R.drawable.ic_launcher).build();
		      NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		      // hide the notification after its selected
		      noti.flags |= Notification.FLAG_AUTO_CANCEL;

		      Log.d(TAG, "About to send notification");
		      notificationManager.notify(0, noti);
		      
		} catch (JSONException e) {
			Log.d(TAG, "JSONException: " + e.getMessage());
		}
		
	}

}
