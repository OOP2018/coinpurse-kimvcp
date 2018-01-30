package coinpurse;

import java.util.ArrayList;
import java.util.List;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

/**
 * A main class to test compareTo method.
 * 
 * @author Vichaphol Thamsuthikul
 */

public class MoneyUtil {

	/**
	 * Sort the list of coins and print the result on the console.
	 * 
	 * @param coin's
	 *            object
	 */
	public static void sortCoins(List<Coin> coin) {
		java.util.Collections.sort(coin);
		System.out.println("\n\tAfter Sorted\n");
		printCoins(coin);

	}

	/**
	 * Print the value and currency.
	 * 
	 * @param coin's
	 *            object
	 */
	public static void printCoins(List<Coin> coin) {
		for (int i = 0; i < coin.size(); i++) {
			System.out.println(coin.get(i));
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
		List<Coin> coins = new ArrayList<Coin>();
		coins.add(new Coin(10.0, "Baht"));
		coins.add(new Coin(20.0, "Dollar"));
		coins.add(new Coin(50.0, "Yen"));
		coins.add(new Coin(10.0, "Rupee"));
		coins.add(new Coin(30.0, "Peso"));
		printCoins(coins);
		sortCoins(coins);

	}

}
