package utils.test;

import java.util.LinkedList;

import junit.framework.TestCase;

import org.junit.Test;

import utils.PrimeNumbers;

public class PrimeNumbersTest extends TestCase {

	@Test
	public void testCountDivisors() {
		assertEquals(2, PrimeNumbers.countDivisors(2));
		assertEquals(2, PrimeNumbers.countDivisors(3));
		assertEquals(3, PrimeNumbers.countDivisors(4));
		assertEquals(2, PrimeNumbers.countDivisors(5));
		assertEquals(4, PrimeNumbers.countDivisors(6));
		assertEquals(2, PrimeNumbers.countDivisors(7));
		assertEquals(4, PrimeNumbers.countDivisors(8));
		assertEquals(3, PrimeNumbers.countDivisors(9));
		assertEquals(4, PrimeNumbers.countDivisors(10));
		assertEquals(2, PrimeNumbers.countDivisors(11));
		assertEquals(6, PrimeNumbers.countDivisors(12));
		assertEquals(2, PrimeNumbers.countDivisors(13));
		assertEquals(4, PrimeNumbers.countDivisors(14));
		assertEquals(4, PrimeNumbers.countDivisors(15));
		assertEquals(5, PrimeNumbers.countDivisors(16));
		assertEquals(2, PrimeNumbers.countDivisors(17));
		assertEquals(6, PrimeNumbers.countDivisors(18));
		assertEquals(2, PrimeNumbers.countDivisors(19));
		assertEquals(6, PrimeNumbers.countDivisors(20));
		assertEquals(4, PrimeNumbers.countDivisors(21));
		assertEquals(4, PrimeNumbers.countDivisors(22));
		assertEquals(2, PrimeNumbers.countDivisors(23));
		assertEquals(8, PrimeNumbers.countDivisors(24));
		assertEquals(3, PrimeNumbers.countDivisors(25));
		assertEquals(4, PrimeNumbers.countDivisors(26));
		assertEquals(4, PrimeNumbers.countDivisors(27));
		assertEquals(6, PrimeNumbers.countDivisors(28));
		assertEquals(2, PrimeNumbers.countDivisors(29));
		assertEquals(8, PrimeNumbers.countDivisors(30));
		assertEquals(2, PrimeNumbers.countDivisors(31));
		assertEquals(6, PrimeNumbers.countDivisors(32));
		assertEquals(4, PrimeNumbers.countDivisors(33));
		assertEquals(4, PrimeNumbers.countDivisors(34));
		assertEquals(4, PrimeNumbers.countDivisors(35));
		assertEquals(9, PrimeNumbers.countDivisors(36));
		assertEquals(2, PrimeNumbers.countDivisors(37));
		assertEquals(4, PrimeNumbers.countDivisors(38));
		assertEquals(4, PrimeNumbers.countDivisors(39));
		assertEquals(8, PrimeNumbers.countDivisors(40));
		assertEquals(2, PrimeNumbers.countDivisors(41));
		assertEquals(8, PrimeNumbers.countDivisors(42));
		assertEquals(2, PrimeNumbers.countDivisors(43));
		assertEquals(6, PrimeNumbers.countDivisors(44));
		assertEquals(6, PrimeNumbers.countDivisors(45));
		assertEquals(4, PrimeNumbers.countDivisors(46));
		assertEquals(2, PrimeNumbers.countDivisors(47));
		assertEquals(10, PrimeNumbers.countDivisors(48));
		assertEquals(3, PrimeNumbers.countDivisors(49));
		assertEquals(6, PrimeNumbers.countDivisors(50));
		assertEquals(4, PrimeNumbers.countDivisors(51));
		assertEquals(6, PrimeNumbers.countDivisors(52));
		assertEquals(2, PrimeNumbers.countDivisors(53));
		assertEquals(8, PrimeNumbers.countDivisors(54));
		assertEquals(4, PrimeNumbers.countDivisors(55));
		assertEquals(8, PrimeNumbers.countDivisors(56));
		assertEquals(4, PrimeNumbers.countDivisors(57));
		assertEquals(4, PrimeNumbers.countDivisors(58));
		assertEquals(2, PrimeNumbers.countDivisors(59));
		assertEquals(12, PrimeNumbers.countDivisors(60));
		assertEquals(2, PrimeNumbers.countDivisors(61));
		assertEquals(4, PrimeNumbers.countDivisors(62));
		assertEquals(6, PrimeNumbers.countDivisors(63));
		assertEquals(7, PrimeNumbers.countDivisors(64));
		assertEquals(4, PrimeNumbers.countDivisors(65));
		assertEquals(8, PrimeNumbers.countDivisors(66));
		assertEquals(2, PrimeNumbers.countDivisors(67));
		assertEquals(6, PrimeNumbers.countDivisors(68));
		assertEquals(4, PrimeNumbers.countDivisors(69));
		assertEquals(8, PrimeNumbers.countDivisors(70));
		assertEquals(2, PrimeNumbers.countDivisors(71));
		assertEquals(12, PrimeNumbers.countDivisors(72));
		assertEquals(2, PrimeNumbers.countDivisors(73));
		assertEquals(4, PrimeNumbers.countDivisors(74));
		assertEquals(6, PrimeNumbers.countDivisors(75));
		assertEquals(6, PrimeNumbers.countDivisors(76));
		assertEquals(4, PrimeNumbers.countDivisors(77));
		assertEquals(8, PrimeNumbers.countDivisors(78));
		assertEquals(2, PrimeNumbers.countDivisors(79));
		assertEquals(10, PrimeNumbers.countDivisors(80));
		assertEquals(5, PrimeNumbers.countDivisors(81));
		assertEquals(4, PrimeNumbers.countDivisors(82));
		assertEquals(2, PrimeNumbers.countDivisors(83));
		assertEquals(12, PrimeNumbers.countDivisors(84));
		assertEquals(4, PrimeNumbers.countDivisors(85));
		assertEquals(4, PrimeNumbers.countDivisors(86));
		assertEquals(4, PrimeNumbers.countDivisors(87));
		assertEquals(8, PrimeNumbers.countDivisors(88));
		assertEquals(2, PrimeNumbers.countDivisors(89));
		assertEquals(12, PrimeNumbers.countDivisors(90));
		assertEquals(4, PrimeNumbers.countDivisors(91));
		assertEquals(6, PrimeNumbers.countDivisors(92));
		assertEquals(4, PrimeNumbers.countDivisors(93));
		assertEquals(4, PrimeNumbers.countDivisors(94));
		assertEquals(4, PrimeNumbers.countDivisors(95));
		assertEquals(12, PrimeNumbers.countDivisors(96));
		assertEquals(2, PrimeNumbers.countDivisors(97));
		assertEquals(6, PrimeNumbers.countDivisors(98));
		assertEquals(6, PrimeNumbers.countDivisors(99));
		assertEquals(9, PrimeNumbers.countDivisors(100));
	}

