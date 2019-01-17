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
		return 3; //열의 개수가 3개이므로
	}
	
	@Override
	public String getColumnName(int column) {
		return columnsName[column]; //해당 idx의 열 이름을 반환
	}

	@Override
	public int getRowCount() {
		return rockets.length; //행의 개수는 로켓의 개수이므로 배열길이 반환
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) { //열에 따른 내용처리
		case 0: //첫번째 열
			return rockets[rowIndex].getName(); //로켓의 이름
		case 1: //두번째 열
			return rockets[rowIndex].getPrice(); //로켓의 가격
		case 2: //세번째 열
			return rockets[rowIndex].getApogee(); //로캣의 최고점
		default:
			return null;
		}
	}
}
