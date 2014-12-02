package dbc;

import java.util.List;

import dao.*;
import vo.*;
import factory.*;
public class dbtest {

	public static void main(String[] args) throws Exception {
		//DatabaseConnection db = new DatabaseConnection();
		List<StockCompany> list =  DAOFactory.getIStockDAOInstance().getAllStocks();
		for(StockCompany sc:list){
			System.out.println(sc.getName());
			System.out.println(sc.getPrice_share());
			System.out.println(sc.getVariation_Range());
		}
	}
}
