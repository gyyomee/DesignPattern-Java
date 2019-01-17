package format;
import java.util.GregorianCalendar;
/*
 * BasicFormat을 이용하여 출력한다
 */
public class SampleFormats {
	public static void main(String[] args) {
		BasicFormat format = new BasicFormat();
	
		/* Tests */
		System.out.println("Date: " + format.formatDate(new GregorianCalendar(2011, 5-1, 24).getTime()));
		// dateFormat.format() expects a Date object. Use
		// GregorianCalendar to construct a Calendar object and the
		// getTime() method to convert it to a Date.
		System.out.println("Date: " + format.formatDate(2011,6,25));
		System.out.println("Integer: " + format.formatLong(1234567));
		System.out.println("Integer: " + format.formatDouble(67.7));
		System.out.println("Money: " + format.formatMoney(9812345.678));
		System.out.println("Money: " + format.formatMoney(9812345));
		System.out.println("Money: " + format.formatMoney(.78));
		System.out.println("Person: " + format.formatPerson("Weinman", "Jerod", "winman"));
		
		// We can create and initialize an Object array on the fly, as
		// shown above.
	}
}