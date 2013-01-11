package org.uva.sea.ql.tests.typechecker.typecheckerVisitorTests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.typechecker.TypecheckerException;

public class DeclarationTests extends TypecheckerVisitorTests {

	@Test(expected = TypecheckerException.class)
	public void variableIsDeclaredTwice_throwsException() {
		final ASTNode tree = new Form(
			new Ident("form1"),
			Arrays.asList(
				(FormElement) new Question("", new Declaration(new Ident("a"), new Bool())),
				(FormElement) new Question("", new Declaration(new Ident("a"), new Bool()))
			)
		);
		
		tree.accept(visitor, null);
	}
	
}
