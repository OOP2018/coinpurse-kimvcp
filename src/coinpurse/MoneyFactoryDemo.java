package coinpurse;

/**
 * Test class to create a MoneyFactory and call its methods. Print results on
 * the console.
 * 
 * @author Vichaphol Thamsuthikul
 *
 */
public class MoneyFactoryDemo {
	/**
	 * Start testing.
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		/** Thai factory */
		ThaiMoneyFactory thaiMoneyFactory = new ThaiMoneyFactory();
		MoneyFactory.setFactory(thaiMoneyFactory);
		MoneyFactory factory = MoneyFactory.getInstance();
		Valuable t = factory.createMoney("1");
		System.out.println(t.toString());
		/** Malaysia factory */
		MalayMoneyFactory malayMoneyFactory = new MalayMoneyFactory();
		MoneyFactory.setFactory(malayMoneyFactory);
		factory = MoneyFactory.getInstance();
		Valuable m = factory.createMoney("0.2");
		System.out.println(m.toString());
	}
}
