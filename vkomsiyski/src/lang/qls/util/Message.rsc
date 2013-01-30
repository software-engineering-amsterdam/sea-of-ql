module lang::qls::util::Message

import Message;


public Message undeclaredError(str name, loc location) 
  = error("Unknown variable: <name>", location);  

public Message redeclaredError(str name, loc location) 
  = error("A rule for <name> already exists", location);
    
public Message duplicateGroupError(str name, loc location) 
  = error("Group <name> already exists", location);    

public Message inGroupError(str name, loc location) 
  = error("Variable <name> is already in a group", location);
    
public Message typeError(str typename, loc location) 
  = error("This rule is undefined for variables of type <typename>", location);
  
public Message ruleError(loc location)
  = error("This rule is already defined", location);

  