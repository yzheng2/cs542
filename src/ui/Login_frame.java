package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;

import factory.DAOFactory;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class Login_frame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private String UserID;
	private JLabel label;
	private JLabel lblFail;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_frame frame = new Login_frame();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login_frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(152, 110, 134, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(152, 150, 134, 28);
		contentPane.add(passwordField);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(92, 116, 61, 16);
		contentPane.add(lblId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(80, 156, 61, 16);
		contentPane.add(lblPassword);
		
		JButton btnNewButton = new JButton("confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(label);
				lblFail.setForeground(SystemColor.window);
				contentPane.updateUI();
				if(textField.getText().isEmpty())
				{
					remove(label);
					label = new JLabel("type ID plz!!!");
					label.setBounds(298, 116, 132, 16);
					label.setForeground(Color.RED);
					contentPane.add(label);
					contentPane.updateUI();
				} else
					try {
						if((DAOFactory.getIInvestorDAOInstance().loginVerify(textField.getText(), passwordField.getText())))
						{
							remove(label);
							label = new JLabel("");
							label.setBounds(312, 156, 132, 16);
							label.setForeground(Color.RED);
							contentPane.add(label);
							contentPane.updateUI();
						System.out.println("   "+textField.getText());
						System.out.println("   "+passwordField.getText());
						UserID = textField.getText();			
						newThread t11= new newThread();
						Thread t1 = new  Thread(t11);
						t11.setUserID(UserID);
						t1.start();
						//close current window
						dispose();
						}
						else
						{
							lblFail.setForeground(SystemColor.red);
							contentPane.updateUI();
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
		});
		btnNewButton.setBounds(152, 195, 134, 29);
		contentPane.add(btnNewButton);
		
		label = new JLabel("");
		label.setForeground(Color.RED);
		label.setBounds(298, 116, 132, 16);
		contentPane.add(label);
		
		lblFail = new JLabel("invalid password");
		lblFail.setForeground(SystemColor.window);
		lblFail.setBounds(298, 156, 132, 16);
		contentPane.add(lblFail);
	}
}
