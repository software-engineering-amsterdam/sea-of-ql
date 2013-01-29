module lang::ql::util::Implode

import ParseTree;
import lang::ql::util::Parse;
import lang::ql::ast::AST;
import IO;


public Form implode(Tree t) = implode(#Form, t);
public Form load(loc l) = implode(parseQL(readFile(l), l));


// needed for tests
public Expr implodeExpr(Tree t) = implode(#Expr, t);
public Expr loadExpr(str src) = implodeExpr(parseExpr(src));

public Statement implodeStatement(Tree t) = implode(#Statement, t);
public Statement loadStatement(str src) = implodeStatement(parseStatement(src));