package org.uva.sea.ql.parser.test.statements.conditions;

import org.junit.Test;
import org.uva.sea.ql.parser.ParseError;

public class TestIfThenElseStatements extends ConditionTypeChecker {
	@Test
	public void testIfThenElseBlock() throws ParseError {
		// Single If-Then-Else condition block with Question as body
		isAValidStatementBlock("if (true) { \"Age?\" age: integer } else { \"Gender?\" gender: string }");
	}
	
	@Test
	public void testIfThenElseBlockWithoutCurlyBrackets() throws ParseError {
		// Single If-Then-Else condition block without curly brackets
		isAValidStatementBlock("if (true) \"Age?\" age: integer else \"Gender?\" gender: string");
	}
	
	@Test
	public void testInnerIfThenElseConditionBlocks() throws ParseError {
		// First we need a AnswerableQuestion to store the identifier used in the IfThen condition
		isAValidStatementBlock(
			"if (true) { " +
				"\"Do you want to buy a house in 2013?\" wantsToBuyHouse: boolean " +
				"if (wantsToBuyHouse) { " + 
					"\"Did you sell a house in 2010?\" hasSoldHouse: boolean " +
				"} else { " +
					"\"Did you buy a car in 2010?\" hasBoughtCar: boolean " +
				"}" +
			"}"
		);
	}
	
	@Test
	public void testInnerIfThenElseConditionBlocksWithMultipleBodyLines() throws ParseError {
		isAValidStatementBlock(
			"if (true) { " +
				"\"Do you want to buy a house in 2013?\" wantsToBuyHouse: boolean " +
			"} else { " + 
				"\"Did you sell a house in 2010?\" hasSoldHouse: boolean " +
				"\"Did you sell a car in 2010?\" hasSoldCar: boolean" +
			"}"
		);
	}
	
	@Test
	public void testInnerIfThenElseConditionBlocksWithComputedQuestions() throws ParseError {
		// First we need a AnswerableQuestion to store the identifier used in the Else condition
		isAValidStatementBlock(
			"if (true) { " +
				"\"Do you want to buy a house in 2013?\" wantsToBuyHouse: boolean " +
			"} else { " + 
				"\"Did you sell a house in 2010?\" hasSoldHouse: boolean " +
				"\"Qualifies for large insurance:\" insuranceProspect = wantsToBuyHouse && hasSoldHouse" +
			"}"
		);
	}
}