package telran.numbers;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SrcIterator implements Iterator<Integer> {
	int min;
	int max;
	public SrcIterator(int min, int max) {
		super();
		this.min = min;
		this.max = max;
	}
	int current = min;
	@Override
	public boolean hasNext() {
		return current <= max;
	}

	@Override
	public Integer next() {
		if(!hasNext()) {
			throw new NoSuchElementException();
		}
		return current++;
	}

}
