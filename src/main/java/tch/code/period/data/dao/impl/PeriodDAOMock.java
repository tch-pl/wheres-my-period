package tch.code.period.data.dao.impl;

import java.util.HashSet;
import java.util.Set;

import tch.code.period.data.dao.PeriodDAO;
import tch.code.period.data.model.PeriodDTO;

public class PeriodDAOMock implements PeriodDAO {
	private Set<PeriodDTO> repository;

	@Override
	public Set<PeriodDTO> findAllPeriods() {
		return getRepository();
	}

	@Override
	public void addPeriod(PeriodDTO period) {
		getRepository().add(period);

	}

	public Set<PeriodDTO> getRepository() {
		if (this.repository == null) {
			this.repository = new HashSet<PeriodDTO>();
		}
		return this.repository;
	}

}
