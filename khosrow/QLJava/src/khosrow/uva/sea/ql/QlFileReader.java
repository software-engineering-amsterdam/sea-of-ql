package khosrow.uva.sea.ql;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class QlFileReader {
	
	private QlFileReader(){}
	
	public static String read(String filePath) throws IOException{
		QlFileReader reader = new QlFileReader();
		return reader.readFile(filePath);
	}
	
	private String readFile(String filePath) throws IOException {	   
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		try {
			String line = null;
			StringBuilder stringBuilder = new StringBuilder();
			String ls = System.getProperty("line.separator");

			while((line = reader.readLine()) != null ) {
				stringBuilder.append(line);
				stringBuilder.append(ls);
			}
			return stringBuilder.toString();
	    }
	    catch(Exception ex){
	    	throw new RuntimeException(ex);
	    }
	    finally{
	    	if (reader != null)
	    		reader.close();
	    }
	}
}
