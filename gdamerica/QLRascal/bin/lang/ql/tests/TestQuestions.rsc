/**
 * This module define test functions for each Question variant
 * A test function is a boolean function without arguments 
 * it can also be called automatically by the unit test framework, by typing :test    
 * @author  Gerson Delgado
 * @version 1.0, 21/01/2013
 */

module lang::ql::tests::TestQuestions

import lang::ql::ast::AST;
import lang::ql::util::Parse;
import ParseTree;

private Question p(str src) 
	= implode(#Question, parseQuestion(src));

public test bool testSingleQstn1() 
	= p("name: \"test Question:\" boolean") is singleQuestion;
public test bool testSingleQstn2() 
	= p("name: \"test Question234:\" int") is singleQuestion;




