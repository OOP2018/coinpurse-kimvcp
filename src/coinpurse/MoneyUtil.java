package coinpurse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

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
	 * Return the larger argument, based on sort order, using the objects' own
	 * compareTo method for comparing.
	 * 
	 * @param args
	 *            one or more Comparable objects to compare.
	 * @return the argument that would be last if sorted the elements.
	 * @throws IllegalArgumentException
	 *             if no arguments given.
	 */
	public static <E extends Comparable<? super E>> E max(E... args) {
		E max = args[0];
		try {

			for (int i = 0; i < args.length; i++) {
				if (max.compareTo(args[i]) < 0)
					max = args[i];
			}
		} catch (NullPointerException e) {
			throw new IllegalArgumentException();
		}
		return max;

	}

	/**
	 * Sort the list of coins and print the result on the console.
	 * 
	 * @param coin's
	 *            object
	 */
	public static void sortMoney(List<? extends Valuable> money) {
		java.util.Collections.sort(money, comparable);
		System.out.println("\n\tAfter Sorted\n");
		printValue(money);

	}

	/**
	 * Print the value and currency.
	 * 
	 * @param coin's
	 *            object
	 */
	public static void printValue(List<? extends Valuable> money) {
		for (int i = 0; i < money.size(); i++) {
			System.out.println(money.get(i));
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
	public static <E extends Valuable> List<E> filterByCurrency(List<E> money, String currency) {
		List<E> compCurrency = new ArrayList<>();
		for (E value : money) {
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
		// List<Valuable> coins = new ArrayList<Valuable>();
		// coins.add(new Coin(10.0, "Baht"));
		// coins.add(new Coin(20.0, "Dollar"));
		// coins.add(new Coin(50.0, "Yen"));
		// coins.add(new Coin(10.0, "Rupee"));
		// coins.add(new Coin(30.0, "Peso"));
		// printValue(coins);
		// sortMoney(coins);

		List<BankNote> list = new ArrayList<BankNote>();
		list.add(new BankNote(10.0, "USD", 100));
		list.add(new BankNote(500.0, "Baht", 101));
		MoneyUtil.sortMoney(list);

		Money m1 = new BankNote(100.0, "Baht", 100);
		Money m2 = new BankNote(500.0, "Baht", 101);
		Money m3 = new Coin(20, "Baht");
		Money max = MoneyUtil.max(m1, m2, m3);
		String max1 = MoneyUtil.max("dog", "zebra", "cat");
		System.out.println(max);
		System.out.println(max1);

		List<Coin> coins = Arrays.asList(new Coin(5, "Baht"), new Coin(0.1, "Ringgit"), new Coin(5, "Cent"));
		List<Coin> result = MoneyUtil.filterByCurrency(coins, "Baht");
		printValue(result);
	}

}
