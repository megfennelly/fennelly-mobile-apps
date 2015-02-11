package com.example.fennellyintentexercise;

import android.app.Activity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class ActivityTwo extends Activity{
	@Override
	protected void onCreate(Bundle bundle){
		super.onCreate(bundle);
		setContentView(R.layout.activity_activitytwo);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		setContentView(R.layout.activity_activitytwo);
	}
	
	//Handles the Menu Button Click
	//Go back to MainActivity
	public void handleClick(View v) {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}

}
