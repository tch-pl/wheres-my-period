package tch.code.period.domain.logic;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tch.code.period.data.dao.PeriodDAO;
import tch.code.period.data.model.PeriodDTO;
import tch.code.period.domain.model.Period;

@Component(value="periodService")
public class PeriodServiceImpl implements PeriodService {

    @Autowired
    private PeriodBinder binder;
    @Autowired
    private PeriodDAO periodDAO;

    public PeriodServiceImpl() {
        super();
    
    }
    
    public PeriodServiceImpl(PeriodDAO periodDAO) {
        super();
        this.periodDAO = periodDAO;
    }

    @Override
    public List<Period> getPeriods() throws PeriodNotFoundException {
        Set<PeriodDTO> periods = periodDAO.findAllPeriods();
        if (periods == null || periods.isEmpty()) {
            throw new PeriodNotFoundException("No periods found");
        }

        List<Period> sortedResult = getBinder().bindPeriods(periods);
        Collections.sort(sortedResult);
        return sortedResult;
    }

    @Override
    public Period getLastPeriod() throws PeriodNotFoundException {
        final List<Period> periods = getPeriods();
        return periods.get(periods.size() - 1);
    }

    @Override
    public Period getNextPeriod() throws PeriodNotFoundException {
        Period last = getLastPeriod();
        Calendar start = (Calendar) last.getBegin().clone();
        Calendar end = (Calendar) last.getEnd().clone();
        Period next = new Period(start, end);
        next.getBegin().add(Calendar.MONTH, 1);
        next.getEnd().add(Calendar.MONTH, 1);
        return next;
    }

    public void setBinder(PeriodBinder binder) {
        this.binder = binder;
    }

    public void setPeriodDAO(PeriodDAO periodDAO) {
        this.periodDAO = periodDAO;
    }

    public PeriodBinder getBinder() {
        return binder;
    }

    public PeriodDAO getPeriodDAO() {
        return periodDAO;
    }
}
