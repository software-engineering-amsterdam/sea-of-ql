package org.uva.sea.ql.parser.test.form;

import static org.junit.Assert.*;

import org.junit.Test;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.parser.test.ParseError;
import org.uva.sea.ql.parser.test.TestParser;

public class TestComputations extends TestParser {

	@Test
	public void acceptsCorrectInputTypeMoney() throws ParseError {
		FormElement c = parseFormElement("salary: \"Calculate\" money(ident - ident2)");
		assertEquals(Computation.class,  c.getClass());
		assertTrue(((Computation)c).getType().equals("money"));
	}

}
