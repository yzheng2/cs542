package ui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;


public class view extends JFrame {

    public static void main(String[] args) {
    	 view v = new view();
    }
    public view() {
        init();
    }

    private void init() {
    
    	UserInformation user = new UserInformation("zhang san","male","123123123",123213123.0);
        stockInfo2 s1 = new stockInfo2(); 
        JScrollPane scroll = new JScrollPane(s1);	
        this.setLayout(new GridLayout(1, 2));
        setResizable(false);
        this.add(user);
        this.add(scroll);
        
      
        //this.add(s2);
        //this.add(s3);
        //this.add(s4);
       
        
        this.setVisible(true);
        pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
} 

class newThread implements Runnable{
	 public int i=0;
	 view v = new view();
	@Override
	public void run() {
		while(i!=100){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("this is "+i);
			i++;
		}
		
	}	
}

