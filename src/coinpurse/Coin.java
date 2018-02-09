package coinpurse;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 * 
 * @author Vichaphol Thamsuthikul
 */

public class Coin extends Money {
	
	/**
	 * Constructor for creating object coin with value and currency.
	 * 
	 * @param value
	 * @param currency
	 * 
	 */
	public Coin(double value, String currency) {
		super(value, currency);

	}

	/**
	 * print the words.
	 * 
	 * @return the words
	 */
	@Override
	public String toString() {
		return String.format("%.0f-%s", this.getValue(), this.getCurrency());
	}

}
