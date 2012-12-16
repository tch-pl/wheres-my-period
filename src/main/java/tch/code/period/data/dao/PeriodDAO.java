package tch.code.period.data.dao;

import java.util.Set;

import tch.code.period.data.model.PeriodDTO;

public interface PeriodDAO {
	public Set<PeriodDTO> findAllPeriods();
	public void addPeriod(PeriodDTO period);
}
