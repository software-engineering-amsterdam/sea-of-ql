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
	= ifCond(Expr ifCondition,list[Question] ifQuestion,list[Question] elseQuestion)
	| simpleIfCond(Expr ifCondition,list[Question] ifQuestion)
	| ifElseIfCond(Expr ifCondition,list[Question] ifQuestion,list[ElseIf] elseifBranch,list[Question] elseQuestion)
	;
	
data ElseIf = elseif(Expr ifExpression,list[Question] elseQuestion);

data Question//needs more tests
	= simpleQuestion(str questionId,str questionLabel,Type questionType)
	| computedQuestion(str questionId, str questionLabel, Type questionType, Expr questionComputation) 
	;

//data WhitespaceOrComment 


//data Expr
data Expr
  = ident(str name)
  | \int(int ivalue) 
  | \string (str strValue) //works needs more tests
  | boolean (str bValue) 
  | date(str dValue) // works..needs to set the days and month numbers correclty
  | money (real monValue)//works but problem with 1,22 two decimal digits
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