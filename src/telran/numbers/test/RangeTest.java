package telran.numbers.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.numbers.DivisibleByThreePredicate;
import telran.numbers.EvenNumbersPredicate;
import telran.numbers.OddNumbersPredicate;
import telran.numbers.Range;

class RangeTest {
	Range range = new Range(1,3);

	@BeforeEach
	void setUp() throws Exception {
		range = new Range(1, 3);
	}

	@Test
	void lengthTest() {
		assertEquals(3, range.length());
	}
	@Test
	void iterableNoPredicateTest() {
		int expected[] = {
				1, 2, 3
		};
		int actual[] = getActualArray(3);
		assertArrayEquals(expected, actual);
	}
	@Test
	void iterablePredicateTest() {
		//Test for HW #12
		int expected[] = {2};
		range.setPredicate(new EvenNumbersPredicate());
		int actual[] = getActualArray(1);
		assertArrayEquals(expected, actual);
		range.setPredicate(new OddNumbersPredicate());
		int expected1[] = {1, 3};
		int actual1[] = getActualArray(2);
		assertArrayEquals(expected1, actual1);
		int expected2[] = {3};
		range.setPredicate(new DivisibleByThreePredicate());
		int actual2[] = getActualArray(1);
		assertArrayEquals(expected2, actual2);
	}

	private int[] getActualArray(int size) {
		int [] res = new int[size];
		int ind = 0;
		for(int num: range) {
			res[ind++] = num;
		}
		return res;
	}

}
