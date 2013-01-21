module lang::qls::tests::ParseHelper

import IO;
import ParseTree;
import lang::qls::ast::AST;
import lang::qls::syntax::QLS;

public Stylesheet parseStylesheet(str src) = 
  implode(#lang::qls::ast::AST::Stylesheet, parse(#start[Stylesheet], src, |file:///-|));

public Stylesheet parseStylesheet(loc f) = 
  parseStylesheet(readFile(f));
