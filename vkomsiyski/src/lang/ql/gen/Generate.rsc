module lang::ql::gen::Generate

import lang::ql::ast::AST;
import lang::ql::gen::Generic;
import lang::ql::gen::Declare;
import lang::ql::gen::Widgets;
import lang::ql::util::Environment;


public str generate(Form input) {
	env = getEnvironment(input);
	widgets = getWidgets(input, env.declarations);
	
	src = "";
	src += header();
	src += imports();
	src += declarations();
	src += addDeclarations(env);
	src += main();
	src += constructor();
	src += addTitle(input.name);
	src += addWidgets(widgets);
	src += gridLayout();
	src += visibility();
	src += addVisibility(widgets);
	src += slots();
	src += addSubmit(widgets, env.declarations);
	src += submit();

	return src;
}

private str addDeclarations(Environment env) {
	src = "";
	for (name <- env.declarations) {
		src += declareLabel(name, env.declarations[name].label);
		src += declareWidget(name, env.declarations[name].\type);
	}
	return src;
}

private str addWidgets(list[Widget] widgets) {
	src = "";
	for (widget <- widgets)
		src += addWidget(widget);
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
 