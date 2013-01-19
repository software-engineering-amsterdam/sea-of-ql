package org.uva.sea.ql.tests.typechecker.typecheckerVisitorTests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.type.*;

public class DeclarationTests extends TypecheckerVisitorTests {

	@Test
	public void typecheckerIsCalledOnDeclaration_IdentityIsAddedToSymbolTable() {
		final Ident identity = new Ident("a");
		final Type type = new Bool();
		final Declaration declaration = new Declaration(identity, type);
		
		declaration.accept(visitor, context);

        assertTrue(context.getErrors().isEmpty());
		assertTrue(context.getSymbolTable().containsKey(identity));
		assertEquals(type, context.getSymbolTable().get(identity));
	}

    @Test
	public void variableIsDeclaredTwice_addsError() {
		final Declaration declaration = new Declaration(new Ident("a"), new Bool());
		
		declaration.accept(visitor, context);
		declaration.accept(visitor, context);

        assertFalse(context.getErrors().isEmpty());
	}

    @Test
	public void variableNameIsDeclaredTwice_addsError() {
		new Declaration(new Ident("a"), new Bool()).accept(visitor, context);
		new Declaration(new Ident("a"), new Int()).accept(visitor, context);

        assertFalse(context.getErrors().isEmpty());
	}
	
}