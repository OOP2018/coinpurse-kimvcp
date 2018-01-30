package coinpurse;

import java.util.ArrayList;
import java.util.List;
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
	 * Withdraw the requested amount of money. Return an array of money withdrawn
	 * from purse, or return null if cannot withdraw the amount requested.
	 * 
	 * @param amount
	 * 
	 *            is the amount to withdraw
	 * @return array of objects for money withdrawn, or null if cannot withdraw
	 *         requested amount.
	 */
	public Valuable[] withdraw(double amount) {
		Comparator<Valuable> comparable = new ValueComparator();
		List<Valuable> templist = new ArrayList<Valuable>();
		Collections.sort(money, comparable);
		Collections.reverse(money);
		if (amount <= 0)
			return null;
		for (Valuable value : money) {
			if (value.getValue() <= amount) {
				templist.add(value);
				amount -= value.getValue();
			}
		}

		/*
		 * See lab sheet for outline of a solution, or devise your own solution. The
		 * idea is to be greedy. Try to withdraw the largest money possible. Each time
		 * you choose a money as a candidate for withdraw, add it to a temporary list
		 * and decrease the amount (remainder) to withdraw.
		 * 
		 * If you reach a point where amountNeededToWithdraw == 0 then you found a
		 * solution! Now, use the temporary list to remove money from the money list,
		 * and return the temporary list (as an array).
		 */

		// Did we get the full amount?
		// This code assumes you decrease amount each time you remove a money.
		// Your code might use some other variable for the remaining amount to withdraw.

		if (amount == 0) {
			for (Valuable value : templist) {
				money.remove(value);
			}
			// failed. Don't change the contents of the purse.

		} else {
			return null;
		}
		// Success.
		// Remove the money you want to withdraw from purse,
		// and return them as an array.
		// Use list.toArray( array[] ) to copy a list into an array.
		// toArray returns a reference to the array itself.

		Valuable[] array = new Valuable[templist.size()];
		return templist.toArray(array);

	}

	/**
	 * toString returns a string description of the purse contents. It can return
	 * whatever is a useful description.
	 */
	public String toString() {
		return String.format("The total money are %d with the value of %f", this.count(), this.getBalance());
	}

}
