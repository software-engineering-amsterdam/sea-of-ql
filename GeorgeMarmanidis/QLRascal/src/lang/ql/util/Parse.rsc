module lang::ql::util::Parse

import lang::ql::syntax::QL;
import ParseTree;

//public start[Expr] parse(str src, loc l) = parse(#start[Expr], src, l);
//public start[ConditionalStatement] parse(str src, loc l) = parse(#start[ConditionalStatement], src, l);
public start[Question] parse(str src, loc l) = parse(#start[Question], src, l);
//public start[Type] parse(str src, loc l) = parse(#start[Type], src, l);
//public start[Form] parse(str src, loc l) = parse(#start[Form], src, l);