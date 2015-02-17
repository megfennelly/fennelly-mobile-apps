package com.example.currencyhelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {

	//Fields for objects
		private TextView textBill;
		private TextView textTip;
		private TextView textTotal;
		private SeekBar seekBar;
		private TextView textView4;
		private Button buttonMenu;
		private Button buttonMenu2;
		private EditText editCurrency;
		private EditText editTip;
		private RadioButton buttonDollar;
		private RadioButton buttonEuro;
		private Button buttonTip;
		private Button buttonCurrency;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//Bind to XML
		textBill = (TextView)findViewById(R.id.textBill);
		textTotal = (TextView)findViewById(R.id.textTotal);
		textTip = (TextView)findViewById(R.id.textTip);
		seekBar= (SeekBar)findViewById(R.id.seekBar);
		textView4=(TextView)findViewById(R.id.textView4);
		buttonMenu=(Button)findViewById(R.id.buttonMenu);
		editCurrency=(EditText)findViewById(R.id.editCurrency);
		buttonDollar=(RadioButton)findViewById(R.id.buttonDollar);
		buttonEuro= (RadioButton)findViewById(R.id.buttonEuro);
		buttonTip=(Button)findViewById(R.id.buttonTip);
		buttonCurrency=(Button)findViewById(R.id.buttonCurrency);
		buttonMenu2=(Button)findViewById(R.id.buttonMenu2);
		editTip=(EditText)findViewById(R.id.editTip);
		
	//Register seek with listener
		seekBar.setMax(500);
		seekBar.setProgress(30);
		seekBar.setOnSeekBarChangeListener(seekBarListener);
	
	}
	//handle buttons
	public void handleClick(View v) {
		boolean checked = ((RadioButton) v).isChecked();
		//bind to editArea
		EditText editCurrency=(EditText)findViewById(R.id.editCurrency);
		double currency = Double.parseDouble(String.valueOf(editCurrency.getText()));
		//which button clicked
				switch (v.getId()) {
				case R.id.buttonCurrency:
					//create new intent
					Intent intentOne = new Intent(this, Currency.class);
					//start Intent
					startActivity(intentOne);
					break;
				case R.id.buttonTip:
					//create new IntentTwo
					Intent intentTwo = new Intent(this, Tip.class);
					startActivity(intentTwo);
					break;
			}//end switch
				//which button clicked
				switch (v.getId()) {
				case R.id.buttonCurrency:
					//which button clicked
					if (checked) {
						editCurrency.setText(euroToDollar(currency));
					}
					break;
				case R.id.buttonTip:
					//which button clicked
					if (checked) {
						editCurrency.setText(dollarToEuro(currency));
					}
					break; 
					}//switch
	}//end handleClick
	
	
	
	private String euroToDollar(double euro) {
		double dollar = euro/.88;
		return String.valueOf(dollar);
	}
	
	private String dollarToEuro(double dollar) {
		double euro = dollar/1.13;
		return String.valueOf(euro);
	}

	@Override 
	protected void onResume() {
		super.onResume();
		setContentView(R.layout.activity_main);
	
	}
	
		
	private OnSeekBarChangeListener seekBarListener=
			new OnSeekBarChangeListener() {
		
		@Override
		public void onProgressChanged(SeekBar seekBar, int progress, boolean frontUser) {
			//TODO Auto-generated method stub
		
			//Get value from SeekBar, display, call getTip function
		int percent = seekBar.getProgress();
		String percentString = String.valueOf(percent);
		textView4.setText(percentString);
		textTip.setText(getTip(percent));
		}

		@Override
		public void onStartTrackingTouch(SeekBar arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onStopTrackingTouch(SeekBar arg0) {
			// TODO Auto-generated method stub
			
		}
		
		//get tip
		private String getTip(int percent) {
			//get value from editTip
			double bill = Double.valueOf(editTip.getText().toString());
			double tip = bill* (Double.valueOf(percent)/100);
			String tipString = String.valueOf(tip);
			return tipString;
		}
		
	};
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
	}
