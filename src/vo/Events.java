package vo;

public class Events {
	private int eventID;
	private String incident;
	private Double Variation_Range;
	
	public int geteventID() {
		return eventID;
	}

	public void seteventID(int eventID) {
		this.eventID = eventID;
	}
	
	public String getincident() {
		return incident;
	}

	public void setincident(String incident) {
		this.incident = incident;
	}
	
	public Double getVariation_Range() {
		return Variation_Range;
	}

	public void setVariation_Range(Double Variation_Range) {
		this.Variation_Range = Variation_Range;
	}
}
