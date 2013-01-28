module lang::ql::syntax::AbstractSyntax

data Form = form(str formName, list[Statement] statement);

data Statement 
	= statement(Question question)
	| ifStat(Expr expression, list[Stamenent] statement)
	| elseIfStat(Expr expression, list[Statement] statement)
	| elseStat(list[Statement] statement)
;

data Question 
	= question(str Id, str name, Type type)
	| exprQuestion(str Id, str name, Type type, Expr expression)
;

data Type
	= natural()
	| string()
	| boolean()
	| decimal()
	| date()
;

data Expr
	= ident	(str name)
	| \int	(int integer)
	| \bool	(bool boolean)
	| date 	(str date)
  	| neg	(Expr value)
  	| not	(Expr value)	
    | mul	(Expr left, Expr right)
    | div	(Expr left, Expr right)
    | add	(Expr left, Expr right)
    | sub	(Expr left, Expr right)
    | lt 	(Expr left, Expr right)
    | leq	(Expr left, Expr right)
    | gt 	(Expr left, Expr right)
    | geq 	(Expr left, Expr right)
    | eq 	(Expr left, Expr right)
    | neq 	(Expr left, Expr right)
	| and 	(Expr left, Expr right)
	| or 	(Expr left, Expr right)
;

anno loc Form@location;                   
anno loc Statement@location;
anno loc Question@location;
anno loc Type@location;
anno loc Expr@location;