package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.ConditionBlock;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.antlr.check.ANTLRParserConditionBlocks;

public class TestConditionBlocks {
	private IParser _parser;
	
	public TestConditionBlocks() {
		_parser = new ANTLRParserConditionBlocks();
	}
	
	@Test
	public void testIfBlock() throws ParseError {
		// Single If-Then condition block with Question as body
		assertEquals(_parser.parse("if (true) { \"Did you sell a house in 2010?\" hasSoldHouse: boolean }").getClass(), ConditionBlock.class);
		assertEquals(_parser.parse("if (wantsToBuyHouse) { \"Did you sell a house in 2010?\" hasSoldHouse: boolean }").getClass(), ConditionBlock.class);
		assertEquals(_parser.parse("if (wantsToBuyHouse && age >= 18) { \"Did you sell a house in 2010?\" hasSoldHouse: boolean }").getClass(), ConditionBlock.class);
	}
	
	@Test
	public void testIfBlockWithoutCurlyBrackets() throws ParseError {
		// Single If-Then condition block without curly brackets
		assertEquals(_parser.parse("if (true) \"Did you sell a house in 2010?\" hasSoldHouse: boolean").getClass(), ConditionBlock.class);
	}
	
	@Test
	public void testElseBlock() throws ParseError {
		// Single If-Then-Else condition block with Question as body
		assertEquals(_parser.parse("if (true) { \"Age?\" age: integer } else { \"Gender?\" gender: string }").getClass(), ConditionBlock.class);
	}
	
	@Test
	public void testElseBlockWithoutCurlyBrackets() throws ParseError {
		// Single If-Then-Else condition block without curly brackets
		assertEquals(_parser.parse("if (true) \"Age?\" age: integer else \"Gender?\" gender: string").getClass(), ConditionBlock.class);
	}
	
	@Test
	public void testIfBlockWithMultipleBodyLines() throws ParseError {
		// Single If-Then condition block with multiple lines as body
		assertEquals(_parser.parse("if (true) { \"Age?\" age: integer \n \"Name?\" name: string }").getClass(), ConditionBlock.class);
	}
	
	@Test
	public void testInnerIfConditionBlocks() throws ParseError {
		// Single If-Then condition block with inner If-Then condition block
		assertEquals(_parser.parse("if (true) { if (wantsToBuyHouse) { \"Did you sell a house in 2010?\" hasSoldHouse: boolean } }").getClass(), ConditionBlock.class);
	}
}