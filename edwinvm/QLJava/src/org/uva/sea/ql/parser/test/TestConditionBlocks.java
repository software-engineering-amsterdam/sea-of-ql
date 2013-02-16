package org.uva.sea.ql.parser.test;

import org.junit.Test;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.antlr.check.ANTLRParserConditionBlocks;

public class TestConditionBlocks extends StatementParserChecker {
	
	public TestConditionBlocks() {
		super(new ANTLRParserConditionBlocks());
	}
	
	@Test
	public void testIfBlock() throws ParseError {
		// Single If-Then condition block with Question as body
		statementMatchesConditionBlock("if (true) { \"Did you sell a house in 2010?\" hasSoldHouse: boolean }");
		statementMatchesConditionBlock("if (wantsToBuyHouse) { \"Did you sell a house in 2010?\" hasSoldHouse: boolean }");
		statementMatchesConditionBlock("if (wantsToBuyHouse && age >= 18) { \"Did you sell a house in 2010?\" hasSoldHouse: boolean }");
	}
	
	@Test
	public void testIfBlockWithoutCurlyBrackets() throws ParseError {
		// Single If-Then condition block without curly brackets
		statementMatchesConditionBlock("if (true) \"Did you sell a house in 2010?\" hasSoldHouse: boolean");
	}
	
	@Test
	public void testElseBlock() throws ParseError {
		// Single If-Then-Else condition block with Question as body
		statementMatchesConditionBlock("if (true) { \"Age?\" age: integer } else { \"Gender?\" gender: string }");
	}
	
	@Test
	public void testElseBlockWithoutCurlyBrackets() throws ParseError {
		// Single If-Then-Else condition block without curly brackets
		statementMatchesConditionBlock("if (true) \"Age?\" age: integer else \"Gender?\" gender: string");
	}
	
	@Test
	public void testIfBlockWithMultipleBodyLines() throws ParseError {
		// Single If-Then condition block with multiple lines as body
		statementMatchesConditionBlock("if (true) { \"Age?\" age: integer \n \"Name?\" name: string }");
	}
	
	@Test
	public void testInnerIfConditionBlocks() throws ParseError {
		// Single If-Then condition block with inner If-Then condition block
		statementMatchesConditionBlock("if (true) { if (wantsToBuyHouse) { \"Did you sell a house in 2010?\" hasSoldHouse: boolean } }");
	}
}