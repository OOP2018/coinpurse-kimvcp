package coinpurse.strategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import coinpurse.Coin;
import coinpurse.Money;
import coinpurse.Purse;
import coinpurse.Valuable;

/**
 * This is the JUnit 4 test for the strategy of Greedy withdraw.
 * 
 * @author Vichaphol Thamsuthikul
 *
 */
public class WithdrawTest {
	private WithdrawStrategy strategy;
	private List<Valuable> money;

	/**
	 * Code to run before each test. Setup the "text fixture".
	 */
	@Before
	public void setUp() {
		money = new ArrayList<>();
		strategy = new GreedyWithdraw();
	}

	/** clear every time the method ends */
	@Before
	public void init() {
		money.clear();
	}

	/** Make money with the default currency. To save typing "new Money(...)" */
	private Money makeMoney(double value) {
		return new Money(value, "Baht");
	}

	/** Test if the withdraw's money is null or not */
	@Test
	public void testWithdrawEmpty() {
		List<Valuable> money2 = strategy.withdraw(makeMoney(50), money);
		assertNull(money2);
	}

	/** Test withdraw everything in the list */
	@Test
	public void testWithdrawEverything() {
		money.add(makeMoney(10));
		money.add(makeMoney(40));
		strategy.withdraw(makeMoney(50), money);
		assertTrue(money.size() == 0);
	}

	/** Test if it can withdraw bigger amount of money in the list or not */
	@Test
	public void testWithdrawOver() {
		money.add(makeMoney(50));
		List<Valuable> money2 = strategy.withdraw(makeMoney(60), money);
		assertNull(money2);
	}

	/** Test the strategy of withdraw */
	@Test
	public void testWithdrawStrategy() {
		money.add(makeMoney(50));
		List<Valuable> money2 = strategy.withdraw(makeMoney(40), money);
		assertTrue(money.contains(makeMoney(50)));
	}

	/** Test if it withdraw and left one value or not */
	@Test
	public void testWithdrawExceptOne() {
		money.add(makeMoney(10));
		money.add(makeMoney(15));
		money.add(makeMoney(10));
		strategy.withdraw(makeMoney(25), money);
		assertTrue(money.size() == 1);
	}

	/** Test if it can withdraw negative value or not */
	@Test
	public void testWithdrawNegative() {
		money = strategy.withdraw(makeMoney(-25), money);
		assertNull(money);
	}

}
