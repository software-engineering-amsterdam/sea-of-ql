module lang::qls::util::Compatible

import lang::qls::ast::AST;

public bool compatible(Type t, Rule r:color(_)) 
  = true;

public bool compatible(Type t, Rule r:font(_)) 
  = true;

public bool compatible(Type t, Rule r:widget(_)) 
  = (t == \bool("bool") && (r.\type == checkbox("checkbox") ||
						    r.\type == combobox("combobox") ||
						    r.\type == radio("radio"))) ||
	((t == \int("int") || 
	  t == float("float")) && (r.\type == slider("slider") ||
						  	   r.\type == dial("dial") ||
						  	   r.\type == spinbox("spinbox")));

public bool compatible(Type t, Rule r:minInt(_)) 
  = (t == \int("int"));

public bool compatible(Type t, Rule r:maxInt(_)) 
  = (t == \int("int"));

public bool compatible(Type t, Rule r:stepInt(_)) 
  = (t == \int("int"));

public bool compatible(Type t, Rule r:minFloat(_)) 
  = (t == float("float"));

public bool compatible(Type t, Rule r:maxFloat(_)) 
  = (t == float("float"));

public bool compatible(Type t, Rule r:stepFloat(_)) 
  = (t == float("float"));

public bool compatible(Type t, Rule r:minDate(_)) 
  = (t == date("date"));

public bool compatible(Type t, Rule r:maxDate(_)) 
  = (t == date("date"));
