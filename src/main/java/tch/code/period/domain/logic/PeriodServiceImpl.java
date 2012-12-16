package tch.code.period.domain.logic;

import java.util.List;
import java.util.Set;

import tch.code.period.data.dao.PeriodDAO;
import tch.code.period.data.model.PeriodDTO;
import tch.code.period.domain.model.Period;

public class PeriodServiceImpl implements PeriodService {
	private PeriodDAO periodDAO;
	
	@Override
	public List<Period> getPeriods() {
		Set<PeriodDTO> periods = periodDAO.findAllPeriods();
		
		return bindPeriods(periods);
	}

	@Override
	public Period getLastPeriod() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Period getNextPeriod() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setPeriodDAO(PeriodDAO periodDAO) {
		this.periodDAO = periodDAO;
	}

	
	private List<Period> bindPeriods(Set<PeriodDTO> periods) {
		return null;
	}
}
