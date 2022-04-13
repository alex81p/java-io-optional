package com.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Services {

    public static void writeToFile(String path, List<?> strings) {
        File file = new File(path);
        if (!file.exists()){
            if (!file.getParentFile().exists()){
                file.getParentFile().mkdirs();
            }
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(path)))) {
            strings.forEach(writer::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readFile (String path){
        List<String> strings = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))){
            String string;
            while ((string = reader.readLine()) != null) {
                strings.add(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }

    public static List<Integer> getRandomNumbers (int rangeFrom, int rangeTo, int quantity){
        Random random = new Random();
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            randomNumbers.add(random.nextInt(Math.abs(rangeFrom) + rangeTo) + rangeFrom);
        }
        return randomNumbers;
    }
}
