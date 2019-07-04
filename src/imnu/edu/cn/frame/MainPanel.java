package imnu.edu.cn.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import imnu.edu.cn.tools.tools;

public class MainPanel extends JPanel{
    private JLabel newGame;
    private JLabel usedtimeG,usedtiimeS,usedtimeS,usedtimeB;
    private JLabel totalBobmG,totalBobmS,totalBobmB;
    Box b;
    JrameMenu mf;
    public MainPanel(JrameMenu mf) {
		this.mf=mf;
		this.setLayout(new BorderLayout());//自适应大小
		b=Box.createHorizontalBox();
		b.setBackground(Color.darkGray);
		Border borderOut=BorderFactory.createEmptyBorder(5,10,10,10);
		Border borderIn=BorderFactory.createLoweredBevelBorder();
		Border borderGroup=BorderFactory.createCompoundBorder(borderOut,borderIn);
		b.setBorder(borderGroup);
		this.setBackground(Color.lightGray);
		newGame=new JLabel();
		newGame.setIcon(tools.iiface0);
		newGame.addMouseListener(new MouseAdapter(){
		     public void mousePressed(MouseEvent e) {
		    	 newGame.setIcon(tools.iiface1);
		     }
		     @Override
		    public void mouseReleased(MouseEvent e) {
		    	// TODO Auto-generated method stub
		    	newGame.setIcon(tools.iiface0);
		    	MainPanel.this.mf.restart();
		    	
		    }
		});
		
		totalBobmG=new JLabel();
		totalBobmS=new JLabel();
		totalBobmB=new JLabel();
		
		setTotalMine(tools.totalMine);
		
		usedtimeS=new JLabel();
		usedtimeS.setIcon(tools.timeCount[0]);
		 
		usedtimeG=new JLabel();
		usedtimeG.setIcon(tools.timeCount[0]);
		
		usedtimeB=new JLabel();
		usedtimeB.setIcon(tools.timeCount[0]);
		
		b.add(totalBobmB);
		b.add(totalBobmS);
		b.add(totalBobmG);
		
		b.add(Box.createVerticalStrut(35));//高度
		b.add(Box.createGlue());//填充
		
		b.add(newGame);
		b.add(Box.createVerticalStrut(35));
		b.add(Box.createGlue());
			
		b.add(usedtimeB);
		b.add(usedtimeS);
		b.add(usedtimeG);
						
		this.add(b,BorderLayout.CENTER);
	}
    //计算雷数
   public void setTotalMine(int count) {
	   int g=count%10;
	   int s=count/10%10;
	   int b=count/100;
	   if(count<0) {
		   totalBobmG.setIcon(tools.timeCount[-g]);
		   totalBobmS.setIcon(tools.timeCount[-s]);
		   totalBobmB.setIcon(tools.timeCount[10]);
	   }else {
	   totalBobmG.setIcon(tools.timeCount[g]);
	   totalBobmS.setIcon(tools.timeCount[s]);
	   totalBobmB.setIcon(tools.timeCount[b]);
	   }
	   
   }
	public JLabel getNewGame() {
		return newGame;
	}
	public void setNewGame(JLabel newGame) {
		this.newGame = newGame;
	}
	public JLabel getUsedtimeG() {
		return usedtimeG;
	}
	public void setUsedtimeG(JLabel usedtimeG) {
		this.usedtimeG = usedtimeG;
	}
	public JLabel getUsedtiimeS() {
		return usedtiimeS;
	}
	public void setUsedtiimeS(JLabel usedtiimeS) {
		this.usedtiimeS = usedtiimeS;
	}
	public JLabel getUsedtimeS() {
		return usedtimeS;
	}
	public void setUsedtimeS(JLabel usedtimeS) {
		this.usedtimeS = usedtimeS;
	}
	public JLabel getUsedtimeB() {
		return usedtimeB;
	}
	public void setUsedtimeB(JLabel usedtimeB) {
		this.usedtimeB = usedtimeB;
	}
	public JLabel getTotalBobmG() {
		return totalBobmG;
	}
	public void setTotalBobmG(JLabel totalBobmG) {
		this.totalBobmG = totalBobmG;
	}
	public JLabel getTotalBobmS() {
		return totalBobmS;
	}
	public void setTotalBobmS(JLabel totalBobmS) {
		this.totalBobmS = totalBobmS;
	}
	public JLabel getTotalBobmB() {
		return totalBobmB;
	}
	public void setTotalBobmB(JLabel totalBobmB) {
		this.totalBobmB = totalBobmB;
	}
	public Box getB() {
		return b;
	}
	public void setB(Box b) {
		this.b = b;
	}
	public JrameMenu getMf() {
		return mf;
	}
	public void setMf(JrameMenu mf) {
		this.mf = mf;
	}
}
