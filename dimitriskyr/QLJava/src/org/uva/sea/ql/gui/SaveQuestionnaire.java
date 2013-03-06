package org.uva.sea.ql.gui;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.uva.sea.ql.ast.Value;

public class SaveQuestionnaire {
	public void saveInFile(Map<String, Value> env) {
		try {
			FileWriter file = new FileWriter("QLlanguageResults.xls");
			BufferedWriter out = new BufferedWriter(file);
			for (Entry<String, Value> identToValue : env.entrySet()) {
				String ident = identToValue.getKey();
				String value = identToValue.getValue().getValue().toString();

				out.write(ident + "--> " + value + "\t");
			}
			System.out.println("Succesfull saving!");
			out.close(); // the file will be created in the directory QLJava
		} catch (IOException e) {
			System.out.println("Saving failed!");
		}
	}

}
