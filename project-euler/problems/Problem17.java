package problems;

public class Problem17 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 1000; i++) {
			sb.append(Number.convertToText(i));
		}
		System.out.println(sb.toString().length());
	}

	public static class Number {
		public static String convertToText(int number) {
			if (number == 1000) {
				// return "one thousand";
				return "onethousand";
			}

			int thirdDigit = 0;
			int secondDigit = 0;
			int firstDigit = 0;

			StringBuilder sb = new StringBuilder();

			if (number > 99) {
				thirdDigit = number / 100;
				number = number % 100;

				sb.append(hundreds(thirdDigit));

				if (number > 0) {
					// sb.append(" and ");
					sb.append("and");
				}
			}

			if (10 <= number && number <= 19) {
				if (number == 10) {
					sb.append("ten");
				}
				if (number == 11) {
					sb.append("eleven");
				}
				if (number == 12) {
					sb.append("twelve");
				}
				if (number == 13) {
					sb.append("thirteen");
				}
				if (number == 14) {
					sb.append("fourteen");
				}
				if (number == 15) {
					sb.append("fifteen");
				}
				if (number == 16) {
					sb.append("sixteen");
				}
				if (number == 17) {
					sb.append("seventeen");
				}
				if (number == 18) {
					sb.append("eighteen");
				}
				if (number == 19) {
					sb.append("nineteen");
				}
				return sb.toString();
			}

			if (number > 9) {
				secondDigit = number / 10;
				number = number % 10;

				sb.append(tens(secondDigit));

				if (number > 0) {
					// sb.append("-");
				}
			}
			firstDigit = number;
			sb.append(units(firstDigit));
			return sb.toString();
		}

		private static String units(int number) {
			switch (number) {
			case 0:
				return "";
			case 1:
				return "one";
			case 2:
				return "two";
			case 3:
				return "three";
			case 4:
				return "four";
			case 5:
				return "five";
			case 6:
				return "six";
			case 7:
				return "seven";
			case 8:
				return "eight";
			case 9:
				return "nine";
			default:
				System.out.println("ERROR");
				return "";
			}
		}

		private static String tens(int digit) {
			switch (digit) {
			case 0:
				return "";
			case 1:
				System.out.println("ERROR");
				return "";
			case 2:
				return "twenty";
			case 3:
				return "thirty";
			case 4:
				return "forty";
			case 5:
				return "fifty";
			case 6:
				return "sixty";
			case 7:
				return "seventy";
			case 8:
				return "eighty";
			case 9:
				return "ninety";
			default:
				System.out.println("ERROR");
				return "";
			}
		}

		private static String hundreds(int digit) {
			switch (digit) {
			case 0:
				return "";
			case 1:
				return "one hundred";
			case 2:
				return "two hundred";
			case 3:
				return "three hundred";
			case 4:
				return "four hundred";
			case 5:
				return "five hundred";
			case 6:
				return "six hundred";
			case 7:
				return "seven hundred";
			case 8:
				return "eight hundred";
			case 9:
				return "nine hundred";
			default:
				return "";
			}
		}
	}

}
