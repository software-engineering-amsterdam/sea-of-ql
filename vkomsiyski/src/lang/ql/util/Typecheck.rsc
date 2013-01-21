module lang::ql::util::Typecheck

import lang::ql::ast::AST;

alias VarMap = map[str name, str \type];

public bool expected(str t, Expr expr:ident(name), VarMap vars) 
  = ((t == vars[name]) || (t == "float" && vars[name] == "int"));

public bool expected(str t, Expr expr:\int(_), VarMap vars) 
  = ((t == "int") || (t == "float"));
  
public bool expected(str t, Expr expr:\bool(_), VarMap vars) 
  = (t == "bool");

public bool expected(str t, Expr expr:string(_), VarMap vars) 
  = (t == "string");

public bool expected(str t, Expr expr:float(_), VarMap vars) 
  = (t == "float");

public bool expected(str t, Expr expr:date(_), VarMap vars) 
  = (t == "date");

public bool expected(str t, Expr expr:pos(e), VarMap vars) 
  = ((t == "int" || t == "float") && expected(t, e, vars)); 

public bool expected(str t, Expr expr:neg(e), VarMap vars) 
  = ((t == "int" || t == "float") && expected(t, e, vars)); 

public bool expected(str t, Expr expr:not(e), VarMap vars) 
  = (t == "bool" && expected(t, e, vars));
  
public bool expected(str t, Expr expr:and(e1, e2), VarMap vars) 
  = (t == "bool" && expected(t, e1, vars) && expected(t, e2, vars));		
  
public bool expected(str t, Expr expr:or(e1, e2), VarMap vars) 
  = (t == "bool" && expected(t, e1, vars) && expected(t, e2, vars));
  
public bool expected(str t, Expr expr:mul(e1, e2), VarMap vars) 
  = ((t == "int" && expected(t, e1, vars) && expected(t, e2, vars)) ||
			 	     (t == "float" && (expected(t, e1, vars) || expected("int", e1, vars)) &&
								      (expected(t, e2, vars) || expected("int", e2, vars))));
								      
public bool expected(str t, Expr expr:div(e1, e2), VarMap vars) 
  = ((t == "int" && expected(t, e1, vars) && expected(t, e2, vars)) ||
			 	     (t == "float" && (expected(t, e1, vars) || expected("int", e1, vars)) &&
								      (expected(t, e2, vars) || expected("int", e2, vars))));
								      
public bool expected(str t, Expr expr:add(e1, e2), VarMap vars) 
  = (((t == "int" || t == "string") && expected(t, e1, vars) && expected(t, e2, vars)) ||
			 	     (t == "float" && (expected(t, e1, vars) || expected("int", e1, vars)) &&
								      (expected(t, e2, vars) || expected("int", e2, vars))));
  
public bool expected(str t, Expr expr:sub(e1, e2), VarMap vars) 
  = ((t == "int" && expected(t, e1, vars) && expected(t, e2, vars)) ||
			 	     (t == "float" && (expected(t, e1, vars) || expected("int", e1, vars)) &&
								      (expected(t, e2, vars) || expected("int", e2, vars))));
								      
public bool expected(str t, Expr expr:lt(e1, e2), VarMap vars) 
  = (t == "bool" && (((expected("float", e1, vars) || expected("int", e1, vars)) &&
								      (expected("float", e2, vars) || expected("int", e2, vars))) ||
								     (expected("date", e1, vars) && expected("date", e2, vars)))); 	
								     
public bool expected(str t, Expr expr:leq(e1, e2), VarMap vars) 
  = (t == "bool" && (((expected("float", e1, vars) || expected("int", e1, vars)) &&
								      (expected("float", e2, vars) || expected("int", e2, vars))) ||
								     (expected("date", e1, vars) && expected("date", e2, vars)))); 	
								     
public bool expected(str t, Expr expr:gt(e1, e2), VarMap vars) 
  = (t == "bool" && (((expected("float", e1, vars) || expected("int", e1, vars)) &&
								      (expected("float", e2, vars) || expected("int", e2, vars))) ||
								     (expected("date", e1, vars) && expected("date", e2, vars)))); 	
								     
public bool expected(str t, Expr expr:geq(e1, e2), VarMap vars) 
  = (t == "bool" && (((expected("float", e1, vars) || expected("int", e1, vars)) &&
								      (expected("float", e2, vars) || expected("int", e2, vars))) ||
								     (expected("date", e1, vars) && expected("date", e2, vars)))); 	
								     
public bool expected(str t, Expr expr:eq(e1, e2), VarMap vars) 
  = (t == "bool" && (((expected("float", e1, vars) || expected("int", e1, vars)) &&
								      (expected("float", e2, vars) || expected("int", e2, vars))) ||
								     (expected("date", e1, vars) && expected("date", e2, vars)) ||
								     (expected("string", e1, vars) && expected("string", e2, vars))));
								     
public bool expected(str t, Expr expr:neq(e1, e2), VarMap vars) 
  = (t == "bool" && (((expected("float", e1, vars) || expected("int", e1, vars)) &&
								      (expected("float", e2, vars) || expected("int", e2, vars))) ||
								     (expected("date", e1, vars) && expected("date", e2, vars)) ||
								     (expected("string", e1, vars) && expected("string", e2, vars))));
		
