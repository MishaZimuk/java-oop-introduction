package telran.numbers;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class Range implements Iterable<Integer> {

	private int min; // inclusive
	private int max; // inclusive

	private class RangeIterator implements Iterator<Integer> {
		int current = min; 
		@Override
		public boolean hasNext() {
			return current <= max;
		}

		@Override
		public Integer next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
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