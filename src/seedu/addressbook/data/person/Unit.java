package seedu.addressbook.data.person;

public class Unit {
	private String _unit;
	public Unit(String unitNumber) {
		setUnit(unitNumber);
	}
	public void setUnit(String UnitNumber){
		this._unit = UnitNumber;
	}
	public String getUnit(){
		return _unit;
	}
}
