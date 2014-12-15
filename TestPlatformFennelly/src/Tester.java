
public class Tester {

	/**
	 * @param args
	 */
	
		public static void main(String[] args) {
		//TODO Auto-generated method stub
		//Code for testing goes here
//		EnglishToSpanish dictionary = new EnglishToSpanish();
//		
//		dictionary.addEntry("cat", "gato");
//		dictionary.addEntry("kitchen", "cocina");
//	
//		String output = dictionary.translate("dog");
//	   System.out.println(output); }
		
	// Contact mk = new Contact ("Fennelly", "MK");
	// Contact meg = new Contact ("Fennelly", "Meg");
	 
	// meg.setEmail("megfennelly18@marist.com");
	// mk.setEmail("fennellym@marist.com");
	 
	// meg.setCellphone("404-932-2128");
	// mk.setCellphone("404-343-3198");
	 
	// mk.setAddress("1036 W Nancy Creek Dr.");
	// meg.setAddress("1036 W Nancy Creek Dr.");
	 
	 //System.out.println(mk.getName());
	 //System.out.println(meg.getName());
	// System.out.println(meg.getEmail());
	// System.out.println(mk.getEmail());
	// System.out.println(meg.getCellphone());
	// System.out.println(mk.getCellphone());
	// System.out.println(mk.getAddress());
	// System.out.println(meg.getAddress());
			
			EnglishToSpanish dictionary = new EnglishToSpanish();
		
		dictionary.addEntry("laugh", "rire");
		dictionary.addEntry("like", "aime");
		dictionary.addEntry("smile", "sourire");
		dictionary.addEntry("run", "course");
		dictionary.addEntry("jump", "sauter");
		
		String output = dictionary.translate("laugh");
	    System.out.println(output); 
		String output1 = dictionary.translate("like");
		System.out.println(output1); 
		String output2 = dictionary.translate("smile");
		System.out.println(output2);
		String output3 = dictionary.translate("run");
		System.out.println(output3);
		String output4 = dictionary.translate("jump");
		System.out.println(output4); }
	 
	 
	 
	 
	 
		}

	 
		
		
	
