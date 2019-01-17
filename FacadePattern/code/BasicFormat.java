package format;

import java.text.SimpleDateFormat;
import java.util.Date;
/*
 * �ش� ������ �����Ѵ�
 */
/** Specifies basic formatting for dates, integers, money, and people */
public class BasicFormat {
	public static String formatDate(Date date) {
		String strTime;
		SimpleDateFormat transFormat = new SimpleDateFormat("d M�� yyyy"); 
		strTime = transFormat.format(date); //date�� String���� ����
		return strTime;
	}

	public static String formatDate(int year, int month, int day) {
		String sDate = Integer.toString(day) + " "; // ��
		sDate += Integer.toString(month) + "�� "; // ��
		sDate += Integer.toString(year); // ��
		return sDate;
	}

	public static String formatDouble(double number) {
		StringBuilder sNumber = new StringBuilder(Double.toString(number));
		for (int i = 0; i < sNumber.length(); i++) {
			if (sNumber.charAt(i) == '.') { // �Ҽ����� �������
				// ù°�ڸ� �ݿø�
				if ('4' < sNumber.charAt(i - 1)) { // �ø�
					int a = sNumber.charAt(i - 1);
					a++;
					sNumber.setCharAt(i - 1, (char) a);
					sNumber.deleteCharAt(i);
					sNumber.deleteCharAt(i);
					break;
				} else { // ����
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
		for (int i = sNumber.length() - 1; i > -1; i--) { // �Ųٷ� �д´�
			count++;
			if (count == 3) { // ���ڰ� �����϶�
				sNumber.insert(i, ","); // ,��´�
				count = 0;
			}
		}
		return sNumber.toString();
	}

	public static String formatMoney(double amount) {
		StringBuilder sNumber = new StringBuilder(Double.toString(amount));
		sNumber.insert(0, "$ "); // �տ� �޷�ǥ��
		int count = 0;
		int i = 0;
		for (i = 0; i < sNumber.length() - 1; i++) {
			if (sNumber.charAt(i) == '.') { // �Ҽ����� �ִ��� ã�´�
				break;
			}
		}
		int count2 = 0;
		for (int j = i + 1; j < sNumber.length(); j++) { // �Ҽ����� �����Ұ��
			count2++;
			if (count2 == 3) { // �Ҽ����Ʒ� ��°�ڸ����� �ݿø�
				// �ø�
				if ('4' < sNumber.charAt(j)) {
					int a = sNumber.charAt(j - 1);
					a++;
					sNumber.setCharAt(j - 1, (char) a);
					sNumber.deleteCharAt(j);
					break;
				} else { // ����
					sNumber.deleteCharAt(j);
					break;
				}
			}
		}

		// �ڸ��� ǥ��
		for (i = i - 1; i > 2; i--) { // �Ҽ��� �տ������� Ž��
			count++;
			if (count == 3) { // ���ڰ� �����ϰ��
				sNumber.insert(i, ","); // ,ǥ��
				count = 0;
			}
		}
		return sNumber.toString();
	}

	public static String formatPerson(String firstName, String lastName, String userName) {
		String person = firstName + ", "; // �̸�
		person += lastName + " "; // ��
		person += "[" + userName + "]"; // ��������
		return person;
	}
}
