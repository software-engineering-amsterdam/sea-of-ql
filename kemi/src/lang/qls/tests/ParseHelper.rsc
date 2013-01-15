module lang::qls::tests::ParseHelper

import IO;
import ParseTree;
import lang::qls::ast::AST;
import lang::qls::syntax::QLS;

public QLS parseStyles(str src) = implode(#lang::qls::ast::AST::QLS, parse(#start[QLS], src, |file:///-|));
public QLS parseStyles(loc f) = parseStyles(readFile(f));
