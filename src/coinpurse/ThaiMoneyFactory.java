package coinpurse;

/**
 * A class for creating Thai's money
 * 
 * @author Vichaphol Thamsuthikul
 *
 */
public class ThaiMoneyFactory extends MoneyFactory {
	// The next serial number of bank note
	private long nextSerialNumber = 1000000;

	/**
	 * Create Money according to the value with the currency(Baht).
	 * 
	 * @param value
	 *            to create
	 * @throws IllegalArgumentException
	 */
	@Override
	public Valuable createMoney(double value) throws IllegalArgumentException {
		double money[] = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
		for (int i = 0; i < money.length; i++) {
			if (value > 20 && value <= 1000) {
				if (money[i] == value)
					return new BankNote(money[i], "Baht", nextSerialNumber++);
			} else if (value > 0 && value <= 10) {
				if (money[i] == value)
					return new Coin(money[i], "Baht");
			}

		}
		throw new IllegalArgumentException("Sorry, "+value+" is not valid.");
	}

}
