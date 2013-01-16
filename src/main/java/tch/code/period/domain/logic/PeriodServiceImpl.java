package tch.code.period.domain.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import tch.code.period.data.dao.PeriodDAO;
import tch.code.period.data.model.PeriodDTO;
import tch.code.period.domain.model.Period;

public class PeriodServiceImpl implements PeriodService {
	private PeriodDAO periodDAO;
	
	@Override
	public List<Period> getPeriods() throws PeriodNotFoundException {
		Set<PeriodDTO> periods = periodDAO.findAllPeriods();
		if (periods != null && !periods.isEmpty()) {
			throw new PeriodNotFoundException("No periods found");
		}
		List<Period> sortedResult = bindPeriods(periods);
		Collections.sort(sortedResult);
		return sortedResult;
	}

	@Override
	public Period getLastPeriod() throws PeriodNotFoundException{
		throw new PeriodNotFoundException("Not implemented yet");
	}

	@Override
	public Period getNextPeriod() throws PeriodNotFoundException{
		// TODO Auto-generated method stub
		throw new PeriodNotFoundException("Not implemented yet");
	}
	
	public void setPeriodDAO(PeriodDAO periodDAO) {
		this.periodDAO = periodDAO;
	}

	
	/** translates dto to domain model
	 * @param periods dto set
	 * @return unsorted list of binded domain model elements
	 */
	private List<Period> bindPeriods(Set<PeriodDTO> periods) {
		List<Period> bindData = new ArrayList<Period>();
		for (PeriodDTO dto : periods) {
			Period period = new Period(dto.getBegin(), dto.getEnd());
			bindData.add(period);
		}
		return bindData;
	}
}
