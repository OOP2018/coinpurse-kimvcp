package coinpurse;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 * 
 * @author Vichaphol Thamsuthikul
 */

public class Coin implements Comparable<Coin> {
	// default value of coin
	private double value;
	// default currency of coin
	private String currency;

	/**
	 * Constructor for creating object coin with value and currency.
	 * 
	 * @param value
	 * @param currency
	 * 
	 */
	public Coin(double value, String currency) {
		if (value > 0) {
			this.value = value;
		}
		this.currency = currency;

	}

	/**
	 * Return the value of the coin.
	 * 
	 * @return value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Return the currency of the coin.
	 * 
	 * @return currency
	 */
	public String getCurrency() {
		return currency;
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
		Coin other = (Coin) arg;
		return this.value == other.value && this.currency == other.currency;
	}

	/**
	 * Compare to make the smaller value comes first.
	 * 
	 * @param other
	 *            coin's object
	 * @return 1 if the object coin has bigger value. -1 if the object coin has
	 *         smaller value. 0 if both has the same value.
	 */
	@Override
	public int compareTo(Coin coin) {
		if (this.getValue() > coin.getValue())
			return 1;
		else if (this.getValue() < coin.getValue())
			return -1;
		else
			return 0;
	}

	/**
	 * print the words.
	 * 
	 * @return the words
	 */
	@Override
	public String toString() {
		return String.format("%.0f-%s", value, currency);
	}

}
