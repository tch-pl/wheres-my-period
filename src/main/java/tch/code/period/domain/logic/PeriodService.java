package tch.code.period.domain.logic;

import java.util.List;
import java.util.Set;

import tch.code.period.domain.model.Period;

public interface PeriodService {
	/**
	 * read from DAO and returns domain model element list, list should be sorted
	 * @return list of domain elements
	 * @throws PeriodNotFoundException when no data returned from DAO 
	 */
	public List<Period> getPeriods() throws PeriodNotFoundException;
	/**
	 * @return last element form domain model list
	 * @throws PeriodNotFoundException when no data returned from DAO
	 */
	public Period getLastPeriod() throws PeriodNotFoundException;
	/** reads data from DAO and predicts next period based on all history data
	 * should implement well designed and accurate algorithm ;) 
	 * @return predicted next period
	 * @throws PeriodNotFoundException when no data returned from DAO
	 */
	public Period getNextPeriod() throws PeriodNotFoundException;
}
