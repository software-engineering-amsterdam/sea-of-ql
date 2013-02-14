module lang::ql::tests::CompilerTest

import lang::ql::ast::AST;
import lang::ql::util::Implode;
import ParseTree;
import IO;
import lang::ql::compiler::CompileForm2;

public void compTest(){
Form a=load(|project://SofConstr/exampleForms/test4.q|);

print(compileForm(a));
}