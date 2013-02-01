module lang::qls::gen::Widgets

import lang::ql::ast::AST;
import lang::ql::gen::Widgets;
import lang::ql::util::Unparse;
import lang::qls::ast::AST;
import lang::qls::util::Environment;
import String;


public str decorateLabel(str name, VarRules rules) {
	deco = "";
	if (name in rules) 
		for (r <- rules[name]) {
			if (color(cname) := r) deco += "color : <replaceAll(cname, "\"", "")>;";
			if (font(fname) := r) deco += "font : <replaceAll(fname, "\"", "")>;";
		}
	return "\n\t\t<name>Label.setStyleSheet(\"<deco>\");";
}