package rocket;
/*
 * 로캣객체
 */
public class Rocket {
	//로켓의 요소들
	private String name;
	private double price;
	private double apogee;

	//생성자
	public Rocket(String name, double price, double apogee) {
		this.name = name;
		this.price = price;
		this.apogee = apogee;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public double getApogee() {
		return apogee;
	}

}
