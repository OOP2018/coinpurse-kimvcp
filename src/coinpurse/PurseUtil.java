package coinpurse;

public class PurseUtil {
	public static void main(String[] args) {
		Purse purse = new Purse(4);
		purse.insert(new Coin(3, "Dollar"));
		purse.insert(new Coin(5, "Dollar"));
		purse.insert(new BankNote(7, "Dollar"));
		purse.insert(new BankNote(10, "Dollar"));
		System.out.println("There are " + purse.count() + " objects\n");
		System.out.println("Total: " + purse.getBalance());
		System.out.println("\nIs it full?");
		System.out.println(purse.isFull());
		System.out.println("\n\t\t-Before withdraw-");
		System.out.println(purse.toString());
		purse.withdraw(10);
		System.out.println("\n\t\t-After withdraw-");
		System.out.println(purse.toString());
	}
}