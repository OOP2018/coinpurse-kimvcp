package coinpurse;

/**
 * Singleton class for creating money.
 * 
 * @author Vichaphol Thamsuthikul
 *
 */
public abstract class MoneyFactory {
	/** singleton instance of MoneyFactory. */
	private static MoneyFactory factory;

	/**
	 * Get an instance of MoneyFactory.
	 * 
	 * @return object of a subclass
	 */
	static MoneyFactory getInstance() {
		if (factory == null)
			setFactory(factory);
		return factory;
	}

	/**
	 * Create mew money object in the local currency. If the value is not a valid
	 * currency amount, then throw IllegalArgumentException.
	 * 
	 * @param value
	 * @throws IllegalArgumentException
	 */
	public abstract Valuable createMoney(double value) throws IllegalArgumentException;

	/**
	 * This method is for convenience of the U.I. The default implementation of this
	 * method converts parameter to a double and calls createMoney(double), but a
	 * subclass may override it to permit other parameter values.
	 * 
	 * @param value
	 * @return Valuable money
	 * @throws IllegalArgumentException
	 */
	Valuable createMoney(String value) {
		double money = 0;
		try {
			money = Double.parseDouble(value);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Can't be parsed as a double");
		}
		return createMoney(money);
	}

	/**
	 * Static method to a "set" the MoneyFactory object that is used. This is mostly
	 * for testing of MoneyFactory.
	 * 
	 * @param f
	 *            object of MoneyFactory
	 */
	static void setFactory(MoneyFactory f) {
		factory = f;
	}
}
