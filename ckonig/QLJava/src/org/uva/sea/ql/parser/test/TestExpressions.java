package org.uva.sea.ql.parser.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.jacc.JACCParser;
import org.uva.sea.ql.parser.rats.RatsParser;

@RunWith(Parameterized.class)
public class TestExpressions {	
	
	@Parameters
	public static List<Object[]> theParsers() {
		return Arrays.asList(new Object[] { new JACCParser() },
				new Object[] { new RatsParser() },
				new Object[] { new ANTLRParser() });
	}

	public TestExpressions(IParse parser) {
		CurrentTest.parser = parser;
	}	
	@Test
	public void testDummy(){
		assertNotNull(CurrentTest.parser);
	}
}
