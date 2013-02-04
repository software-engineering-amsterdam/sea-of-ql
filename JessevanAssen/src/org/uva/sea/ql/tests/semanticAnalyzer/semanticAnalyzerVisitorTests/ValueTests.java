package org.uva.sea.ql.tests.semanticAnalyzer.semanticAnalyzerVisitorTests;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ValueTests extends SemanticAnalyzerVisitorTests {

	@Test
	public void visitBoolValue_returnsBoolType() {
		assertEquals(
			org.uva.sea.ql.ast.type.Bool.class,
			new org.uva.sea.ql.ast.expr.value.Bool(true).accept(visitor, context).getClass()
		);
	}

	@Test
	public void visitIntValue_returnsIntType() {
		assertEquals(
			org.uva.sea.ql.ast.type.Int.class,
			new org.uva.sea.ql.ast.expr.value.Int(1).accept(visitor, context).getClass()
		);
	}

	@Test
	public void visitStringValue_returnsStringType() {
		assertEquals(
			org.uva.sea.ql.ast.type.Str.class,
			new org.uva.sea.ql.ast.expr.value.Str("a").accept(visitor, context).getClass()
		);
	}
	
}
