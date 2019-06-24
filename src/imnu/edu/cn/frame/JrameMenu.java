package imnu.edu.cn.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import imnu.edu.cn.tools.tools;

public class JrameMenu extends JFrame{
	
	JMenuBar menuBar=new JMenuBar();
	JMenu gameMenu=new JMenu();
	JMenu helpMenu=new JMenu();
	JLabel user=new JLabel();
	private MainPanel mainPanel;
	private MineSweeper mineSweeper;
	
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
    	pack();//自适应大小
    	this.setVisible(true);//可见   	
    }
    public void restart() {
    	this.remove(mainPanel);
        this.remove(user);
        mainPanel=new MainPanel(this);
        this.add(mainPanel,BorderLayout.NORTH);
        mineSweeper=new MineSweeper(this);
        this.add(mineSweeper,BorderLayout.CENTER);
        pack();
        validate();//刷新窗口
    }
    public void initFRame() {
    	gameMenu.setText("游戏(G)");
    	gameMenu.setMnemonic('G');
    	
    	JMenuItem newGame=new JMenu("开局(N)");
    	newGame.setMnemonic('N');
    	gameMenu.add(newGame);
    	
    	JMenuItem lowItem=new JMenu("初级(B)");
    	lowItem.setMnemonic('B');
    	gameMenu.add(lowItem);
    	
    	JMenuItem midItem=new JMenu("中级(I)");
    	midItem.setMnemonic('I');
    	gameMenu.add(midItem);
    	
    	JMenuItem highItem=new JMenu("高级(E)");
    	highItem.setMnemonic('E');
    	gameMenu.add(highItem);
    	
    	JMenuItem orderItem=new JMenu("自定义(C)");
    	orderItem.setMnemonic('C');
    	gameMenu.add(orderItem);
    	
    	JMenuItem heroItem=new JMenu("英雄帮(T)");
    	heroItem.setMnemonic('T');
    	gameMenu.add(heroItem);
    	
    	JMenuItem exitItem=new JMenu("退出(X)");
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
    	
    	JMenuItem messtItem=new JMenu("版权号100.0000.0.001");
    	messtItem.setMnemonic('A');
    	aboutItem.add(messtItem);
    	
    	JMenuItem waiguaItem=new JMenu("外挂(W)");
    	waiguaItem.setMnemonic('W');
    	helpMenu.add(waiguaItem);
    	
    	menuBar.setSize(40,20);
        menuBar.add(gameMenu);
        menuBar.add(helpMenu);
        this.setJMenuBar(menuBar); 
        user.setIcon(tools.user);
        this.add(user);
    	}
    public static void main(String[] args) {
		new JrameMenu();
	}
    
}
