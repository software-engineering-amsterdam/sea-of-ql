module util::Priorities

// Courtesy of CWI-SWAT:
// https://github.com/cwi-swat/oberon0/blob/master/
// src/ldta/oberon0/util/Priorities.rsc 

import Grammar;
import Node;
import lang::rascal::grammar::definition::Priorities;
import IO;
import List;

public &T parens(DoNotNest prios, node parent, node kid, &T x,  &T(&T x) parenizer) = parenizer(x)
  when 
     <pprod, pos, kprod> <- prios,
     pprod.def has name,
     kprod.def has name, 
     pprod.def.name == getName(parent), 
     kprod.def.name == getName(kid),
     parent[astPosition(pos, pprod)] == kid;

private int astPosition(int pos, Production p)
  = ( -1 | it + 1 | i <- [0,1..pos], isASTsymbol(p.symbols[i]) );

public bool isASTsymbol(\layouts(_)) = false; 
public bool isASTsymbol(\keywords(str name)) = false;
public bool isASTsymbol(\lit(str string)) = false;
public bool isASTsymbol(\cilit(str string)) = false;
//public bool isASTsymbol(\conditional(_, _)) = false;
public bool isASTsymbol(\empty()) = false;
public default bool isASTsymbol(Symbol _) = true;

public default &T parens(DoNotNest prios, node parent, node kid, &T x,  &T(&T x) parenizer) = x;
