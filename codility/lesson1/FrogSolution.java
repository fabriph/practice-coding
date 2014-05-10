package lesson1;
public class FrogSolution {

	public int solution(int X, int Y, int D) {
		int diff = Y - X;
		return (int) Math.ceil(diff / D);
	}

}
