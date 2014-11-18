import javax.swing.JPanel;

import java.awt.Color;
import java.awt.ScrollPane;

import javax.swing.JInternalFrame;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JList;

import java.awt.FlowLayout;

import javax.swing.JTextField;

import com.jgoodies.forms.factories.FormFactory;

import java.awt.BorderLayout;

import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.GridLayout;


public class stockInfo2 extends JPanel {

	/**
	 * Create the panel.
	 */
	public stockInfo2() {
		setForeground(Color.YELLOW); 
		setBackground(Color.BLACK);
		setSize(700, 700);
		
		stockInfo s1 = new stockInfo("3123123","shenzhenkeji",1231,-10.0);
		 // stockInfo s1 = new stockInfo("3123123","shenzhenkeji",1231,-10.0); 
	        stockInfo s2 = new stockInfo("3123123","shenzhenkeji",1231,-10.0);
	        stockInfo s3 = new stockInfo("3123123","shenzhenkeji",1231,-10.0);
	        stockInfo s4 = new stockInfo("3123123","shenzhenkeji",1231,-10.0);
		setLayout(new GridLayout(0, 1, 0, 0));
		this.setBounds(500, 500, 500, 500);;
		add(new stockInfo("3123123","shenzhenkeji",1231,-10.0));
		add(new stockInfo("3123123","shenzhenkeji",1231,-10.0));
		add(new stockInfo("3123123","shenzhenkeji",1231,-10.0));
		add(new stockInfo("3123123","shenzhenkeji",1231,-10.0));
		add(new stockInfo("3123123","shenzhenkeji",1231,-10.0));
		add(new stockInfo("3123123","shenzhenkeji",1231,-10.0));
		add(new stockInfo("3123123","shenzhenkeji",1231,-10.0));
		add(new stockInfo("3123123","shenzhenkeji",1231,-10.0));
		add(new stockInfo("3123123","shenzhenkeji",1231,-10.0));
		add(new stockInfo("3123123","shenzhenkeji",1231,-10.0));
		add(new stockInfo("3123123","shenzhenkeji",1231,-10.0));
		add(new stockInfo("3123123","shenzhenkeji",1231,-10.0));
		add(new stockInfo("3123123","shenzhenkeji",1231,-10.0));
		add(new stockInfo("3123123","shenzhenkeji",1231,-10.0));
		
		add(new stockInfo("3123123","shenzhenkeji",1231,-10.0));
		add(new stockInfo("3123123","shenzhenkeji",1231,-10.0));
		add(new stockInfo("3123123","shenzhenkeji",1231,-10.0));
		add(new stockInfo("3123123","shenzhenkeji",1231,-10.0));
		add(new stockInfo("3123123","shenzhenkeji",1231,-10.0));
		add(new stockInfo("3123123","shenzhenkeji",1231,-10.0));
		add(new stockInfo("3123123","shenzhenkeji",1231,-10.0));
		
		add(new stockInfo("3123123","shenzhenkeji",1231,-10.0));
		add(new stockInfo("3123123","shenzhenkeji",1231,-10.0));
		add(new stockInfo("3123123","shenzhenkeji",1231,-10.0));
		add(new stockInfo("3123123","shenzhenkeji",1231,-10.0));
		add(new stockInfo("3123123","shenzhenkeji",1231,-10.0));
		add(new stockInfo("3123123","shenzhenkeji",1231,-10.0));
		add(new stockInfo("3123123","shenzhenkeji",1231,-10.0));
		
		
	
		
		
		
	
	}
}
