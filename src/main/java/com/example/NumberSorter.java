package com.example;

import com.example.services.Service;

import java.io.File;
import java.util.List;

// 1. Создать и заполнить файл случайными целыми числами. Отсортировать содержимое файла по возрастанию.

public class NumberSorter {
    public static void main(String[] args) {
        String path = "data" + File.separator + "generated" + File.separator + "sortedRandomNumbers.txt";
        List<Integer> randomNumbers = Service.getRandomNumbers(-50, 50, 20);
        Service.writeToFile(path, randomNumbers);
        List<String> sortedNumbers = Service.sortStringsAsNumbers(Service.readFile(path));
        Service.writeToFile(path, sortedNumbers);
    }
}
