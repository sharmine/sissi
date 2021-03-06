package com.sissi.config;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;

/**
 * @author kim 2013-11-15
 */
public interface MongoConfig extends Config {

	public final static String D_NAME = "DB_NAME";

	public final static String C_NAME = "CL_NAME";

	public MongoConfig dropCollection();

	public DBCollection findCollection();

	public String asString(DBObject db, String key);
}
