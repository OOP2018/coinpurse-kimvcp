package coinpurse.strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.Money;
import coinpurse.Valuable;

public class RecursiveWithdraw implements WithdrawStrategy {
	public List<Valuable> withdraw(Valuable amount, List<Valuable> items) {
		double value = amount.getValue();
		if (value < 0)
			return null;
		if (value != 0 && items.size() == 0)
			return null;
		if (value == 0)
			return new ArrayList<>();
		Valuable cutMoney = new Money((value - items.get(0).getValue()), "Baht");
		List<Valuable> rest = items.subList(1, items.size());
		List<Valuable> chooseList = withdraw(cutMoney, rest);
		List<Valuable> notChoose = withdraw(amount, rest);
		if (chooseList != null) {
			chooseList.add(items.get(0));
			return chooseList;
		}
		return notChoose;

	}
}
