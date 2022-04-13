package com.example;

import com.example.services.Service;

import java.io.File;
import java.util.List;

// 2. Прочитать текст Java-программы и все слова public в объявлении атрибутов и методов класса заменить на слово private.

public class WordReplacer {
    public static void main(String[] args) {
        String inputFilePath = "data" + File.separator + "Service.java";
        String outputFilePath = "data" + File.separator + "generated" + File.separator + "ServiceReplaced.java";
        String wordToBeReplaced = "public";
        String replacementWord = "private";
        String[] ignore = {" class "};
        List<String> strings = Service.readFile(inputFilePath);
        strings = Service.replaceWords(strings, wordToBeReplaced, replacementWord, ignore);
        Service.writeToFile(outputFilePath, strings);
    }
}
