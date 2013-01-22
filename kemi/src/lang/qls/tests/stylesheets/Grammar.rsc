module lang::qls::tests::stylesheets::Grammar

import lang::qls::ast::AST;
import lang::qls::tests::ParseHelper;

public test bool testStyles1() = parseStylesheet("class A { #el1 #el2 }") is stylesheet;
public test bool testStyles2() = parseStylesheet("boolean { type radio }") is stylesheet;
public test bool testStyles3() = parseStylesheet(".A { type checkbox }") is stylesheet;
public test bool testStyles4() = parseStylesheet("#B { width 100 }") is stylesheet;
