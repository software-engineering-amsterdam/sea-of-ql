@contributor{George Marmanidis -geo.marmani@gmail.com}
module lang::ql::ast::AST

import List;

data Form
	= form(str ident,list[FormBodyItem] formItem)
	;
	
data FormBodyItem
	= question(Question itemQuestion)
	| conditionalStatement(ConditionalStatement itemCondStatement)
	;
	
data ConditionalStatement
	= ifCond(Expr ifCondition,list[FormBodyItem] ifQuestion,list[FormBodyItem] elseQuestion)
	| simpleIfCond(Expr ifCondition,list[FormBodyItem] ifQuestion)
	| ifElseIfCond(Expr ifCondition,list[FormBodyItem] ifQuestion,list[ElseIf] elseifBranch,list[FormBodyItem] elseQuestion)
	;
	
data ElseIf = elseif(Expr ifExpression,list[FormBodyItem] elseQuestion);

data Question
	= simpleQuestion(str questionId,str questionLabel,Type questionType)
	| computedQuestion(str questionId, str questionLabel, Type questionType, Expr questionComputation) 
	;

data Expr
  = ident(str name)
  | \int(int ivalue) 
  | string(str strValue) 
  | boolean(str bValue) 
  | date(str dValue) 
  | money (str monValue)
  | float (real fValue) 
  
  | add(Expr addLeft, Expr addRight)
  | mul(Expr multLeft, Expr multright)
  | div(Expr divLeft, Expr divRight)
  | sub(Expr subLeft, Expr subRight)
  
  | pos(Expr posValue)
  | neg(Expr negValue)
  | not(Expr notValue)
  
  | lt(Expr ltLeft, Expr ltRight)
  | leq(Expr leqLeft, Expr leqRight)
  | gt(Expr gtLeft, Expr gtRight)
  | geq(Expr getLeft, Expr getRight)
  | eq(Expr eqLeft, Expr eqRight)
  | neq(Expr neqLeft, Expr neqRight)
  
  | and(Expr andLeft, Expr andRight)
  | or(Expr orLeft, Expr orRight)
  ;
  
data Type
	= boolean()
	| integer()
	| string()
	| money()
	| date()
	| float()
	;
	
anno loc Expr@location;
anno loc Question@location;
anno loc Type@location;
anno loc Form@location;
anno loc ConditionalStatement@location;
anno loc ElseIf@location;