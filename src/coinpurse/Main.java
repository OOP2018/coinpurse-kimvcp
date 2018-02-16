package coinpurse;

import java.io.FileReader;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * A main class to create objects and connect objects together. The user
 * interface needs a reference to coin purse.
 * 
 * @author Vichaphol Thamsuthikul
 */
public class Main {
	/**
	 * Configure and start the application.
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		MoneyFactory.setFactory(FilesReader.readFiles());
		// 1. create a Purse
		Purse purse = new Purse(10);
		// 2. create a ConsoleDialog with a reference to the Purse object
		ConsoleDialog ui = new ConsoleDialog(purse);
		// 3. run the ConsoleDialog
		ui.run();
	}

}
