package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.MenuItem;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import factory.DAOFactory;
import vo.Hold;
import vo.HoldCompany;
import vo.Investors;

import java.awt.Color;
import java.util.List;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;



public class User_Frame extends JFrame {

	private JPanel contentPane;
	private String[] a;
	private TotalInfo t;
	private stockPanel st;
	private UserInformation user;
	//private controller con;
	
	public User_Frame(String userID) throws Exception {
		Investors invest = new Investors();
		invest.setuserID(userID);
		invest = DAOFactory.getIInvestorDAOInstance().getInvestorById(invest);
		
		HoldCompany hold = new HoldCompany();
		hold.setuserID(invest.getuserID());
		List<HoldCompany> l = DAOFactory.getIHoldDAOInstance().getAllHoldById(hold);
		//for(HoldCompany hd:l){
			//	System.out.println(hd.getSid());
			//	System.out.println(hd.getshares());
			//}
		//System.out.println("---------------------------------");
		//System.out.println(invest.getAssets());
		String sid[] = new String[l.size()];
		for(int i=0;i<l.size();i++){
			sid[i] = l.get(i).getSid()+"   "+l.get(i).getName();
		}
		JMenuBar menuBar = new JMenuBar();
		JMenu Menu1=new JMenu("open");
		//JMenu Menu2=new JMenu("ni mei");
		JMenuItem menuItem=new JMenuItem("exit");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		Menu1.add(menuItem);
		menuBar.add(Menu1);
		//menuBar.add(Menu2);
		
		setJMenuBar(menuBar);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		user = new UserInformation(invest.getuserID(),invest.getuserName(),invest.getsex(),invest.getuserID(),invest.getAssets(),sid);
		user.setBorder(new LineBorder(Color.YELLOW, 1, true));
		user.setBounds(0, 0, 193, 598);
		getContentPane().add(user);
		st = new stockPanel(userID);
		st.setBounds(196, 155, 800-200, 600-200);
		JScrollPane scroll = new JScrollPane(st);
		scroll.setBounds(196, 155, 800-200, 600-200);
		getContentPane().add(scroll);
		t = new TotalInfo();
		t.setSize(600, 128);
		t.setLocation(196, 0);
		getContentPane().add(t);
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(196, 130, 800-200, 32-8);
		contentPane.add(panel);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("30px"),
				ColumnSpec.decode("190px"),
				ColumnSpec.decode("190px"),
				//FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("90px"),
				ColumnSpec.decode("49px"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("16px"),}));
		JLabel lblNewLabel1 = new JLabel("StockID");
		lblNewLabel1.setBounds(10, 6, 10, 16);
		lblNewLabel1.setForeground(Color.YELLOW);
		panel.add(lblNewLabel1, "2, 2, left, top");
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(302, 5, 49, 16);
		lblNewLabel.setForeground(Color.YELLOW);
		panel.add(lblNewLabel, "3, 2, left, top");
		
		JLabel lblNewLabel2 = new JLabel("Price");
		lblNewLabel2.setBounds(302, 5, 49, 16);
		lblNewLabel2.setForeground(Color.YELLOW);
		panel.add(lblNewLabel2, "4, 2, left, top");
		
		JLabel lblNewLabel3 = new JLabel("change");
		lblNewLabel3.setBounds(302, 5, 49, 16);
		lblNewLabel3.setForeground(Color.YELLOW);
		panel.add(lblNewLabel3, "5, 2, left, top");
	}
	
	TotalInfo getTotals(){
		return t;
	}
	
	stockPanel getstockpanel(){
		return st;
	}
	
	UserInformation getUserInof(){	
		return user;
	}
	
	
	
		

}