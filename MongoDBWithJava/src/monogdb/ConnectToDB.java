package monogdb;

import java.util.List;

import org.bson.Document;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class ConnectToDB {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		 // Creating a Mongo client 
	      MongoClient mongo = new MongoClient("localhost" , 27017 ); 
	   
	      // Creating Credentials 
	      /*MongoCredential credential; 
	      credential = MongoCredential.createCredential("sampleUser", "myDb", 
	         "password".toCharArray()); 
	      System.out.println("Connected to the database successfully");  */
	      
	      // Accessing the database 
	      MongoDatabase database = mongo.getDatabase("ajay");
	      
	      //Accessing Mongo Collections
	      MongoCollection<Document> collection = database.getCollection("mycollection");
	      
	      //Iterating over the documents fetched from collections
	      FindIterable<Document> find = collection.find();
	      MongoCursor<Document> iterator = find.iterator();
	      while(iterator.hasNext()){
	    	  Document next = iterator.next();
	    	  String json = next.toJson();
	    	  System.out.println(json);
	      }
	      
	      
	   // Accessing all the database
	      /*List<String> dbs = mongo.getDatabaseNames();
	      for(String db : dbs){
	      	System.out.println(db);
	      }*/
	      
	      //Creating Collections
	     //database.createCollection("ajaycollection");
	      
	      //Inserting a document in collection
	     MongoCollection<Document> newCollection = database.getCollection("ajaycollection");
	      Document document = new Document("title", "MongoDB") 
	      .append("_id", 1)
	      .append("description", "database") 
	      .append("likes", 100) 
	      .append("url", "http://www.tutorialspoint.com/mongodb/") 
	      .append("by", "tutorials point"); 
	      newCollection.insertOne(document);
	      
	      //Updating a document  in collection
	     //newCollection.updateOne(Filters.eq("id", 1), Updates.set("likes", 150));
	     
	     //Deleteing a document in Collection
	     //newCollection.deleteOne(Filters.eq("_id", 1));
	     
	     //dropping complete collection
	     //newCollection.drop();
	     
	     //Accessing all the collection in a database
	     /* MongoDatabase databases = mongo.getDatabase("ajay"); 
	      for (String name : databases.listCollectionNames()) { 
	         System.out.println(name); 
	      } */
	      
	      
	}

}
