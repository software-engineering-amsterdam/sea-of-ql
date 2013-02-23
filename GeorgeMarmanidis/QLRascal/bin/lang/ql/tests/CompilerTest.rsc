module lang::ql::tests::CompilerTest

import lang::ql::ast::AST;
import lang::ql::util::Implode;
import ParseTree;
import IO;
import lang::ql::compiler::CompileForm;

public void compTest(){
Form a=load(|project://SofConstr/exampleForms/test5.q|);

compileForm(a,|project://SofConstr/exampleForms/test5.q|);
}