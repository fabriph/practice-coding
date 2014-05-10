public class TraversArrayAccordingIndexes {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3 };
		System.out.println(solution(a));

		int[] b = { 3, -5, 0, -1, -3 };
		System.out.println(solution(b));

		int[] c = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		System.out.println(solution(c));
		
		int[] d = { 1};
		System.out.println(solution(d));
		
		int[] e = { 3, 8,-1 ,-1};
		System.out.println(solution(e));
		
		int[] f = {};
		System.out.println("f " +  solution(f));
		
		int[] g = {10};
		System.out.println("g " +  solution(g));
		
		int[] h = {10 , 1};
		System.out.println("h " +  solution(h));
	}

	public static int solution(int[] A) {
		int pending = A.length;
		int k = 0;
		int previous = -1;
		while (k < A.length) {
			previous = k;
			k = k + A[k];
			pending--;
			if (previous == k) {
				return pending;
			}
		}
		return pending;
	}

}
