package rocket;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
/*
 * 로켓을 display한다
 */
public class ShowRocketTable {
	public static void main(String[] args) {
		//로켓 객체 생성
		Rocket[] rockets = new Rocket[] { new Rocket("Shooter", 3.95, 50.0), new Rocket("Orbit", 29.95, 5000.0) };
		//로켓 테이블 생성
		AbstractTableModel tableModel = new RocketTable(rockets);
		JTable table = new JTable(tableModel);
		JScrollPane pane = new JScrollPane(table);
		display(pane, " Rockets"); //로켓 display
	};

	//로켓을 JFrame에 display한다
	public static void display(Component c, String title) {
		JFrame frame = new JFrame(title); //JFrame만든다
		frame.getContentPane().add(c);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
