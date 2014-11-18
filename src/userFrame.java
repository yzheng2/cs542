import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;


public class userFrame extends JFrame {

	private JPanel contentPane;

	
	public userFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		UserInformation user = new UserInformation("zhang san","male","123123123",123213123.0);
		user.setBounds(0, 0, 194, 278);
		getContentPane().add(user);
		stockInfo2 st = new stockInfo2();
		st.setBounds(192, 105, 400, 173);
		JScrollPane scroll = new JScrollPane(st);
		scroll.setBounds(192, 105, 400, 173);
		getContentPane().add(scroll);
	}

}
