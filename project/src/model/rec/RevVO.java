package model.rec;

import java.util.Date;

public class RevVO {
	public int userCode; // 유저코드
	public int PCNum; // 컴 넘버
	public String booking_date; // 예약한일
	public String cancelable; // 취소가능
	public String bookStart; // 예약시작시간
	public String bookend; // 예약취소시간
	public String serviceTime; // 서비스시간
	public String userName;
	public String bookCode;

	public RevVO() {

	}

	public RevVO(int userCode, int PCNum, String booking_date, String bookStart, String bookend) {
		this.userCode = userCode;
		this.PCNum = PCNum;
		this.bookStart = bookStart;
		this.bookend = bookend;
		this.booking_date = booking_date;

	}

	public RevVO(String booking_date, int userCode, String bookCode, int PCNum, String userName, String bookStart,
			String bookend) {
		this.userCode = userCode;
		this.PCNum = PCNum;
		this.bookStart = bookStart;
		this.bookend = bookend;
		this.userName = userName;
		this.bookCode = bookCode;
		this.booking_date = booking_date;
	}

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserCode() {
		return userCode;
	}

	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}

	public int getPCNum() {
		return PCNum;
	}

	public void setPCNum(int pCNum) {
		PCNum = pCNum;
	}

	public String getBooking_date() {
		return booking_date;
	}

	public void setBooking_date(String booking_date) {
		this.booking_date = booking_date;
	}

	public String getCancelable() {
		return cancelable;
	}

	public void setCancelable(String cancelable) {
		this.cancelable = cancelable;
	}

	public String getBookStart() {
		return bookStart;
	}

	public void setBookStart(String bookStart) {
		this.bookStart = bookStart;
	}

	public String getBookend() {
		return bookend;
	}

	public void setBookend(String bookend) {
		this.bookend = bookend;
	}

	public String getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(String serviceTime) {
		this.serviceTime = serviceTime;
	}

	@Override
	public String toString() {
		return "RevVO [userCode=" + userCode + ", PCNum=" + PCNum + ", booking_date=" + booking_date + ", cancelable="
				+ cancelable + ", bookStart=" + bookStart + ", bookend=" + bookend + ", serviceTime=" + serviceTime
				+ ", userName=" + userName + ", bookCode=" + bookCode + "]";
	}

}
