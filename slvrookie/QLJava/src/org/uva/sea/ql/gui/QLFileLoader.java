package org.uva.sea.ql.gui;

import java.io.File;
import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.uva.sea.ql.ast.formelements.Form;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.antlr.IParse;
import org.uva.sea.ql.parser.antlr.ParseError;

public class QLFileLoader {

	static void openFile(File file) throws IOException, ParseError {
		IParse parser = new ANTLRParser();
		try {
			ANTLRFileStream charStream = new ANTLRFileStream(file.getAbsolutePath());
			Form ast = parser.parseForm(charStream.toString());
			new Gui(ast);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseError e) {
			e.printStackTrace();
		}
	}
	
}
