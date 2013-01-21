module lang::ql::tests::TestDataTypes

/**
 * This module define test functions for each DataType DataType   
 * @author  Gerson Delgado
 * @version 1.0, 20/01/2013
 */
 
import lang::ql::util::Parse;
import lang::ql::util::Implode;
import lang::ql::ast::AST;

private Expr p(str src) = implode(parse(src, |file:///-|));

