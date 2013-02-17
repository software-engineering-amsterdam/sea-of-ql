module lang::ql::ast::ExprInspector

import lang::ql::ast::AST;

public set[str] getAllIndentifiersInExpr(Expr e) {
	set[str] identifiers = {};
	
	visit (e) { 
		case ident(str name): identifiers += name;  
	}
	
	return identifiers;
}