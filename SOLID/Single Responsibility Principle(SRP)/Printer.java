
//출력에 대한 기능이 변화가 생기게 되면 Text클래스는 계속해서 변경된다
//Text안에 있던 print기능을 클래스로 따로 분리하여 결합된 책임을 분리한다
public class Printer {
	Text text;

	Printer(Text t) {
		this.text = t;
	}

	void printText(){ ... }
}