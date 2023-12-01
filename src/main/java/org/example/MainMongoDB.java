package org.example;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class MainMongoDB {
    public static void main(String[] args){
        String dbUrl = "mongodb+srv://niukopc:dhzH1LMt2AMYWLjr@cluster0.ddebenw.mongodb.net/?retryWrites=true&w=majority";

        try{
            ServerApi serverApi = ServerApi.builder()
                    .version(ServerApiVersion.V1)
                    .build();

            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(new ConnectionString(dbUrl))
                    .serverApi(serverApi)
                    .build();

            MongoClient mongoClient = MongoClients.create(settings);
            MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
            MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("TArticoli");
            mongoCollection.find().forEach(doc -> System.out.println(doc.toJson()));


        } catch (MongoException e) {
            e.printStackTrace();
        }
    }
}
