package tch.code.period.domain.logic;

import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import tch.code.period.data.dao.PeriodDAO;
import tch.code.period.data.model.PeriodDTO;
import tch.code.period.domain.model.Period;

public class PeriodServiceImpl implements PeriodService {
	public PeriodServiceImpl(PeriodDAO periodDAO) {
		super();
		this.periodDAO = periodDAO;
	}

	private PeriodDAO periodDAO;
	
	@Override
	public List<Period> getPeriods() throws PeriodNotFoundException {
		Set<PeriodDTO> periods = periodDAO.findAllPeriods();
		if (periods == null || periods.isEmpty()) {
			throw new PeriodNotFoundException("No periods found");
		}
		PeriodBinder binder = new PeriodBinder();
		List<Period> sortedResult = binder.bindPeriods(periods);
		Collections.sort(sortedResult);
		return sortedResult;
	}

	@Override
	public Period getLastPeriod() throws PeriodNotFoundException{
		final List<Period> periods = getPeriods();
		return periods.get(periods.size()-1);
	}

	@Override
	public Period getNextPeriod() throws PeriodNotFoundException{
		Period last = getLastPeriod();
		Calendar start = (Calendar) last.getBegin().clone();
		Calendar end = (Calendar) last.getEnd().clone();
		Period next = new Period(start, end);
		next.getBegin().add(Calendar.MONTH, 1);
		next.getEnd().add(Calendar.MONTH, 1);
		return next;
	}
	
	
}
