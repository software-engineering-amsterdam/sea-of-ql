package org.uva.sea.ql.tests.typechecker.typecheckerVisitorTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.uva.sea.ql.ast.Declaration;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.type.*;

public class IdentTests extends TypecheckerVisitorTests {

	@Test
	public void visitsIdent_usesTypeFromSymbolTable() {
		Ident[] idents = {
			new Ident("a"),
			new Ident("b"),
			new Ident("c")	
		};
		Declaration[] declarations = {
			new Declaration(idents[0], new Bool()),
			new Declaration(idents[1], new Str()),
			new Declaration(idents[2], new Int()),
		};
		for(Declaration declaration : declarations)
			declaration.accept(visitor, context);
		
		assertEquals(Int.class,  idents[2].accept(visitor, context).getClass());
		assertEquals(Str.class,  idents[1].accept(visitor, context).getClass());
		assertEquals(Bool.class, idents[0].accept(visitor, context).getClass());
	}

    @Test
	public void visitsIdent_typeNotInSymbolTable_addsError() {
		new Declaration(new Ident("a"), new Bool()).accept(visitor, context);
		Type type = new Ident("b").accept(visitor, context);

        assertFalse(context.getSymbolTable().isEmpty());
        assertFalse(type.getClass().equals(Bool.class));
        assertFalse(type.getClass().equals(Int.class));
        assertFalse(type.getClass().equals(Str.class));
	}
	
}