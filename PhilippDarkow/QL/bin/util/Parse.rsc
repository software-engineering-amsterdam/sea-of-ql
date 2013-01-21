module util::Parse

import syntax::ConcreteSyntax;
import ParseTree;
import Prelude;

public start[Expression] parseExpression(str src, loc l) = parse(#start[Expression], src, l);

public start[Statement] parse(str src, loc l) = parse(#start[Statement], src, l);

public start[Question] parseQuestion(str src) = parse(#start[Question], src, |file:///test.q|);

public start[Type] parseType(str src, loc l) = parse(#start[Type], src, l);