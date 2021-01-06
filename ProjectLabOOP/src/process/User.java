package process;

import java.time.LocalDate;

public class User {
	protected String Fullname;
	protected String PIN;
	protected String Phonenumber;
	protected String ID;
	protected String Password;
	
	public User() {
		
	}
	public User(String pIN, String fullname, String phonenumber, String iD, String password) {
		super();
		Fullname = fullname;
		PIN = pIN;
		Phonenumber = phonenumber;
		ID = iD;
		Password = password;
	}
	
	public String getFullname() {
		return Fullname;
	}
	public void setFullname(String fullname) {
		Fullname = fullname;
	}
	public String getPIN() {
		return PIN;
	}
	public void setPIN(String pIN) {
		PIN = pIN;
	}
	public String getPhonenumber() {
		return Phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		Phonenumber = phonenumber;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
}
