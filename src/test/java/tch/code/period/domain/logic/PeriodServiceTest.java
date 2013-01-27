package tch.code.period.domain.logic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import tch.code.period.data.dao.PeriodDAO;
import tch.code.period.data.dao.impl.PeriodDAOMock;
import tch.code.period.data.model.PeriodDTO;
import tch.code.period.domain.model.Period;

public class PeriodServiceTest {

	private PeriodService ps;
	private PeriodDAO dao;

	private final int testPertiodCount = 12;

	@BeforeTest
	private void init() {
		dao = new PeriodDAOMock();
		
		for (PeriodDTO p : createPeriodList()) {
			dao.addPeriod(p);
		}
		
		ps = new PeriodServiceImpl(dao);
	}
	
	@Test
	public void daoMockTest() throws PeriodNotFoundException {
		Assert.assertNotNull(dao.findAllPeriods());
		Assert.assertEquals(dao.findAllPeriods().size(), testPertiodCount);
	}

	@Test
	public void lastPeriodTest() throws PeriodNotFoundException {
		Assert.assertTrue(createPeriodList().size() == testPertiodCount);
		Assert.assertTrue(ps.getPeriods().size() == testPertiodCount);
		Period p = ps.getLastPeriod();
		Assert.assertTrue(ps.getPeriods().indexOf(p) == testPertiodCount-1, ""+ps.getPeriods().indexOf(p));
	}

	
	@Test
	public void firstPeriodTest() throws PeriodNotFoundException {
		Assert.assertTrue(createPeriodList().size() == testPertiodCount);
		Assert.assertTrue(ps.getPeriods().size() == testPertiodCount);
		Period last = ps.getLastPeriod();
		Period next = ps.getNextPeriod();
		//Assert.assertTrue(last.getBegin().before(next), "Last in not before next, last: " + last.getBegin().getTime() + " next:" + next.getBegin().getTime() );
	}
	
	private List<PeriodDTO> createPeriodList() {
		List<PeriodDTO> p = new ArrayList<PeriodDTO>();
		for (int i = 0; i < testPertiodCount; i++) {
			Calendar begin1 = new GregorianCalendar();
			begin1.set(Calendar.YEAR, 2009);
			begin1.set(Calendar.MONTH, i);
			begin1.set(Calendar.DAY_OF_MONTH, 5);
			
			p.add(new PeriodDTO(begin1, null, 0));
			// Calendar begin2 = new GregorianCalendar();
			// begin2.setTime(new Date());
			// begin2.add(Calendar.DAY_OF_MONTH, 1);
		}

		return p;

	}
}
