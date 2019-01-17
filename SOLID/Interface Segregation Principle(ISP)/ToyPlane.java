
public class ToyPlane implements Toy, Movable, Flyable {
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
	public void move(){ ... }

	@Override
	public void fly(){ ... }
}
