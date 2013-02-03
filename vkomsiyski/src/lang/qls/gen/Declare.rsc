module lang::qls::gen::Declare

import lang::ql::ast::AST;
import lang::qls::ast::AST;
import lang::qls::util::Environment;
import String;

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

