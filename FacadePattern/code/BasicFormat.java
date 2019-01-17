package format;

import java.text.SimpleDateFormat;
import java.util.Date;
/*
 * 해당 포멧을 구현한다
 */
/** Specifies basic formatting for dates, integers, money, and people */
public class BasicFormat {
	public static String formatDate(Date date) {
		String strTime;
		SimpleDateFormat transFormat = new SimpleDateFormat("d M월 yyyy"); 
		strTime = transFormat.format(date); //date를 String으로 저장
		return strTime;
	}

	public static String formatDate(int year, int month, int day) {
		String sDate = Integer.toString(day) + " "; // 일
		sDate += Integer.toString(month) + "월 "; // 월
		sDate += Integer.toString(year); // 년
		return sDate;
	}

	public static String formatDouble(double number) {
		StringBuilder sNumber = new StringBuilder(Double.toString(number));
		for (int i = 0; i < sNumber.length(); i++) {
			if (sNumber.charAt(i) == '.') { // 소수점이 있을경우
				// 첫째자리 반올림
				if ('4' < sNumber.charAt(i - 1)) { // 올림
					int a = sNumber.charAt(i - 1);
					a++;
					sNumber.setCharAt(i - 1, (char) a);
					sNumber.deleteCharAt(i);
					sNumber.deleteCharAt(i);
					break;
				} else { // 버림
					sNumber.deleteCharAt(i);
					sNumber.deleteCharAt(i);
					break;
				}
			}
		}
		return sNumber.toString();
	}

	public static String formatLong(long number) {
		StringBuilder sNumber = new StringBuilder(Long.toString(number));
		int count = 0;
		for (int i = sNumber.length() - 1; i > -1; i--) { // 거꾸로 읽는다
			count++;
			if (count == 3) { // 숫자가 세개일때
				sNumber.insert(i, ","); // ,찍는다
				count = 0;
			}
		}
		return sNumber.toString();
	}

	public static String formatMoney(double amount) {
		StringBuilder sNumber = new StringBuilder(Double.toString(amount));
		sNumber.insert(0, "$ "); // 앞에 달러표시
		int count = 0;
		int i = 0;
		for (i = 0; i < sNumber.length() - 1; i++) {
			if (sNumber.charAt(i) == '.') { // 소수점이 있는지 찾는다
				break;
			}
		}
		int count2 = 0;
		for (int j = i + 1; j < sNumber.length(); j++) { // 소수점이 존재할경우
			count2++;
			if (count2 == 3) { // 소수점아래 셋째자리에서 반올림
				// 올림
				if ('4' < sNumber.charAt(j)) {
					int a = sNumber.charAt(j - 1);
					a++;
					sNumber.setCharAt(j - 1, (char) a);
					sNumber.deleteCharAt(j);
					break;
				} else { // 버림
					sNumber.deleteCharAt(j);
					break;
				}
			}
		}

		// 자리수 표시
		for (i = i - 1; i > 2; i--) { // 소수점 앞에서부터 탐색
			count++;
			if (count == 3) { // 숫자가 세개일경우
				sNumber.insert(i, ","); // ,표시
				count = 0;
			}
		}
		return sNumber.toString();
	}

	public static String formatPerson(String firstName, String lastName, String userName) {
		String person = firstName + ", "; // 이름
		person += lastName + " "; // 성
		person += "[" + userName + "]"; // 유저네임
		return person;
	}
}
