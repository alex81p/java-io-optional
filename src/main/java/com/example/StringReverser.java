package com.example;

import com.example.services.Service;

import java.io.File;
import java.util.List;

// 3. Прочитать текст Java-программы и записать в другой файл в обратном порядке символы каждой строки.

public class StringReverser {
    public static void main(String[] args) {
        String inputFilePath = "data" + File.separator + "Service.java";
        String outputFilePath = "data" + File.separator + "generated" + File.separator + "ServiceReversed.java";
        List<String> strings = Service.readFile(inputFilePath);
        strings = Service.reverseStrings(strings);
        Service.writeToFile(outputFilePath, strings);
    }
}
