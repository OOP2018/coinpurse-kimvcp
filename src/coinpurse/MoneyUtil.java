package coinpurse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Iterator;

/**
 * A main class to test compareTo method.
 * 
 * @author Vichaphol Thamsuthikul
 */

public class MoneyUtil {

	/** Create a ValueComparator object */
	private static Comparator<Valuable> comparable = new ValueComparator();

	/**
	 * Sort the list of coins and print the result on the console.
	 * 
	 * @param coin's
	 *            object
	 */
	public static void sortValue(List<Valuable> value) {
		java.util.Collections.sort(value, comparable);
		System.out.println("\n\tAfter Sorted\n");
		printValue(value);

	}

	/**
	 * Print the value and currency.
	 * 
	 * @param coin's
	 *            object
	 */
	public static void printValue(List<Valuable> value) {
		for (int i = 0; i < value.size(); i++) {
			System.out.println(value.get(i));
		}

	}

	/*
	 * Filter the money by the currency.
	 * 
	 * @param value of the object
	 * 
	 * @param currency
	 * 
	 * @return list of the value that have the same currency
	 */
	public static List<Valuable> filterByCurrency(List<Valuable> money, String currency) {
		List<Valuable> compCurrency = new ArrayList<>();
		for (Valuable value : compCurrency) {
			if (value.getCurrency().equals(currency))
				compCurrency.add(value);
		}
		return compCurrency;
	}

	/**
	 * Main for testing compareTo method
	 * 
	 * @param args
	 *            is not used
	 */
	public static void main(String[] args) {
		List<Valuable> coins = new ArrayList<Valuable>();
		coins.add(new Coin(10.0, "Baht"));
		coins.add(new Coin(20.0, "Dollar"));
		coins.add(new Coin(50.0, "Yen"));
		coins.add(new Coin(10.0, "Rupee"));
		coins.add(new Coin(30.0, "Peso"));
		printValue(coins);
		sortValue(coins);

	}

}
