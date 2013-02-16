package org.uva.sea.ql.parser.test;

import org.junit.Test;
import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.Int;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.Str;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.antlr.check.ANTLRParserTypes;

public class TestTypes extends ASTNodeChecker {
	
	public TestTypes() {
		super(new ANTLRParserTypes());
	}
	
	@Test
	public void testBools()   throws ParseError { expressionMatchesASTClass("boolean", Bool.class); }
	@Test
	public void testInts()    throws ParseError { expressionMatchesASTClass("integer", Int.class); }
	@Test
	public void testMoneys()  throws ParseError { expressionMatchesASTClass("money",   Money.class); }
	@Test
	public void testStrings() throws ParseError { expressionMatchesASTClass("string",  Str.class); }
}