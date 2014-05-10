package utils;

public class Number {

	private long base;
	private int exponent;

	public Number(long base, int exponent) {
		this.base = base;
		this.exponent = exponent;
	}

	public long getBase() {
		return base;
	}

	public void setBase(long base) {
		this.base = base;
	}

	public int getExponent() {
		return exponent;
	}

	public void setExponent(int exponent) {
		this.exponent = exponent;
	}

	@Override
	public String toString() {
		return base + "^" + exponent;
	}
}
