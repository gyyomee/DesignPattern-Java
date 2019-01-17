# SOLID

## 단일 책임 원칙(Single Responsibility Principle, SRP)

단 하나의 책임 만을 가져야 한다는 의미. 책임의 기본단위는 객체이다. 책임을 많이 질수록 강하게 결합되어 변화시 영향을 일으키 가능성이 높다.

산탄총 수술 : 어떤 변경이 있을 때 하나가 아닌 여러 클래스를 변경해야 한다.

SRP에 따른 설계를 하면 응집도는 높아지고 결합도는 낮아지게 된다.



**예제문제**

```java
class Text {
	String text;
	String author;
	int length;

	String getText() { ... }

	void setText(String s) { ... }

	String getAuthor() { ... }

	void setAuthor(String s) { ... }

	int getLength() { ... }

	void setLength(int k) { ... }

	/* methods that change the text */
	void allLettersToUpperCase() { ... }

	void findSubTextAndDelete(String s) { ... }

	/* method for formatting output */
	void printText() { ... }
}
```

* 출력 기능에 대한 변화가 생기게 되면 Text 클래스는 계속해서 변경된다. `Text`는 다른 역할을 하는 코드들과 결합관계를 가지고 있으므로 단일 책임 원칙을 위배하고 있다.
* 결합된 책임을 분리하여 별도에 클래스에 저장한다 -> `Text` 클래스 안에 있는 출력 기능을 `Printer` 클래스로 분리한다.



## 개방-폐쇄 원칙(Open-Closed Principle, OCP)

기존의 코드를 변경하지 않으면서 기능을 추가할 수 있도록 설계가 되어야 함.

기능을 다양하게 하기위해서 추상클래스나 인터페이스를 사용.

환경의 변경이 가능하므로 테스트 클래스에서 해당 객체를 변경하지 않고 Test가 가능함.



**예제문제**

```java
public class Rectangle {
	public double length;
	public double width;
}

public class AreaCalculator {
	public double calculateRectangleArea(Rectangle rectangle) {
		return rectangle.length * rectangle.width;
	}
}

//Circle 모양을 추가하기 위하여 다음과 같이 AreaCalulator를 수정하였다.
public class Circle {
	public double radius;
}

public class AreaCalculator {
	public double calculateRectangleArea(Rectangle rectangle) {
		return rectangle.length * rectangle.width;
	}

	public double calculateCircleArea(Circle circle) {
		return (22 / 7) * circle.radius * circle.radius;
	}
}
```

* 새로운 모양이 계속 추가될 경우 새로운 모양의 `AreaCalculator` 클래스를 계속 수정 해야 되므로 복잡해지게 된다. 따라서 이 디자인은 수정에 폐쇄되어있지 폐쇄되어있지 않고 확장성이 없다.
* `Shape`라는 인터페이스를 만들어 인터페이스에서 구체적인 모양 매체를 캡슐화해 처리하도록 한다.



## 의존 관계 역전의 원리(Dependency Inversion Principle, DIP)

의존 관계를 맺을 때 변화하기 쉬운 것 또는 자주 변화하는 것 보다는 **변화하기 어려운것, 거의 변화가 없는 것** 에 의존하라는 원칙이다.

인터페이스나 추상클래스와 의존 관계를 맺도록 설계. 



**예제문제**

```java
public class LightBulb {
	public void turnOn() {
		System.out.println("LightBulb: Bulb turned on...");
	}

	public void turnOff() {
		System.out.println("LightBulb: Bulb turned off...");
	}
}

public class ElectricPowerSwitch {
	public LightBulb lightBulb;
	public boolean on;

	public ElectricPowerSwitch(LightBulb lightBulb) {
		this.lightBulb = lightBulb;
		this.on = false;
	}

	public boolean isOn() {
		return this.on;
	}

	public void press() {
		boolean checkOn = isOn();
		if (checkOn) {
			lightBulb.turnOff();
			this.on = false;
		} else {
			lightBulb.turnOn();
			this.on = true;
		}
	}
}
```

* 고레벨인 `ElectricPowerSwitch`에서 저레벨인 `LightBulb`을 직접 참조한다. 
* 상위층은 구체적인 클래스 보다는 인터페이스나 추상클래스와 의존 관계를 맺도록 설계해야 한다.



## 인터페이스 격리의 원칙(Interface Segregation Principle, ISP)

클라이언트 자신이 이용하지 않는 기능에는 영향을 받지 않아야 한다.

인터페이스를 클라이언트에 특화되도록 분리시켜야 한다.



**예제문제**

```java
public interface Toy {
	void setPrice(double price);

	void setColor(String color);

	void move();

	void fly();
}

//이렇게 설계하면 만일 Toyhouse가 필요하다면 다음과 같이 move 기능과 fly 기능이 없더라도 구현하여야 한다.

public class ToyHouse implements Toy {
	double price;
	String color;

	@Override
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public void move() {
	}

	@Override
	public void fly() {
	}
}
```

* 클라이언트와 무관하게 발생한 변화로 클라이언트 자식이 영향을 받지 않으려면 범용의 인터페이스보다는 클라이언트에 특화된 인터페이스를 사용해야 한다. 
* 따라서 인터페이스를 클라이언트에 특화되도록 분리시켜야 한다
* 문제점을 해결하여 `Toy House`, `Toy Car`, `Toy Plane`을 구현



## 리스코프 치환 원칙(Liskov Substitution Principle, LSP)

부모클래스와 자식클래스 사이의 행위가 일관성이 있어야 한다.

부모클래스의 인스턴스를 자식 클래스의 인스턴스로 대신할 수 있어야 한다.

슈퍼클래스에서 상속받은 메서드들이 서브클래스에서 오버라이드, 즉 **재정의** 않도록 해야 한다.



**예제문제**

```java
public class Rectangle {
	private int height;
	private int width;

	public Rectangle(int height, int width) {
		this.height = height;
		this.width = width;
	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
}

public class Square extends Rectangle {
	public Square(int size) {
		super(size, size);
	}

	public int getHeight() {
		return super.height;
	}

	public int getWidth() {
		return super.width;
	}
}

//위 프로그램이 다음과 같은 코드로 실행되었을 때 결과와 문제점은?
Rectangle r = new Square();
r.setHeight(5);
r.setWidth(6);
```

* r의 높이는 5 너비는 6으로 설정되게 된다. 정사각형은 너비와 높이가 같아야 한다. 따라서 이것은 `Square` 객체를 무효화 시키는 문제점이 발생하게 된다.
* 문제가 발생한 이유는 `Rectangle`의 특성을 `Square`이 모두 포함하고 있지 않기 때문이다. `Square`는 Rectangle이 아니다. 따라서 이 코드는 부모 클래스의 인스턴스를 자식 클래스의 인스턴스로 대신할 수 없다. 이것은 리스코프 치환원칙을 위배한다.
* `Square`과 `Rectangle`을 분리하여 구현해야 한다.