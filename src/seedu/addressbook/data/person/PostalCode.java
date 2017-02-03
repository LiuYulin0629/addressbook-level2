package seedu.addressbook.data.person;

public class PostalCode {
	private String _postalCode;
	public PostalCode(String postalCodeNumber) {
		setPostalCode(postalCodeNumber);
	}
	public void setPostalCode(String PostalCodeNumber){
		this._postalCode = PostalCodeNumber;
	}
	public String getPostalCode(){
		return _postalCode;
	}
}
