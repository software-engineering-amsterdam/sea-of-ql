package org.uva.sea.ql.gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.parser.jacc.JACCParser;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.parser.test.ParseError;

public class QLFileReader {

	public static Form read(String path) throws IOException, ParseError {
		IParse parser = new JACCParser();
		String source = readQLSourceFile(path);
		return (Form) parser.parse(source);
	}
	
	private static String readQLSourceFile(String path) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File(path).getAbsolutePath()));
		String source = "";
		String line = br.readLine();
		while (line != null) {
		   source += line + " \n";
		   line = br.readLine();
		}
		br.close();
		return source;
	}
	
}
