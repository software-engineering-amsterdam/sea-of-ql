module lang::ql::util::Parse

import lang::ql::syntax::QL;
import ParseTree;

public start[Form] parse(str src) = parse(#start[Form], src);
public start[Form] parse(str src, loc l) = parse(#start[Form], src, l);

public Expr parseExpr(str src) = parse(#Expr, src);
public Expr parseExpr(str src, loc l) = parse(#Expr, src, l);