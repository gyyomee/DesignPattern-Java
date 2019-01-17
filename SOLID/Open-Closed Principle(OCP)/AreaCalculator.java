
//Shape 인터페이스를 사용해서 모양이 추가되더라도 클래스를 수정하지 않아도 된다
public class AreaCalculator {
	public double calculateShapeArea(Shape shape) {
		return shape.calculateArea();
	}
}
