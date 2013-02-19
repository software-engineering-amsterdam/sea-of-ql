module lang::ql::gen::Widgets

import lang::ql::ast::AST;
import lang::ql::util::Environment;
import lang::ql::util::Unparse;
import String;

alias Widget = tuple[str name, Type \type, str visibility, str val, bool enabled];

private str defaultValue(Type t:\int(_)) = "0";
private str defaultValue(Type t:\bool(_)) = "false";
private str defaultValue(Type t:float(_)) = "0.0";
private str defaultValue(Type t:string(_)) = "\"\"";
private str defaultValue(Type t:date(_)) = "new QDate(2000, 1, 1)";



public list[Widget] getWidgets(Form input, Declarations d) {
	widgets = [];
	for (statement <- input.statements) 
		widgets += getWidgets(statement, boolConst(true), d);
	
	return widgets;
}

private list[Widget] getWidgets(Statement s:regular(\type, name, _), Expr vis, Declarations d) 
  = [<name, \type, unparse(vis, d), defaultValue(\type), true>];

private list[Widget] getWidgets(Statement s:computed(\type, name, _, expr), Expr vis, Declarations d)
  = [<name, \type, unparse(vis, d), unparse(expr, d), false>];


private list[Widget] getWidgets(Statement s:conditional(\if, [], \else), Expr vis, Declarations d)
  = [w | st <- s.\if.body, w <- getWidgets(st, and(vis, s.\if.condition), d)] +
	[w | st <- s.\else, w <- getWidgets(st, and(vis, not(s.\if.condition)), d)];

private list[Widget] getWidgets(Statement s:conditional(\if, elseIfs, \else), Expr vis, Declarations d)
  = [w | st <- s.\if.body, w <- getWidgets(st, and(vis, s.\if.condition), d)] +
	getWidgets(conditional(head(s.elseIfs), tail(s.elseIfs), s.\else), and(vis, not(s.\if.condition)), d);



public str addWidget(Widget w:<name, \bool(_), vis, val, e>) ="
\t\t<name>Widget.setChecked(<val>);
\t\t<name>Widget.toggled.connect(this, \"onChanged(boolean)\");" 
+ genericWidget(name, vis, e);

public str addWidget(Widget w:<name, \int(_), vis, val, e>) ="
\t\t<name>Widget.setValue(<val>);
\t\t<name>Widget.valueChanged.connect(this, \"onChanged(int)\");"
+ genericWidget(name, vis, e);

public str addWidget(Widget w:<name, float(_), vis, val, e>) ="
\t\t<name>Widget.setValue(<val>);
\t\t<name>Widget.valueChanged.connect(this, \"onChanged(double)\");"
+ genericWidget(name, vis, e);

public str addWidget(Widget w:<name, string(_), vis, val, e>) ="
\t\t<name>Widget.setText(<val>);
\t\t<name>Widget.textChanged.connect(this, \"onChanged(String)\");"
+ genericWidget(name, vis, e);

public str addWidget(Widget w:<name, date(_), vis, val, e>) ="
\t\t<name>Widget.setDate(<val>);
\t\t<name>Widget.setDisplayFormat(\"d MMMM yyyy\"); 
\t\t<name>Widget.setCalendarPopup(true); 
\t\t<name>Widget.dateChanged.connect(this, \"onChanged(QDate)\");"
+ genericWidget(name, vis, e);

public str genericWidget(str name, str vis, bool e) = "
\t\t<name>Label.setBuddy(<name>Widget);
\t\tlabels.add(<name>Label);
\t\t<name>Widget.setEnabled(<e>);"
+ visibilityMap(name, vis);

public str visibilityMap(str name, str vis) = "\n\t\tvisibilityMap.put(<name>Label, <vis>);";

public str setValue(Type t:string(_), str name, str val) = "\n\t\t<name>Widget.setText(<val>);";

public str setValue(Type t:date(_), str name, str val) = "\n\t\t<name>Widget.setDate(<val>);";

public str setValue(Type t:\bool(_), str name, str val) = "\n\t\t<name>Widget.setChecked(<val>);";

public str setValue(Type t:\int(_), str name, str val) = "\n\t\t<name>Widget.setValue(<val>);";

public str setValue(Type t:float(_), str name, str val) = "\n\t\t<name>Widget.setValue(<val>);";

public str submitWidget(str name, Declarations d) = "
\t\tif (<name>Widget.isVisible())
\t\t\tobj.put(\"<name>\", <unparse(ident(name), d)>);\n"; 





