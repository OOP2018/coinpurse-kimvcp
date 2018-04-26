package coinpurse;

/**
 * A class for creating Malaysia's money
 * 
 * @author Vichaphol Thamsuthikul
 *
 */
public class MalayMoneyFactory extends MoneyFactory {
	// The next serial number of bank note
	private long nextSerialNumber = 1000000;

	/**
	 * Create Money according to the value with the currency(Ringgit).
	 * 
	 * @param value
	 *            to create
	 * @return Valuable object
	 * @throws IllegalArgumentException
	 */

	@Override
	public Valuable createMoney(double value) throws IllegalArgumentException {
		double money[] = { 0.05, 0.10, 0.20, 0.50, 1, 2, 5, 10, 20, 50, 100 };
		for (int i = 0; i < money.length; i++) {
			if (value >= 1 && value <= 100) {
				if (money[i] == value)
					return new BankNote(money[i], "Ringgit", nextSerialNumber++);
			} else if (value > 0 && value <= 0.50) {
				if (money[i] == value)
					return new Coin(money[i], "Ringgit");
			}

		}
		throw new IllegalArgumentException("Sorry, " + value + " is not valid.");
	}
}
