package org.uva.sea.ql.tests.visitor.elementchecker;

import java.io.File;
import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.junit.Test;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.antlr.IParse;
import org.uva.sea.ql.parser.antlr.ParseError;
import org.uva.sea.ql.visitors.ElementChecker;
import org.uva.sea.ql.visitors.Errors;
import org.uva.sea.ql.visitors.State;

public class TestFile {

	final private IParse parser = new ANTLRParser();
	final String path = "src/org/uva/sea/ql/tests/TestQL.ql";
	final Errors errors = new Errors();
	final State state = new State();

	@Test
	public void testTypeCheck() throws ParseError, IOException {
		File filePath = new File(path);
		ANTLRFileStream charStream = new ANTLRFileStream(filePath.getAbsolutePath());
		ElementChecker.check(parser.parseForm(charStream.toString()), state, errors);
		errors.getErrors();
	}

}
