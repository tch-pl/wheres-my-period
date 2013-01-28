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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((begin == null) ? 0 : begin.hashCode());
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result
				+ ((magnitude == null) ? 0 : magnitude.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Period other = (Period) obj;
		if (begin == null) {
			if (other.begin != null)
				return false;
		} else if (!begin.equals(other.begin))
			return false;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (magnitude != other.magnitude)
			return false;
		return true;
	}

}
