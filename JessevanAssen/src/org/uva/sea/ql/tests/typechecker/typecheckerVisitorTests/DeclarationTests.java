package org.uva.sea.ql.tests.typechecker.typecheckerVisitorTests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.type.*;
import org.uva.sea.ql.typechecker.TypecheckerException;

public class DeclarationTests extends TypecheckerVisitorTests {

	@Test
	public void typecheckerIsCalledOnDeclaration_IdentityIsAddedToSymbolTable() {
		final Ident identity = new Ident("a");
		final Type type = new Bool();
		final Declaration declaration = new Declaration(identity, type);
		
		declaration.accept(visitor, symbolTable);
		
		assertTrue(symbolTable.containsKey(identity));
		assertEquals(type, symbolTable.get(identity));
	}
	
	@Test(expected = TypecheckerException.class)
	public void variableIsDeclaredTwice_throwsException() {
		final Declaration declaration = new Declaration(new Ident("a"), new Bool());
		
		declaration.accept(visitor, symbolTable);
		declaration.accept(visitor, symbolTable);
	}
	
	@Test(expected = TypecheckerException.class)
	public void variableNameIsDeclaredTwice_throwsException() {
		new Declaration(new Ident("a"), new Bool()).accept(visitor, symbolTable);
		new Declaration(new Ident("a"), new Int()).accept(visitor, symbolTable);
	}
	
}
