module lang::ql::tests::TestTypes

import ParseTree;

import lang::ql::ast::AST;
import lang::ql::util::Parse;

private Type p(str src) = implode(#Type, parseType(src));

public test bool testIntType() = p("int") is intType;
public test bool testBoolType() = p("bool") is boolType;
public test bool testStringType() = p("string") is stringType;