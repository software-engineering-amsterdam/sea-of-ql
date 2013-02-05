package org.uva.sea.ql.parser.test.form;

import static org.junit.Assert.*;

import org.junit.Test;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expressions.binary.*;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.visitor.*;
import org.uva.sea.ql.parser.test.*;

public class TestComputations extends TestParser {

	@Test
	public void acceptsCorrectInputTypeMoney() throws ParseError {
		FormElement c = parseFormElement("salary: \"Calculate\" money(ident - ident2)");
		assertEquals(Computation.class,  c.getClass());
		//assertTrue(((Computation)c).getType().equals("money"));
		System.out.println(((Computation) c).getType(new SymbolTable()));
		assertEquals(((Computation) c).getType(new SymbolTable()).getClass(), Money.class);
	}
	
	@Test
	public void checkTheOperator() throws ParseError {
		FormElement c = parseFormElement("salary: \"Calculate\" money(ident - ident2)");
		assertEquals(Computation.class, c.getClass());
		Expr type = ((Computation)c).getArgument(); 
		assertTrue(type.getClass() == Sub.class);
	}
 
}
