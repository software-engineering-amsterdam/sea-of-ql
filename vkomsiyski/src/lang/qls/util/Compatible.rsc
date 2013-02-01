module lang::qls::util::Compatible

import lang::qls::ast::AST;

public bool compatible(Type t, Rule r:color(_)) 
  = true;

public bool compatible(Type t, Rule r:font(_)) 
  = true;

public bool compatible(Type t, Rule r:widget(_)) 
  = (\bool(_) := t && (checkbox(_) := r.\type ||
					   combobox(_) := r.\type ||
					   radio(_) := r.\type)) ||
	(\int(_) := t && (slider(_) := r.\type ||
					  dial(_) := r.\type ||
					  spinbox(_) := r.\type));

public bool compatible(Type t, Rule r:minInt(_)) 
  = (\int(_) := t);

public bool compatible(Type t, Rule r:maxInt(_)) 
  = (\int(_) := t);

public bool compatible(Type t, Rule r:stepInt(_)) 
  = (\int(_) := t);

public bool compatible(Type t, Rule r:minFloat(_)) 
  = (float(_) := t);

public bool compatible(Type t, Rule r:maxFloat(_)) 
  = (float(_) := t);

public bool compatible(Type t, Rule r:stepFloat(_)) 
  = (float(_) := t);

public bool compatible(Type t, Rule r:minDate(_)) 
  = (date(_) := t);

public bool compatible(Type t, Rule r:maxDate(_)) 
  = (date(_) := t);
