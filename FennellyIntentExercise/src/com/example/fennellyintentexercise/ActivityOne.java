package com.example.fennellyintentexercise;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityOne extends Activity {
	
	@Override
	protected void onCreate (Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.activity_activityone);
	}
	
	@Override 
	protected void onResume() {
		super.onResume();
		setContentView(R.layout.activity_activityone);
	}
	//Handles the Menu button Click
		//go back to MainActivity
		public void handleClick(View v) {
			Intent intent= new Intent (this, MainActivity.class);
			startActivity(intent);
}
}//end Activity one

