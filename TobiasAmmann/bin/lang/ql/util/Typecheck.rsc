module lang::ql::util::Typecheck

import Prelude;
import Message;
import lang::ql::ast::AST;
import lang::ql::ast::load;

data QLTable = qltable(
	map[str, TYPE] question,	
	map[str, TYPE] conditionalQst,
	set[str] labels,
	
	set[Message] messages);

anno set[Message] start[FORM]@messages;
anno loc node@location;
	
QLTable initQLTable() = qltable((),(),{},{});

public QLTable check(str x){
	ast = load(x);
	QLTable qltable = initQLTable();
	visit(ast){
		case IF i:		qltable = checkIf(qltable, i);
		case ELSEIF ei: qltable = checkElseIf(qltable, ei);
		case QUESTION q:qltable = checkQuestion(qltable, q);
		case EXPR x: 	qltable = checkExpr(qltable, x);
	}
	return qltable;
}

public TYPE typeOfExpr(QLTable qltable, EXPR exp:ident(str var)){
	if(var in qltable.question) {
		return qltable.question[var];
	}
	else if(var in qltable.conditionalQst) {
		return qltable.conditionalQst[var];
	}
	else{
		return string();
	}
}

public TYPE typeOfExpr(QLTable qltable, EXPR exp){
  switch(exp){
	case \int(int x):	return natural();
	case \bool(bool x):	return boolean();
  	case neg(EXPR x):	return natural();
  	case not(EXPR x):	return boolean();	
    case mul(EXPR l,EXPR r):	return natural();
    case div(EXPR l,EXPR r):	return decimal();
    case add(EXPR l,EXPR r):	return natural();
    case sub(EXPR l,EXPR r):	return natural();
    case lt(EXPR l,EXPR r): 	return boolean();
    case leq(EXPR l,EXPR r):	return boolean();
    case gt(EXPR l,EXPR r): 	return boolean();
    case geq(EXPR l,EXPR r): 	return boolean();
    case eq(EXPR l,EXPR r): 	return boolean();
    case neq(EXPR l,EXPR r): 	return boolean();
	case and(EXPR l,EXPR r): 	return boolean();
	case or(EXPR l,EXPR r): 	return boolean();
	}
}

public list[TYPE] typeInput(EXPR exp){
  switch(exp){
  	case neg(EXPR x):			return [natural()];
  	case not(EXPR x):			return [boolean()];	
    case mul(EXPR l,EXPR r):	return [natural(), decimal()];
    case div(EXPR l,EXPR r):	return [natural(), decimal()];
    case add(EXPR l,EXPR r):	return [natural(), decimal()];
    case sub(EXPR l,EXPR r):	return [natural(), decimal()];
    case lt(EXPR l,EXPR r): 	return [natural(), decimal(), boolean(), string(), date()];
    case leq(EXPR l,EXPR r):	return [natural(), decimal(), boolean(), string(), date()];
    case gt(EXPR l,EXPR r): 	return [natural(), decimal(), boolean(), string(), date()];
    case geq(EXPR l,EXPR r): 	return [natural(), decimal(), boolean(), string(), date()];
    case eq(EXPR l,EXPR r): 	return [natural(), decimal(), boolean(), string(), date()];
    case neq(EXPR l,EXPR r): 	return [natural(), decimal(), boolean(), string(), date()];
	case and(EXPR l,EXPR r): 	return [boolean()];
	case or(EXPR l,EXPR r): 	return [boolean()];
  }
  return [decimal()];
}

public QLTable checkExpr(QLTable qltable, EXPR x){
	if(typeOfExpr(qltable, x) == string()){
		qltable.messages += { error("identifier <x> not defined!", x@location) };
	}
	else if(x has left){
		if(typeOfExpr(qltable, x.left) notin typeInput(x)){
			qltable.messages += { error("Got <typeOfExpr(qltable, x.left)>, need <typeInput(x)>", x@location) };
		}
		if(typeOfExpr(qltable, x.right) notin typeInput(x)){
			qltable.messages += { error("Got <typeOfExpr(qltable, x.right)>, need <typeInput(x)>", x@location) };
		}
	}
	else if(x has val){
		if(typeOfExpr(qltable, x.val) notin typeInput(x)){
			qltabel.messages += { error("Got <typeOfExpr(qltable, x)>, need <typeInput(x)>", x@location) };
		}
	}
	return qltable;
}

public QLTable checkQuestion(QLTable qltable, QUESTION q:exprQuestion(str identifier, str label, TYPE qtype, EXPR expr)){
	if(qtype != typeOfExpr(qltable, expr)){
		qltable.messages += { error("Output from <expr> does not match with type <qtype>", q@location) };
	}
	qltable = checkLabel(qltable, q, label);
	
	return checkIdentifier(qltable, q, identifier, qtype);
}
//Overload
public QLTable checkQuestion(QLTable qltable, QUESTION q:question(str identifier, str label, TYPE qtype)){
	qltable = checkLabel(qltable, q, label);
	
	return checkIdentifier(qltable, q, identifier, qtype);	
}

public QLTable checkIdentifier(QLTable qltable, node N, str identifier, TYPE qtype){
	if(identifier in qltable.conditionalQst || identifier in qltable.question){
		qltable.messages += { error("Identifier <identifier> already exists", N@location) };
	}
	else qltable.conditionalQst += (identifier : qtype);

	return qltable;
}

public QLTable checkLabel(QLTable qltable, node N, str label){
	if(label in qltable.labels){
		qltable.messages += { warning("Warning, label \"<label>\" already exist", N@location)};
	}
	qltable.labels += { label };
	return qltable;
}

public QLTable checkIf(QLTable qltable, IF ifStat){
	if(typeOfExpr(qltable, ifStat.expression) != boolean()){
		qltable.messages += { error("Statement <ifStat.expression> cannot be evaluated because it is not of type boolean", ifStat@location)};
	}
	return qltable;
}

public QLTable checkElseIf(QLTable qltable, ELSEIF elseIfStat){
	if(typeOfExpr(qltable, elseIfStat.expression) != boolean()){
		qltable.messages += { error( "Statement <elseIfStat.expression> cannot be evaluated because it is not of type boolean", elseIfStat@location)};
	}
	return qltable;
}