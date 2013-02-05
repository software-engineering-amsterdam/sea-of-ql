/**
 * This module contains implode funtion for Form 
 * A implode function Implode a parse tree according to a given ADT  
 * @author  Gerson Delgado
 * @version 1.0, 21/01/2013
 */
 
module lang::ql::util::Implode

import lang::ql::util::Parse;
import lang::ql::ast::AST;
import ParseTree;
import IO;

public Form implode(Tree t) = implode(#Form, t);
public Form load(loc l) = implode(parse(readFile(l), l));

public Form load(str txt) = implode(#Form, parse(#Form, txt));


