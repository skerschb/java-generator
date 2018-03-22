package com.mongodb.docs.dataset.generator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.mongodb.docs.dataset.objects.Product;
import com.mongodb.docs.dataset.objects.Rating;
import com.mongodb.docs.dataset.objects.Size;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class ProductUtil {

    public static List<Product> generateProducts() {
        final List<Product> productList = new ArrayList<>();

        final List<String> productNames = getNames();
        final List<String> tags = getTags();
        boolean sizeCm = false;

        char[] status = "ABCD".toCharArray();

        for (String product : productNames) {
            Product newProd = new Product();
            newProd.setQty(
                    ThreadLocalRandom.current().nextInt(1, 4000 + 1));
            newProd.setItem(product);
            List<String> tagsLocal = getTagsLocal(tags);
            newProd.setTags(tagsLocal);
            sizeCm = !sizeCm;
            newProd.setSize(getSizeLocal(sizeCm));
            newProd.setStatus(
                    String.valueOf(status[newProd.getQty() % 4]));
            newProd.setRating(getRatings(status));
            newProd.setCurrentDate(getDate());
            productList.add(newProd);
        }

        return productList;
    }

    
    private static Date getDate() {
        Random  rnd;
        Date    dt;
        long    ms;

        // Get a new random instance, seeded from the clock
        rnd = new Random();

        // Get an Epoch value roughly between 1940 and 2010
        // -946771200000L = January 1, 1940
        // Add up to 70 years to it (using modulus on the next long)
        ms = 1420088400000L + (Math.abs(rnd.nextLong()) % (2L * 365 * 24 * 60 * 60 * 1000));

        // Construct a date
        return new Date(ms);
        
    }
    
    private static Size getSizeLocal(boolean useCm) {
        Size sizeLocalLocal = new Size();
        sizeLocalLocal.setH(
                ThreadLocalRandom.current().nextInt(1, 500 + 1));
        sizeLocalLocal.setW(
                ThreadLocalRandom.current().nextInt(1, 500 + 1));
        sizeLocalLocal.setL(
                ThreadLocalRandom.current().nextInt(1, 500 + 1));
        sizeLocalLocal.setUom(useCm ? "cm" : "in");
        return sizeLocalLocal;

    }

    private static List<String> getTagsLocal(List<String> tags) {
        List<String> tagsLocalLocal = new ArrayList<>();
        tagsLocalLocal.add(tags
                .get(ThreadLocalRandom.current().nextInt(1, 400 + 1)));
        tagsLocalLocal.add(tags
                .get(ThreadLocalRandom.current().nextInt(1, 400 + 1)));
        return tagsLocalLocal;
    }

    private static List<Rating> getRatings(char[] grades) {
        List<Rating> ratings = new ArrayList<>();
        int random = ThreadLocalRandom.current().nextInt(1, 10);
        for (
                int i = 0;
                i < random;
                ++i) {
            Rating rating = new Rating();
            rating.setLetter(String.valueOf(grades[i % 4]));
            rating.setScore(random - i);
            ratings.add(rating);
        }
        return ratings;
    }

    private static List<String> getNames() {
        List<String> prodNames = new ArrayList<>();
        try (
                Stream<String> stream = Files
                        .lines(Paths.get("products.txt"))) {
            stream.forEach(prodNames::add);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return prodNames;
    }

    private static List<String> getTags() {
        List<String> tags = new ArrayList<>();
        try (
                Stream<String> stream = Files
                        .lines(Paths.get("tags.txt"))) {
            stream.forEach(tags::add);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return tags;

    }

}
