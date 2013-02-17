/**
 * This module contains implode funtion(s) for Form 
 * @author  Gerson Delgado
 * @version 1.0, 21/01/2013
 */
 
module lang::ql::util::Implode

import lang::ql::util::Parse;
import lang::ql::ast::AST;
import ParseTree;
import IO;

/**
* Implode function fucntion 
* A implode function Implode a parse tree according to a given ADT
*/
public Form implode(Tree t) = implode(#Form, t);

/**
* Load function fucntion 
* load or implode a .q file from given location
*/
public Form load(loc l) = implode(parseForm(readFile(l)));







