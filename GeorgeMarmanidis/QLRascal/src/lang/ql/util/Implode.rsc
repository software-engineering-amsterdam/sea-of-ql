module lang::ql::util::Implode

import ParseTree;
import lang::ql::util::Parse;
import lang::ql::ast::AST;
import IO;


public Question implode(Tree t) = implode(#Question, t);

public Question load(loc l) = implode(parse(readFile(l), l));