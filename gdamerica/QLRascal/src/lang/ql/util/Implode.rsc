/**
 * This module contains implode funtion(s) for Form
 * Implode functions implode a parse tree according to the given ADT 
 * @author  Gerson Delgado
 * @version 1.0, 21/01/2013
 */
 
module lang::ql::util::Implode

import lang::ql::util::Parse;
import lang::ql::ast::AST;
import ParseTree;
import IO;

public Form implode(Tree t) 
	= implode(#Form, t);

public Form load(loc l) 
	= implode(parseForm(readFile(l)));







