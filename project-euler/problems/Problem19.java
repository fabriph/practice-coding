package problems;

import java.util.Calendar;
import java.util.Date;

public class Problem19 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		for (int year = 1; year <= 100; year++) {
			for (int month = 0; month <= 11; month++) {
				c.setTime(new Date(year, month, 1));
				// c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
				System.out.println(c.getTime());
				// Then use grep to count
			}
		}
	}
}
