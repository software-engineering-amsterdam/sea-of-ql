package khosrow.uva.sea.ql.parser.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import khosrow.uva.sea.ql.ast.expr.*;
import khosrow.uva.sea.ql.ast.type.*;
import khosrow.uva.sea.ql.env.Env;
import khosrow.uva.sea.ql.parser.jacc.JACCParser;
import khosrow.uva.sea.ql.visitor.check.ExprTypeChecker;

import org.junit.Before;
import org.junit.Test;

public class TestExprTypeChecker {
	private IParse parser;
	
	@Before
	public void setUp() {
		parser = new JACCParser();
	}
	
	@Test
	public void testAddsType() throws ParseError {
		Env typeEnv = new Env();
		List<QlError> messages = new ArrayList<QlError>();
		Ident a = new Ident("a");
		Ident b = new Ident("b");
		typeEnv.DeclareType(a, new Int());
		typeEnv.DeclareType(b, new Int());
		
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("a + b"), typeEnv, messages), true);
	}

}
