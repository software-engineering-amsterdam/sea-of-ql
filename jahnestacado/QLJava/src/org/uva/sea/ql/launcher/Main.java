package org.uva.sea.ql.launcher;

import java.io.File;
import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.test.ParseError;

public class Main {

	public static void main(String[] args) {

		final String path = "src/org/uva/sea/ql/launcher/SampleCode.ql";
		File filePath = new File(path);

		try {
			ANTLRFileStream charStream = new ANTLRFileStream(filePath.getAbsolutePath());
			ANTLRParser parser = new ANTLRParser();
			parser.parseForm(charStream.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseError e) {
			e.printStackTrace();
		}
		

	}

}
