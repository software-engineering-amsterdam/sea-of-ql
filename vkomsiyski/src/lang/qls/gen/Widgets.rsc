module lang::qls::gen::Widgets

import lang::ql::ast::AST;
import lang::ql::util::Environment;
import lang::ql::gen::Widgets;
import lang::qls::ast::AST;
import lang::qls::util::Unparse;
import String;

private str defaultValue(Type t:\int(_)) = "0";
private str defaultValue(Type t:\bool(_)) = "false";
private str defaultValue(Type t:float(_)) = "0.0";
private str defaultValue(Type t:string(_)) = "\"\"";
private str defaultValue(Type t:date(_)) = "new QDate(2000, 1, 1)";

private WidgetType defaultWidget(Type t:\bool(_)) = checkbox("CheckBox");
private WidgetType defaultWidget(Type t:\int(_)) = spinbox("SpinBox");
private WidgetType defaultWidget(Type t:float(_)) = doublespinbox("DoubleSpinBox");
private WidgetType defaultWidget(Type t:date(_)) = dateedit("DateEdit");
private WidgetType defaultWidget(Type t:string(_)) = lineedit("LineEdit");


public list[Widget] getCustomWidgets(Form input, Declarations d) {
	widgets = [];
	for (statement <- input.statements) 
		widgets += getCustomWidgets(statement, boolConst(true), d);
	
	return widgets;
}

private list[Widget] getCustomWidgets(Statement s:regular(\type, name, _), Expr vis, Declarations d) 
  = [<name, \type, unparseCustom(vis, d), defaultValue(\type), true>];

private list[Widget] getCustomWidgets(Statement s:computed(\type, name, _, expr), Expr vis, Declarations d)
  = [<name, \type, unparseCustom(vis, d), unparseCustom(expr, d), false>];


private list[Widget] getCustomWidgets(Statement s:conditional(\if, [], \else), Expr vis, Declarations d)
  = [w | st <- s.\if.body, w <- getCustomWidgets(st, and(vis, s.\if.condition), d)] +
	[w | st <- s.\else, w <- getCustomWidgets(st, and(vis, not(s.\if.condition)), d)];

private list[Widget] getCustomWidgets(Statement s:conditional(\if, elseIfs, \else), Expr vis, Declarations d)
  = [w | st <- s.\if.body, w <- getCustomWidgets(st, and(vis, s.\if.condition), d)] +
	getCustomWidgets(conditional(head(s.elseIfs), tail(s.elseIfs), s.\else), and(vis, not(s.\if.condition)), d);

public str setCustomValue(Type t, WidgetType wt:combobox(_), str name, str val) 
  = "\n\t\t<name>Widget.setCurrentIndex(<val> ? 1 : 0);";

public str setCustomValue(Type t, WidgetType wt, str name, str val)
  = setValue(t, name, val);
  
  
public str submitCustomWidget(str name, Declarations d) = "
\t\tif (<name>Widget.isVisible())
\t\t\tobj.put(\"<name>\", <unparseCustom(ident(name), d)>);\n"; 
  