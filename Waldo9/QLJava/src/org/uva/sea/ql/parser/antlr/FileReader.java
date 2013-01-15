package org.uva.sea.ql.parser.antlr;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileReader {
	
	public static String readFile() throws IOException {
	    File file = new File("C:/Users/Wouter Kwakernaak/sea-of-ql/Waldo9/QLJava/src/org/uva/sea/ql/parser/antlr/QLtest.ql");
	    StringBuilder stringBuilder = new StringBuilder((int)file.length());
	    Scanner scanner = new Scanner(file);
	    try {
	        while(scanner.hasNextLine()) {        
	        	stringBuilder.append(scanner.nextLine());
	        }
	        return stringBuilder.toString();
	    } finally {
	        scanner.close();
	    }
	}
}
