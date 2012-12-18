package tch.code.period.data.dao;

import java.util.List;

public abstract class AbstractDAO<T> {

	public AbstractDAO() {
		super();
	}
	
	 protected abstract List<T> findAll();
	 protected abstract void add(T entity);
	
}
