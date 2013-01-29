module lang::qls::util::Message

import Message;


public Message undeclaredError(str name, loc location) 
  = error("Unknown variable: <name>", location);  

public Message redeclaredError(str name, loc location) 
  = error("A rule for <name> already exists", location);
    
public Message duplicateGroupError(str name, loc location) 
  = error("Group <name> already exists", location);    
    
public Message typeError(str typename, loc location) 
  = error("This rule is undefined for variables of type <typename>", location);
  