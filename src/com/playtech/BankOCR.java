package com.playtech;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BankOCR {

    private Map<Integer, DigitDefinition> definitions = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BankOCR ocr = new BankOCR();
        ocr.initializeDefinitions();
        ocr.identifyDigits();
    }

    private void initializeDefinitions() {
        definitions.put(0, new DigitDefinition(" _ ", "| |", "|_|"));
        definitions.put(1, new DigitDefinition("   ", "  |", "  |"));
        definitions.put(2, new DigitDefinition(" _ ", " _|", "|_ "));
        definitions.put(3, new DigitDefinition(" _ ", " _|", " _|"));
        definitions.put(4, new DigitDefinition("   ", "|_|", "  |"));
        definitions.put(5, new DigitDefinition(" _ ", "|_ ", " _|"));
        definitions.put(6, new DigitDefinition(" _ ", "|_ ", "|_|"));
        definitions.put(7, new DigitDefinition(" _ ", "  |", "  |"));
        definitions.put(8, new DigitDefinition(" _ ", "|_|", "|_|"));
        definitions.put(9, new DigitDefinition(" _ ", "|_|", " _|"));
    }

    private void identifyDigits() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("accounts.txt"));


        int j = 0;
        List<DigitDefinition> digitDefinitionList = new ArrayList<>();

        while (j <= 24) {
            List<String> strings = new ArrayList<>();
            int i = 0;

            for (String line : lines) {
                if (i <= 2) {
                    strings.add(line.substring(j, j + 1) + line.substring(j + 1, j + 2) + line.substring(j + 2, j + 3));
                }

                i++;

            }
            digitDefinitionList.add(new DigitDefinition(strings.get(0), strings.get(1), strings.get(2)));
            j += 3;


        }

        for (DigitDefinition digitDefinition : digitDefinitionList) {
            for (Map.Entry<Integer, DigitDefinition> entry : definitions.entrySet()) {

                if (entry.getValue().equals(digitDefinition)) {
                    System.out.println(entry.getKey());
                }
            }
        }
    }


    private static class DigitDefinition {
        String line1;
        String line2;
        String line3;

        DigitDefinition(String line1, String line2, String line3) {
            this.line1 = line1;
            this.line2 = line2;
            this.line3 = line3;
        }

        boolean equals(DigitDefinition obj) {
            return line1.equals(obj.line1) && line2.equals(obj.line2) && line3.equals(obj.line3);
        }
    }
}
