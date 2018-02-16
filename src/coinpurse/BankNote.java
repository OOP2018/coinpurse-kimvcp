package coinpurse;

/**
 * Bank note with the value, currency, and serial number
 * 
 * @author Vichaphol Thamsuthikul
 */
public class BankNote extends Money {

	// The serial number of bank note
	private long serialNumber;

	/**
	 * Constructor for creating object BankNote with value and currency.
	 * 
	 * @param value
	 * @param currency
	 * 
	 */
	public BankNote(double value, String currency, long serialNumber) {
		super(value, currency);
		this.serialNumber = serialNumber;

	}

	/**
	 * Get the serial number of the bank note.
	 * 
	 * @return serial number
	 */
	public long getSerial() {
		return serialNumber;
	}

	/**
	 * print the words.
	 * 
	 * @return the words
	 */
	@Override
	public String toString() {
		return String.format("%.0f-%s note [%d]", value, currency, serialNumber);
	}

}
