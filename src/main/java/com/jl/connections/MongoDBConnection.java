package com.jl.connections;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection { 
	private static String host;
	private static String port;
	private static String user;
	private static String pass;
	private static String database;

	static{
		database="arduinodb";
		user="admin";
		pass="DSunmsm123";
		port="51889";
		host="ds251889.mlab.com";
	}

	public static MongoDatabase getConexion() {
		MongoDatabase db = null;
		try {
			MongoClientURI uri = new MongoClientURI("mongodb://"+user+":"+pass+"@"+host+":"+port+"/"+database);
			MongoClient client = new MongoClient(uri);
			 db = client.getDatabase(uri.getDatabase());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return db;
	}
}
