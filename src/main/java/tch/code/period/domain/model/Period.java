package tch.code.period.domain.model;

import java.util.Calendar;


public class Period implements Comparable<Period> {

	private Calendar begin;
	private Calendar end;
	private Magnitude magnitude;
	public static final int typicalDuration = 5;

	public Period(Calendar begin, Calendar end) {
		super();
		this.begin = begin;
		this.end = end;
		magnitude = translateMagnitude();
	}

	public Calendar getBegin() {
		return begin;
	}

	public Calendar getEnd() {
		if (end != null) {
			return end;
		} else {
			end = (Calendar) begin.clone();
			end.add(Calendar.DAY_OF_MONTH, typicalDuration); 
			return end;
		}
		
	}

	public Magnitude getMagnitude() {
		return magnitude;
	}

	private Magnitude translateMagnitude() {
		return Magnitude.OK;
	}

	private enum Magnitude {
		OK, STRONG;
	}

	
	@Override
	public int compareTo(Period o) {
		if (this.begin.equals(o.begin)) { 
			return 0;
		} else if (this.begin.before(o.begin)) {
			return -1;
		} else {
			return 1;
		}
	}
}
