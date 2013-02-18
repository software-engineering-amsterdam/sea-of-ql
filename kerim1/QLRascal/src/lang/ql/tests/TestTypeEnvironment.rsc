module lang::ql::tests::TestTypeEnvironment

import lang::ql::util::Implode;

import lang::ql::ast::AST;
import lang::ql::ast::TypeEnvironment;

public test bool testTypeEnvironment1() = 
	<(	"g" : intType()), (
		"a" : intType(),
		"f" : boolType(),
		"h" : stringType()
	)> == getTypeEnvironment(load(	"form test {
									'	a: \"a\" int
									'	if (b && (c \< d)) {
									'		f: \"f\" bool
									'	}
									'	if (e) {
									'		g: \"g\" int (+100)
									'		if (z) {
									'			h: \"h\" string
									'		}
									'	}
									'}"));