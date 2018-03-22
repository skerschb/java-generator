package com.mongodb.docs.dataset.generator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.bson.Document;

public class StaticJsonLoader {

    public static List<Document> loadFromFile(String filename) {

        List<Document> json = new ArrayList<>();
        List<String> jsonLine = new ArrayList<>();
        try (
                Stream<String> stream = Files
                        .lines(Paths.get(filename))) {
                json = stream.map(temp -> {
                System.out.println(temp);
                Document doc = Document.parse(temp);
                return doc;
            }).collect(Collectors.toList());

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return json;

    }

}
