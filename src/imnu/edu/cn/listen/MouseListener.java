package imnu.edu.cn.listen;

import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



import imnu.edu.cn.frame.JrameMenu;
import imnu.edu.cn.frame.MineLabel;
import imnu.edu.cn.frame.Win;
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
    		if(!mineLabel.isExpanded()&&!mineLabel.isFlag()) {
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
    	}else if(e.getButton()==e.BUTTON3&&!mineLabel.isExpanded()) {
    		int ClickCount=mineLabel.getRightClickCount();
    		ClickCount++;
    		if(ClickCount==1) {
    			mineLabel.setIcon(tools.iiflag);
    			mineLabel.setRightClickCount(ClickCount);
    			mineLabel.setFlag(true);
    			temp--;
    			mf.getMainPanel().setTotalMine(temp);
    			
    		}else if(ClickCount==2) {
    			mineLabel.setIcon(tools.iiask0);
    			mineLabel.setRightClickCount(ClickCount);
    			mineLabel.setFlag(false);
    			temp++;
    			mf.getMainPanel().setTotalMine(temp);
    			
    		}else if(ClickCount==3) {
    			mineLabel.setIcon(tools.iiblank);
    			mineLabel.setRightClickCount(0);
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
    		if(!mineLabel.isExpanded()&&!mineLabel.isFlag()) {
    			if(!mf.isStart()) {
    				mf.getTimer().start();
    				mf.setStart(true);
    			}
    			if(mineLabel.isMine()&&!mineLabel.isFlag()) {    				
    				openMine(x,y);  
    				mf.getMainPanel().getNewGame().setIcon(tools.iiface3);
    				mf.getTimer().stop();
    				mf.setStart(false);
    				
    			}else {
    				mf.getMainPanel().getNewGame().setIcon(tools.iiface0);
    				open(x,y);
    				isMind();
    				
    			}
    		}else if(mineLabel.isExpanded()) {
    			mf.getMainPanel().getNewGame().setIcon(tools.iiface0);
    		}
    	}    	
}
    public void openMine(int i, int j) {
		for (int m = 0; m < tools.totalx; m++) {
			for (int n = 0; n < tools.totaly; n++) {
				MineLabel mineLabel = mf.getMineSweeper().getMineLabel()[m][n];
								
				if (mineLabel.isMine() && !mineLabel.isFlag()) {
					if (i == m && j == n) {
						mineLabel.setIcon(tools.iiblood);
					} else {
						mineLabel.setIcon(tools.iimine);
					}					
				} else if (!mineLabel.isMine() && mineLabel.isFlag()) {
					mineLabel.setIcon(tools.iierror);
					mf.getMainPanel().getNewGame().setIcon(tools.iiface3);										
					mf.setStart(false);					
				}
				mineLabel.removeMouseListener(mf.getMineSweeper().getMouseListener());
			}
		}
    }
    private void open(int rowIndex, int colIndex) {
		MineLabel mineLabel = mf.getMineSweeper().getMineLabel()[rowIndex][colIndex];
		if (!mineLabel.isExpanded() && !mineLabel.isFlag()) {
			int count = mineLabel.getMineCount();
			mineLabel.setIcon(tools.mineCount[count]);
			mineLabel.setExpanded(true);
			expendedCount++;
			if (count == 0) {
				for (int x = Math.max(rowIndex - 1, 0); x <= Math.min(
						rowIndex + 1, tools.totalx - 1); x++) {
					for (int y = Math.max(colIndex - 1, 0); y <= Math.min(
							colIndex + 1, tools.totaly - 1); y++) {
						open(x, y);
					}
				}
			}
		}
	}
	public void isMind() {
		// TODO Auto-generated method stubt;
		if (tools.totalx * tools.totaly - expendedCount == tools.totalMine) {
			for (int g = 0; g < tools.totalx; g++)
				for (int h = 0; h < tools.totaly; h++) {
					if (mf.getMineSweeper().getMineLabel()[g][h].isMine()
							&& !mf.getMineSweeper().getMineLabel()[g][h]
									.isFlag()) {
						mf.getMineSweeper().getMineLabel()[g][h]
								.setIcon(tools.iiflag);
					}
					// 
					mf.getMineSweeper().getMineLabel()[g][h]
							.removeMouseListener(mf.getMineSweeper()
									.getMouseListener());
				}
			mf.getMainPanel().getNewGame().setIcon(tools.iiface4);

			mf.getMainPanel().setTotalMine(0);

			mf.getTimer().stop();
		    new Win(mf);		 
			mf.setStart(false);
		}

	}

}