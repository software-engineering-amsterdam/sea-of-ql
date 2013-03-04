package org.uva.sea.ql.qlsource;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.uva.sea.ql.ast.values.Value;

public class QLWriter {

	public void save(Map<String, Value> env) {
		try {
			FileWriter fileWriter = new FileWriter("QL_Results.txt");
			BufferedWriter out = new BufferedWriter(fileWriter);			
			for (Entry<String, Value> identifierWithValue : env.entrySet()) {
				out.write(
						identifierWithValue.getKey() + 
						" = " + 
						identifierWithValue.getValue().getValue().toString() + 
						"\n");
			}
			out.close();
		}
		catch (IOException e) {
			System.out.println("Error saving.");
		}			
	}

}
