package rocket;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
/*
 * ������ display�Ѵ�
 */
public class ShowRocketTable {
	public static void main(String[] args) {
		//���� ��ü ����
		Rocket[] rockets = new Rocket[] { new Rocket("Shooter", 3.95, 50.0), new Rocket("Orbit", 29.95, 5000.0) };
		//���� ���̺� ����
		AbstractTableModel tableModel = new RocketTable(rockets);
		JTable table = new JTable(tableModel);
		JScrollPane pane = new JScrollPane(table);
		display(pane, " Rockets"); //���� display
	};

	//������ JFrame�� display�Ѵ�
	public static void display(Component c, String title) {
		JFrame frame = new JFrame(title); //JFrame�����
		frame.getContentPane().add(c);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
