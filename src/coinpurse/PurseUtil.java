package coinpurse;

/**
 * A utility class to test many methods in purse class.
 * 
 * @author Vichaphol Thamsuthikul
 */
public class PurseUtil {
	/**
	 * Main for testing methods.
	 * 
	 * @param args
	 *            is not used
	 */
	public static void main(String[] args) {
		Purse purse = new Purse(4);
		purse.insert(new Money(3, "Dollar"));
		purse.insert(new Money(5, "Baht"));
		purse.insert(new Money(7, "BTC"));
		purse.insert(new Money(10, "Dollar"));
		System.out.println("There are " + purse.count() + " objects\n");
		System.out.println("Total: " + purse.getBalance());
		System.out.println("\nIs it full?");
		System.out.println(purse.isFull());
		System.out.println("\n\t\t-Before withdraw-");
		System.out.println(purse.toString());
		System.out.println("\n\t\t-After withdraw(Dollar)-");
		purse.withdraw(new Money(10, "Dollar"));
		System.out.println(purse.toString());
	}
}