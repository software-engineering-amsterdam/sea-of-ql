/**
 * This module define test functions for each Form variant
 * A test function is a boolean function without arguments 
 * it can also be called automatically by the unit test framework, by typing :test    
 * @author  Gerson Delgado
 * @version 1.0, 21/01/2013
 */
module lang::ql::tests::TestForms

import lang::ql::util::Implode;
import lang::ql::util::Parse;
import lang::ql::ast::AST;

private Form p(str src) = implode(parse(src));

public test bool testForm1() = p("form Box1HouseOwning{  }") is form;


