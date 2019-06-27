package imnu.edu.cn.frame;

import javax.swing.JLabel;

public class MineLabel extends JLabel{
     private int rowIndex;
     private int colIndex;
     private boolean isMine;
     private boolean isExpanded;
     private boolean isFlag;
     private boolean isMineAndNotflag;
     private int mineCount;
     private int rightClickCount;
     
	public boolean isMine() {
		return isMine;
	}
	public void setMine(boolean isMine) {
		this.isMine = isMine;
	}
	public boolean isExpanded() {
		return isExpanded;
	}
	public void setExpanded(boolean isExpanded) {
		this.isExpanded = isExpanded;
	}
	public boolean isFlag() {
		return isFlag;
	}
	public void setFlag(boolean isFlag) {
		this.isFlag = isFlag;
	}
	public boolean isMineAndNotflag() {
		return isMineAndNotflag;
	}
	public void setMineAndNotflag(boolean isMineAndNotflag) {
		this.isMineAndNotflag = isMineAndNotflag;
	}
	public int getMineCount() {
		return mineCount;
	}
	public void setMineCount(int mineCount) {
		this.mineCount = mineCount;
	}
	public int getRightClickCount() {
		return rightClickCount;
	}
	public void setRightClickCount(int rightClickCount) {
		this.rightClickCount = rightClickCount;
	}
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