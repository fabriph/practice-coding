package problems;

import junit.framework.TestCase;

import org.junit.Test;

import problems.Problem17.Number;

public class Problem17Test extends TestCase {

	@Test
	public void test() {
		convert("one", 1);
		convert("two", 2);
		convert("three", 3);
		convert("four", 4);
		convert("five", 5);
		convert("six", 6);
		convert("seven", 7);
		convert("eight", 8);
		convert("nine", 9);

		convert("ten", 10);
		convert("eleven", 11);
		convert("twelve", 12);
		convert("thirteen", 13);
		convert("fourteen", 14);
		convert("fifteen", 15);
		convert("sixteen", 16);
		convert("seventeen", 17);
		convert("eighteen", 18);
		convert("nineteen", 19);

		convert("twenty", 20);
		convert("twenty-three", 23);
		convert("twenty-nine", 29);

		convert("thirty-one", 31);
		convert("thirty-six", 36);

		convert("one hundred and fifteen", 115);

		convert("three hundred and forty-two", 342);

		convert("one thousand", 1000);
	}

	private void convert(String expected, int number) {
		assertEquals(expected, Number.convertToText(number));
	}

}
