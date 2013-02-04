module lang::ql::util::Parse

import lang::ql::syntax::QL;
import ParseTree;

public start[Form] parseQL(str src, loc l) = parse(#start[Form], src, l);

// needed for tests
public Expr parseExpr(str src) = parse(#Expr, src);

public Statement parseStatement(str src) = parse(#Statement, src);
