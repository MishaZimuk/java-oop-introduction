package telran.numbers;

import java.util.function.Predicate;

public class NotTenPredicate implements Predicate<Integer> {

	@Override
	public boolean test(Integer t) {
		return t!=10;
	}

}
