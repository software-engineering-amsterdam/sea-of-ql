module load::Parse

import syntax::Concrete;
import ParseTree;
import Prelude;


public start[Expression] parseExpression(str src, loc l) = parse(#start[Expression], src, l);

public start[Statement] parseStatement(str src, loc l) = parse(#start[Statement], src, l);

public start[Question] parseQuestion(str src,loc l) = parse(#start[Question], src, l);

public start[Type] parseType(str src, loc l) = parse(#start[Type], src, l);

public start[Form] parseForm(str src, loc l) = parse(#start[Form], src, l);

public start[Form] parseForm(str src, loc l) = parse(#start[Form], src, l);
