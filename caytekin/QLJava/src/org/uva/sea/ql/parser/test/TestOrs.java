package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.parser.antlr.ANTLRAddsParser;
import org.uva.sea.ql.parser.antlr.ANTLRExpressionParser;
import org.uva.sea.ql.parser.antlr.ANTLRMulsParser;
import org.uva.sea.ql.parser.antlr.ANTLROrParser;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.antlr.ANTLRRelsParser;

public class TestOrs {


	private IParse parser;

	public TestOrs() {
		this.parser = new ANTLROrParser();
	}

	

	@Test
	public void testOrs() throws ParseError {
		assertEquals(parser.parse("a || b").getClass(), Or.class);
		assertEquals(parser.parse("a || b || c").getClass(), Or.class);
		assertEquals(parser.parse("a || b && c").getClass(), Or.class);		
	}
		
}
