module lang::ql::util::Message

import Message;


public Message undeclaredError(str name, loc location) 
  = error("Undeclared variable: <name>", location);  

public Message redeclaredError(str name, loc location) 
  = error("Variable <name> redeclared with different type", location);
    
public Message redeclaredError(loc location) 
  = error("Expression occurs with different type", location);    
    
public Message typeError(str typename, loc location) 
  = error("Type mismatch: <typename> required", location);
  
public Message duplicateLabel(loc location) 
  = warning("Duplicate label", location);