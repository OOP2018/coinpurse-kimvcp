package coinpurse;

/**
 * The class which contains the monetary attributes such as value and currency.  
 *  
 * @author Vichaphol Thamsuthikul
 *
 */
public class Money implements Valuable {
	// protected value
	protected double value;
	// protected currency
	protected String currency;

	/**
	 * Initialize the value and currency of the money.
	 * 
	 * @param value
	 * @param currency
	 */
	public Money(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	/**
	 * Return the value of the money.
	 * 
	 * @return value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Return the currency of the money.
	 * 
	 * @return currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Compare two objects that implement Valuable. First compare them by currency,
	 * so that "Baht" < "Dollar". If both objects have the same currency, order them
	 * by value.
	 * 
	 * @param o
	 *            valuable object
	 * @return 1 if the object coin has bigger value and currency. -1 if the object
	 *         coin has smaller value and currency. 0 if both has the same value.
	 */
	@Override
	public int compareTo(Valuable o) {
		if (this.getCurrency().equals(o.getCurrency())) {
			if (this.getValue() > o.getValue())
				return 1;
			else if (this.getValue() < o.getValue())
				return -1;
			else
				return 0;
		}
		return this.getCurrency().compareTo(o.getCurrency());
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
		Money other = (Money) arg;
		return this.value == other.value && this.currency.equals(other.currency);
	}

}