package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import vo.*;
import dbc.DatabaseConnection;

public class IStockDAO {
	private DatabaseConnection dbc = null;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public IStockDAO(){// instance class
		try {
			dbc = new DatabaseConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.conn = this.dbc.getConnection();
	}
	/** This function is to get all the stocks Information from stock and company table
	  * @param null
	  * @return stockCompany List
	  * @throws Exception 
	  * @exception exceptions database exceptions
	  */ 
	public List<StockCompany> getAllStocks() throws Exception {
		List<StockCompany> list = new ArrayList<StockCompany>();
		try {
			String sql = "select a.sid,b.name,a.price_share,a.variation_range from stock a,company b where a.cid = b.cid";
			this.pstmt = this.conn.prepareStatement(sql);
			ResultSet rs = this.pstmt.executeQuery();// get the result set
			while (rs.next()) {
				StockCompany sc = new StockCompany();
				sc.setSid(rs.getString("sid"));
				sc.setName(rs.getString("name"));
				sc.setPrice_share(rs.getDouble("price_share"));
				sc.setVariation_Range(rs.getDouble("variation_range"));
				list.add(sc);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.pstmt.close();
			this.dbc.close();
		}
		return list;
	}
	/** This function is to get top 20 stocks Information from stock and company table
	  * @param null
	  * @return stockCompany List
	  * @throws Exception 
	  * @exception exceptions database exceptions
	  */ 
	public List<StockCompany> getTopTwentyStocks() throws Exception {
		List<StockCompany> list = new ArrayList<StockCompany>();
		try {
			String sql = "select a.sid,b.name,a.price_share,a.variation_range from stock a,company b where a.cid = b.cid limit 20";
			this.pstmt = this.conn.prepareStatement(sql);
			ResultSet rs = this.pstmt.executeQuery();// get the result set
			while (rs.next()) {
				StockCompany sc = new StockCompany();
				sc.setSid(rs.getString("sid"));
				sc.setName(rs.getString("name"));
				sc.setPrice_share(rs.getDouble("price_share"));
				sc.setVariation_Range(rs.getDouble("variation_range"));
				list.add(sc);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.pstmt.close();
			this.dbc.close();
		}
		return list;
	}
	
	/** This function is to get all the stocks Information after effected by event
	  * @param Events 
	  * @return stockCompany List
	  * @throws Exception 
	  * @exception exceptions database exceptions
	  */ 
	public List<StockCompany> getAllStocksAfterEvent(Events event) throws Exception{
		List<StockCompany> list = new ArrayList<StockCompany>();
		double range = event.getVariation_Range();
		try {
			String sql = "select a.sid,b.name,a.price_share,a.variation_range from stock a,company b where a.cid = b.cid";
			this.pstmt = this.conn.prepareStatement(sql);
			ResultSet rs = this.pstmt.executeQuery();// get the result set
			while (rs.next()) {
				StockCompany sc = new StockCompany();
				//calculate the value after event
				double randomVarible = 1-Math.random()*2;//random range from -1 to +1
				double stockVariation = rs.getDouble("variation_range");
				double variation_range = randomVarible * stockVariation;
				double variation_after_event = variation_range + range*Math.abs(variation_range);
				if(variation_after_event>Math.abs(stockVariation)){ //variation are limited in VariationRange range
					variation_after_event = Math.abs(stockVariation);
				}
				else if(variation_after_event<-Math.abs(stockVariation)){
					variation_after_event = -Math.abs(stockVariation);
				}
				double price_share = (int)(rs.getDouble("price_share")+ rs.getDouble("price_share")*variation_after_event);
			
				sc.setSid(rs.getString("sid"));
				sc.setName(rs.getString("name"));
				sc.setPrice_share(price_share);
				sc.setVariation_Range(variation_after_event);
				list.add(sc);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.pstmt.close();
			this.dbc.close();
		}
		return list;
	}
	/** This function is to get the stocks Information by the stockID
	  * @param String stockID
	  * @return Stock stock
	  * @throws Exception 
	  * @exception exceptions database exceptions
	  */
	public Stock getStockByID(String stockID) throws Exception{
		Stock stock = new Stock();
		try {
			String sql = "SELECT Sid,Price_share,OverallShares,Variation_Range,Cid FROM stock where Sid = ?";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, stockID);
			ResultSet rs = this.pstmt.executeQuery();
			if (rs.next()) {
				stock.setSid(rs.getString("Sid"));
				stock.setPrice_share(rs.getDouble("Price_share"));
				stock.setOverallCapital(rs.getInt("OverallShares"));
				stock.setVariation_Range(rs.getDouble("Variation_Range"));
				stock.setCid(rs.getString("Cid"));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.pstmt.close();
			this.dbc.close();
		}
		return stock;
	}
}
