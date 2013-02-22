package org.uva.sea.ql.parser.test.statements.conditions;

import org.junit.Test;
import org.uva.sea.ql.parser.ParseError;

public class TestIfThenStatements extends ConditionTypeChecker {
	@Test
	public void testIfThen() throws ParseError {
		// Single If-Then condition block with AnswerableQuestion as body
		isAValidStatementBlock("if (true) { \"Did you want to buy a house?\" wantsToBuyHouse: boolean }");
		isAValidStatementBlock("if (wantsToBuyHouse) { \"What is your name?\" age: integer }");
		isAValidStatementBlock("if (wantsToBuyHouse && age >= 18) { \"Did you sell a house in 2010?\" hasSoldHouse: boolean }");
	}
	
	@Test
	public void testIfBlockWithoutCurlyBrackets() throws ParseError {
		// Single If-Then condition block without curly brackets
		isAValidStatementBlock("if (true) \"Did you sell a house in 2010?\" hasSoldHouse: boolean");
	}
	
	@Test
	public void testElseBlock() throws ParseError {
		// Single If-Then-Else condition block with Question as body
		isAValidStatementBlock("if (true) { \"Age?\" age: integer } else { \"Gender?\" gender: string }");
	}
	
	@Test
	public void testElseBlockWithoutCurlyBrackets() throws ParseError {
		// Single If-Then-Else condition block without curly brackets
		isAValidStatementBlock("if (true) \"Age?\" age: integer else \"Gender?\" gender: string");
	}
	
	@Test
	public void testIfBlockWithMultipleBodyLines() throws ParseError {
		// Single If-Then condition block with multiple lines as body
		isAValidStatementBlock("if (true) { \"Age?\" age: integer \n \"Name?\" name: string }");
	}
	
	@Test
	public void testInnerIfConditionBlocks() throws ParseError {
		// First we need a AnswerableQuestion to store the identifier used in the IfThen condition
		isAValidStatementBlock(
			"if (true) { " +
				"\"Do you want to buy a house in 2013?\" wantsToBuyHouse: boolean " +
				"if (wantsToBuyHouse) { " + 
					"\"Did you sell a house in 2010?\" hasSoldHouse: boolean " +
				"}" +
			"}");
	}
	
	@Test
	public void testInnerIfConditionBlocksWithMultipleBodyLines() throws ParseError {
		// First we need a AnswerableQuestion to store the identifier used in the IfThen condition
		isAValidStatementBlock(
			"if (true) { " +
				"\"Do you want to buy a house in 2013?\" wantsToBuyHouse: boolean " +
				"if (wantsToBuyHouse) { " + 
					"\"Did you sell a house in 2010?\" hasSoldHouse: boolean " +
					"\"Did you sell a car in 2010?\" hasSoldCar: boolean" +
				"}" +
			"}");
	}
	
	@Test
	public void testInnerIfConditionBlocksWithComputedQuestions() throws ParseError {
		// First we need a AnswerableQuestion to store the identifier used in the IfThen condition
		isAValidStatementBlock(
			"if (true) { " +
				"\"Do you want to buy a house in 2013?\" wantsToBuyHouse: boolean " +
				"if (wantsToBuyHouse) { " + 
					"\"Did you sell a house in 2010?\" hasSoldHouse: boolean " +
					"\"Qualifies for large insurance:\" insuranceProspect = wantsToBuyHouse && hasSoldHouse" +
				"}" +
			"}");
	}
}