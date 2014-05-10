package lesson3;

public class PassingCars {
	public static int solution(int[] A) {
		int travelingEastCars = 0;
		int passingCars = 0;
		for (int a : A) {
			if (a == 0) {
				travelingEastCars++;
			} else {
				passingCars += travelingEastCars;
				if (passingCars > 1000000000) {
					return -1;
				}
			}
		}
		return passingCars;
	}
}
