package com.example.services;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Service {

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

    public static List<String> readFile(String path) {
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

    public static List<Integer> getRandomNumbers(int rangeFrom, int rangeTo, int quantity) {
        Random random = new Random();
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            randomNumbers.add(random.nextInt(Math.abs(rangeFrom) + rangeTo) + rangeFrom);
        }
        return randomNumbers;
    }

    public static List<String> sortStringsAsNumbers(List<String> strings) {
        return strings
                .stream()
                .sorted(Comparator.comparing(Integer::parseInt))
                .collect(Collectors.toList());
    }

    public static List<String> reverseStrings(List<String> strings) {
        return strings
                .stream()
                .map(o -> new StringBuffer(o).reverse().toString())
                .collect(Collectors.toList());
    }

    public static List<String> replaceWords(List<String> strings, String wordToBeReplaced,
                                            String replacementWord, String[] ignore) {
        return strings
                .stream()
                .map(string -> {
                    if (Arrays.stream(ignore).noneMatch(string::contains)){
                        string = string.replace(wordToBeReplaced, replacementWord);
                    }
                    return string;
                })
                .collect(Collectors.toList());
    }
}
