module lang::ql::gen::Generate


import lang::ql::gen::Templates;
import lang::ql::gen::Declare;
import lang::ql::gen::Widgets;
import lang::ql::util::Environment;


public str generate(node input) {
	env = getEnvironment(input);
	widgets = getWidgets(input, env.declarations);
	
	src = header;
	src += addDeclarations(env);
	src += body1;
	src += addWidgets(widgets);
	src += body2;
	src += addVisibility(widgets);
	src += body3;

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
  
 