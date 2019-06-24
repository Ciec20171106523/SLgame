package imnu.edu.cn.frame;

import javax.swing.JLabel;

public class MineLabel extends JLabel{
     private int rowIndex;
     private int colIndex;
	public int getRowIndex() {
		return rowIndex;
	}
	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}
	public int getColIndex() {
		return colIndex;
	}
	public void setColIndex(int colIndex) {
		this.colIndex = colIndex;
	}
	public MineLabel(int rowIndex,int colIndex) {
		this.rowIndex=rowIndex;
		this.colIndex=colIndex;
		// TODO Auto-generated constructor stub
	}
}
