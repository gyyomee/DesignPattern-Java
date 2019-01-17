
public class LightBulb implements Switchable {
	@override
	public void turnOn() {
		System.out.println("LightBulb: Bulb turned on...");
	}

	@override
	public void turnOff() {
		System.out.println("LightBulb: Bulb turned off...");
	}
}
