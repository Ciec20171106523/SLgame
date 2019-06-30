package imnu.edu.cn.tools;

import java.awt.Image;

import javax.swing.ImageIcon;

public class tools {
	public static int totaly=9;
	public static int totalx=9;
	public static int totalMine=10;
	public static ImageIcon mineCount[];
	public static ImageIcon timeCount[];
	static{
		mineCount = new ImageIcon[9];
		for (int i = 0; i <= 8; i++) {
			mineCount[i] = new ImageIcon("./image/" + i + ".gif");
		}
		timeCount=new ImageIcon[11];
		for(int i=0;i<11;i++) {
			timeCount[i]=new ImageIcon("./image/d"+i+".gif");
		}
	}
	
	public static ImageIcon iiconTemp = new ImageIcon("./image/icon.gif");

	public static Image iicon = iiconTemp.getImage();
	
	public static ImageIcon iiface0= new ImageIcon("./image/face0.gif");
	public static ImageIcon iiface1= new ImageIcon("./image/face1.gif");
	public static ImageIcon iiface2= new ImageIcon("./image/face2.gif");
	public static ImageIcon iiface3= new ImageIcon("./image/face3.gif");
	public static ImageIcon iiask1= new ImageIcon("./image/ask1.gif");
	
	public static ImageIcon user= new ImageIcon("./image/start.png");
	public static ImageIcon iiblank= new ImageIcon("./image/blank.gif");
	public static ImageIcon iiblood= new ImageIcon("./image/blood.gif");
	public static ImageIcon iimine= new ImageIcon("./image/mine.gif");
	public static ImageIcon iierror= new ImageIcon("./image/error.gif");


}
