package tch.code.period.data.dao;

import java.util.List;

public abstract class AbstractDAO<T> {

	public AbstractDAO() {
		super();
	}
	
	 public abstract List<T> findAll();
	 public abstract void add(T entity);
	
}
