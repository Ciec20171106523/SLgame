package imnu.edu.cn.listen;

import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



import imnu.edu.cn.frame.JrameMenu;
import imnu.edu.cn.frame.MineLabel;
import imnu.edu.cn.tools.tools;

public class MouseListener extends MouseAdapter{
    JrameMenu mf;
    private int mousePressedCount;
    private int expendedCount;
    private boolean isDouble;
    int temp=tools.totalMine;
    private boolean isStart;
    public MouseListener(JrameMenu mf){
    	this.mf=mf;   	
    }
    @Override
    public void mousePressed(MouseEvent e) {
    	// TODO Auto-generated method stub
    	MineLabel mineLabel=(MineLabel)e.getSource();
    	int x=mineLabel.getRowIndex();
    	int y=mineLabel.getColIndex();
    	mousePressedCount++;
    	if(mousePressedCount==1) {
    		mf.getMineSweeper().buildMine(x, y);
    	}
    	if(e.getButton()==e.BUTTON1) {
    		if(!mineLabel.isEnabled()&&!mineLabel.isFlag()) {
    			if(mineLabel.getRightClickCount()==2) {
    				mineLabel.setIcon(tools.iiask1);
    			}else {
    				mineLabel.setIcon(tools.mineCount[0]);
    			}
    			mf.getMainPanel().getNewGame().setIcon(tools.iiface2);   			
    		}
    		if(mineLabel.isEnabled()) {
    			mf.getMainPanel().getNewGame().setIcon(tools.iiface0);
    		}
    	}
    }
	
    @Override
    public void mouseReleased(MouseEvent e) {
    	// TODO Auto-generated method stub
    	MineLabel mineLabel=(MineLabel)e.getSource();
    	int x=mineLabel.getRowIndex();
    	int y=mineLabel.getColIndex();
    	int i=e.getModifiers();
    	if(i==InputEvent.BUTTON1_MASK) {
    		if(!mineLabel.isEnabled()&&!mineLabel.isFlag()) {
    			if(!mf.isStart()) {
    				mf.setStart(true);
    			}
    			if(mineLabel.isMine()&&!mineLabel.isFlag()) {    				
    				openMine(x,y);    				
    			}
    		}
    	}
}
    public void openMine(int i, int j) {
		for (int m = 0; m < tools.totalx; m++) {
			for (int n = 0; n < tools.totaly; n++) {
				MineLabel mineLabel = mf.getMineSweeper().getMineLabel()[m][n];
				//是雷的情况  且不是旗子
				if (mineLabel.isMine() && !mineLabel.isFlag()) {

					if (i == m && j == n) {

						mineLabel.setIcon(tools.iiblood);
					} else {
						mineLabel.setIcon(tools.iimine);
					}
					
				} else if (!mineLabel.isMine() && mineLabel.isFlag()) {
					mineLabel.setIcon(tools.iierror);
					mf.getMainPanel().getNewGame()
					.setIcon(tools.iiface3);
					
					//sartframe.getTimer().stop();
					mf.setStart(false);
					
				}
				mineLabel.removeMouseListener(mf.getMineSweeper()
						.getMouseListener());
			}
		}
	}
}