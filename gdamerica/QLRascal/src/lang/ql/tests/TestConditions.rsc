/**
 * This module define test functions for each Condition variant 
 * A test function is a boolean function without arguments 
 * it can also be called automatically by the unit test framework, by typing :test 
 * @author  Gerson Delgado
 * @version 1.0, 21/01/2013
 */
 
module lang::ql::tests::TestConditions

import lang::ql::ast::AST;
import lang::ql::util::Parse;
import ParseTree;


private Condition p(str src) 
	= implode(#Condition, parseCondition(src));

public test bool testSimpleIfCondition1() 
	= p("if (a || b) { name: \"test Question234:\" int }") is singleIfCondition;
public test bool testSimpleIfCondition2() 
	= p("if (b) { name: \"test Question:\" money }") is singleIfCondition;

public test bool testIfElseCondition1() 
	= p("if (a || b) { name: \"test Question234:\" int } else { name: \"test Question4:\" money }") is ifElseCondition;
public test bool testIfElseIfCondition2() 
	= p("if (a && b) { name: \"test Question34:\" boolean } else { name: \"test Question5:\" money } ") is ifElseCondition;





										
							
							