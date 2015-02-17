package com.example.currencyhelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Tip extends Activity {
 
	@Override
 protected void onCreate(Bundle bundle) {
	 super.onCreate(bundle);
	 setContentView(R.layout.activity_tip);
 }

	@Override
	protected void onResume() {
		super.onResume();
		setContentView(R.layout.activity_tip);
}
	
//handles the menu button click
	public void handleClick(View v) {
		Intent intentTwo = new Intent(this, MainActivity.class);
		startActivity(intentTwo);
	}
}//end tip
 
