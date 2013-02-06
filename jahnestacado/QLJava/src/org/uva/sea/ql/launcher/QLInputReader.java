package org.uva.sea.ql.launcher;

import java.io.File;
import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.test.ParseError;

public class QLInputReader {
	private final static String path = "src/org/uva/sea/ql/launcher/SampleCode.ql";

	public static Form getParsedForm() {
		File filePath = new File(path);

		try {
			ANTLRFileStream charStream = new ANTLRFileStream(filePath.getAbsolutePath());
			ANTLRParser parser = new ANTLRParser();
			Form parsedForm = parser.parseForm(charStream.toString());
			return parsedForm;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseError e) {
			e.printStackTrace();
		}
		return null;
	}

}
