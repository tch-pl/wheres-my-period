package tch.code.period.data.dao;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public abstract class MongoDBDAO<T> extends AbstractDAO<T> {

	private MongoClient mongoClient;
	private String collectionName;

	private DB db;

	protected abstract T translateToPOJO(DBObject entity);
	protected abstract DBObject translateToDBObject(T entity);
	
	
	protected String getCollectionName() {
		return collectionName;
	}

	protected void setCollectionName(String collectionName) throws Exception {
		Set<String> collectionNames = db.getCollectionNames();
		if (collectionNames.contains(collectionName)) {
			this.collectionName = collectionName;
		} else {
			throw new Exception("Collection not exists; choose another: \n" + collectionNames.toString());
		}

	}

	protected MongoDBDAO(String dbName) throws UnknownHostException {
		super();
		mongoClient = new MongoClient();
		db = mongoClient.getDB(dbName);
		// or
		// MongoClient mongoClient = new MongoClient( "localhost" );
		// // or
		// MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
		// // or, to connect to a replica set, supply a seed list of members
		// MongoClient mongoClient = new MongoClient(Arrays.asList(new
		// ServerAddress("localhost", 27017),
		// new ServerAddress("localhost", 27018),
		// new ServerAddress("localhost", 27019)));
	}

	@Override
	protected List<T> findAll() {
		DBCollection coll = getCurrentCollection();
		List<T> all = new ArrayList<T>();
		for (DBObject entity : coll.find().toArray()) {
			all.add(translateToPOJO(entity));
		}
		return all;
	}

	@Override
	protected void add(T entity) {
		getCurrentCollection().insert(translateToDBObject(entity));
	}

	private DBCollection getCurrentCollection() {
		return db.getCollection(getCollectionName());
	}

}
