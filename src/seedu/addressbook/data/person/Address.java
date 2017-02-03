package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "a/123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must be entered in the following"
    		                                                + " format "+ "a/BLOCK, STREET, UNIT, POSTAL_CODE ";
    public static final String ADDRESS_VALIDATION_REGEX = "[^,]*,[^,]+,[^,]+,[^,\n]+";
    
    public static final int INDEX_BLOCK = 0;
    public static final int INDEX_STREET = 1;
    public static final int INDEX_UNIT = 2;
    public static final int INDEX_POSTALCODE = 3;

    public final Block block;
    public final Street street;
    public final Unit unit;
    public final PostalCode postalCode;
    
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        String[] splitTrimmedAddress = trimmedAddress.split(", ");
        int addressLength = splitTrimmedAddress.length;
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.block = addressLength > INDEX_BLOCK ? new Block(splitTrimmedAddress[INDEX_BLOCK]) : new Block("");
        this.street = addressLength > INDEX_STREET ? new Street(splitTrimmedAddress[INDEX_STREET]) : new Street("");
        this.unit = addressLength > INDEX_UNIT ? new Unit(splitTrimmedAddress[INDEX_UNIT]) : new Unit("");
        this.postalCode = addressLength > INDEX_POSTALCODE ? new PostalCode(splitTrimmedAddress[INDEX_POSTALCODE]) : new PostalCode("");
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
    	String address = block.getBlockNumber() + ", " + street.getStreet() + ", " + unit.getUnit() + ", " + 
    			postalCode.getPostalCode();
    	while (address.substring(address.length() - 2).equals(", ")) {
    		 address = address.substring(0, address.length() - 2);
    	}
    	return address;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.toString().equals(((Address) other).toString())); // state check
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
