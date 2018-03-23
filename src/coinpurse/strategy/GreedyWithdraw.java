package coinpurse.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import coinpurse.Valuable;

/**
 * A strategy to withdraw the requested amount of money. using only items that
 * have the same currency as the parameter(amount). Return an array of money
 * withdrawn from list, or return null if cannot withdraw the amount requested.
 * 
 * @author Vichaphol Thamsuthikul
 *
 */
public class GreedyWithdraw implements WithdrawStrategy {
	/**
	 * 
	 * @param 
	 */
	public List<Valuable> withdraw(Valuable amount, List<Valuable> items) {
		List<Valuable> templist = new ArrayList<Valuable>();
		Collections.sort(items);
		Collections.reverse(items);
		double aValue = amount.getValue();
		if (aValue <= 0)
			return null;
		List<Valuable> tempCurrency = new ArrayList<>();
		for (Valuable valuable : items) {
			if (valuable.getCurrency().equals(amount.getCurrency()))
				tempCurrency.add(valuable);
		}
		for (Valuable value : tempCurrency) {
			if (value.getValue() <= aValue) {
				templist.add(value);
				aValue -= value.getValue();
			}
		}
		if (templist.size() == 0 || aValue != 0)
			return null;
		return templist;
	}
}
