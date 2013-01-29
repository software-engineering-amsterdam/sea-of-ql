module lang::qls::util::Parse

import lang::qls::syntax::QLS;
import ParseTree;

public start[FormStyle] parseQLS(str src, loc l) = parse(#start[FormStyle], src, l);

// needed for tests
//public Expr parseExpr(str src) = parse(#Expr, src);

//public Statement parseStatement(str src) = parse(#Statement, src);