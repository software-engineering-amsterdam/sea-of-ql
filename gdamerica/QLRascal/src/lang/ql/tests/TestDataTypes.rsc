/**
 * This module define test functions for each DataType variant   
 * @author  Gerson Delgado
 * @version 1.0, 21/01/2013
 */
 
module lang::ql::tests::TestDataTypes

import lang::ql::ast::AST;
import lang::ql::util::Parse;
import ParseTree;

private DataType p(str src) = implode(#DataType, parseDataType(src));

public test bool testInteger() = p("int") is integer;
public test bool testBoolean() = p("boolean") is boolean;
public test bool testString() = p("string") is string;
public test bool testMoney() = p("money") is money;
public test bool testDecimal() = p("decimal") is decimal;
public test bool testDate() = p("date") is date;


