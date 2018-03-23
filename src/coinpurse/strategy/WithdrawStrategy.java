package coinpurse.strategy;

import java.util.List;

import coinpurse.Valuable;

/**
 * Containing many strategies for Purse class to perform the work. Receiving the
 * information from the Context and, tell the Purse what to withdraw without
 * removing anything from the Purse, the strategy needs a reference to the items
 * in the Purse.
 * 
 * @author Vichaphol Thamsuthikul
 *
 */
public interface WithdrawStrategy {
	/**
	 * Find and return items from a collection whose total value equals the
	 * requested amount.
	 * 
	 * @param amount
	 *            of money to withdraw, with currency
	 * @param money
	 *            the contents that are available for possible withdraw. Must not be
	 *            null, but may be an empty list. This list is not modified.
	 * @return if a solution is found, return a List containing references from the
	 *         money parameter (List) whose sum equals the amount. If the solution
	 *         is not found, return null
	 */
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money);
}
