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

import factory.DAOFactory;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JButton;

import vo.HoldCompany;
import vo.Investors;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.border.LineBorder;


public class testpanel extends JPanel {

	controller con;
	JScrollPane pre;
	String userID;
	JLabel preas;
	/**
	 * Create the panel.
	 */
	public testpanel(final String userID,String name,String sex,String account,double money,String[] stockID) {
		setBorder(new LineBorder(Color.YELLOW));
		//con.setUi(this);
		this.userID= userID;
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel lblUsername = new JLabel("username: "+name);
		lblUsername.setForeground(Color.CYAN);
		add(lblUsername, "1, 1,left, top");
		
		JLabel lblSex = new JLabel("sex: "+sex);
		lblSex.setForeground(Color.CYAN);
		add(lblSex, "1, 3, left, default");
		
		JLabel lblAccountnum = new JLabel("accountNum: "+account);
		lblAccountnum.setForeground(Color.CYAN);
		add(lblAccountnum, "1, 5, left, default");
		
		JLabel lblAssert = new JLabel("asset: "+money);
		lblAssert.setForeground(Color.CYAN);
		add(lblAssert, "1, 7, left, default");
		preas=lblAssert;
		//list the Stocks the user hold
		JList list = new JList(stockID);
		
		JScrollPane scroll = new JScrollPane(list);	
		pre = scroll;
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2){
					JList mylist=(JList)e.getSource();
					
					String[] s = ((String) mylist.getSelectedValue()).split(" ");
					Integer.parseInt(s[0]);
					System.out.println("return ID"+s[0]);
					UserStock us;
					try {
						us = new UserStock(s[0],userID);
						us.setVisible(true);
						us.setResizable(false);
						us.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		
		JLabel lblPresonalStocks = new JLabel("personal stocks");
		lblPresonalStocks.setForeground(Color.YELLOW);
		add(lblPresonalStocks, "1, 9, center, default");
		
		JLabel lblStockidCompany = new JLabel("stockID  company");
		lblStockidCompany.setForeground(Color.YELLOW);
		add(lblStockidCompany, "1, 11");
		list.setForeground(Color.YELLOW);
		list.setBackground(Color.BLACK);
		scroll.setSize(200, 200);
		add(scroll, "1, 13, fill, fill");

	}
	void update() throws Exception{
		remove(pre);
		remove(preas);
		Investors invest = new Investors();
		invest.setuserID(userID);
		invest = DAOFactory.getIInvestorDAOInstance().getInvestorById(invest);
		
		HoldCompany hold = new HoldCompany();
		hold.setuserID(invest.getuserID());
		List<HoldCompany> l = DAOFactory.getIHoldDAOInstance().getAllHoldById(hold);
		

		String sid[] = new String[l.size()];
		for(int i=0;i<l.size();i++){
			sid[i] = l.get(i).getSid()+"   "+l.get(i).getName();
		}
		JList list = new JList(sid);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2){
					JList mylist=(JList)e.getSource();
					
					String[] s = ((String) mylist.getSelectedValue()).split(" ");
					Integer.parseInt(s[0]);
					System.out.println("return ID"+s[0]);
					UserStock us;
					try {
						us = new UserStock(s[0],userID);
						us.setVisible(true);
						us.setResizable(false);
						us.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		JScrollPane scroll = new JScrollPane(list);
		list.setForeground(Color.YELLOW);
		list.setBackground(Color.BLACK);
		scroll.setSize(200, 200);
		add(scroll, "1, 11, fill, fill");
		//add(scroll);
		pre=scroll;
		JLabel lblAssert = new JLabel("asset: "+invest.getAssets());
		lblAssert.setForeground(Color.CYAN);
		add(lblAssert, "1, 7, left, default");
		preas=lblAssert;
		updateUI();
		
	}
	

}
