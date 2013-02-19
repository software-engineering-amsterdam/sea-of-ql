package org.uva.sea.ql.output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.uva.sea.ql.ast.expr.value.Ident;
import org.uva.sea.ql.interpreter.Env;

public class CSVWriter {
	
	private final static String extension = ".csv";
	private final static String folderSeperator = "\\";
	
	public static void writeForm(String formName, Env env, File location) {
		try
		{
			final String newLine = System.getProperty("line.separator");
			final String seperator = ",";
		    FileWriter writer = new FileWriter(location + folderSeperator + formName + extension);
	 
		    writer.append(formName);
		    writer.append(newLine);
		    
		    for(Ident identity : env.getValueEnv().keySet()){
		    	writer.append(identity.getName());
			    writer.append(seperator);
			    writer.append(env.getValue(identity).toString());
			    writer.append(newLine);
		    }
	 
		    writer.flush();
		    writer.close();
		}
		catch(IOException e)
		{
		     e.printStackTrace();
		} 
	}
	
}
