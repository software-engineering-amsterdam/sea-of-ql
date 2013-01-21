/**
 * This module define test functions for each Condition variant   
 * @author  Gerson Delgado
 * @version 1.0, 21/01/2013
 */
 
module lang::ql::tests::TestConditions

import lang::ql::ast::AST;
import lang::ql::util::Parse;
import ParseTree;

private Condition p(str src) = implode(#Condition, parseCondition(src));

										
										
										