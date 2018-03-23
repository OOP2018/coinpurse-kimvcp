package coinpurse;

import java.util.ArrayList;
import java.util.List;

import coinpurse.strategy.GreedyWithdraw;
import coinpurse.strategy.RecursiveWithdraw;
import coinpurse.strategy.WithdrawStrategy;

import java.util.Collections;
import java.util.Comparator;

/**
 * A coin purse contains coins. You can insert coins, withdraw money, check the
 * balance, and check if the purse is full.
 * 
 * @author Vichaphol Thamsuthikul
 */
public class Purse {
	/** Collection of objects in the purse. */
	List<Valuable> money;
	private WithdrawStrategy strategy;
	/** Create a ValueComparator object */
	private Comparator<Valuable> comparable = new ValueComparator();

	/**
	 * Capacity is maximum number of items the purse can hold. Capacity is set when
	 * the purse is created and cannot be changed.
	 */
	private final int capacity;

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity
	 *            is maximum number of money you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
		money = new ArrayList<Valuable>();
		setWithdrawStrategy(new GreedyWithdraw());
	}

	/**
	 * Count and return the number of money in the purse. This is the number of
	 * money, not their value.
	 * 
	 * @return the number of bank notes in the purse
	 */
	public int count() {

		return money.size();
	}

	/**
	 * Get the total value of all items in the purse.
	 * 
	 * @return the total value of items in the purse.
	 */
	public double getBalance() {
		double sum = 0;
		for (Valuable value : money) {
			sum = sum + value.getValue();
		}
		return sum;
	}

	/**
	 * Return the capacity of the money in the purse.
	 * 
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * Test whether the purse is full. The purse is full if number of items in purse
	 * equals or greater than the purse capacity.
	 * 
	 * @return true if purse is full.
	 */
	public boolean isFull() {
		return money.size() >= capacity;
	}

	/**
	 * Insert a money into the purse. The money is only inserted if the purse has
	 * space for it and the money has positive value. No worthless money!
	 * 
	 * @param value
	 *            is a valuable's object to insert into purse
	 * @return true if money inserted, false if can't insert
	 */
	public boolean insert(Valuable value) {
		if (value.getValue() <= 0 || isFull())
			return false;
		money.add(value);
		return true;
	}

	/**
	 * Withdraw the requested amount of money. using only items that have the same
	 * currency as the parameter(amount). Return an array of money withdrawn from
	 * purse, or return null if cannot withdraw the amount requested.
	 * 
	 * @param amount
	 * 
	 *            is the amount to withdraw
	 * @return array of objects for money withdrawn, or null if cannot withdraw
	 *         requested amount.
	 */
	public Valuable[] withdraw(Valuable amount) {
		List<Valuable> withdrawList = strategy.withdraw(amount, money);
		if (withdrawList == null)
			return null;
		for (Valuable value : withdrawList) {
			money.remove(value);
		}
		Valuable[] array = new Valuable[withdrawList.size()];
		return withdrawList.toArray(array);

	}

	/**
	 * Withdraw the requested amount of money using default currency. Return an
	 * array of money withdrawn from purse, or return null if cannot withdraw the
	 * amount requested.
	 * 
	 * @param amount
	 * 
	 *            is the amount to withdraw
	 * @return array of objects for money withdrawn, or null if cannot withdraw
	 *         requested amount.
	 */
	public Valuable[] withdraw(double amount) {
		Money money = new Money(amount, "Baht");
		return withdraw(money);
	}

	public void setWithdrawStrategy(WithdrawStrategy strategy) {
		this.strategy = strategy;
	}

	/**
	 * toString returns a string description of the purse contents. It can return
	 * whatever is a useful description.
	 */
	public String toString() {
		return String.format("This purse has %d object with the value of %.2f", this.count(), this.getBalance());
	}

}
