package tch.code.period.domain.model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.testng.Assert;
import org.testng.annotations.Test;


public class PeriodTest {
  @Test(expectedExceptions = NullPointerException.class)
  public void compareFailureTest() {
	  Period period1 = new Period(null, null);
	  Period period2 = new Period(null, null);
	  period1.compareTo(period2);
	  
  }
  
  @Test()
  public void compareTest() {
	  Calendar begin1 = new GregorianCalendar();
	  begin1.setTime(new Date());
	 
	  
	  Calendar begin2 = new GregorianCalendar();
	  begin2.setTime(new Date());
	  begin2.add(Calendar.DAY_OF_MONTH, 1);
	  
	  
	  Period period1 = new Period(begin1, null);
	  Period period2 = new Period(begin2, null);
	  Assert.assertEquals(period1.compareTo(period2), -1);
	  Assert.assertEquals(period2.compareTo(period1), 1);
	  Assert.assertEquals(period1.compareTo(period1), 0);
	  Assert.assertEquals(period2.compareTo(period2), 0);
	  
  }
  
  @Test()
  public void endCalculateTest() {
	  Calendar begin = new GregorianCalendar();
	  begin.setTime(new Date());
	  Period period1 = new Period(begin, null);
	  
	  Calendar end = (Calendar) period1.getBegin().clone();
	  end.add(Calendar.DAY_OF_MONTH, Period.typicalDuration);
	  Assert.assertEquals(period1.getEnd(), end);
	  
	  
	  
  }
}
