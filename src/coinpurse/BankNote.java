package coinpurse;

/**
 * 
 * 
 * @author Vichaphol Thamsuthikul
 *
 */
public class BankNote implements Valuable {

	// The next serial number of bank note
	private long nextSerialNumber = 1000000;
	// The value of bank note
	private double value;
	// The currency of bank note
	private String currency;
	// The serial number of bank note
	private long serialNumber;

	/**
	 * Constructor for creating object BankNote with value and currency.
	 * 
	 * @param value
	 * @param currency
	 * 
	 */
	public BankNote(double value, String currency) {
		this.value = value;
		this.currency = currency;
		this.serialNumber = nextSerialNumber;
	}

	/**
	 * Get the value of the bank note.
	 * 
	 * @return value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Get the currency of the bank note.
	 * 
	 * @return currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Get the serial number of the bank note.
	 * 
	 * @return serial number
	 */
	public long getSerialNumber() {
		return serialNumber;
	}

	/**
	 * Check if the value and currency are the same or not.
	 * 
	 * @param arg
	 * @return true if the value and currency are the same
	 */
	@Override
	public boolean equals(Object arg) {
		if (arg == null)
			return false;
		if (this.getClass() != arg.getClass())
			return false;
		BankNote other = (BankNote) arg;
		return this.value == other.value && this.currency.equals(other.currency);
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
