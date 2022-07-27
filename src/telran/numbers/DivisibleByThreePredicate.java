package telran.numbers;

import java.util.function.Predicate;

public class DivisibleByThreePredicate implements Predicate<Integer> {

	@Override
	public boolean test(Integer t) {
		return t % 3 == 0;
	}

}
