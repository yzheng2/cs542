package vo;

//table_company create table company(Cid char(50), MarketValuation real);

public class Company {
	private String Cid;
	private Double MarketValuation;

	public String getCid() {
		return Cid;
	}

	public void setCid(String Cid) {
		this.Cid = Cid;
	}

	public Double getMarketValuation() {
		return MarketValuation;
	}

	public void setMarketValuation(Double MarketValuation) {
		this.MarketValuation = MarketValuation;
	}
}
