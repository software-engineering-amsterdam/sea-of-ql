package org.uva.sea.ql.parser.test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class QLFileReader {
	
	public String readQLFile(String qlFile) throws IOException {
		URL url = this.getClass().getResource(qlFile);
	    String path = url.getPath();
	    path = path.replace("%20", " ");
		File file = new File(path);
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
