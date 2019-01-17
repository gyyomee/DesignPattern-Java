package rocket;

import javax.swing.table.AbstractTableModel;

public class RocketTable extends AbstractTableModel {
	protected Rocket[] rockets;
	protected String[] columnsName = new String[] { "Name", "Price", "Apogee" };

	public RocketTable(Rocket[] rockets) {
		this.rockets = rockets;
	}

	@Override
	public int getColumnCount() {
		return 3; //���� ������ 3���̹Ƿ�
	}
	
	@Override
	public String getColumnName(int column) {
		return columnsName[column]; //�ش� idx�� �� �̸��� ��ȯ
	}

	@Override
	public int getRowCount() {
		return rockets.length; //���� ������ ������ �����̹Ƿ� �迭���� ��ȯ
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) { //���� ���� ����ó��
		case 0: //ù��° ��
			return rockets[rowIndex].getName(); //������ �̸�
		case 1: //�ι�° ��
			return rockets[rowIndex].getPrice(); //������ ����
		case 2: //����° ��
			return rockets[rowIndex].getApogee(); //��Ĺ�� �ְ���
		default:
			return null;
		}
	}
}
