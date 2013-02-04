package org.uva.sea.ql.tests.semanticAnalyzer.semanticAnalyzerVisitorTests;

import org.junit.Test;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.ast.type.Int;
import org.uva.sea.ql.ast.type.Str;
import org.uva.sea.ql.ast.type.Type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class IdentTests extends SemanticAnalyzerVisitorTests {

	@Test
	public void visitsIdent_usesTypeFromSymbolTable() {
		Ident[] idents = {
			new Ident("a"),
			new Ident("b"),
			new Ident("c")	
		};
		Question[] questions = {
			new Question("a", idents[0], new Bool()),
			new Question("b", idents[1], new Str()),
			new Question("c", idents[2], new Int()),
		};
		for(Question question : questions)
            question.accept(visitor, context);
		
		assertEquals(Int.class,  idents[2].accept(visitor, context).getClass());
		assertEquals(Str.class,  idents[1].accept(visitor, context).getClass());
		assertEquals(Bool.class, idents[0].accept(visitor, context).getClass());
	}

    @Test
	public void visitsIdent_typeNotInSymbolTable_addsError() {
		new Question("a", new Ident("a"), new Bool()).accept(visitor, context);
		Type type = new Ident("b").accept(visitor, context);

        assertFalse(context.getSymbolTable().isEmpty());
        assertFalse(type.getClass().equals(Bool.class));
        assertFalse(type.getClass().equals(Int.class));
        assertFalse(type.getClass().equals(Str.class));
	}
	
}