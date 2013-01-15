module lang::qls::util::Implode

import ParseTree;
import lang::qls::util::Parse;
import lang::qls::ast::AST;


public QLS implode(Tree t) = implode(#QLS, t);

public QLS load(loc l) = implode(parse(readFile(l), l));