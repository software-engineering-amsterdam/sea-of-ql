package org.uva.sea.ql.parser.antlr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.visitor.check.CheckFormCorrectnessVisitor;
import org.uva.sea.ql.visitor.gui.FormRenderer;

public class QLRun {

	public static void main(String[] args) throws Exception {
		ANTLRParser parser = new ANTLRParser();
		
		Form form1 = parser.parseForm(readFile(
				"C:\\Users\\Steven\\Documents\\GitHub\\sea-of-ql\\svombergen\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\test\\toParse.txt"
				));
		CheckFormCorrectnessVisitor correctVisitor = new CheckFormCorrectnessVisitor();
		
		if (form1.accept(correctVisitor)) {
			FormRenderer formRenderer1 = new FormRenderer();
			form1.accept(formRenderer1);
			System.out.println("form: " + form1);
		}
	}
	
	public static String readFile(String location) {
		File file = new File(location);
        StringBuilder contents = new StringBuilder();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;

            while ((text = reader.readLine()) != null) {
                contents.append(text)
                        .append(System.getProperty(
                                "line.separator"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return contents.toString();
	}

}
