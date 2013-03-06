module lang::ql::ast::AST

public data FORM = form(str formName, list[STATEMENT] statement);

public data STATEMENT
	= statement(QUESTION question)
	| conditional1(IF ifStatement, list[ELSEIF] elseIfStatement, ELSE elseStatement)
	| conditional2(IF ifStatement, list[ELSEIF] elseIfStatement)
;
public data IF
	= ifStat(EXPR expression, list[STATEMENT] statement) 
;

public data ELSEIF
	= elseIfStat(EXPR expression, list[STATEMENT] statement)
;

public data ELSE
	= elseStat(list[STATEMENT] statement)
;

public data QUESTION 
	= exprQuestion(str identifier, str label, TYPE qtype, EXPR expr)
	| question(str identifier, str label, TYPE qtype)
;

public data TYPE
	= natural()
	| string()
	| boolean()
	| decimal()
	| date()
;

public data EXPR
	= ident	(str name)
	| \int  (int integer)
	| \bool	(bool boolean)
	| string(str string)
	| date  (str date)	
  	| neg   (EXPR val)
  	| not   (EXPR val)	
    | mul	(EXPR left, EXPR right)
    | div	(EXPR left, EXPR right)
    | add	(EXPR left, EXPR right)
    | sub	(EXPR left, EXPR right)
    | lt 	(EXPR left, EXPR right)
    | leq	(EXPR left, EXPR right)
    | gt 	(EXPR left, EXPR right)
    | geq 	(EXPR left, EXPR right)
    | eq 	(EXPR left, EXPR right)
    | neq 	(EXPR left, EXPR right)
	| and 	(EXPR left, EXPR right)
	| or 	(EXPR left, EXPR right)
;
anno loc FORM@location;                   
anno loc STATEMENT@location;
anno loc QUESTION@location;
anno loc TYPE@location;
anno loc EXPR@location;
