package imnu.edu.cn.frame;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

import imnu.edu.cn.tools.tools;

public class MineSweeper extends JPanel{
    JrameMenu mf;//雷快
    private MineLabel mineLabel[][];
	public JrameMenu getMf() {
		return mf;
	}
	public void setMf(JrameMenu mf) {
		this.mf = mf;
	}

  
	public MineLabel[][] getMineLabel() {
		return mineLabel;
	}
	public void setMineLabel(MineLabel[][] mineLabel) {
		this.mineLabel = mineLabel;
	}
	public MineSweeper(JrameMenu mf) {
		this.mf=mf;
		this.setLayout(new BorderLayout());
    	mineLabel=new MineLabel[tools.totalx][tools.totaly];
    	JPanel jPanel2=new JPanel();
    	jPanel2.setLayout(new GridLayout(tools.totalx,tools.totaly));
    	for(int i=0;i<tools.totalx;i++) {
    		for(int j=0;j<tools.totaly;j++) {
    			mineLabel[i][j]=new MineLabel(i,j);
    			mineLabel[i][j].setIcon(tools.iiblank);
    			jPanel2.add(mineLabel[i][j]);
    		}
    	}
    	this.add(jPanel2);
	}
	
	
	
}
