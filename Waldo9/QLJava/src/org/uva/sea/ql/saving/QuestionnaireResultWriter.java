package org.uva.sea.ql.saving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.evaluation.values.Value;

public class QuestionnaireResultWriter {
	
	private static final String OUTPUT_FILE = "QLDemoResults.csv";

	public void saveResult(Map<Ident, Value> identifierEnvironment) {
		try {
			FileWriter writer = new FileWriter(OUTPUT_FILE);
			BufferedWriter out = new BufferedWriter(writer);			
			for (Entry<Ident, Value> identifierWithValue : identifierEnvironment.entrySet()) {
				String variable = identifierWithValue.getKey().getName();
				String value = identifierWithValue.getValue().getValue().toString();
				out.write(variable + ", " + value + "\n");
			}
			out.close();
		}
		catch (IOException e) {
			System.out.println("Save operation failed.");
		}			
	}

}
