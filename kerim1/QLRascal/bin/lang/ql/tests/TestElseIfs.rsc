module lang::ql::tests::TestElseIfs

import ParseTree;

import lang::ql::ast::AST;
import lang::ql::util::Parse;

private ElseIf p(str src) = implode(#ElseIf, parseElseIf(src));

public test bool testElseIf1() = p("else if (test) { a: \"abc\" int }") is elseIf;

public test bool testElseIf2() = p(	"else if (test) { 
									'	a: \"abc\" int 
									'}") is elseIf;
									
public test bool testElseIf3() = p(	"elseif(test){ 
									'	a: \"abc\" int 
									'	b: \"bcd\" bool (1 \< 2)
									'	c: \"cde\" string
									'}") is elseIf;
