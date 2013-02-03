package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.IfElseStatement;
import org.uva.sea.ql.ast.IfStatement;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.jacc.JaccQLParser;

public class TestStatements {

	private IParse parser;
	
	@Before
	public void setup(){
		parser = new JaccQLParser();
	}
	
	private Class parse(String qlText) throws ParseError {
		return parser.parseStatement(qlText).getClass();
	}
	
	private <E extends Statement> E parse(String qlText, Class<E> expectedClass) throws ParseError {
		final Statement stmnt = parser.parseStatement(qlText);
		assertNotNull("Parser returned Null for " + qlText, stmnt);
		assertEquals("Unexpected instance type!", expectedClass, stmnt.getClass());
		return (E)stmnt;
	}
	
	@Test
	public void testQuestion1() throws ParseError {
		assertEquals(Question.class, parse("hasSoldHouse: \"Did you sell a house?\" boolean"));
	}
	
	@Test
	public void testIf1() throws ParseError {
		IfStatement stmnt = parse("if(true){ x: \"X?\" boolean }", IfStatement.class);
		
		assertNotNull(stmnt.getExpression());
		assertNotNull(stmnt.getCompoundStatement());
	}

	@Test
	public void testIfElse1() throws ParseError {
		IfElseStatement stmnt = parse("if(true){ x: \"X?\" boolean } else { y: \"Y?\" boolean }", IfElseStatement.class);
		
		assertNotNull(stmnt.getExpression());
		assertNotNull(stmnt.getCompoundStatement());
		assertNotNull(stmnt.getElseCompoundStatement());
	}
	
	@Test
	public void testIfNested() throws ParseError {
		IfStatement stmnt = parse("if(true){ if(!false){ x: \"X?\" boolean } }", IfStatement.class);
		
		assertNotNull(stmnt.getExpression());
		assertNotNull(stmnt.getCompoundStatement());
		assertEquals(IfStatement.class, stmnt.getCompoundStatement().getStatementIterator().next().getClass());
	}
	
	@Test
	public void testIfElseNested() throws ParseError {
		IfElseStatement stmnt = parse("if(true){ if(!false){ x: \"X?\" boolean } } else { if(!false){ x: \"X?\" boolean } }", IfElseStatement.class);
		
		assertNotNull(stmnt.getExpression());
		assertNotNull(stmnt.getCompoundStatement());
		assertEquals(IfStatement.class, stmnt.getCompoundStatement().getStatementIterator().next().getClass());
		assertNotNull(stmnt.getElseCompoundStatement());
		assertEquals(IfStatement.class, stmnt.getElseCompoundStatement().getStatementIterator().next().getClass());
	}
	
}
