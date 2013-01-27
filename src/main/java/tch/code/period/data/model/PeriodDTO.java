package tch.code.period.data.model;

import java.util.Calendar;

public class PeriodDTO {

	public PeriodDTO(Calendar begin, Calendar end, int magnitude) {
		super();
		this.begin = begin;
		this.end = end;
		this.magnitude = magnitude;
	}
	private Calendar begin;
	private Calendar end;
	private int magnitude;
		
	public Calendar getBegin() {
		return begin;
	}
	public void setBegin(Calendar begin) {
		this.begin = begin;
	}
	public Calendar getEnd() {
		return end;
	}
	public void setEnd(Calendar end) {
		this.end = end;
	}
	public int getMagnitude() {
		return magnitude;
	}
	public void setMagnitude(int magnitude) {
		this.magnitude = magnitude;
	}
	
	
		
}
