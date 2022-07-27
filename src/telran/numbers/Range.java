package telran.numbers;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class Range implements Iterable<Integer> {

	// closed range
	private int min; // inclusive
	private int max; // inclusive
	private Predicate<Integer> predicate;

	public Predicate<Integer> getPredicate() {
		return predicate;
	}

	public void setPredicate(Predicate<Integer> predicate) {
		this.predicate = predicate;
	}

	private class RangeIterator implements Iterator<Integer> {
		// If predicate == null all range numbers should be iterated
		int current = predicate == null ? min : getFirstCurrent(); // TODO update method for iterating only numbers
																	// matching the predicate

		@Override
		public boolean hasNext() {
			// TODO
			// update method for iterating only numbers matching the predicate
			int lastCurrent = predicate == null ? max : getLastCurrent();
			return current <= lastCurrent;
		}

		private int getLastCurrent() {
			int current = max;
			while (!predicate.test(current)) {
				current--;
			}
			;
			return current;
		}

		private int getFirstCurrent() {
			int current = min;
			while (!predicate.test(current)) {
				current++;
			}
			;
			// System.out.println(current);
			return current;
		}

		@Override
		public Integer next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			// TODO
			// update method for iterating only numbers matching the predicate
			if (predicate != null) {
				while (!predicate.test(current)) {
					current++;
				}
			}
			return current++;
		}

	}

	public Range(int min, int max) {

		this.min = min;
		this.max = max;
	}

	@Override
	public Iterator<Integer> iterator() {

		return new RangeIterator();
	}

	public int length() {
		return max - min + 1;
	}

}