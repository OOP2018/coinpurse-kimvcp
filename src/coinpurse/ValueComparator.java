package coinpurse;

import java.util.Comparator;

/**
 * A class having a method to compare the value.
 * 
 * @author Vichaphol Thamsuthikul
 */
public class ValueComparator implements Comparator<Valuable> {
	/**
	 * Compare two objects that implement Valuable. First compare them by currency,
	 * so that "Baht" < "Dollar". If both objects have the same currency, order them
	 * by value.
	 * 
	 * @param object
	 *            a to compare
	 * @param object
	 *            b to compare
	 * @return 1 if the object coin has bigger value and currency. -1 if the object
	 *         coin has smaller value and currency. 0 if both has the same value.
	 */
	public int compare(Valuable a, Valuable b) {
		if (a.getCurrency().equals(b.getCurrency())) {
			if (a.getValue() > b.getValue())
				return 1;
			else if (a.getValue() < b.getValue())
				return -1;
			else
				return 0;
		}
		return a.getCurrency().compareTo(b.getCurrency());
	}

}
