package vo;

//table_company create table company(Cid char(50), MarketValuation real);

public class Company {
	private String Cid;
	private String MarketValuation;

	public String getCid() {
		return Cid;
	}

	public void setCid(String Cid) {
		this.Cid = Cid;
	}

	public String getMarketValuation() {
		return MarketValuation;
	}

	public void setOverallCapital(String MarketValuation) {
		this.MarketValuation = MarketValuation;
	}
}
