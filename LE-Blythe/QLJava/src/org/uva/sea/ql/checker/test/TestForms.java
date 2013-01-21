package org.uva.sea.ql.checker.test;

import org.junit.Test;
import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.checker.VisitorFormChecking;
import org.uva.sea.ql.util.FormStringBuilder;
import org.uva.sea.ql.util.Stack;
import org.uva.sea.ql.interfaces.*;
import org.uva.sea.ql.parser.rats.RatsParser;
import org.uva.sea.ql.errors.*;


public class TestForms {

	private IVisitor checker;
	private IParse	parser;
	
	public TestForms(){
		this.checker = new VisitorFormChecking();
		this.parser = new RatsParser();
	}
	

	private void execute(String... args) throws Exception{
		
		String sForm = FormStringBuilder.form("a", args);

		ASTNode Form = parser.parse(sForm);
		Form.accept(checker, new Stack() );
	}
	
	

	@Test(expected = IdentifierScopeError.class)
	public void outOfScopeTestSimpleCondition() throws Exception{
		
		String q1 = FormStringBuilder.question("q1", "boolean");
		String q2 = FormStringBuilder.question("q2", "boolean");
		
		String sBranch1 = FormStringBuilder.ifStatement("q1", q2);
		String sBranch2 = FormStringBuilder.ifStatement("q2", ""); 
		
		//the second branch statement evaluates q2 as its condition, but q2 is out of scope 
		execute(q1, sBranch1, sBranch2);
	}
	
	
	@Test(expected = IdentifierScopeError.class)
	public void outOfScopeTestExpressiveCondition() throws Exception{
		
		String q1 = FormStringBuilder.question("q1", "boolean");
		String q2 = FormStringBuilder.question("q2", "boolean");
		
		String sBranch1 = FormStringBuilder.ifStatement("q1", q2);
		String sBranch2 = FormStringBuilder.ifStatement("q1 && q2", "");
		
		//the second branch statement evaluates the conjunction q1 and q2, but q2 is out of scope
		execute(q1, sBranch1, sBranch2);
		
	}
	
	
	@Test(expected = IdentifierScopeError.class)
	public void outOfScopeTestNumericExpressions() throws Exception{
		
		String q1 = FormStringBuilder.question("q1", "boolean");
		String q2 = FormStringBuilder.question("q2", "integer");
		String q3 = FormStringBuilder.question("q3", "q2+1");
		
		String sBranch1 = FormStringBuilder.ifStatement("q1", q2);
		
		//q2 will be out of scope when q3 attempts to calculate it's value based on q2
		//this is because q2's scope is only within the branch's body
		execute(q1, sBranch1, q3);
		
	}
		
	
	@Test(expected = IdentifierExistsError.class)
	public void identifierDuplicationCheckingSameType() throws Exception{
		
		String q1 = FormStringBuilder.question("q1", "integer");
		String q2 = FormStringBuilder.question("q1", "integer");
		
		//should fail because q1 is defined twice
		execute(q1, q2);
	}
	
	
	@Test(expected = IdentifierExistsError.class)
	public void identifierDuplicationCheckingDifferentType() throws Exception{
		
		String q1 = FormStringBuilder.question("q1", "integer");
		String q2 = FormStringBuilder.question("q1", "boolean");
		
		//should fail because q1 is defined twice
		execute(q1, q2);
	}
	
	
	@Test(expected = IdentifierTypeError.class)
	public void identifierTypeCheckingNumeric() throws Exception{
		
		String q1 = FormStringBuilder.question("q1", "integer");
		String q2 = FormStringBuilder.question("q2", "boolean");
		String q3 = FormStringBuilder.question("q3", "q2+q1");
		
		//q3 should fail due to a type mismatch: boolean(q1)+integer(q2)
		execute(q1, q2, q3);
		
	}
	
	
	@Test(expected = IdentifierTypeError.class)
	public void identifierTypeCheckingBoolean() throws Exception{
		
		String q1 = FormStringBuilder.question("q1", "integer");
		String q2 = FormStringBuilder.question("q2", "boolean");
		String q3 = FormStringBuilder.question("q3", "q2&&q1");
		
		//q3 should fail due to a type mismatch: boolean(q1)&&integer(q2)
		execute(q1, q2, q3);
	}
	
	
	@Test(expected = IdentifierTypeError.class)
	public void identifierTypeCheckingComparative() throws Exception{
		
		String q1 = FormStringBuilder.question("q1", "integer");
		String q2 = FormStringBuilder.question("q2", "boolean");
		String q3 = FormStringBuilder.question("q3", "q2>q1");
		
		//q3 should fail due to a type mismatch: boolean(q1)>integer(q2)
		execute(q1, q2, q3);
	}
	
	
	@Test(expected = ExpressionTypeError.class)
	public void expressionTypeCheckingNumeric() throws Exception{
		
		//should fail because 'false' is not a numeric expression
		execute(FormStringBuilder.question("q1", "1 + false"));
	}
	
	
	@Test(expected = ExpressionTypeError.class)
	public void expressionTypeCheckingComparative() throws Exception{
		
		//should fail because 'false' is not a numeric expression	
		execute(FormStringBuilder.question("q1", "1 > false"));
	}
	
	
	@Test(expected = ExpressionTypeError.class)
	public void expressionTypeCheckingBoolean() throws Exception{
		
		//should fail because (1+1) is not a boolean expression
		execute(FormStringBuilder.question("q1", "(1+1) && false"));
	}
	

	@Test
	public void correctIdentifierTypeCheckNumeric() throws Exception{

		String q1 = FormStringBuilder.question("q1", "integer");
		String q2 = FormStringBuilder.question("q2", "integer");
		String q3 = FormStringBuilder.question("q3", "q1+q2");
		
		execute(q1, q2, q3);
	}
	
	
	@Test
	public void correctIdentifierTypeCheckBoolean() throws Exception{
		
		String q1 = FormStringBuilder.question("q1", "boolean");
		String q2 = FormStringBuilder.question("q2", "boolean");
		String q3 = FormStringBuilder.question("q3", "q1 && q2");
		
		execute(q1, q2, q3);
	}
	
	
	@Test
	public void correctIdentifierTypeCheckComparative() throws Exception{
		
		String q1 = FormStringBuilder.question("q1", "integer");
		String q2 = FormStringBuilder.question("q2", "integer");
		String q3 = FormStringBuilder.question("q3", "q1> q2");
		
		execute(q1, q2, q3);
	}
	
	
	@Test
	public void correctExpressionTypeCheckNumeric() throws Exception{
		execute(FormStringBuilder.question("q1", "(1+1) * (2*2)"));
	}
	
	
	@Test
	public void correctExpressionTypeCheckBoolean() throws Exception{
		execute(FormStringBuilder.question("q1", "true && true"));
	}
	
	
	@Test
	public void correctExpressionTypeCheckComparative() throws Exception{
		execute(FormStringBuilder.question("q1", "(2+2) > (1+1)"));
	}
}
