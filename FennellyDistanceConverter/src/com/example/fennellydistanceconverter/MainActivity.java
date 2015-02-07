package com.example.fennellydistanceconverter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends Activity {

	//Fields
	private Button resetButton;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 
		
		//Bind to XML
	resetButton = (Button)findViewById(R.id.resetButton); }


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
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	//Method to handle buttons
	public void handleClick(View v) {
		//boolean object-> which button was checked
		 boolean checked= ((RadioButton) v).isChecked();
		 EditText text1 = (EditText)findViewById(R.id.editDistance);
		 double distance= Double.parseDouble(String.valueOf(text1.getText()));
		 
		 EditText text2 = (EditText)findViewById(R.id.editTemperature);
		 double temp = Double.parseDouble(String.valueOf(text2.getText()));
		 
		
		 //which button was clicked
		 switch(v.getId()) {
		 case R.id.radioMiles:
			 if(checked) {
				String miles= kmToMiles(distance);
				text1.setText(miles);
				
			 }
			 break;
		 }
		 
		//which temp button
		 switch(v.getId()) {
		 case R.id.radioCelsius:
			 if(checked) {
				 String cel= fahrenheitToCelsius(temp);
				 text2.setText(cel);
			 }
		 case R.id.radioFahrenheit:
			 if(checked) {
				 String fah= celsiusToFahrenheit(temp);
				 text2.setText(fah);
			 }
			 break;
		 }
		 
	}

	private String fahrenheitToCelsius(double temp) {
		double cel = (temp - 32)* 5/9;
		return String.valueOf(cel);
		}
	
	private String celsiusToFahrenheit(double temp) {
		double fahrenheit = temp * 9/5 + 32;
		return String.valueOf(fahrenheit);
	}
	private String milesToKm(double distance) {
		double kilos = distance * 1.609;
		return String.valueOf(kilos);
	}

	private String kmToMiles(double distance) {
		double miles= distance / 1.609;
		return String.valueOf(miles);
	} 
	public void reset(View v){
		EditText text1 = (EditText)findViewById(R.id.editDistance);
		text1.setText("0");
	}
}
