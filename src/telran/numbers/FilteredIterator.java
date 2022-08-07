package telran.numbers;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class FilteredIterator<T> implements Iterator<T> {
		private Iterator<T> srcIterator;
		private Predicate<T> filter;
		public FilteredIterator(Iterator<T> srcIterator, Predicate<T> filter) {
			this.srcIterator = srcIterator;
			this.filter = filter;
		} 
		T current; 
		
		@Override
		public boolean hasNext() {
			return srcIterator.hasNext();
		}
		T cur;
		boolean res = true;
		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			current = srcIterator.next();
			while(!filter.test(current)) {
				if(!srcIterator.hasNext()) {
					throw new NullPointerException();
				}
				current = srcIterator.next();
			}
			return current;
		}

	}