package coinpurse;

import java.util.ResourceBundle;

/**
 * A class for reading a properties file.
 * 
 * @author Vichaphol Thamsuthikul
 *
 */
public class FilesReader {
	/**
	 * Read a properties file
	 * 
	 * @return factory object
	 */
	public static MoneyFactory readFiles() {
		ResourceBundle bundle = ResourceBundle.getBundle("purse");
		String factoryclass = bundle.getString("moneyfactory");
		MoneyFactory factory = null;
		try {
			factory = (MoneyFactory) Class.forName(factoryclass).newInstance();
		} catch (ClassCastException cce) {
			System.out.println(factoryclass + " is not type MoneyFactory");
		} catch (Exception ex) {
			System.out.println("Error creating MoneyFactory " + ex.getMessage());
		}
		if (factory == null)
			System.exit(1);
		return factory;
	}
}
