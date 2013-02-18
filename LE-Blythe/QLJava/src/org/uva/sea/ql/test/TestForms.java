package org.uva.sea.ql.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.checker.Error;
import org.uva.sea.ql.checker.ErrorExpressionType;
import org.uva.sea.ql.checker.ErrorIdentifierExists;
import org.uva.sea.ql.checker.ErrorIdentifierScope;
import org.uva.sea.ql.checker.VisitorStatementChecker;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.rats.RatsParser;
import org.uva.sea.ql.util.FormStringBuilder;


public class TestForms {

	/** Confirm that the checker found the error we were expecting to get.
	 * Provided is the list of errors that were encountered by the checker
	 * It is possible that more than one error is contained in the list due to errors
	 * cascading. Therefore, this method checks to see if the expected error is found 
	 * amongst those received
	 */
	private boolean containsExpected(List<Error> errors, Class<?> type){
	
		for(Error error: errors){
			
			 //we found the expected error
			if(type.isInstance(error)){
				return true;
			}
		}
		
		return false;
	}
	
	
	/** wrap provided form elements into form structure
	 * parse and perform validation check 
	 */
	private Statement execute(String... args) throws Exception{
		
		String strForm = FormStringBuilder.form("a", args);
		IParse parser = new RatsParser();
		
		return parser.parse(strForm);
	}
	
	
	/** provided form elements are expected to trigger the provided error,
	 * if this happens, the error is extracted from visitor object.
	 */
	private boolean faulty(Class<?> expectedFailureType, String... args) throws Exception{
		
		VisitorStatementChecker checker = new VisitorStatementChecker();
		
		Statement form = execute(args);
		form.accept(checker);
		
		if(!checker.errorsFound())
			return false;
		
		List<Error> errors = checker.getErrors();
		return containsExpected(errors, expectedFailureType);
	}
	
	
	/** Provided form is expected to be correct, it is correct if the visitor encounters
	 *  no errors
	 */
	private boolean correct(String... args) throws Exception{
		VisitorStatementChecker checker = new VisitorStatementChecker();
		
		Statement form = execute(args);
		form.accept(checker);
		
		return !checker.errorsFound();
	}

	
	@Test
	public void outOfScopeTestSimpleCondition() throws Exception{
		
		String q1 = FormStringBuilder.question("q1", "boolean");
		String q2 = FormStringBuilder.question("q2", "boolean");
		
		String sBranch1 = FormStringBuilder.ifStatement("q1", q2);
		String sBranch2 = FormStringBuilder.ifStatement("q2", ""); 
		
		//the second branch statement evaluates q2 as its condition, but q2 is out of scope 
		assertTrue(faulty(ErrorIdentifierScope.class, q1, sBranch1, sBranch2));
	}
	
	
	@Test
	public void outOfScopeTestExpressiveCondition() throws Exception{
		
		String q1 = FormStringBuilder.question("q1", "boolean");
		String q2 = FormStringBuilder.question("q2", "boolean");
		
		String sBranch1 = FormStringBuilder.ifStatement("q1", q2);
		String sBranch2 = FormStringBuilder.ifStatement("q1 && q2", "");
		
		//the second branch statement evaluates the conjunction q1 and q2, but q2 is out of scope
		assertTrue(faulty(ErrorIdentifierScope.class, q1, sBranch1, sBranch2));

	}
	
	
	@Test
	public void outOfScopeTestNumericExpressions() throws Exception{
		
		String q1 = FormStringBuilder.question("q1", "boolean");
		String q2 = FormStringBuilder.question("q2", "integer");
		String q3 = FormStringBuilder.question("q3", "q2+1");
		
		String sBranch1 = FormStringBuilder.ifStatement("q1", q2);
		
		//q2 will be out of scope when q3 attempts to calculate it's value based on q2
		//this is because q2's scope is only within the branch's body
		assertTrue(faulty(ErrorIdentifierScope.class, q1, sBranch1, q3));
	}
		
	
	@Test
	public void identifierDuplicationCheckingSameType() throws Exception{
		
		String q1 = FormStringBuilder.question("q1", "integer");
		String q2 = FormStringBuilder.question("q1", "integer");
		
		//should fail because q1 is defined twice
		assertTrue(faulty(ErrorIdentifierExists.class, q1, q2));
	}
	
	
	@Test
	public void identifierDuplicationCheckingDifferentType() throws Exception{
		
		String q1 = FormStringBuilder.question("q1", "integer");
		String q2 = FormStringBuilder.question("q1", "boolean");
		
		//should fail because q1 is defined twice
		assertTrue(faulty(ErrorIdentifierExists.class, q1, q2));

	}
	
	
	@Test
	public void identifierTypeCheckingNumeric() throws Exception{
		
		String q1 = FormStringBuilder.question("q1", "integer");
		String q2 = FormStringBuilder.question("q2", "boolean");
		String q3 = FormStringBuilder.question("q3", "q2+q1");
		
		//q3 should fail due to a type mismatch: boolean(q1)+integer(q2)
		assertTrue(faulty(ErrorExpressionType.class, q1, q2, q3));
		
	}
	
	
	@Test
	public void identifierTypeCheckingBoolean() throws Exception{
		
		String q1 = FormStringBuilder.question("q1", "integer");
		String q2 = FormStringBuilder.question("q2", "boolean");
		String q3 = FormStringBuilder.question("q3", "q2&&q1");
		
		//q3 should fail due to a type mismatch: boolean(q1)&&integer(q2)
		assertTrue(faulty(ErrorExpressionType.class, q1, q2, q3));
	}
	
	
	@Test
	public void identifierTypeCheckingComparative() throws Exception{
		
		String q1 = FormStringBuilder.question("q1", "integer");
		String q2 = FormStringBuilder.question("q2", "boolean");
		String q3 = FormStringBuilder.question("q3", "q2>q1");
		
		//q3 should fail due to a type mismatch: boolean(q1)>integer(q2)
		assertTrue(faulty(ErrorExpressionType.class, q1, q2, q3));
	}
	
	
	@Test
	public void expressionTypeCheckingNumeric() throws Exception{
		
		//should fail because 'false' is not a numeric expression
		assertTrue(faulty(ErrorExpressionType.class, FormStringBuilder.question("q1", "1 + false")));
	}
	
	
	@Test
	public void expressionTypeCheckingComparative() throws Exception{
		
		//should fail because 'false' is not a numeric expression	
		assertTrue(faulty(ErrorExpressionType.class, FormStringBuilder.question("q1", "1 > false")));
	}
	
	
	@Test
	public void expressionTypeCheckingBoolean() throws Exception{
		
		//should fail because (1+1) is not a boolean expression
		assertTrue(faulty(ErrorExpressionType.class, FormStringBuilder.question("q1", "(1+1) && false")));
	}
	

