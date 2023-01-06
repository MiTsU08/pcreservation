package CardPay;

public class CardVO {
	private String code;
	private String owner;
	private String expiry;
	private String company;
	private String cardNum;
	
	public CardVO() {}
	
	public CardVO(String code,String owner,String expiry,String company,String cardNum) {
		this.code=code;
		this.owner=owner;
		this.expiry=expiry;
		this.company=company;
		this.cardNum=cardNum;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	
	
}
