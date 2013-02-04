package org.uva.sea.ql.tests.semanticAnalyzer.semanticAnalyzerVisitorTests;

import org.junit.Test;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.type.*;
import org.uva.sea.ql.ast.type.Boolean;
import org.uva.sea.ql.ast.type.Integer;
import org.uva.sea.ql.ast.type.String;

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
			new Question("a", identifiers[0], new Boolean()),
			new Question("b", identifiers[1], new String()),
			new Question("c", identifiers[2], new Integer()),
		};
		for(Question question : questions)
            question.accept(visitor, context);
		
		assertEquals(Integer.class,  identifiers[2].accept(visitor, context).getClass());
		assertEquals(String.class,  identifiers[1].accept(visitor, context).getClass());
		assertEquals(org.uva.sea.ql.ast.type.Boolean.class, identifiers[0].accept(visitor, context).getClass());
	}

    @Test
	public void visitsIdent_typeNotInSymbolTable_addsError() {
		new Question("a", new Identifier("a"), new Boolean()).accept(visitor, context);
		Type type = new Identifier("b").accept(visitor, context);

        assertFalse(context.getSymbolTable().isEmpty());
        assertFalse(type.getClass().equals(Boolean.class));
        assertFalse(type.getClass().equals(Integer.class));
        assertFalse(type.getClass().equals(String.class));
	}
	
}