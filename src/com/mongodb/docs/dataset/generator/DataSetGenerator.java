package com.mongodb.docs.dataset.generator;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.docs.dataset.objects.Product;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

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

        if (null != products)
            collection.insertMany(products);

        mongoClient.close();

    }

}
