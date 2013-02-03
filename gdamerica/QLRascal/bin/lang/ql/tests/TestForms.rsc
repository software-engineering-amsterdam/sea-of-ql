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

private Form p(str src) = implode(parseForm(src));

public test bool testForm1() = p("form Box1HouseOwning{  }") is form;
public test bool testForm2() = p("form Box1HouseOwning{ if (a || b) { name: \"test Question234:\" int } }") is form;
public test bool testForm3() = p("form Box1HouseOwning{ 
														hasSoldHouse: \"Did you sell a house in 2010?:\" boolean 
														hasBoughtHouse: \"Did you buy a house in 2010?:\" boolean 
														if (hasSoldHouse) { 
														SellingPrice: \"price of the house was sold for:\" money 
																		   } 
													   }") is form;


