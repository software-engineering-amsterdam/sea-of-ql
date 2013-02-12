module lang::ql::tests::TestVariableDepedencies

import lang::ql::util::Implode;

import lang::ql::ast::AST;
import lang::ql::ast::VariableDependencies;

public test bool testVariableDependencies1() = 
	(	"a" : 	{},
		"f" :	{"b", "c", "d"},
		"g" :	{"e"},
		"h"	: 	{"e", "z"}
	) == getVarDependencies(load(	"form test {
									'	a: \"a\" int
									'	if (b && (c \< d)) {
									'		f: \"f\" bool
									'	}
									'	if (e) {
									'		g: \"g\" int
									'		if (z) {
									'			h: \"h\" string
									'		}
									'	}
									'}"));