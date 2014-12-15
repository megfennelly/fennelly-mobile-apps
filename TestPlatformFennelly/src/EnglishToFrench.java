	import java.util.ArrayList;
	import java.util.List;

	public class EnglishToFrench {
		private List<String []> dictionary;
		
		public EnglishToFrench() {
			dictionary = new ArrayList<String []>(0);
			
			addEntry("smile", "sourire");
			addEntry("laugh", "rire");
			addEntry("run", "course");
			addEntry("jump", "sauter");
			addEntry("like", "aime");
		}
		
		public void addEntry(String e, String s) {
			String entry [] = {e, s};
			dictionary.add(entry); }
			
			//translate
			public String translate(String s) {
				String result = ""; //Blank Word
				
				//Search for Translation
				for (int w = 0; w < dictionary.size(); w++) {
					if (s.equals(dictionary.get(w)[0])) {
						result = dictionary.get(w)[1]; // get match
					}
				}
				if (result.equals("")) {
					result = s; //set to incoming word
				}
				return result; //give back to program
				
			} //end translate
		
		{

	}
}
