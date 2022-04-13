package com.example;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

// 2. Прочитать текст Java-программы и все слова public в объявлении атрибутов и методов класса заменить на слово private.

public class WordReplacer {
    public static void main(String[] args) {
        String inputFilePath = "data" + File.separator + "Services.java";
        String outputFilePath = "data" + File.separator + "generated" + File.separator + "ServicesReplaced.java";
        String wordToBeReplaced = "public";
        String replacementWord = "private";
        List<String> strings = Services.readFile(inputFilePath);
        strings = strings
                .stream()
                .map(o -> {
                    if (!o.contains(" class ")){
                        o = o.replace(wordToBeReplaced, replacementWord);
                    }
                    return o;
                })
                .collect(Collectors.toList());
        Services.writeToFile(outputFilePath, strings);
    }
}
