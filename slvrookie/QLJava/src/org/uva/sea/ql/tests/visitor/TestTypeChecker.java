package org.uva.sea.ql.tests.visitor;



import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.antlr.runtime.ANTLRFileStream;
import org.junit.Test;
import org.uva.sea.ql.ast.expr.value.Value;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.antlr.IParse;
import org.uva.sea.ql.parser.antlr.ParseError;
import org.uva.sea.ql.visitors.ElementChecker;
import org.uva.sea.ql.visitors.State;


public class TestTypeChecker {

	final private IParse parser = new ANTLRParser();
	final String path = "src/org/uva/sea/ql/tests/TestQL.ql";
	final String expr1 = "(3.00+2.00)-6.11";
	final State state = new State();
	final Map<String, Value> env = new HashMap<String, Value>();
	@Test
	public void testTypeCheck() throws ParseError {
		
		try {
			File filePath = new File(path);
			ANTLRFileStream charStream = new ANTLRFileStream(filePath.getAbsolutePath());
			ElementChecker.check(parser.parseForm(charStream.toString()));
//			Renderer.render(parser.parseForm(charStream.toString()), state);
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}
	
}
