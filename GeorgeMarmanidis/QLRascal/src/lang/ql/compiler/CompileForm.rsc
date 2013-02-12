module lang::ql::compiler::CompileForm

import ParseTree;
import lang::ql::ast::AST;
import lang::ql::compiler::JavaScriptFunctions;

import IO;
public alias SCD=list[str];

public SCD addSourceCode(SCD scd, str code) = scd+code;
public void printSourceCode(SCD scd){
	for(x<-scd){
		print(x);
	}
}

public str compileForm(form(ident,formBody)){
	SCD scd=[];
	
		scd=addSourceCode(scd,createStartFormStatmn(ident));
		scd=addSourceCode(scd,createBodyStatmn());
		scd=addSourceCode(scd,createEndFormStatmn());
	
	printSourceCode(scd);
	return "ok";
}