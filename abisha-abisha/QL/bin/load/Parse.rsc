module load::Parse

import syntax::ConcreteSyntax;
import ParseTree;
import Prelude;

public start[Expression] parseExpression(str src, loc l) = parse(#start[Expression], src, l);

public start[Statement] parseStatement(str src, loc l) = parse(#start[Statement], src, l);

public start[Question] parseQuestion(str src,loc l) = parse(#start[Question], src, l);

public start[Type] parseType(str src, loc l) = parse(#start[Type], src, l);

public start[Program] parseProgram(str src, loc l) = parse(#start[Program], src, l);