	@Test
	public void testGetDivisors() {
		LinkedList<Long> list = new LinkedList<Long>();
		list.add(1L);
		list.add(2L);
		assertEquals(list, PrimeNumbers.getDivisors(2));
		list.add(4L);
		assertEquals(list, PrimeNumbers.getDivisors(4));
		list.add(8L);
		assertEquals(list, PrimeNumbers.getDivisors(8));

		list = new LinkedList<Long>();
		list.add(1L);
		list.add(2L);
		list.add(3L);
		list.add(6L);
		assertEquals(list, PrimeNumbers.getDivisors(6));
		list.remove(3L);
		list.add(4L);
		list.add(3L);
		list.remove(6L);
		list.add(6L);
		list.add(12L);
		assertEquals(list, PrimeNumbers.getDivisors(12));

		list = new LinkedList<Long>();
		list.add(1L);
		list.add(17L);
		assertEquals(list, PrimeNumbers.getDivisors(17));
	}

	@Test
	public void testIsPrime() {
		assertFalse(PrimeNumbers.isPrime(-10));
		assertFalse(PrimeNumbers.isPrime(50));
		assertFalse(PrimeNumbers.isPrime(13338));

		assertTrue(PrimeNumbers.isPrime(2));
		assertTrue(PrimeNumbers.isPrime(3));
		assertTrue(PrimeNumbers.isPrime(53));
		assertTrue(PrimeNumbers.isPrime(13337));
	}
}
