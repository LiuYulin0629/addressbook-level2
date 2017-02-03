package seedu.addressbook.data.person;

public class Street {
	private String _street;
	public Street(String streetName) {
		setStreet(streetName);
	}
	public void setStreet(String streetName){
		this._street = streetName;
	}
	public String getStreet(){
		return _street;
	}
}
