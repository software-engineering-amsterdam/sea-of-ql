module lang::ql::experiments::cheker

import lang::ql::ast::load;
import lang::ql::ast::AST;
import lang::ql::syntax::Syntax;

data QLtable = qltable(
	map[str, type, bool] question,	//identifier, type, computedquestion=true, noncomputedquestion=false 
	map[str, list[str]] questionDependency, //questions which depend on a question ident-ident
	set[Message] messages);


public QLtable check(str x){
	ast = loadE(x);
	str Q = "";
	visit(ast){
	case form(str id, list[STATEMENT] statements): checkForm(id, statements);
//	case statement(QUESTION question): return q;
	case conditional1(IF ifStat, list[ELSEIF] elseIfStat, ELSE elseStat):checkElseIF(ifStat, elseIfStat, elseStat);
	case conditional2(IF ifStat, list[ELSEIF] elseIfStat): checkIf(ifStat, elseIfStat);
	case exprQuestion(str id, str qst, TYPE t, EXPR expr): checkEQuest(id, t, expr);
	case question(str id, str qst, TYPE t):checkQuest(id, qst);
	}
	return Q;
}

QLtable checkForm(str id, list[STATEMENT] statements){
}

QLtable checkElseIF(ifStat(EXPR exp,list[STATEMENT] stat), list[ELSEIF] elseIfStat, ELSE elseStat){

}

QLtable checkIF(IF ifStat, list[ELSEIF] elseIfStat){
}

QLtable checkEQuest(str id, TYPE t, EXPR expr){
}

QLtable checkQuest(str id, TYPE t){
}
str readableTypes(set[Type] types) = intercalate(" or ", [tp | tp <- types]);

QLtable checkExpr(Expr e, set[Type] req, QLtable qltable) {
	Type outType = typeOfExpr(e);
	
	if (resultType notin req) {
		qltable.messages += error("Required <readableTypes(req)>, got <outType>",e@location);
	}
	else if (e has val) {
		env = checkUnaryExpr(e, qltable);
	}
	else if ((e has left) && (e has right)) {
		env = checkBinaryExpr(e, qltable);
	}
}
public str pretty(intType()) = "int";