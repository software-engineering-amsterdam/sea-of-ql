package org.uva.sea.ql.parser.test.form;

import static org.junit.Assert.*;

import org.junit.Test;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expressions.binary.*;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.parser.test.*;

public class TestComputations extends TestParser {
	
	@Test
	public void checkTheOperator() throws ParseError {
		FormElement c = parseFormElement("salary: \"Calculate\" int(ident - ident2)");
		assertEquals(Computation.class, c.getClass());
		Expr type = ((Computation)c).getArgument(); 
		assertTrue(type.getClass() == Sub.class);
		
		c = parseFormElement("salary: \"Calculate\" int(ident + ident2)");
		assertEquals(Computation.class, c.getClass());
		type = ((Computation)c).getArgument(); 
		assertTrue(type.getClass() == Add.class);

		c = parseFormElement("salary: \"Calculate\" int(ident * ident2)");
		assertEquals(Computation.class, c.getClass());
		type = ((Computation)c).getArgument(); 
		assertTrue(type.getClass() == Mul.class);

		c = parseFormElement("salary: \"Calculate\" int(ident / ident2)");
		assertEquals(Computation.class, c.getClass());
		type = ((Computation)c).getArgument(); 
		System.out.println("Class: " + type.getClass());
		assertTrue(type.getClass() == Div.class);
	}
 
}
