module util::Parse

import syntax::ConcreteSyntax;
import ParseTree;
import Prelude;

public start[Expression] parseExpression(str src, loc l) = parse(#start[Expression], src, l);

public start[Statement] parse(str src, loc l) = parse(#start[Statement], src, l);

public start[Question] parseQuestion(str src,loc l) = parse(#start[Question], src, l);

public start[Type] parseType(str src, loc l) = parse(#start[Type], src, l);