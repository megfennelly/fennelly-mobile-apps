package com.example.fennellyintentexercise;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

	public class ActivityThree extends Activity{
		@Override
		protected void onCreate(Bundle bundle){
			super.onCreate(bundle);
			setContentView(R.layout.activity_activitythree);
		}
		
		@Override
		protected void onResume() {
			super.onResume();
			setContentView(R.layout.activity_activitythree);
		}
		
		//Handles the Menu Button Click
		//Go back to MainActivity
		public void handleClick(View v) {
			Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);
		}

	}

