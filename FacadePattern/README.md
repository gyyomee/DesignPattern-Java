# 퍼사드 패턴(Facade Pattern)

**의도**

* 있는 시스템을 쉽게 사용하고 싶을 때. 자신만의 인터페이스를 정의하고 싶을 때

**문제**

* 복잡한 시스템의 부분만 사용 또는 특정 방법으로 인터랙션할 필요

**솔루션**

* 현재 시스템을 사용하는 클라이언트를 위한 새로운 인터페이스 제시

**컴포넌트**

* 쉽게 사용하기 위한 특별한 인터페이스

**결과**

* 서브시스템 사용을 간소화시킴. 하지만 기능이 다 가용되지 않을 수도 있음



### 퍼사드 패턴의 응용

* 클라이언트 객체가 다루어야 할 객체의 수를 줄여줌
* 새로운 기능을 추가하여 확장
* 캡슐화 층 – 시스템을 감추고 캡슐화



![2019-01-17 22 29 55](https://user-images.githubusercontent.com/22466478/51321952-74073200-1aa7-11e9-8b87-5e299af7dba8.JPG)





## 예제 문제 

다음의 코드<Simpleformat.java>를 읽고 이해한 후 프로그램을 컴파일하여 실행해 보라.

여러 가지 클래스의 복잡한 옵션 대신에 간단한 인터페이스로 사용할 수 있도록 퍼싸드 패턴을 적용하여 다음과 같은 <basicformat.java> 프로그램의 Body를 완성하고 주어진 main을 이용하여 실행하라.

```java
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.DecimalFormat;
import java.text.MessageFormat;

public class SampleFormats {
	public static void main(String[] args) {
		/*
		 * Date format. Examples: 4 Jul 1997 10 Mar 1979
		 */
		SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM yyyy");
		/*
		 * A pretty integer format. Examples: 4,235,682 5,487 42
		 */
		DecimalFormat intFormat = new DecimalFormat("#,###");
		/*
		 * A monetary format. Examples: $ 4,235,670 $ 345.23 $ 0.48
		 */
		DecimalFormat dollarFormat = new DecimalFormat("$ #,##0.##");
		/*
		 * A person format using first, last, and user names. Examples: Weinman, Jerod
		 * [weinman] Davis, Janet [davisjan] Coahran, Marge [coahranm] The {x} syntax
		 * means replace with the x'th index of an array.
		 */
		MessageFormat personFormat = new MessageFormat("{0}, {1} [{2}]");
		/* Tests */
		System.out.println("Date: " + dateFormat.format(new GregorianCalendar(2005, 7, 4).getTime()));
// dateFormat.format() expects a Date object. Use
// GregorianCalendar to construct a Calendar object and the
// getTime() method to convert it to a Date.
		System.out.println("Integer: " + intFormat.format(1234567));
		System.out.println("Integer: " + intFormat.format(67.7));
		System.out.println("Money: " + dollarFormat.format(9812345.678));
		System.out.println("Money: " + dollarFormat.format(9812345));
		System.out.println("Money: " + dollarFormat.format(.78));
		System.out.println("Person: " + personFormat.format(new Object[] { "Weinman", "Jerod", "weinman" }));
// We can create and initialize an Object array on the fly, as
// shown above.
	}
}

import java.util.Date;

/** Specifies basic formatting for dates, integers, money, and people */
public class BasicFormat {
	public static String formatDate(Date date) {
	// BODY
	}

	/**
	 * Formats a date
	 * 
	 * @param year  Full integral value of the year, e.g. 1945, 2008
	 * @param month Zero-based month index, e.g. 0 is January, 6 is July
	 * @param day   One-based day of the month
	 */
	public static String formatDate(int year, int month, int day) {
	// BODY
	}

	public static String formatLong(long number) {
	// BODY
	}

	public static String formatMoney(double amount) {
	// BODY
	}

	public static String formatPerson(String firstName, String lastName, String userName) {
	// BODY
	}
}
```