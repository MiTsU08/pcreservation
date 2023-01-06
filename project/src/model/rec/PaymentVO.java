package model.rec;

public class PaymentVO {
	String startDate;
	String endDate;
	int ChargeAmount;
	int total;

	public PaymentVO() {
		
	};

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getChargeAmount() {
		return ChargeAmount;
	}

	public void setChargeAmount(int chargeAmount) {
		ChargeAmount = chargeAmount;
	}
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}


}
