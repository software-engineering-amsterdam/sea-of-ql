module lang::qls::gen::Decorate

import lang::ql::ast::AST;
import lang::ql::util::Unparse;
import lang::qls::ast::AST;
import lang::qls::util::Environment;
import String;

public str decorateLabel(str name, VarRules rules) {
	deco = "";
	if (name in rules) 
		for (r <- rules[name]) {
			deco += getLabelDecoration(name, r);
		}
	return "\n\t\t<name>Label.setStyleSheet(\"<deco>\");";
}

public str decorateWidget(str name, VarRules rules) {
	deco = "";
	if (name in rules) 
		for (r <- rules[name]) {
			deco += getWidgetDecoration(name, r);
		}
	return deco;
}




private str getLabelDecoration(str name, Rule rule:color(cname)) 
	=  "color : <replaceAll(cname, "\"", "")>;";

private str getLabelDecoration(str name, Rule rule:font(fname)) 
	=  "font : <replaceAll(fname, "\"", "")>;";
		
private str getLabelDecoration(str name, Rule rule) =  "";
				
		
private str getWidgetDecoration(str name, Rule rule:minInt(val)) 
	=  "\t\t<name>Widget.setMinimum(<val>);\n";

private str getWidgetDecoration(str name, Rule rule:maxInt(val)) 
	=  "\t\t<name>Widget.setMaximum(<val>);\n";

private str getWidgetDecoration(str name, Rule rule:stepInt(val)) 
	=  "\t\t<name>Widget.setSingleStep(<val>);\n";

private str getWidgetDecoration(str name, Rule rule:minFloat(val)) 
	=  "\t\t<name>Widget.setMinimum(<val>);\n";

private str getWidgetDecoration(str name, Rule rule:maxFloat(val)) 
	=  "\t\t<name>Widget.setMaximum(<val>);\n";

private str getWidgetDecoration(str name, Rule rule:stepFloat(val)) 
	=  "\t\t<name>Widget.setSingleStep(<val>);\n";

private str getWidgetDecoration(str name, Rule rule:minDate(val)) 
	=  "\t\t<name>Widget.setMinimumDate(<unparse(dateConst(val), ())>);\n";

private str getWidgetDecoration(str name, Rule rule:maxDate(val)) 
	=  "\t\t<name>Widget.setMaximumDate(<unparse(dateConst(val), ())>);\n";

private str getWidgetDecoration(str name, Rule rule) =  "";
