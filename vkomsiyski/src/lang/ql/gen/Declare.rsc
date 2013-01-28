module lang::ql::gen::Declare

import lang::ql::ast::AST;
import lang::ql::util::Environment;

public str declareLabel(str name, str label) 
  = "\tQLabel <name>Label = new QLabel(<label>);\n";

public str declareWidget(str name, Type t:\bool(_)) 
  = "\tQCheckBox <name>Widget = new QCheckBox();\n";

public str declareWidget(str name, Type t:\int(_)) 
  = "\tQSpinBox <name>Widget = new QSpinBox();\n";

public str declareWidget(str name, Type t:string(_)) 
  = "\tQLineEdit <name>Widget = new QLineEdit();\n";

public str declareWidget(str name, Type t:float(_)) 
  = "\tQDoubleSpinBox <name>Widget = new QDoubleSpinBox();\n";

public str declareWidget(str name, Type t:date(_)) 
  = "\tQDateEdit <name>Widget = new QDateEdit();\n";

