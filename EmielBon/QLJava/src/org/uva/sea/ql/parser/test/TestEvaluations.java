package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.eval.*;
import org.uva.sea.ql.parser.jacc.JACCParser;

public class TestEvaluations {

	private IParse parser;
	
	public TestEvaluations() {
		this.parser = new JACCParser();
	}
	
	@Test
	public void testEvaluations() throws Exception {
		assertEquals(((Expression)parser.parse("(1+2)*5-8")).accept(new Eval(new ValueEnvironment())), new IntegerValue(7));
		assertEquals(((Expression)parser.parse("100")).accept(new Eval(new ValueEnvironment())), new IntegerValue(100));
	}
	
}
