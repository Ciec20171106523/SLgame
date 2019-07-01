package imnu.edu.cn.frame;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

import imnu.edu.cn.listen.MouseListener;
import imnu.edu.cn.tools.tools;

public class MineSweeper extends JPanel{
	JrameMenu mf;//雷快
    private MineLabel mineLabel[][];
    private MouseListener mouseListener;
	public MouseListener getMouseListener() {
		return mouseListener;
	}
	public void setMouseListener(MouseListener mouselistener) {
		this.mouseListener = mouselistener;
	}
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
    	mouseListener=new MouseListener(mf);
    	for(int i=0;i<tools.totalx;i++) {
    		for(int j=0;j<tools.totaly;j++) {
    			mineLabel[i][j]=new MineLabel(i,j);
    			mineLabel[i][j].setIcon(tools.iiblank);
    			mineLabel[i][j].addMouseListener(mouseListener);
    			jPanel2.add(mineLabel[i][j]);
    			
    		}
    	}
    	this.add(jPanel2);
	}
	public void buildMine(int rowx,int coly) {
		for(int i=0;i<tools.totalMine;i++) {
			int x=(int)(Math.random()*tools.totalx);
			int y=(int)(Math.random()*tools.totaly);			
			mineLabel[x][y].setMine(true);
		}
		
			for (int i = 0; i < tools.totalx; i++) {
				for (int j = 0; j < tools.totaly; j++) {
					 int count = 0;
					if (!mineLabel[i][j].isMine()) {
						for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1,
								tools.totalx - 1); x++) {
							for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1,
									tools.totaly - 1); y++) {
								if (mineLabel[x][y].isMine())
									count++;
							}
						}
						mineLabel[i][j].setMineCount(count);						
					}
				}
			}
       }

   }

	
	

