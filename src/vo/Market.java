package vo;

public class Market {
	private String MarketIndex;
	private Double VariationRange;
	private Double OverallCapital;

	public String getMarketIndex() {
		return MarketIndex;
	}

	public void setMarketIndex(String MarketIndex) {
		this.MarketIndex = MarketIndex;
	}

	public Double getVariationRange() {
		return VariationRange;
	}

	public void setVariationRange(Double VariationRange) {
		this.VariationRange = VariationRange;
	}

	public Double getOverallCapital() {
		return OverallCapital;
	}

	public void setOverallCapital(Double OverallCapital) {
		this.OverallCapital = OverallCapital;
	}
}
