module lang::ql::util::Unparse

import lang::ql::ast::AST;

// needed for the conditional label; 
// it's impossible to use library functions because the expression is already imploded 

public str unparse(Expr e:ident(name)) = name;

public str unparse(Expr e:intConst(val)) = "<val>";

public str unparse(Expr e:boolConst(val)) = "<val>";

public str unparse(Expr e:stringConst(val)) = val;

public str unparse(Expr e:dateConst(val)) = val;

public str unparse(Expr e:floatConst(val)) = "<val>";

public str unparse(Expr e:pos(e)) = "+" + unparse(e);

public str unparse(Expr e:neg(e)) = "-" + unparse(e);

public str unparse(Expr e:not(e)) = "!" + unparse(e);

public str unparse(Expr e:mul(e1, e2)) = unparse(e1) + "*" + unparse(e2);

public str unparse(Expr e:div(e1, e2)) = unparse(e1) + "/" + unparse(e2);

public str unparse(Expr e:add(e1, e2)) = unparse(e1) + "+" + unparse(e2);

public str unparse(Expr e:sub(e1, e2)) = unparse(e1) + "-" + unparse(e2);

public str unparse(Expr e:lt(e1, e2)) = unparse(e1) + "\<" + unparse(e2);

public str unparse(Expr e:leq(e1, e2)) = unparse(e1) + "\<=" + unparse(e2);

public str unparse(Expr e:gt(e1, e2)) = unparse(e1) + "\>" + unparse(e2);

public str unparse(Expr e:geq(e1, e2)) = unparse(e1) + "\>=" + unparse(e2);

public str unparse(Expr e:eq(e1, e2)) = unparse(e1) + "==" + unparse(e2);

public str unparse(Expr e:neq(e1, e2)) = unparse(e1) + "!=" + unparse(e2);

public str unparse(Expr e:and(e1, e2)) = unparse(e1) + "&&" + unparse(e2);

public str unparse(Expr e:or(e1, e2)) = unparse(e1) + "||" + unparse(e2);

