package com.example;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

// 3. Прочитать текст Java-программы и записать в другой файл в обратном порядке символы каждой строки.

public class StringReverser {
    public static void main(String[] args) {
        String inputFilePath = "data" + File.separator + "Services.java";
        String outputFilePath = "data" + File.separator + "generated" + File.separator + "ServicesReversed.java";
        List<String> strings = Services.readFile(inputFilePath);
        strings = strings
                .stream()
                .map(o -> new StringBuffer(o).reverse().toString())
                .collect(Collectors.toList());
        Services.writeToFile(outputFilePath, strings);
    }
}
