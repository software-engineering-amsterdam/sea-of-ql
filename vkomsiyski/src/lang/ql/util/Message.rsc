module lang::ql::util::Message

import Message;


public Message undeclaredError(str name, loc location) 
  = error("Undeclared variable: <name>", location);  

public Message redeclaredError(str name, loc location) 
  = error("Variable <name> redeclared with different type", location);
    
public Message typeError(str \type, loc location) 
  = error("Type mismatch: <\type> required", location);
  
public Message duplicateLabel(loc location) 
  = warning("Duplicate label", location);