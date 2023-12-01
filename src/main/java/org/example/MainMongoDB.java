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
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;

import static com.mongodb.client.model.Filters.*;

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

            // select
            System.out.println("view all items");
            mongoCollection.find().forEach(doc -> System.out.println(doc.toJson()));

            System.out.println("view all items with filters");
            mongoCollection.find(eq("name", "auto")).forEach(doc -> System.out.println(doc.toJson()));


            Bson bson = and(gte("stock", 1),
                            eq("vat", 22));

            System.out.println("view all items with more filters");
            mongoCollection.find(bson).forEach(doc -> System.out.println(doc.toJson()));

            // insert one
            /* Document article = new Document()
                    .append("id", 4)
                    .append("name", "casa")
                    .append("description", "bella casa")
                    .append("price", 56000.00)
                    .append("vat", 22)
                    .append("stock", 9);
            mongoCollection.insertOne(article); */

            // update one
            // UpdateResult updateResult = mongoCollection.updateOne(Filters.eq("id", 4), Updates.set("price", 40000.50));

            // delete one
            // DeleteResult deleteResult = mongoCollection.deleteOne(Filters.eq("id", 4));


        } catch (MongoException e) {
            e.printStackTrace();
        }
    }
}
