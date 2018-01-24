package coinpurse;

import java.util.ArrayList;
import java.util.List;

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
	 * 
	 * 
	 * @param coins' object
	 * 
	 * @param currency
	 * 
	 * @return list of Coins that contains only the coins from coins
	 */
	public static List<Coin> filterByCurrency(List<Coin> coins, String currency) {
		List<Coin> coinList = new ArrayList<>();
		for (Coin coin : coins) {
			if (coin.getCurrency().equals(currency))
				coinList.add(coin);
		}
		return coinList;
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
