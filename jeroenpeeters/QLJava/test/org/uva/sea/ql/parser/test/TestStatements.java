package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.statement.CompoundStatement;
import org.uva.sea.ql.ast.statement.IfElseStatement;
import org.uva.sea.ql.ast.statement.IfStatement;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.ast.statement.Statement;
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
		assertNotNull(stmnt.getStatement());
	}

	@Test
	public void testIfElse1() throws ParseError {
		IfElseStatement stmnt = parse("if(true){ x: \"X?\" boolean } else { y: \"Y?\" boolean }", IfElseStatement.class);
		
		assertNotNull(stmnt.getExpression());
		assertNotNull(stmnt.getStatement());
		assertNotNull(stmnt.getElseStatement());
	}
	
	@Test
	public void testIfNested() throws ParseError {
		IfStatement stmnt = parse("if(true){ if(!false){ x: \"X?\" boolean } }", IfStatement.class);
		
		assertNotNull(stmnt.getExpression());
		assertNotNull(stmnt.getStatement());
		assertEquals(CompoundStatement.class, stmnt.getStatement().getClass());
		assertEquals(IfStatement.class, ((CompoundStatement)stmnt.getStatement()).getStatementIterator().next().getClass());
	}
	
	@Test
	public void testIfElseNested() throws ParseError {
		IfElseStatement stmnt = parse("if(true){ if(!false){ x: \"X?\" boolean } } else { if(!false){ x: \"X?\" boolean } }", IfElseStatement.class);
		
		assertNotNull(stmnt.getExpression());
		assertNotNull(stmnt.getStatement());
		assertEquals(CompoundStatement.class, stmnt.getStatement().getClass());
		assertEquals(IfStatement.class, ((CompoundStatement)stmnt.getStatement()).getStatementIterator().next().getClass());
		assertNotNull(stmnt.getElseStatement());
		assertEquals(CompoundStatement.class, stmnt.getElseStatement().getClass());
		assertEquals(IfStatement.class, ((CompoundStatement)stmnt.getElseStatement()).getStatementIterator().next().getClass());
	}
	
	@Test
	public void testIfElseIf() throws ParseError {
		IfElseStatement stmnt = parse("if(true){ x:\"X?\" boolean } else if(true){ y:\"Y?\" boolean }", IfElseStatement.class);
		
		assertNotNull(stmnt.getExpression());
		assertNotNull(stmnt.getStatement());
		assertNotNull(stmnt.getElseStatement());
		assertEquals(IfStatement.class, stmnt.getElseStatement().getClass());
		assertNotNull(((IfStatement)stmnt.getElseStatement()).getExpression());
		assertNotNull(((IfStatement)stmnt.getElseStatement()).getStatement());
	}
	
}
