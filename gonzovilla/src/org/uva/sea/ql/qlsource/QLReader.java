package org.uva.sea.ql.qlsource;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class QLReader {

		public String read(String string) throws IOException {
			
			URL url = this.getClass().getResource(string);
		    String path = url.getPath();
			File file = new File(path);
		    StringBuilder stringBuilder = new StringBuilder((int)file.length());
		    Scanner scanner = new Scanner(file);
		    while(scanner.hasNextLine()) {        
		       stringBuilder.append(scanner.nextLine());
		    }
		    scanner.close();
		    return stringBuilder.toString(); 
		}
}
