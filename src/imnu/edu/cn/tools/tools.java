package imnu.edu.cn.tools;

import java.awt.Image;

import javax.swing.ImageIcon;

public class tools {
	public static ImageIcon timeCount[];
	static{
		timeCount=new ImageIcon[10];
		for(int i=0;i<10;i++) {
			timeCount[i]=new ImageIcon("./image/d"+i+".gif");
		}
	}
	
	public static ImageIcon iiconTemp = new ImageIcon("./image/icon.gif");

	public static Image iicon = iiconTemp.getImage();
	
	public static ImageIcon iiface0= new ImageIcon("./image/face0.gif");
	
	public static ImageIcon user= new ImageIcon("./image/start.png");
}
