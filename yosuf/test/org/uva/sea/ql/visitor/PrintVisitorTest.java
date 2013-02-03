package org.uva.sea.ql.visitor;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.exp.Identifier;
import org.uva.sea.ql.ast.type.StringType;
import org.uva.sea.ql.util.LogPrinter;

public class PrintVisitorTest {
	PrintVisitor visitor;

	@Before
	public void setUp() {
		visitor = new PrintVisitor();
		LogPrinter.setDebugOn(true);
	}

	@After
	public void tearDown() {
		LogPrinter.setDebugOn(false);
	}

	@Test
	public void testVisitForm() {
		Form form = new Form(new Identifier("ident"), new StringType());
	}
}
