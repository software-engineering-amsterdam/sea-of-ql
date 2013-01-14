module lang::ql::util::Implode

import IO;
import ParseTree;
import lang::ql::util::Parse;
import lang::ql::ast::AST;

public Form implode(Tree t) = implode(#Form, t);

public Form load(loc l) = implode(parse(readFile(l), l));
public Form load(str text) = implode(parse(text));
