
public class Player {
	//Fields
	private String name; 
	private int position; 
	private String email;
	
	public Player (String n) {
		name = n; //Sets name
		position = 0; //Makes Position =0
	} //end constructor


	//Methods for our player
	public String getName() {
		return name; 
	}//end getName
		
	public int getPosition() {
		return position;
	}
	
	public void setPosition(int p) {
		position = p;
	}//end setPosition
	
	public void setEmail(String em) {
		email = em;
		
	}
	
	public String getEmail() {
		return email;
	}
}//end class player
	
	
	 

		
