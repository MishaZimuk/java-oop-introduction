package telran.numbers;

import java.util.function.Predicate;

public class NotZeroPredicate implements Predicate<Integer> {

	@Override
	public boolean test(Integer t) {
		return t!=0;
	}

}
