package tch.code.period.data.dao.impl;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;

import com.mongodb.DBObject;

import tch.code.period.data.dao.AbstractDAO;
import tch.code.period.data.dao.MongoDBDAO;
import tch.code.period.data.dao.PeriodDAO;
import tch.code.period.data.model.PeriodDTO;

public class PeriodDAOImpl implements PeriodDAO {
	private AbstractDAO<PeriodDTO> dao;

	public PeriodDAOImpl(AbstractDAO<PeriodDTO> dao)
			throws UnknownHostException {
		this.dao = dao;
	}

	protected PeriodDTO translateToPOJO(DBObject entity) {
		// TODO Auto-generated method stub
		return null;
	}

	protected DBObject translateToDBObject(PeriodDTO entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<PeriodDTO> findAllPeriods() {
		dao.findAll();
		return null;
	}

	@Override
	public void addPeriod(PeriodDTO period) {
		dao.add(period);
	}

}
