module lang::qls::util::Implode

import ParseTree;
import lang::qls::util::Parse;
import lang::qls::ast::AST;
import IO;


public FormStyle implode(Tree t) = implode(#FormStyle, t);
public FormStyle load(loc l) = implode(parseQLS(readFile(l), l));


// needed for tests
//public Expr implodeExpr(Tree t) = implode(#Expr, t);
//public Expr loadExpr(str src) = implodeExpr(parseExpr(src));

//public Statement implodeStatement(Tree t) = implode(#Statement, t);
//public Statement loadStatement(str src) = implodeStatement(parseStatement(src));