package org.uva.sea.ql.visitors;

import java.io.File;
import java.io.IOException;



import org.antlr.runtime.ANTLRFileStream;
import org.uva.sea.ql.ast.formelements.Form;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.antlr.IParse;
import org.uva.sea.ql.parser.antlr.ParseError;

public class Loader {
	final static String path = "src/org/uva/sea/ql/tests/TestQL.ql";
	/**
	 * @param args
	 * @throws IOException 
	 * @throws ParseError 
	 */
	public static void main(String[] args) throws IOException, ParseError {
		IParse parser = new ANTLRParser();
		File filePath = new File(path);
		ANTLRFileStream charStream = new ANTLRFileStream(filePath.getAbsolutePath());
		Form ast = parser.parseForm(charStream.toString());
	//	new Gui(ast);
	}

}
