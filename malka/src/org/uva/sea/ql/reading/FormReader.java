package org.uva.sea.ql.reading;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

public class FormReader implements IQuestionnaireReader{
	
	private String getFileContents(String filename) throws FileNotFoundException {
		Scanner scanner = new Scanner(new FileReader(filename));
		StringBuilder builder = new StringBuilder();
		
		while (scanner.hasNext())
			builder.append(scanner.nextLine() + "\n");
		return builder.toString();
	}
	
	public Form read(String filename) throws FileNotFoundException {
		String contents = getFileContents(filename);
		Form form = null;
		
		IParse parser = new ANTLRParser();
		try {
			form = parser.parseForm(contents);
			
			//TODO proper error handling!
			if (! parser.getErrors().isEmpty()) {
				System.out.println("parse error!");
				System.out.println(parser.getErrors());
			}
		} catch (ParseError e) {
			//TODO proper error handling!
			System.out.println("parse error!");
		}
		
		return form;
	}
}
