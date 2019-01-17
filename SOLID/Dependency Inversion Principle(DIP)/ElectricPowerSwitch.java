
//ElectricPowerSwitch에서 저레벨인 LightBulb를 직접 참조한다
//상위층은 클래스보다는 인터페이스나 추상클래스와 의존관계를 맺어야한다
//Switchable 인터페이스를 참조한다
public class ElectricPowerSwitch implements Switch {
	public Switchable client;
	public boolean on;

	public ElectricPowerSwitch(Switchable client) {
		this.client = client;
		this.on = false;
	}

	public boolean isOn() {
		return this.on;
	}

	public void press() {
		boolean checkOn = isOn();
		if (checkOn) {
			client.turnOff();
			this.on = false;
		} else {
			client.turnOn();
			this.on = true;
		}
	}
}
