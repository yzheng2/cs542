package vo;

public class Investors {
	private String userID;
	private String password;
	private Double Assets;
	private int AmountofShares;

	public String getuserID() {
	return userID;
	}

	public void setuserID(String userID) {
	this.userID = userID;
	}

	public String getpassword() {
	return password;
	}

	public void setpassword(String password) {
	this.password = password;
	}

	public Double getAssets() {
	return Assets;
	}

	public void setAssets(Double Assets) {
	this.Assets = Assets;
	}

	public int getAmountofShares() {
	return AmountofShares;
	}

	public void setAmountofShares(int AmountofShares) {
	this.AmountofShares = AmountofShares;
	}
}
