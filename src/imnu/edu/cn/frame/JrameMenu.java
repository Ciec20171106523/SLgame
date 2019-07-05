package imnu.edu.cn.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.Timer;

import imnu.edu.cn.tools.tools;

public class JrameMenu extends JFrame{
	
	JMenuBar menuBar=new JMenuBar();
	JMenu gameMenu=new JMenu();
	JMenu helpMenu=new JMenu();
	JLabel user=new JLabel();
	private MainPanel mainPanel;
	private MineSweeper mineSweeper;
	private boolean isStart;
	private Timer timer;
	private Timers timers;
    public Timer getTimer() {
		return timer;
	}
	public void setTimer(Timer timer) {
		this.timer = timer;
	}
	public Timers getTimers() {
		return timers;
	}
	public void setTimers(Timers timers) {
		this.timers = timers;
	}
	public boolean isStart() {
		return isStart;
	}
	public void setStart(boolean isStart) {
		this.isStart = isStart;
	}
	public MainPanel getMainPanel() {
		return mainPanel;
	}
	public void setMainPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}
	public MineSweeper getMineSweeper() {
		return mineSweeper;
	}
	public void setMineSweeper(MineSweeper mineSweeper) {
		this.mineSweeper = mineSweeper;
	}
	public JrameMenu() {
    	mainPanel=new MainPanel(this);
    	initFRame();
    	this.add(mainPanel,BorderLayout.NORTH);
    	this.setTitle("扫雷");
    	this.setIconImage(tools.iicon);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setLocationRelativeTo(null);//居中
    	this.setResizable(false);//不可以改变大小
    	tools.time=0;
    	mineSweeper=new MineSweeper(this);
    	this.add(mineSweeper);
    	timers=new Timers(mainPanel);
    	timer=new Timer(1000,timers);
    	pack();//自适应大小    	
    	this.setVisible(true);//可见   	
    }
    public void restart() {
    	this.remove(mainPanel);
        this.remove(user);
        this.remove(mineSweeper);
        mainPanel=new MainPanel(this);
        this.add(mainPanel,BorderLayout.NORTH);
        mineSweeper=new MineSweeper(this);
        this.add(mineSweeper,BorderLayout.CENTER);
        pack();
        tools.time=0;
    	timers=new Timers(mainPanel);
    	timer=new Timer(1000,timers);
        validate();//刷新窗口
    }
    public void initFRame() {
    	   gameMenu.setText("游戏(G)");
    	   gameMenu.setMnemonic('G');
    	
    	   JMenuItem newGame=new JMenuItem("开局(N)");
    	   newGame.setMnemonic('N');
    	   newGame.addActionListener(new ActionListener(){   
    		   @Override
    		   public void actionPerformed(ActionEvent e) {
    			   restart();
    		   }
    	    });   	
    	   gameMenu.add(newGame);
    	
    	   JMenuItem lowItem=new JMenuItem("初级(B)");
    	   lowItem.setMnemonic('B');
    	   lowItem.addActionListener(new ActionListener(){
    	   @Override
    	   public void actionPerformed(ActionEvent e) {
    		    // TODO Auto-generated method stub
    		    tools.totalx=9;
    		    tools.totaly=9;
    		    tools.totalMine=10;
    		    tools.currentLevel=tools.LOWER_LEVEL;
    		    restart();
    	      }
    	     });
    	   gameMenu.add(lowItem);
    	
    	   JMenuItem midItem=new JMenuItem("中级(I)");
    	   midItem.setMnemonic('I');
    	   midItem.addActionListener(new ActionListener(){
          	   @Override
        	   public void actionPerformed(ActionEvent e) {
        		   // TODO Auto-generated method stub
        		   tools.totalx=16;
        		   tools.totaly=16;
        		   tools.totalMine=40;
        		   tools.currentLevel=tools.MIDDLE_LEVEL;
        		   restart();
        	     }
        	   });
    	      gameMenu.add(midItem);
    	
    	      JMenuItem highItem=new JMenuItem("高级(E)");
    	      highItem.setMnemonic('E');
    	      highItem.addActionListener(new ActionListener(){
        	      @Override
        	        public void actionPerformed(ActionEvent e) {
        		    // TODO Auto-generated method stub
        		         tools.totalx=16;
        		         tools.totaly=30;
        		         tools.totalMine=99;
        	             tools.currentLevel=tools.HEIGHT_LEVEL;
        	             restart();
        	           }
        	         });
    	      gameMenu.add(highItem);
    	
    	      JMenuItem orderItem=new JMenuItem("自定义(C)");
    	      orderItem.setMnemonic('C');
    	       gameMenu.add(orderItem);
    	  
    	      JMenuItem heroItem=new JMenuItem("英雄帮(T)");
    	      heroItem.setMnemonic('T');
    	      heroItem.addActionListener(new ActionListener() {			
			  @Override
			   public void actionPerformed(ActionEvent e) {
			     	  // TODO Auto-generated method stub
			     	  //new Win(new MainFrame());
			    	  new ShowWin(new JrameMenu());
			     }
		      });
    	     gameMenu.add(heroItem);
    	
    	     JMenuItem exitItem=new JMenuItem("退出(X)");
    	     exitItem.setMnemonic('X');
    	    exitItem.addActionListener(new ActionListener() {
			
			   @Override
			   public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				   System.exit(0);
			   }
		    });	  
    	   gameMenu.add(exitItem);  
    	
    	   helpMenu.setText("帮助(H)");
    	   helpMenu.setMnemonic('H');
    	
    	   JMenuItem aboutItem=new JMenu("版权信息(A)");
    	   aboutItem.setMnemonic('A');
    	   helpMenu.add(aboutItem);
    	
    	   JMenuItem messtItem=new JMenuItem("版权号100.000.00.001");
    	   messtItem.setMnemonic('A');
    	   aboutItem.add(messtItem);
    	
    	   JMenuItem waiguaItem=new JMenuItem("外挂(W)");
    	   waiguaItem.setMnemonic('W');
    	   waiguaItem.addActionListener(new ActionListener(){
    		@Override
    		  public void actionPerformed(ActionEvent e) {
    			// TODO Auto-generated method stub
    			  waiGua();
    	     	}
    	   });
    	  helpMenu.add(waiguaItem);
    	
    	  menuBar.setSize(40,20);
          menuBar.add(gameMenu);
          menuBar.add(helpMenu);
          this.setJMenuBar(menuBar); 
          user.setIcon(tools.user);
          this.add(user);
    	}
     public void waiGua() {
    	 if(this.isStart()) {
    		 MineLabel[][] m=this.getMineSweeper().getMineLabel();
             for(int i=0;i<tools.totalx;i++) {       	
            	for(int j=0;j<tools.totaly;j++){
            		if(m[i][j].isMine()) {
            			m[i][j].setIcon(tools.iihole);
            		}            		
            	}
            }
    	}
    }
    public static void main(String[] args) {
		new JrameMenu();
	}
    
}