	@Test
	public void correctIdentifierTypeCheckNumeric() throws Exception{

		String q1 = FormStringBuilder.question("q1", "integer");
		String q2 = FormStringBuilder.question("q2", "integer");
		String q3 = FormStringBuilder.question("q3", "q1+q2");
		
		assertTrue(correct(q1, q2, q3));
	}
	
	
	@Test
	public void correctIdentifierTypeCheckBoolean() throws Exception{
		
		String q1 = FormStringBuilder.question("q1", "boolean");
		String q2 = FormStringBuilder.question("q2", "boolean");
		String q3 = FormStringBuilder.question("q3", "q1 && q2");
		
		assertTrue(correct(q1, q2, q3));
	}
	
	
	@Test
	public void correctIdentifierTypeCheckComparative() throws Exception{
		
		String q1 = FormStringBuilder.question("q1", "integer");
		String q2 = FormStringBuilder.question("q2", "integer");
		String q3 = FormStringBuilder.question("q3", "q1> q2");
		
		assertTrue(correct(q1, q2, q3));
	}
	
	
	@Test
	public void correctExpressionTypeCheckNumeric() throws Exception{
		assertTrue(correct(FormStringBuilder.question("q1", "(1+1) * (2*2)")));
	}
	
	
	@Test
	public void correctExpressionTypeCheckBoolean() throws Exception{
		assertTrue(correct(FormStringBuilder.question("q1", "true && true")));
	}
	
	
	@Test
	public void correctExpressionTypeCheckComparative() throws Exception{
		assertTrue(correct(FormStringBuilder.question("q1", "(2+2) > (1+1)")));
	}
}
