module lang::qls::tests::styles::Grammar

import lang::qls::ast::AST;
import lang::qls::tests::ParseHelper;

public test bool testStyles1() = parseStyles("class A { #el1 #el2 }") is qls;
public test bool testStyles2() = parseStyles("boolean { type radio }") is qls;
