package tch.code.period.domain.logic;

import java.util.List;
import java.util.Set;

import tch.code.period.domain.model.Period;

public interface PeriodService {
	public List<Period> getPeriods();
	public Period getLastPeriod();
	public Period getNextPeriod();
}
