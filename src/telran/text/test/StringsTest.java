package telran.text.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.text.Strings;

class StringsTest {
	private static String[] dates = {"10/8/2021", "30/12/2020", "5/8/2021"};
	private static String[] expected = {"30/12/2020", "5/8/2021", "10/8/2021"};


	@Test
	void testSortStringsAsDates() {
		assertArrayEquals(Strings.sortStringsAsDates(dates), expected);
	}

}
