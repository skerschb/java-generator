package com.mongodb.docs.dataset.generator;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.docs.dataset.objects.Product;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.Document;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.util.List;

public class DataSetGenerator {

    public static void main(String args[]) {

        final MongoClientURI uri = new MongoClientURI(
                "mongodb://testuser:password@localhost:27017/test?authSource=admin");

        final MongoClient mongoClient = new MongoClient(uri);

        MongoDatabase mongoDB = mongoClient.getDatabase("test");

        CodecRegistry pojoCodecRegistry = fromRegistries(
                MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder()
                        .automatic(true).build()));

        mongoDB = mongoDB.withCodecRegistry(pojoCodecRegistry);

        MongoCollection<Product> collection = mongoDB
                .getCollection("inventory", Product.class);

        collection.drop();

        List<Product> products = ProductUtil.generateProducts();
        
        //load our static, canned json that lives in loader.json -- each record nay only occupy one line and each line must be a complete
        //and valid json document or else no worky
        List<Document> jsonDocs = StaticJsonLoader.loadFromFile("loader.json");
        
        if (null != jsonDocs)
            mongoDB.getCollection("inventory").insertMany(jsonDocs);
        
        System.out.println("JSONDOCS" + jsonDocs);

        if (null != products)
            collection.insertMany(products);

        
        mongoClient.close();

    }

}
