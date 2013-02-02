module lang::qls::gen::Generate

import lang::ql::ast::AST;
import lang::ql::gen::Declare;
import lang::ql::gen::Widgets;
import lang::ql::util::Environment;
import lang::qls::ast::AST;
import lang::qls::gen::Templates;
import lang::qls::gen::Declare;
import lang::qls::gen::Decorate;
import lang::qls::gen::Groups;
import lang::qls::util::Environment;
import lang::qls::util::QL;



public str generate(FormStyle style) {

	formQL = getForm(style.name);
	stylenv = getStyleEnvironment(style, formQL);	
	env = getEnvironment(formQL);		
	widgets = getWidgets(formQL, env.declarations);	
	
	varRules = getAllVarRules(stylenv, env.declarations);
	
	src = addHeader();
	src += addDeclarations(env.declarations, varRules);
	src += addBody1();
	src += addTitle(formQL.name);
	src += addWidgets(widgets, varRules);
	src += addBody2();
	src += addGroups(stylenv.groups);
	src += addBody3();
	src += addVisibility(widgets);
	src += addBody4();
	src += addSubmit(widgets, env.declarations);
	src += addBody5();

	return src;
}



private str addDeclarations(Declarations d, VarRules rules) {
	src = "";
	for (name <- d) {
		src += declareLabel(name, d[name].label);
		src += declareStyledWidget(name, d[name].\type, rules);
	}
	return src;
}




private str addWidgets(list[Widget] widgets, VarRules rules) {
	src = "";
	for (widget <- widgets)
		src += addWidget(widget) + 
			   decorateLabel(widget.name, rules) +
			   decorateWidget(widget.name, rules);
	return src;
}
  
private str addVisibility(list[Widget] widgets) {
	src = "";
	for (widget:<name, \type, _, val, false> <- widgets) 
		src += setValue(\type, name, val);
	for (widget <- widgets)
		src += visibilityMap(widget.name, widget.visibility);
	return src;
}
  
  
private str addSubmit(list[Widget] widgets, Declarations d) {
	src = "";
	for (widget <- widgets) 
		src += submitWidget(widget.name, d);
	return src;
}




private str addGroups(Groups groups) {
	src = "";
	for (name <- groups) 
		src += addGroup(name, groups[name]);
	return src;
}



 