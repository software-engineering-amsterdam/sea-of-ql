package org.uva.sea.ql.tests.semanticAnalyzer.semanticAnalyzerVisitorTests;

import org.junit.Test;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.ast.type.Int;
import org.uva.sea.ql.ast.type.Str;
import org.uva.sea.ql.ast.type.Type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class IdentTests extends SemanticAnalyzerVisitorTests {

	@Test
	public void visitsIdent_usesTypeFromSymbolTable() {
		Identifier[] identifiers = {
			new Identifier("a"),
			new Identifier("b"),
			new Identifier("c")
		};
		Question[] questions = {
			new Question("a", identifiers[0], new Bool()),
			new Question("b", identifiers[1], new Str()),
			new Question("c", identifiers[2], new Int()),
		};
		for(Question question : questions)
            question.accept(visitor, context);
		
		assertEquals(Int.class,  identifiers[2].accept(visitor, context).getClass());
		assertEquals(Str.class,  identifiers[1].accept(visitor, context).getClass());
		assertEquals(Bool.class, identifiers[0].accept(visitor, context).getClass());
	}

    @Test
	public void visitsIdent_typeNotInSymbolTable_addsError() {
		new Question("a", new Identifier("a"), new Bool()).accept(visitor, context);
		Type type = new Identifier("b").accept(visitor, context);

        assertFalse(context.getSymbolTable().isEmpty());
        assertFalse(type.getClass().equals(Bool.class));
        assertFalse(type.getClass().equals(Int.class));
        assertFalse(type.getClass().equals(Str.class));
	}
	
}