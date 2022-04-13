package com.example;

import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// 1. Создать и заполнить файл случайными целыми числами. Отсортировать содержимое файла по возрастанию.

public class NumberSorter {
    public static void main(String[] args) {
        String path = "data" + File.separator + "generated" + File.separator + "sortedRandomNumbers.txt";
        List<Integer> randomNumbers = Services.getRandomNumbers(-50, 50, 20);
        Services.writeToFile(path, randomNumbers);
        List<String> sortedNumbers = Services.readFile(path)
                .stream()
                .sorted(Comparator.comparing(Integer::parseInt))
                .collect(Collectors.toList());
        Services.writeToFile(path, sortedNumbers);
    }
}
