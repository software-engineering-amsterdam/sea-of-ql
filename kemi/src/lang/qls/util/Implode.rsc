module lang::qls::util::Implode

import ParseTree;
import lang::qls::util::Parse;
import lang::qls::ast::AST;


public Stylesheet implode(Tree t) = 
  implode(#Stylesheet, t);

public Stylesheet load(loc l) = 
  implode(parse(readFile(l), l));
  