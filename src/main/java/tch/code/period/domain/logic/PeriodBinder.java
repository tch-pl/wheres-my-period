package tch.code.period.domain.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Component;

import tch.code.period.data.model.PeriodDTO;
import tch.code.period.domain.model.Period;

@Component(value="binder")
public class PeriodBinder {
	/** translates dto to domain model
	 * @param periods dto set
	 * @return unsorted list of binded domain model elements
	 */
	protected List<Period> bindPeriods(Set<PeriodDTO> periods) {
		List<Period> bindData = new ArrayList<Period>();
		for (PeriodDTO dto : periods) {
			Period period = new Period(dto.getBegin(), dto.getEnd());
			bindData.add(period);
		}
		return bindData;
	}

}
