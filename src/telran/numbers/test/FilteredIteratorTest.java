package telran.numbers.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.numbers.Range;
import telran.numbers.SrcIterator;
import telran.numbers.FilteredIterator;
import telran.numbers.NotTenPredicate;
import telran.numbers.NotZeroPredicate;
import telran.numbers.TruePredicate;

class FilteredIteratorTest {
	Range range = new Range(1,20);
	SrcIterator it = new SrcIterator(0,10);
	StringBuilder res = new StringBuilder();
	//SrcIterator itForNonValues = new SrcIterator(null, null);
	@BeforeEach
	void setUp() throws Exception {
		range = new Range(1,20);
		it = new SrcIterator(0,10);
		res = new StringBuilder("");
		}
	@Test
	void EmptyTest() {
		FilteredIterator<Integer> iter = new FilteredIterator<>(it, new TruePredicate().negate());
		while(iter.hasNext()) {
			try {
				res.append(iter.next());
			}catch(NullPointerException e) {}
			};
		
		assertEquals(res.toString(), "");
	}

	@Test
	void truePredicateTest() {
	FilteredIterator<Integer> iter = new FilteredIterator<>(it, new TruePredicate());
	while(iter.hasNext()) {
			res.append(iter.next()+" ");
		}
	assertEquals(res.toString(), "0 1 2 3 4 5 6 7 8 9 10 ");
	}
	@Test
	void firstPassedTest() {
	FilteredIterator<Integer> iter = new FilteredIterator<>(it, new NotZeroPredicate());
	while(iter.hasNext()) {
			res.append(iter.next()+" ");
		}
	assertEquals(res.toString(), "1 2 3 4 5 6 7 8 9 10 ");
	}
	@Test
	void lastPassedTest() {
	FilteredIterator<Integer> iter = new FilteredIterator<>(it, new NotTenPredicate());
	while(iter.hasNext()) {
		try {
			res.append(iter.next()+" ");
		}catch(NullPointerException e) {
		}
		}
	assertEquals(res.toString(), "0 1 2 3 4 5 6 7 8 9 ");
	}
	
}
