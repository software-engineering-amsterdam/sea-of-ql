module lang::ql::ast::load

import lang::ql::syntax::Syntax;
import lang::ql::ast::AST;
import ParseTree;

public FORM load(str txt) = implode(#FORM, parse(#Form, txt));

public EXPR loadE(str txt) = implode(#EXPR, parse(#Expr, txt));

public TYPE loadT(str txt) = implode(#TYPE, parse(#Type, txt));

public QUESTION loadQ(str txt) = implode(#QUESTION, parse(#Question, txt));

public STATEMENT loadS(str txt) = implode(#STATEMENT, parse(#Statement, txt));

public IF loadIF(str txt) = implode(#IF, parse(#If, txt));

public ELSEIF loadEIF(str txt) = implode(#ELSEIF, parse(#ElseIf, txt));

public ELSE loadELSE(str txt) = implode(#ELSE, parse(#Else, txt));