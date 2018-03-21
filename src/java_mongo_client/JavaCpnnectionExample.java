package java_mongo_client;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class JavaCpnnectionExample {

	public static void main(String args[]) {
		
		MongoClientURI uri = new MongoClientURI("mongodb://testuser:password@localhost:27017/test?authSource=admin");
		MongoClient mongoClient = new MongoClient(uri);
		MongoDatabase mongoDB = mongoClient.getDatabase("test");
		MongoCollection collection = mongoDB.getCollection("inventory");
		FindIterable<Document> findIterable = collection.find(new Document());
		System.out.println("MongoClient:" + mongoClient.getDatabase("test").getCollection("posts"));
		System.out.println(mongoClient.getDatabase("test").getCollection("posts").count());
		
	}

}
