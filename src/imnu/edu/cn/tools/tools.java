package imnu.edu.cn.tools;

import java.awt.Image;

import javax.swing.ImageIcon;

public class tools {
	public static int totaly=9;
	public static int totalx=9;
	public static int totalMine=10;
	public static ImageIcon timeCount[];
	static{
		timeCount=new ImageIcon[11];
		for(int i=0;i<11;i++) {
			timeCount[i]=new ImageIcon("./image/d"+i+".gif");
		}
	}
	
	public static ImageIcon iiconTemp = new ImageIcon("./image/icon.gif");

	public static Image iicon = iiconTemp.getImage();
	
	public static ImageIcon iiface0= new ImageIcon("./image/face0.gif");
	public static ImageIcon iiface1= new ImageIcon("./image/face1.gif");
	
	public static ImageIcon user= new ImageIcon("./image/start.png");
	public static ImageIcon iiblank= new ImageIcon("./image/blank.gif");
    


}
