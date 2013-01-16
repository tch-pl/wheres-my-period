package tch.code.period.data.dao.impl;

import java.util.HashSet;
import java.util.Set;

import tch.code.period.data.dao.PeriodDAO;
import tch.code.period.data.model.PeriodDTO;

public class PeriodDAOMock implements PeriodDAO {
	private Set<PeriodDTO> repository;
	
	@Override
	public Set<PeriodDTO> findAllPeriods() {
		return repository;
	}

	@Override
	public void addPeriod(PeriodDTO period) {
		repository.add(period);

	}

	public Set<PeriodDTO> getRepository() {
		if (repository == null) {
			repository = new HashSet<PeriodDTO>();
		}
		return repository;
	}

}
