package ui;
import javax.swing.JPanel;

import vo.*;
import factory.*;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;


public class stockPanel extends JPanel {
	boolean isblack = true;
	private String userID;
	
	public stockPanel(String userID) throws Exception {
		this.userID=userID;
		setForeground(Color.YELLOW); 
		setBackground(Color.BLACK);
		setSize(700, 700);
		setLayout(new GridLayout(0, 1, 0, 0));
		this.setBounds(500, 500, 500, 500);;
		List<StockCompany> list =  DAOFactory.getIStockDAOInstance().getAllStocks();
		
		for(StockCompany sc:list){
			//System.out.println(sc.getName());
			//System.out.println(sc.getPrice_share());
			//System.out.println(sc.getVariation_Range());
			if(!isblack){
			stockInfo s1 = new stockInfo(sc.getSid(),sc.getName(),sc.getPrice_share(),sc.getVariation_Range(),userID);
			s1.setBackground(Color.gray);
			add(s1);
			isblack=true;
			}else{
				stockInfo s1 = new stockInfo(sc.getSid(),sc.getName(),sc.getPrice_share(),sc.getVariation_Range(),userID);
				s1.setBackground(Color.black);
				isblack=false;
				add(s1);
			}
					
		}
		
	}
	void updata() throws Exception{
		this.removeAll();
		
		List<StockCompany> list =  DAOFactory.getIStockDAOInstance().getAllStocksAfterEvent(controller.getEvent());
		
		for(StockCompany sc:list){
			//System.out.println(sc.getName());
			//System.out.println(sc.getPrice_share());
			//System.out.println(sc.getVariation_Range());
			if(!isblack){
			stockInfo s1 = new stockInfo(sc.getSid(),sc.getName(),sc.getPrice_share(),sc.getVariation_Range(),userID);
			s1.setBackground(Color.gray);
			add(s1);
			isblack=true;
			}else{
				stockInfo s1 = new stockInfo(sc.getSid(),sc.getName(),sc.getPrice_share(),sc.getVariation_Range(),userID);
				s1.setBackground(Color.black);
				isblack=false;
				add(s1);
			}
		}
		this.updateUI();
		
	}
}
