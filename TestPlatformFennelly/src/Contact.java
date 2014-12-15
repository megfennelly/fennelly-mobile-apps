
public class Contact {
	//Fields
	private String lastname;
	private String firstname;
	private String email;
	private String cellphone;
	private String address;
	
	//Constructor
	public Contact(String ln,String fn) {
		lastname = ln;
		firstname = fn; }
		
	//Methods
	public String getName() {
		return firstname + " " + lastname;
	}
	public void setName (String last, String first) {
		lastname = last;
		firstname = first;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail (String em) {
		email = em;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone (String c) {
		cellphone = c;
	}
	public String getAddress () {
		return address;
	}
	public void setAddress (String a) {
		address = a;
	}
	

	
			
			
		
		
	}
	
	


