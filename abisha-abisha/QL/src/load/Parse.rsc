module load::Parse


import syntax::Concrete;
import ParseTree;
import Prelude;


public start[Expression] parseExpression(str src, loc l) = parse(#start[Expression], src, l);
public start[Expression] parseExpression(str src) = parse(#Expr, src);

public start[Statement] parseStatement(str src, loc l) = parse(#start[Statement], src, l);
public start[Statement] parseStatement(str src) = parse(#Statement, src);

public start[ElseIf] parseElseIf(str src, loc l) = parse(#ElseIf, src, l);
public start[ElseIf] parseElseIf(str src) = parse(#ElseIf, src);

public start[Question] parseQuestion(str src,loc l) = parse(#start[Question], src, l);
public start[Question] parseQuestion(str src) = parse(#Question, src);

public start[Type] parseType(str src, loc l) = parse(#start[Type], src, l);
public start[Type] parseType(str src) = parse(#Type, src);

public start[Form] parseForm(str src, loc l) = parse(#start[Form], src, l);
public start[Form] parseForm(str src) = parse(#start[Form], src);


