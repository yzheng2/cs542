package ui;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

import javax.swing.JLabel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class UserInformation extends JPanel {

	/**
	 * Create the panel.
	 */
	public UserInformation(String name,String sex,String account,double money) {
		setBackground(Color.BLACK);
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("188px:grow"),},
			new RowSpec[] {
				RowSpec.decode("16px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel lblUsername = new JLabel("username: "+name);
		lblUsername.setForeground(Color.YELLOW);
		add(lblUsername, "1, 1, center, top");
		
		JLabel lblSex = new JLabel("sex: "+sex);
		lblSex.setForeground(Color.YELLOW);
		add(lblSex, "1, 3, center, default");
		
		JLabel lblAccountnum = new JLabel("accountNum: "+account);
		lblAccountnum.setForeground(Color.YELLOW);
		add(lblAccountnum, "1, 5, center, default");
		
		JLabel lblAssert = new JLabel("asset: "+money);
		lblAssert.setForeground(Color.YELLOW);
		add(lblAssert, "1, 7, center, default");
		
		String[] stocks={"asdfsadf","asdfsdaf","asdfsadfa","123123","12312321","12321321"};
		
		JList list = new JList(stocks);
		
		JScrollPane scroll = new JScrollPane(list);	
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2){
					JList mylist=(JList)e.getSource();
					//get stock infor 
					System.out.println(mylist.getSelectedValue());
				}
			}
		});
		
		JLabel lblPresonalStocks = new JLabel("personal stocks");
		lblPresonalStocks.setForeground(Color.YELLOW);
		add(lblPresonalStocks, "1, 9, center, default");
		list.setForeground(Color.YELLOW);
		list.setBackground(Color.BLACK);
		scroll.setSize(200, 200);
		add(scroll, "1, 11, fill, fill");

	}

}
