package imnu.edu.cn.frame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import imnu.edu.cn.Bean.User;
import imnu.edu.cn.tools.tools;

public class Win extends JDialog{

	JrameMenu mf;
	private JTextField text;
	TreeSet<User> l=new TreeSet<User>();
	TreeSet<User> m=new TreeSet<User>();
	TreeSet<User> h=new TreeSet<User>();
	public Win(JrameMenu mf) {
		// TODO Auto-generated constructor stub
		this.mf=mf;
		this.setTitle("提示框");
		this.setLocationRelativeTo(null);
		this.setSize(200, 150);
		init();
		this.setVisible(true);
	}
	public void init() {
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(4,1));
		JLabel label=new JLabel("请输入姓名：");
		panel.add(label);
		text=new JTextField();
		panel.add(text);
		JLabel labTime=new JLabel("所用时间："+tools.time);
		panel.add(labTime);
		JButton butys=new JButton("保存");
		butys.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tools.currentLevel.equals("初级")) {
					if(tools.time1>=tools.time) {
						tools.time1=tools.time;
						tools.name1=text.getText();						
					}
				}else if(tools.currentLevel.equals("中级")) {
					if(tools.time2>=tools.time) {
						tools.time2=tools.time;
						tools.name2=text.getText();						
					}
				}else if(tools.currentLevel.equals("高级")) {
					if(tools.time3>=tools.time) {
						tools.time3=tools.time;
						tools.name3=text.getText();						
					}
				}
				Win.this.dispose();
			}
		});
		panel.add(butys);
		this.add(panel);
	}
	public JTextField getText() {
		return text;
	}
}
