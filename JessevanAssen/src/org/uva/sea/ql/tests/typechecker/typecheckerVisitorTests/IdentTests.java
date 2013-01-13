package org.uva.sea.ql.tests.typechecker.typecheckerVisitorTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.Declaration;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.type.*;
import org.uva.sea.ql.typechecker.TypecheckerException;

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
			declaration.accept(visitor, symbolTable);
		
		assertEquals(Int.class,  idents[2].accept(visitor, symbolTable).getClass());
		assertEquals(Str.class,  idents[1].accept(visitor, symbolTable).getClass());
		assertEquals(Bool.class, idents[0].accept(visitor, symbolTable).getClass());
	}
	
	@Test(expected = TypecheckerException.class)
	public void visitsIdent_typeNotInSymbolTable_throwsTypeckeckerException() {
		new Declaration(new Ident("a"), new Bool()).accept(visitor, symbolTable);
		new Ident("b").accept(visitor, symbolTable);
	}
	
}
