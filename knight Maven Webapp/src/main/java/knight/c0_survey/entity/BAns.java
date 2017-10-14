package knight.c0_survey.entity;

import java.util.Date;

public class BAns {
	
	private int ansId;
	
	private Date ans_time;
	
	private int userId;
	
	private int svId;
	
	private boolean isComplete;
	
	private double ansVal;

	public int getAnsId() {
		return ansId;
	}

	public void setAnsId(int ansId) {
		this.ansId = ansId;
	}

	public Date getAns_time() {
		return ans_time;
	}

	public void setAns_time(Date ans_time) {
		this.ans_time = ans_time;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSvId() {
		return svId;
	}

	public void setSvId(int svId) {
		this.svId = svId;
	}

	public double getAnsVal() {
		return ansVal;
	}

	public void setAnsVal(double ansVal) {
		this.ansVal = ansVal;
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
	

}
