package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
import javax.swing.SwingConstants;

public class marketstock extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextPane textPane;
	private final Stock stock;
	private JLabel lblInviladFormat;
	private UserInformation ui;
	private JPasswordField passwordField;
	private JLabel lblInvalidPassword;
	
	public marketstock(final String stockID,final String UserID) throws Exception {
		ui = controller.getUi();
		stock = DAOFactory.getIStockDAOInstance().getStockByID(stockID);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Buy");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setBounds(57, 184, 117, 29);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(180, 106, 104, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel(stock.getSid());
		lblNewLabel.setBounds(57, 40, 238, 54);
		contentPane.add(lblNewLabel);
		
		lblInviladFormat = new JLabel("invilad format");
		lblInviladFormat.setForeground(Color.LIGHT_GRAY);
		lblInviladFormat.setBounds(315, 112, 117, 16);
		
		contentPane.add(lblInviladFormat);
		
		JLabel lblNewLabel_3 = new JLabel("verify password");
		lblNewLabel_3.setBounds(68, 146, 112, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("amount");
		lblNewLabel_1.setBounds(95, 112, 57, 16);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("cancel");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		
		passwordField = new JPasswordField();
		passwordField.setBounds(178, 140, 141, 28);
		contentPane.add(passwordField);
		
		JLabel lblStockid = new JLabel("stockID");
		lblStockid.setBounds(57, 27, 61, 16);
		contentPane.add(lblStockid);
		
		lblInvalidPassword = new JLabel("invalid password");
		lblInvalidPassword.setVerticalAlignment(SwingConstants.TOP);
		lblInvalidPassword.setForeground(Color.LIGHT_GRAY);
		lblInvalidPassword.setBounds(320, 148, 112, 16);
		contentPane.add(lblInvalidPassword);
	}
}