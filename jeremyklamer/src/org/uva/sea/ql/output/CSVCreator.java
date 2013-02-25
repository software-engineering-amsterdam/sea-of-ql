package org.uva.sea.ql.output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.uva.sea.ql.ast.expr.value.Ident;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.output.opencsv.CSVWriter;

public class CSVCreator {
		
	public static void writeForm(String formName, Env env, File location) {
		try {		
			CSVWriter writer = new CSVWriter(
					new FileWriter(
							location.getPath() + 
							File.separator + 
							formName + 
							".csv"));
			for(Ident identity : env.getValueEnv().keySet()){
				writer.writeNext(new String[]{ identity.getName(), env.getValue(identity).toString()});
			}
			writer.close();

		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(null, "An unexpected error occured, your document has not been saved.", "Error saving document", JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
