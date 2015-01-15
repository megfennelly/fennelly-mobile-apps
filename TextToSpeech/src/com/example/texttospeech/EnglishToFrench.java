package com.example.texttospeech;

import java.util.ArrayList;
import java.util.List;

public class EnglishToFrench {

	//Field to hold String Arrays
	private List<String []> dictionary;
	

//Constructor
public EnglishToFrench () {
	//initialize dictionary List
	dictionary = new ArrayList<String []>(0);
	
	//Add some words to the dictionary
	addEntry("car", "velo");
	addEntry("dog", "chien");
	addEntry("often","souvent");
	addEntry("eat", "manger");
	addEntry("living room", "salon");
	addEntry("in", "a");
	addEntry("skirt", "jupe");
	addEntry("shirt", "blouse");
	addEntry("television", "tele");
	addEntry("wash", "laver");
	addEntry("mom", "mere");
	
} //end Constructor 

	//Add words to the dictionary List
	public void addEntry(String e, String s) {
		String entry [] = {e, s};
		dictionary.add(entry);
		} //end addEntry
	
	//Returns the dictionary object
	public List <String []> getDictionary() {
		return dictionary;
	} //end getDictionary
}
