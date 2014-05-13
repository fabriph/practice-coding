package problems;

public class Problem31 {

	public static void main(String[] args) {
		// TODO more intelligence can be added to the loops
		int counter = 0;
		for (int onePence = 0; onePence < 201; onePence++) {
			for (int twoPence = 0; twoPence < 101; twoPence++) {
				for (int fivePence = 0; fivePence < 41; fivePence++) {
					for (int tenPence = 0; tenPence < 21; tenPence++) {
						for (int twentyPence = 0; twentyPence < 11; twentyPence++) {
							for (int fiftyPence = 0; fiftyPence < 5; fiftyPence++) {
								for (int onePound = 0; onePound < 3; onePound++) {
									for (int twoPound = 0; twoPound < 2; twoPound++) {
										if (onePence + twoPence * 2 + fivePence
												* 5 + tenPence * 10
												+ twentyPence * 20 + fiftyPence
												* 50 + onePound * 100
												+ twoPound * 200 == 200)
											counter++;
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(counter);
	}
}