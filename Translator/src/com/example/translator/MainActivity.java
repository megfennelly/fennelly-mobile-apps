package com.example.translator;

import java.util.ArrayList;
import java.util.List;

import android.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {
	
	//DEfine the dictionary field for Translations
	private EnglishToSpanish dictionary;
	
	//Fields for UI
	private EditText editEnglish;
	private EditText editTranslate;
	private Button buttonTranslateWord;
	private Button buttonAddWord;
	private Button buttonPhrase;
	private Button buttonSpeak;
	private Button buttonClear;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Initialize the dictionary
		dictionary = new EnglishToSpanish();
		
		//Bind to XML objects
		editEnglish = (EditText)findBiewById(R.id.editEnglish);
		editTranslate = (EditText)findViewById(R.id.editTranslate);
		buttonTranslateWord = (Button)findViewById(R.id.buttonTranslateWord);
		buttonPhrase = (Button)findViewById(R.id.buttonPhrase);
		buttonSpeak = (Button)findViewById(R.id.buttonSpeak);
		buttonClear = (Button)findViewById(R.id.buttonClear);
	
	}//end on Create
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
		
	}
		
		//REturns a List of words parsed from a string
		public List<String> getParsed(String s) {
			// establish a blank List to return
			List <String> words = new ArrayList<String> (0);
			//transfer content of s to phrase
			String phrase = s;
			//Convert phrase to lower case
			phrase.toLowerCase();
			//Define current word
			String currentWord = ""; //blank 
			//Create an array of char objects from string
			char [] charList = phrase.toCharArray();
			
			//For loop to search characters and pull out words
			for (int i=0; i < charList.length; i++) {
				//is the char not a space
				if (!String.valueOf(charList[i]).equals(" ")) {
					currentWord += String.valueOf(charList[i]); //add letter
					}
				else {
					words.add(currentWord); //put currentWord in List
					currentWord = ""; //Blank out currentWord
				}
			}
			
			//Check for word at end
			if (currentWord.length() >0) {
				words.add(currentWord); }
						
			return words; 
			}
			
			//Translates a string of words and returns a string with translation
			public String translate(String s) {
				String result = "";
				
				//Define a Blank List
				List<String> words = getParsed(s);
				Object dictionary;
				//Define a List of available translations
				List<String []> bank = (dictionary).getDictionary();
				
				//For words in the list words
				for (int i = 0; i < words.size(); i++) {
					//Search for the match in the bank list
					for (int w = 0; w < bank.size(); w++) {
						if (words.get(i)equals(bank.get(w)[0])) {
							result += bank.get(w) [1];
							result += " ";
							
						}//end if
					}//end for
				}//end for
				return result; 
		}//end translate
		

}//end getParsed ()

