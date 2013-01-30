module lang::qls::gen::Declare

import lang::ql::ast::AST;
import lang::qls::ast::AST;
import lang::qls::util::Environment;


public str declareStyledWidget(str name, Type t:string(_), VarRules rules) 
  = "\tQLineEdit <name>Widget = new QLineEdit();\n";

public str declareStyledWidget(str name, Type t:float(_), VarRules rules) 
  = "\tQDoubleSpinBox <name>Widget = new QDoubleSpinBox();\n";

public str declareStyledWidget(str name, Type t:date(_), VarRules rules) 
  = "\tQDateEdit <name>Widget = new QDateEdit();\n";

public str declareStyledWidget(str name, Type t:\int(_), VarRules rules) 
  = "\tQSpinBox <name>Widget = new QSpinBox();\n";
  
public str declareStyledWidget(str name, Type t:\bool(_), VarRules rules) 
  = "\tQCheckBox <name>Widget = new QCheckBox();\n";

/*
public str declareStyledWidget(str name, Type t:\bool(_), StyleEnvironment env) 
  = declareStyledWidget(name, t, env, "CheckBox");
  
public str declareStyledWidget(str name, Type t:\int(_), StyleEnvironment env) 
  = declareStyledWidget(name, t, env, "SpinBox");
  
private str declareStyledWidget(str name, Type t, StyleEnvironment env, str defaultWidget) {
	widgetType = defaultWidget;
	if (name in env.varRules)
		for (r <- env.varRules[name], widget(\type) := r)
			widgetType = \type.name;		
	else if (t in env.typeRules)
		for (r <- env.typeRules[t], widget(\type) := r)
			widgetType = \type.name;			
	return "\tQ<widgetType> <name>Widget = new Q<widgetType>();\n";
}


public str declareStyledWidget(str name, Type t:\int(_), StyleEnvironment env) {
	widgetType = "SpinBox";
	if (name in env.varRules)
		for (r <- env.varRules[name], widget(\type) := r)
			widgetType = \type;		
	else if (t in env.typeRules)
		for (r <- env.typeRules[t], widget(\type) := r)
			widgetType = \type;			
	return "\tQ<widgetType> <name>Widget = new Q<widgetType>();\n";
}
*/