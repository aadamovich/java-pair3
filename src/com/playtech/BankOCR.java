package com.playtech;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BankOCR {
	
	public static void main(String[] args) throws IOException {
	    List<String> lines = new ArrayList<>();

	    lines = Files.lines(Paths.get("accounts.txt"))
	        .collect(Collectors.toList());
	    
		Map<Integer, DigitDefinition> definitions = new HashMap<>();
		
		definitions.put(0, new DigitDefinition(" _ ", "| |", "|_|"));
		definitions.put(1, new DigitDefinition("   ", " |", " | "));
		definitions.put(2, new DigitDefinition(" _ ", " _|", "|_ "));
		definitions.put(3, new DigitDefinition(" _ ", " _|", " _|"));
		definitions.put(4, new DigitDefinition("   ", "|_|", "  |"));
		definitions.put(5, new DigitDefinition(" _ ", "|_", " _|"));
		definitions.put(6, new DigitDefinition(" _ ", "|_ ", "|_|"));
		definitions.put(7, new DigitDefinition(" _ ", "  |", "  |"));
		definitions.put(8, new DigitDefinition(" _ ", "|_|", "|_|"));
		definitions.put(9, new DigitDefinition(" _ ", "|_|", " _|"));
	}
	
	private static class DigitDefinition {
		private String line1;
		private String line2;
		private String line3;
		
		public DigitDefinition(String line1, String line2, String line3) {
			this.line1 = line1;
			this.line2 = line2;
			this.line3 = line3;
		}
    }

}
