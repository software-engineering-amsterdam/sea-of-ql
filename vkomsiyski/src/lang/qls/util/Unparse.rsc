module lang::qls::util::Unparse

import lang::ql::ast::AST;
import lang::ql::util::Environment;
import lang::ql::util::Typecheck;
import lang::qls::ast::AST;
import String;


public str unparseCustom(Expr e:ident(name), Declarations d) 
  = "(" + name + getValueCustom(d[name].\type, d[name].\type@widget) + ")";

public str unparseCustom(Expr e:intConst(val), Declarations d) = "(<val>)";

public str unparseCustom(Expr e:boolConst(val), Declarations d) = "(<val>)";

public str unparseCustom(Expr e:stringConst(val), Declarations d) = "(<val>)";

public str unparseCustom(Expr e:dateConst(val), Declarations d) = "(new QDate(<split(".", val)[2]>, <split(".", val)[1]>, <split(".", val)[0]>))";

public str unparseCustom(Expr e:floatConst(val), Declarations d) = "(<val>)";

public str unparseCustom(Expr e:pos(e), Declarations d) = "(+" + unparseCustom(e, d) + ")";

public str unparseCustom(Expr e:neg(e), Declarations d) = "(-" + unparseCustom(e) + ")";

public str unparseCustom(Expr e:not(e), Declarations d) = "(!" + unparseCustom(e) + ")";

public str unparseCustom(Expr e:mul(e1, e2), Declarations d) = "(" + unparseCustom(e1, d) + "*" + unparseCustom(e2, d) + ")";

public str unparseCustom(Expr e:div(e1, e2), Declarations d) = "(" + unparseCustom(e1, d) + "/" + unparseCustom(e2, d) + ")";

public str unparseCustom(Expr e:add(e1, e2), Declarations d) = "(" + unparseCustom(e1, d) + "+" + unparseCustom(e2, d) + ")";

public str unparseCustom(Expr e:sub(e1, e2), Declarations d) = "(" + unparseCustom(e1, d) + "-" + unparseCustom(e2, d) + ")";

public str unparseCustom(Expr e:lt(e1, e2), Declarations d) = 
	(expected(\date("date"), e1, d) && expected(\date("date"), e2, d)) ?
	"(" + unparseCustom(e1, d) + ".daysTo" + unparseCustom(e2, d) + "\>0)" :
	"(" + unparseCustom(e1, d) + "\<" + unparseCustom(e2, d) + ")";

public str unparseCustom(Expr e:leq(e1, e2), Declarations d) = 
	(expected(\date("date"), e1, d) && expected(\date("date"), e2, d)) ?
	"(" + unparseCustom(e1, d) + ".daysTo" + unparseCustom(e2, d) + "\>=0)" :
	"(" + unparseCustom(e1, d) + "\<=" + unparseCustom(e2, d) + ")";

public str unparseCustom(Expr e:gt(e1, e2), Declarations d) = 
	(expected(\date("date"), e1, d) && expected(\date("date"), e2, d)) ?
	"(" + unparseCustom(e1, d) + ".daysTo" + unparseCustom(e2, d) + "\<0)" :
	"(" + unparseCustom(e1, d) + "\>" + unparseCustom(e2, d) + ")";

public str unparseCustom(Expr e:geq(e1, e2), Declarations d) = 
	(expected(\date("date"), e1, d) && expected(\date("date"), e2, d)) ?
	"(" + unparseCustom(e1, d) + ".daysTo" + unparseCustom(e2, d) + "\<=0)" :
	"(" + unparseCustom(e1, d) + "\>=" + unparseCustom(e2, d) + ")";

public str unparseCustom(Expr e:eq(e1, e2), Declarations d) = 
	(expected(\date("date"), e1, d) && expected(\date("date"), e2, d)) ?
	"(" + unparseCustom(e1, d) + ".daysTo" + unparseCustom(e2, d) + "==0)" :
	(expected(\string("string"), e1, d) && expected(\string("string"), e2, d)) ?
	"(" + unparseCustom(e1, d) + ".equals" + unparseCustom(e2, d) + ")" :
	"(" + unparseCustom(e1, d) + "==" + unparseCustom(e2, d) + ")";

public str unparseCustom(Expr e:neq(e1, e2), Declarations d) = 
	(expected(\date("date"), e1, d) && expected(\date("date"), e2, d)) ?
	"(" + unparseCustom(e1, d) + ".daysTo" + unparseCustom(e2, d) + "!=0)" :
	(expected(\string("string"), e1, d) && expected(\string("string"), e2, d)) ?
	"(!(" + unparseCustom(e1, d) + ".equals" + unparseCustom(e2, d) + "))" :
	"(" + unparseCustom(e1, d) + "!=" + unparseCustom(e2, d) + ")";

public str unparseCustom(Expr e:and(e1, e2), Declarations d) = "(" + unparseCustom(e1, d) + "&&" + unparseCustom(e2, d) + ")";

public str unparseCustom(Expr e:or(e1, e2), Declarations d) = "(" + unparseCustom(e1, d) + "||" + unparseCustom(e2, d) + ")";


public str getValueCustom(Type t:\bool(_), WidgetType wt:combobox(_)) = "Widget.currentIndex() == 1";

public str getValueCustom(Type t:\bool(_), WidgetType wt) = "Widget.isChecked()";

public str getValueCustom(Type t:string(_), WidgetType wt) = "Widget.text()";

public str getValueCustom(Type t:date(_), WidgetType wt) = "Widget.date()";

public str getValueCustom(Type t:\int(_), WidgetType wt) = "Widget.value()";

public str getValueCustom(Type t:float(_), WidgetType wt) = "Widget.value()";
