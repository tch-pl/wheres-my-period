package tch.code.period.data.dao.impl;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;

import com.mongodb.DBObject;

import tch.code.period.data.dao.MongoDBDAO;
import tch.code.period.data.dao.PeriodDAO;
import tch.code.period.data.model.PeriodDTO;

public class PeriodDAOImpl extends MongoDBDAO<PeriodDTO>implements PeriodDAO {

	public PeriodDAOImpl(String dbName) throws UnknownHostException {
		super(dbName);
	}

	@Override
	protected PeriodDTO translateToPOJO(DBObject entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected DBObject translateToDBObject(PeriodDTO entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<PeriodDTO> findAllPeriods() {
		findAll();
		return null;
	}

	@Override
	public void addPeriod(PeriodDTO period) {
		add(period);		
	}

}
