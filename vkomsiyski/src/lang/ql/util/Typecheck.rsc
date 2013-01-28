module lang::ql::util::Typecheck

import lang::ql::ast::AST;
import lang::ql::util::Environment;


public bool expected(Type t, Expr e:ident(name), Declarations d) 
  = name in d && ((t == d[name].\type) || (t == float("float") && d[name].\type == \int("int")));

public bool expected(Type t, Expr expr:\intConst(_), Declarations d) 
  = (t == \int("int")) || (t == float("float"));
  
public bool expected(Type t, Expr expr:\boolConst(_), Declarations d) 
  = (t == \bool("bool"));

public bool expected(Type t, Expr expr:stringConst(_), Declarations d) 
  = (t == string("string"));

public bool expected(Type t, Expr expr:floatConst(_), Declarations d) 
  = (t == float("float"));

public bool expected(Type t, Expr expr:dateConst(_), Declarations d) 
  = (t == date("date"));

public bool expected(Type t, Expr expr:pos(e), Declarations d) 
  = ((t == \int("int")|| t == float("float")) && expected(t, e, d)); 

public bool expected(Type t, Expr expr:neg(e), Declarations d) 
  = ((t == \int("int") || t == float("float")) && expected(t, e, d)); 

public bool expected(Type t, Expr expr:not(e), Declarations d) 
  = (t == \bool("bool") && expected(t, e, d));
  
public bool expected(Type t, Expr expr:and(e1, e2), Declarations d) 
  = (t == \bool("bool") && expected(t, e1, d) && expected(t, e2, d));		
  
public bool expected(Type t, Expr expr:or(e1, e2), Declarations d) 
  = (t == \bool("bool") && expected(t, e1, d) && expected(t, e2, d));
  
public bool expected(Type t, Expr expr:mul(e1, e2), Declarations d) 
  = ((t == \int("int") && expected(t, e1, d) && expected(t, e2, d)) ||
	 (t == float("float") && (expected(t, e1, d) || expected(\int("int"), e1, d)) &&
							 (expected(t, e2, d) || expected(\int("int"), e2, d))));
								      
public bool expected(Type t, Expr expr:div(e1, e2), Declarations d) 
  = ((t == \int("int") && expected(t, e1, d) && expected(t, e2, d)) ||
	 (t == float("float") && (expected(t, e1, d) || expected(\int("int"), e1, d)) &&
							 (expected(t, e2, d) || expected(\int("int"), e2, d))));
								      
public bool expected(Type t, Expr expr:add(e1, e2), Declarations d) 
  = (((t == \int("int") || t == string("string")) && expected(t, e1, d) && expected(t, e2, d)) ||
	 (t == float("float") && (expected(t, e1, d) || expected(\int("int"), e1, d)) &&
						     (expected(t, e2, d) || expected(\int("int"), e2, d))));
  
public bool expected(Type t, Expr expr:sub(e1, e2), Declarations d) 
  = ((t == \int("int") && expected(t, e1, d) && expected(t, e2, d)) ||
	 (t == float("float") && (expected(t, e1, d) || expected(\int("int"), e1, d)) &&
							 (expected(t, e2, d) || expected(\int("int"), e2, d))));
							 								      
public bool expected(Type t, Expr expr:lt(e1, e2), Declarations d) 
  = (t == \bool("bool") && (((expected(float("float"), e1, d) || expected(\int("int"), e1, d)) &&
							 (expected(float("float"), e2, d) || expected(\int("int"), e2, d))) ||
						    (expected(date("date"), e1, d) && expected(date("date"), e2, d)))); 	
								     
public bool expected(Type t, Expr expr:leq(e1, e2), Declarations d) 
  = (t == \bool("bool") && (((expected(float("float"), e1, d) || expected(\int("int"), e1, d)) &&
							 (expected(float("float"), e2, d) || expected(\int("int"), e2, d))) ||
						    (expected(date("date"), e1, d) && expected(date("date"), e2, d))));
						   								     
public bool expected(Type t, Expr expr:gt(e1, e2), Declarations d) 
  = (t == \bool("bool") && (((expected(float("float"), e1, d) || expected(\int("int"), e1, d)) &&
							 (expected(float("float"), e2, d) || expected(\int("int"), e2, d))) ||
						    (expected(date("date"), e1, d) && expected(date("date"), e2, d))));
									     
public bool expected(Type t, Expr expr:geq(e1, e2), Declarations d) 
  = (t == \bool("bool") && (((expected(float("float"), e1, d) || expected(\int("int"), e1, d)) &&
							 (expected(float("float"), e2, d) || expected(\int("int"), e2, d))) ||
						    (expected(date("date"), e1, d) && expected(date("date"), e2, d))));
	
public bool expected(Type t, Expr expr:eq(e1, e2), Declarations d) 
  = (t == \bool("bool") && (((expected(float("float"), e1, d) || expected(\int("int"), e1, d)) &&
						     (expected(float("float"), e2, d) || expected(\int("int"), e2, d))) ||
							(expected(date("date"), e1, d) && expected(date("date"), e2, d)) ||
							(expected(string("string"), e1, d) && expected(string("string"), e2, d))));
								     
public bool expected(Type t, Expr expr:neq(e1, e2), Declarations d) 
  = (t == \bool("bool") && (((expected(float("float"), e1, d) || expected(\int("int"), e1, d)) &&
						     (expected(float("float"), e2, d) || expected(\int("int"), e2, d))) ||
							(expected(date("date"), e1, d) && expected(date("date"), e2, d)) ||
							(expected(string("string"), e1, d) && expected(string("string"), e2, d))));
