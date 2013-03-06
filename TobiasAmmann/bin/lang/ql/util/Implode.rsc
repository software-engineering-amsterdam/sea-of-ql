module lang::ql::util::Implode

import ParseTree;
import lang::ql::util::Parse;
import lang::ql::ast::AST;
import IO;


public FORM implode(Tree t) = implode(#FORM, t);

public FORM load(loc l) = implode(parse(readFile(l), l));