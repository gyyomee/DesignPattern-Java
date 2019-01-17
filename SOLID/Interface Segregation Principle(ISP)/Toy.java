
//클라이언트와 무관하게 발생한 변화로 클라이언트 자신이 영향을 받지 않으려면,
//범용의 인터페이스보다는 클라이언트에 특화된 인터페이스를 사용해야 한다
public interface Toy {
	void setPrice(double price);

	void setColor(String color);
}

