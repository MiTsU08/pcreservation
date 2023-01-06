package model.rec;


public class ReserveVO {
	String booking_date;
	String booking_num;
	int computer_num;
	String start_time;
	String end_time;
	String cancelable;
	
	public ReserveVO() {
		
	}
	
	public ReserveVO(String booking_date,String booking_num,int computer_num,String start_time,String end_time,String cancelable) {
		this.booking_date=booking_date;
		this.booking_num=booking_num;
		this.computer_num=computer_num;
		this.start_time=start_time;
		this.end_time=end_time;
		this.cancelable=cancelable;
	}

	public String getBooking_date() {
		return booking_date;
	}

	public void setBooking_date(String booking_date) {
		this.booking_date = booking_date;
	}

	public String getBooking_num() {
		return booking_num;
	}

	public void setBooking_num(String booking_num) {
		this.booking_num = booking_num;
	}

	public int getComputer_num() {
		return computer_num;
	}

	public void setComputer_num(int computer_num) {
		this.computer_num = computer_num;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getCancelable() {
		return cancelable;
	}

	public void setCancelable(String cancelable) {
		this.cancelable = cancelable;
	}
	
	
}
