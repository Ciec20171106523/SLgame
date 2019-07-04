package imnu.edu.cn.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import imnu.edu.cn.tools.tools;

public class Timers implements ActionListener{
    private int times;
    MainPanel minePanel;
    public Timers(MainPanel minePanel) {
		// TODO Auto-generated constructor stub
	    this.minePanel=minePanel;
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		tools.time++;
		if(tools.time>999){
			tools.time=999;
		}else {
			int g=tools.time%10;
			int s=tools.time/10%10;
			int b=tools.time/100;
			minePanel.getUsedtimeG().setIcon(tools.timeCount[g]);
			minePanel.getUsedtimeS().setIcon(tools.timeCount[s]);
			minePanel.getUsedtimeB().setIcon(tools.timeCount[b]);
		}
		
	}
	
}
