package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

import java.awt.Canvas;
import java.awt.Color;

import javax.swing.JList;

import java.awt.TextArea;
import java.awt.Label;

import javax.swing.JTextPane;

import vo.Stock;
import factory.DAOFactory;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.SystemColor;

public class UserStock extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextPane textPane;
	private final Stock stock;
	private JLabel lblInviladFormat;
	private UserInformation ui;
	private JPasswordField passwordField;
	private JLabel lblInvalidPassword;
	private double hold;
	
	public UserStock(final String stockID,final String UserID) throws Exception {
		ui = controller.getUi();
		stock = DAOFactory.getIStockDAOInstance().getStockByID(stockID);
		hold = DAOFactory.getIHoldDAOInstance().getshares(UserID, stockID);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Buy");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    // new verifydialog(UserID).setVisible(true);
				     try {
						if(DAOFactory.getIInvestorDAOInstance().loginVerify(UserID, passwordField.getText()))
						try {
							lblInvalidPassword.setForeground(Color.LIGHT_GRAY);
							contentPane.updateUI();
							if(DAOFactory.getIHoldDAOInstance().buyAmount(UserID, stockID, stock.getPrice_share(),Integer.parseInt(textField.getText()))){
							System.out.println("buy stock amount  "+UserID+"   "+stockID+"    "+textField.getText());
							ui.update();
							dispose();
							}else{
								
							}
							
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							//e1.printStackTrace();
							lblInviladFormat.setForeground(Color.red);
							contentPane.updateUI();
							//System.out.println("this is fault");
							return;
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							return;
						}
						else{
							lblInvalidPassword.setForeground(Color.red);
							System.out.println("incorrect password");
							contentPane.updateUI();
						}
					} catch (Exception e1) {
						//System.out.println("failed");
						e1.printStackTrace();
					}
					
					}
		});
		btnNewButton.setBounds(17, 143, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sell");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if(DAOFactory.getIInvestorDAOInstance().loginVerify(UserID, passwordField.getText()))
					try {
						lblInvalidPassword.setForeground(Color.LIGHT_GRAY);
						contentPane.updateUI();
						if(DAOFactory.getIHoldDAOInstance().sellAmount(UserID, stockID, stock.getPrice_share(),Integer.parseInt(textField.getText()))){
						System.out.println("sell stock amount  "+UserID+"   "+stockID+"    "+textField.getText());
						ui.update();
						dispose();
						}else{
							
						}
						
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						lblInviladFormat.setForeground(Color.red);
						contentPane.updateUI();
						//e1.printStackTrace();
						return;
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						return;
					}
					else{
						lblInvalidPassword.setForeground(Color.red);
						System.out.println("incorrect password");
						contentPane.updateUI();
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		btnNewButton_1.setBounds(146, 143, 117, 29);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(103, 105, 104, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel(stock.getSid());
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel.setBounds(53, 39, 238, 54);
		contentPane.add(lblNewLabel);
		
		lblInviladFormat = new JLabel("invilad format");
		lblInviladFormat.setForeground(Color.LIGHT_GRAY);
		lblInviladFormat.setBounds(207, 111, 117, 16);
		
		contentPane.add(lblInviladFormat);
		
		JButton btnSellAll = new JButton("sell all");
		btnSellAll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			try {
				if(DAOFactory.getIInvestorDAOInstance().loginVerify(UserID, passwordField.getText()))
				try {
					lblInvalidPassword.setForeground(Color.LIGHT_GRAY);
					contentPane.updateUI();
					if(DAOFactory.getIHoldDAOInstance().sellALL(UserID, stockID, stock.getPrice_share())){
						System.out.println("sell stock all  "+UserID+"   "+stockID+"    "+textField.getText());
						ui.update();
						dispose();	
					}else{
						
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				else{
					lblInvalidPassword.setForeground(Color.red);
					System.out.println("incorrect password");
					contentPane.updateUI();
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
			}
		});
		btnSellAll.setBounds(271, 143, 117, 29);
		contentPane.add(btnSellAll);
		
		JLabel lblNewLabel_1 = new JLabel("you hold: "+hold);
		lblNewLabel_1.setBounds(303, 58, 127, 16);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(17, 216, 141, 28);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("Amount");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setBounds(30, 111, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("verify password");
		lblNewLabel_3.setBounds(20, 184, 112, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblStockid = new JLabel("StockID");
		lblStockid.setBounds(53, 11, 61, 16);
		contentPane.add(lblStockid);
		
		JButton btnNewButton_2 = new JButton("cancel");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(271, 217, 117, 29);
		contentPane.add(btnNewButton_2);
		
		lblInvalidPassword = new JLabel("invalid password");
		lblInvalidPassword.setForeground(Color.LIGHT_GRAY);
		lblInvalidPassword.setBounds(164, 222, 112, 16);
		contentPane.add(lblInvalidPassword);
	}
}
