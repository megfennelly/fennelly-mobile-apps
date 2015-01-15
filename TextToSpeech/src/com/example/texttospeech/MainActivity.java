package com.example.texttospeech;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Service;
import android.speech.tts.TextToSpeech;
import android.text.Editable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements TextToSpeech.OnInitListener {

	//View Objects
	private Button speak; //Presses to Start speech from Edit
	private EditText enterText; //Where the user will type the text
	
	//Varaibles to Store Text for Speaking
	private String phrase;
	
	//Text to Speech Object
	private TextToSpeech speaker;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Initialize View Objects
		speak = (Button) findViewById(R.id.speechButton);
		enterText = (EditText) findViewById(R.id.enterText);
		
		//Initialize the TExt to Speech Object
		speaker = new TextToSpeech(this,this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void speak(View v) {
		//Close the Keyboard on lost focus
		InputMethodManager imm = (InputMethodManager) this.getSystemService(Service.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(v.getApplicationWindowToken(), 0);
	
		// Get the Input Text
		Editable input = enterText.getText();
		
		//Convert to a String
		phrase = input.toString();
	
		//speak the phrase aloud
		speaker.speak(phrase, 1, null);
	} //End method speak()


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

	@Override
	public void onInit(int status) {
		// TODO Auto-generated method stub
		
	} //end method onInit()
	
	public void onDestroy() {
		if (speaker != null) {
			speaker.stop();
			speaker.shutdown();
		}
		super.onDestroy();
	} // end method onDestroy ()
	
} //end class MainActivity
