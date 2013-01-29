/**
 * This module define test functions for each ElseIf variant   
 * A test function is a boolean function without arguments 
 * it can also be called automatically by the unit test framework, by typing :test 
 * @author  Gerson Delgado
 * @version 1.0, 21/01/2013
 */
 
module lang::ql::tests::TestElseIfConditions

import lang::ql::ast::AST;
import lang::ql::util::Parse;
import ParseTree;

private ElseIf p(str src) = implode(#ElseIf, parseElseIf(src));

public test bool testElseIf1() = p("else if (a || b) { name: \"test Question234:\" int }") is elseifCondition;
public test bool testElseIf2() = p(	"else if (a \> 3) {name: \"test Question234:\" string }") is elseifCondition;
									
