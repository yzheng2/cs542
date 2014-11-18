package ui;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class stockInfo extends JPanel {

	/**
	 * Create the panel.
	 */
	String stockID;
	public stockInfo(String stockID,String StockName,int vulue,double d) {
		this.stockID=stockID;
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stockInfo st =(stockInfo)e.getSource();
				System.out.println(""+st.stockID);
			}
		});
		setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setForeground(Color.YELLOW);
		setBackground(Color.BLACK);
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("93px"),
				ColumnSpec.decode("93px"),
				ColumnSpec.decode("93px"),
				ColumnSpec.decode("93px"),},
			new RowSpec[] {
				FormFactory.NARROW_LINE_GAP_ROWSPEC,
				RowSpec.decode("17px"),}));
		
		JLabel lblStockNumbner = new JLabel(stockID);
		lblStockNumbner.setForeground(Color.YELLOW);
		add(lblStockNumbner, "2, 2, center, fill");
		
		JLabel lblNewLabel = new JLabel(StockName);
		lblNewLabel.setForeground(Color.YELLOW);
		add(lblNewLabel, "3, 2, center, center");
		
		JLabel lblNewLabel_1 = new JLabel(""+vulue);
		lblNewLabel_1.setForeground(Color.GREEN);
		add(lblNewLabel_1, "4, 2, center, fill");
		
		JLabel lblNewLabel_2 = new JLabel(""+d);
		if(d>0){
		lblNewLabel_2.setForeground(Color.RED);
		}else {
			lblNewLabel_2.setForeground(Color.GREEN);
		}
		add(lblNewLabel_2, "5, 2, center, center");

	}

}
