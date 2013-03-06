module lang::PrettyPrint

import lang::ql::ast::AST;


public str idGenerator(EXPR exp){
	switch(exp){
	case ident(str x):	return x;
	case \int(int x):	return "<x>";
	case \bool(bool x):	return "<x>";
  	case neg(EXPR x):	return "-(<idGenerator(x)>)";
  	case not(EXPR x):	return "!(<idGenerator(x)>)";	
    case mul(EXPR l,EXPR r):	return "<idGenerator(l)> * <idGenerator(r)>";
    case div(EXPR l,EXPR r):	return "<idGenerator(l)> / <idGenerator(r)>";
    case add(EXPR l,EXPR r):	return "(<idGenerator(l)> + <idGenerator(r)>)";
    case sub(EXPR l,EXPR r):	return "(<idGenerator(l)> - <idGenerator(r)>)";
    case lt(EXPR l,EXPR r): 	return "<idGenerator(l)> \< <idGenerator(r)>";
    case leq(EXPR l,EXPR r):	return "<idGenerator(l)> \<= <idGenerator(r)>";
    case gt(EXPR l,EXPR r): 	return "<idGenerator(l)> \> <idGenerator(r)>";
    case geq(EXPR l,EXPR r): 	return "<idGenerator(l)> \>= <idGenerator(r)>";
    case eq(EXPR l,EXPR r): 	return "<idGenerator(l)> == <idGenerator(r)>";
    case neq(EXPR l,EXPR r): 	return "<idGenerator(l)> != <idGenerator(r)>";
	case and(EXPR l,EXPR r): 	return "<idGenerator(l)> && <idGenerator(r)>";
	case or(EXPR l,EXPR r): 	return "<idGenerator(l)> || <idGenerator(r)>";
	}
}

public str typeListToValue(list[TYPE] t:[natural(), boolean(), string()]){
	return "natural- or boolean value or string";
}
public str typeListToValue(list[TYPE] t){
	return typeToString(head(t));
}
public str typeToString(TYPE t:boolean()){
	return "boolean value";
}
public str typeToString(TYPE t:natural()){
	return "natural value";
}
public str typeToString(TYPE t:string()){
	return "String";
}