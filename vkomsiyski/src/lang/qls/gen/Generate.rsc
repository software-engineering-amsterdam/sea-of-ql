module lang::qls::gen::Generate

import lang::ql::ast::AST;
import lang::ql::gen::Generic;
import lang::ql::gen::Declare;
import lang::ql::gen::Widgets;
import lang::ql::util::Environment;
import lang::qls::ast::AST;
import lang::qls::gen::Decorate;
import lang::qls::gen::Custom;
import lang::qls::gen::Groups;
import lang::qls::gen::Widgets;
import lang::qls::util::Environment;
import lang::qls::util::QL;


public str generate(FormStyle style) {
	formQL = getForm(style.name);
	stylenv = getStyleEnvironment(style, formQL);	
	env = getEnvironment(formQL);		
	env.declarations = decorateDeclarations(env.declarations, stylenv);
	widgets = getCustomWidgets(formQL, env.declarations);	
	widgets = decorateWidgets(widgets, stylenv);
	varRules = getAllVarRules(env.declarations, stylenv);
	
	src = "";
	src += header();
	src += imports();
	src += declarations();
	src += addDeclarations(env);
	src += main();
	src += constructor();
	src += localDeclarations();
	src += addTitle(formQL.name);
	src += addCustomWidgets(widgets, varRules);
	src += gridLayout();
	src += addGroups(stylenv.groups);
	src += visibility();
	src += addCustomVisibility(widgets);
	src += slots();
	src += addCustomSubmit(widgets, env.declarations);
	src += submit();

	return src;
}


private str addDeclarations(Environment env) {
	src = "";
	for (name <- env.declarations) {
		src += declareLabel(name, env.declarations[name].label);
		src += declareCustomWidget(name, env.declarations[name].\type@widget.name);
	}
	return src;
}

private str addCustomWidgets(list[Widget] widgets, VarRules rules) {
	src = "";
	for (widget <- widgets) {
		src += addCustomWidget(widget, widget.\type@widget);
		src += customizeLabel(widget.name, rules); 
    	src += customizeWidget(widget.name, widget.\type@widget, rules);
	}
	return src;
}

private str addGroups(Groups groups) {
	src = "";
	for (name <- groups) 
		src += addGroup(name, groups[name]);
	return src;
} 


private str addCustomVisibility(list[Widget] widgets) {
	src = "";
	for (widget:<name, \type, _, val, false> <- widgets) 
		src += setCustomValue(\type, \type@widget, name, val);
	for (widget <- widgets)
		src += visibilityMap(widget.name, widget.visibility);
	return src;
}


private str addCustomSubmit(list[Widget] widgets, Declarations d) {
	src = "";
	for (widget <- widgets) 
		src += submitCustomWidget(widget.name, d);
	return src;
}