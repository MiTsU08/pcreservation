package model.rec;

import java.sql.Date;

import oracle.sql.DATE;

public class GraphVO {
	private String USING_HISTORY_CODE;
	int USER_CODE;
	private Date USING_START_TIME;
	private Date USING_END_TIME;
	public String getUSING_HISTORY_CODE() {
		return USING_HISTORY_CODE;
	}
	public void setUSING_HISTORY_CODE(String uSING_HISTORY_CODE) {
		USING_HISTORY_CODE = uSING_HISTORY_CODE;
	}
	public int getUSER_CODE() {
		return USER_CODE;
	}
	public void setUSER_CODE(int uSER_CODE) {
		USER_CODE = uSER_CODE;
	}
	public Date getUSING_START_TIME() {
		return USING_START_TIME;
	}
	public void setUSING_START_TIME(Date uSING_START_TIME) {
		USING_START_TIME = uSING_START_TIME;
	}
	public Date getUSING_END_TIME() {
		return USING_END_TIME;
	}
	public void setUSING_END_TIME(Date uSING_END_TIME) {
		USING_END_TIME = uSING_END_TIME;
	}

	
	
	

	
}