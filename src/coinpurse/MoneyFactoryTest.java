package coinpurse;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * A class containing JUnit tests of MoneyFactory methods
 * 
 * @author Vichaphol Thamsuthikul
 *
 */
public class MoneyFactoryTest {
	
	/** Test if it is singleton or not */
	@Test
	public void TestSingleton() {
		MoneyFactory m = MoneyFactory.getInstance();
		MoneyFactory m2 = MoneyFactory.getInstance();
		assertTrue(m == m2);
	}
	
	/** Test if it is set or not */
	@Test
	public void TestSetFactory() {
		MoneyFactory m = MoneyFactory.getInstance();
		MoneyFactory.setFactory(new MalayMoneyFactory());
		MoneyFactory m2 = MoneyFactory.getInstance();
		assertFalse(m == m2);
	}

	/** Test if it is created the same value or not */
	@Test
	public void TestThaiFactory() {
		MoneyFactory m = MoneyFactory.getInstance();
		MoneyFactory m2 = MoneyFactory.getInstance();
		m.createMoney("100");
		m2.createMoney("100");
		assertTrue(m == m2);
	}

	/** Test if it is created the same value or not */
	@Test
	public void TestMalaysiaFactory() {
		MoneyFactory.setFactory(new MalayMoneyFactory());
		MoneyFactory m = MoneyFactory.getInstance();
		MoneyFactory m2 = MoneyFactory.getInstance();
		m.createMoney("100");
		m2.createMoney("100");
		assertTrue(m == m2);
	}
}
