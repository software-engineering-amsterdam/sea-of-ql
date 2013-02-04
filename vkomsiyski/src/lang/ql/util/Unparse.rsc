module lang::ql::util::Unparse

import lang::ql::ast::AST;
import lang::ql::util::Environment;
import lang::ql::util::Typecheck;
import String;

public str unparse(Expr e:ident(name)) = name;

public str unparse(Expr e:ident(name), Declarations d) = "(" + name + getValue(d[name].\type) + ")";

public str unparse(Expr e:intConst(val)) = "<val>";

public str unparse(Expr e:intConst(val), Declarations d) = "(<val>)";

public str unparse(Expr e:boolConst(val)) = "<val>";

public str unparse(Expr e:boolConst(val), Declarations d) = "(<val>)";

public str unparse(Expr e:stringConst(val)) = val;

public str unparse(Expr e:stringConst(val), Declarations d) = "(<val>)";

public str unparse(Expr e:dateConst(val)) = val;

public str unparse(Expr e:dateConst(val), Declarations d) = "(new QDate(<split(".", val)[2]>, <split(".", val)[1]>, <split(".", val)[0]>))";

public str unparse(Expr e:floatConst(val)) = "<val>";

public str unparse(Expr e:floatConst(val), Declarations d) = "(<val>)";

public str unparse(Expr e:pos(e)) = "+" + unparse(e);

public str unparse(Expr e:pos(e), Declarations d) = "(+" + unparse(e, d) + ")";

public str unparse(Expr e:neg(e)) = "-" + unparse(e);

public str unparse(Expr e:neg(e), Declarations d) = "(-" + unparse(e) + ")";

public str unparse(Expr e:not(e)) = "!" + unparse(e);

public str unparse(Expr e:not(e), Declarations d) = "(!" + unparse(e) + ")";

public str unparse(Expr e:mul(e1, e2)) = unparse(e1) + "*" + unparse(e2);

public str unparse(Expr e:mul(e1, e2), Declarations d) = "(" + unparse(e1, d) + "*" + unparse(e2, d) + ")";

public str unparse(Expr e:div(e1, e2)) = unparse(e1) + "/" + unparse(e2);

public str unparse(Expr e:div(e1, e2), Declarations d) = "(" + unparse(e1, d) + "/" + unparse(e2, d) + ")";

public str unparse(Expr e:add(e1, e2)) = unparse(e1) + "+" + unparse(e2);

public str unparse(Expr e:add(e1, e2), Declarations d) = "(" + unparse(e1, d) + "+" + unparse(e2, d) + ")";

public str unparse(Expr e:sub(e1, e2)) = unparse(e1) + "-" + unparse(e2);

public str unparse(Expr e:sub(e1, e2), Declarations d) = "(" + unparse(e1, d) + "-" + unparse(e2, d) + ")";

public str unparse(Expr e:lt(e1, e2)) = unparse(e1) + "\<" + unparse(e2);

public str unparse(Expr e:lt(e1, e2), Declarations d) = 
	(expected(\date("date"), e1, d) && expected(\date("date"), e2, d)) ?
	"(" + unparse(e1, d) + ".daysTo" + unparse(e2, d) + "\>0)" :
	"(" + unparse(e1, d) + "\<" + unparse(e2, d) + ")";

public str unparse(Expr e:leq(e1, e2)) = unparse(e1) + "\<=" + unparse(e2);

public str unparse(Expr e:leq(e1, e2), Declarations d) = 
	(expected(\date("date"), e1, d) && expected(\date("date"), e2, d)) ?
	"(" + unparse(e1, d) + ".daysTo" + unparse(e2, d) + "\>=0)" :
	"(" + unparse(e1, d) + "\<=" + unparse(e2, d) + ")";

public str unparse(Expr e:gt(e1, e2)) = unparse(e1) + "\>" + unparse(e2);

public str unparse(Expr e:gt(e1, e2), Declarations d) = 
	(expected(\date("date"), e1, d) && expected(\date("date"), e2, d)) ?
	"(" + unparse(e1, d) + ".daysTo" + unparse(e2, d) + "\<0)" :
	"(" + unparse(e1, d) + "\>" + unparse(e2, d) + ")";

public str unparse(Expr e:geq(e1, e2)) = unparse(e1) + "\>=" + unparse(e2);

public str unparse(Expr e:geq(e1, e2), Declarations d) = 
	(expected(\date("date"), e1, d) && expected(\date("date"), e2, d)) ?
	"(" + unparse(e1, d) + ".daysTo" + unparse(e2, d) + "\<=0)" :
	"(" + unparse(e1, d) + "\>=" + unparse(e2, d) + ")";

public str unparse(Expr e:eq(e1, e2)) = unparse(e1) + "==" + unparse(e2);

public str unparse(Expr e:eq(e1, e2), Declarations d) = 
	(expected(\date("date"), e1, d) && expected(\date("date"), e2, d)) ?
	"(" + unparse(e1, d) + ".daysTo" + unparse(e2, d) + "==0)" :
	(expected(\string("string"), e1, d) && expected(\string("string"), e2, d)) ?
	"(" + unparse(e1, d) + ".equals" + unparse(e2, d) + ")" :
	"(" + unparse(e1, d) + "==" + unparse(e2, d) + ")";

public str unparse(Expr e:neq(e1, e2)) = unparse(e1) + "!=" + unparse(e2);

public str unparse(Expr e:neq(e1, e2), Declarations d) = 
	(expected(\date("date"), e1, d) && expected(\date("date"), e2, d)) ?
	"(" + unparse(e1, d) + ".daysTo" + unparse(e2, d) + "!=0)" :
	(expected(\string("string"), e1, d) && expected(\string("string"), e2, d)) ?
	"(!(" + unparse(e1, d) + ".equals" + unparse(e2, d) + "))" :
	"(" + unparse(e1, d) + "!=" + unparse(e2, d) + ")";

public str unparse(Expr e:and(e1, e2)) = unparse(e1) + "&&" + unparse(e2);

public str unparse(Expr e:and(e1, e2), Declarations d) = "(" + unparse(e1, d) + "&&" + unparse(e2, d) + ")";

public str unparse(Expr e:or(e1, e2)) = unparse(e1) + "||" + unparse(e2);

public str unparse(Expr e:or(e1, e2), Declarations d) = "(" + unparse(e1, d) + "||" + unparse(e2, d) + ")";

public str getValue(Type t:\bool(_)) = "Widget.isChecked()";

public str getValue(Type t:string(_)) = "Widget.text()";

public str getValue(Type t:date(_)) = "Widget.date()";

public str getValue(Type t:\int(_)) = "Widget.value()";

public str getValue(Type t:float(_)) = "Widget.value()";
