package problems;

public class Problem25 {
	static double FI = (1 + Math.pow(5, 0.5)) / 2;

	static double fib(int n) {
		return (Math.pow(FI, n) - Math.pow(-FI, -n)) / Math.pow(5, 0.5);
	}

	public static void main(String[] args) {
		double base = Math.pow(10, 1000);
		int n = 1;
		for (n = 1; n < 10000; n++) {
			// System.out.println(fib(n));
			if (fib(n) / base > 1.0) {
				System.out.println(n);
				System.out.println("!!!!!!");
				System.out.println("!!!!!!");
				System.out.println("!!!!!!");
			}
		}
		System.out.println("last " + n + " " + fib(n));
	}
}
