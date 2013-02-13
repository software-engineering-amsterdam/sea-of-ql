tree grammar QLTreeWalker;

options{
tokenVocab = QL;
ASTLabelType=CommonTree; 
}

@header
{
package org.uva.sea.ql.parser.antlr;
import java.util.Map; 
import java.util.HashMap; 
import org.uva.sea.ql.ast.nodes.values.*;
import org.uva.sea.ql.ast.nodes.*;
import org.uva.sea.ql.ast.type.*;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.stat.*;
import org.uva.sea.ql.questionnaire.Questionnaire;
import org.uva.sea.ql.ast.expr.ASTNode;
}

@members{
  public Map<Ident,Type> typeEnv = null; 
	  
	  public QLTreeWalker(CommonTreeNodeStream nodes, Map<Ident,Type> typeEnv) { 
	  super(nodes); 
	  this.typeEnv = typeEnv;
	    
	  } 
}

walk returns [Questionnaire root]
	:  ^(FormId blockItem*) {$root = new Questionnaire("KOMM SCHON") ;};
	
blockItem returns [Stat stat]
	:(questionAssignment 
	| constantAssignment 
	| ifBlock ) ; 
	

questionAssignment returns [Stat stat]
	: ^(ASSIGNMENT ^(IDENT Ident) ^(ASSIGNMENT_TYPE identType) ^(QUESTION_LABEL  String)  (^(ASSIGNMENT_EXPRESSION expression))?)
		//{$stat = new AnswerableStat($Ident.text,$String.text);}
	 ;


constantAssignment returns [Stat stat]
	: ^(ASSIGNMENT ^(IDENT Ident ) ^(ASSIGNMENT_TYPE identType) ^(ASSIGNMENT_EXPRESSION  expression))
	;
	 

identType returns [Type t]
	:  BooleanType {$t = new BoolType();} 
	|  MoneyType  {$t = new MoneyType();}
	;	

ifBlock returns [Stat stat]
	: ^(IF_STATEMENT  ^(IF_CONDITION expression )  ^(IF_BLOCK_TRUE blockItem*) (^(IF_BLOCK_FALSE blockItem+))?) 
	;
	
//TODO ELSE IF!?	
ifStatementBlock returns [Stat	block]
	: 	 blockItem* {$block = $blockItem.stat;}
	;

elseBlock returns [Stat block]
	:  blockItem* {$block = $blockItem.stat;}
	;
	
expression returns [Expr node]
  : 
     ^(Or lhs=expression rhs=expression) {$node = new Or(lhs,rhs);}
  |  ^(And lhs=expression rhs=expression)  {$node = new And(lhs,rhs);}
  |  ^(Equ lhs=expression rhs=expression) {$node = new Eq(lhs,rhs);}
  |  ^(NotEqu lhs=expression rhs=expression) {$node = new NEq(lhs,rhs);}
  |  ^(GTEqu lhs=expression rhs=expression) {$node = new GEq(lhs,rhs);}
  |  ^(LTEqu lhs=expression rhs=expression) {$node = new LEq(lhs,rhs);}
  |  ^(GT lhs=expression rhs=expression) {$node = new GT(lhs,rhs);}
  |  ^(LT lhs=expression rhs=expression) {$node = new LT(lhs,rhs);}
  |  ^(Add lhs=expression rhs=expression) {$node = new Add(lhs,rhs);}
  |  ^(Sub lhs=expression rhs=expression) {$node = new Sub(lhs,rhs);}
  |  ^(Mul lhs=expression rhs=expression) {$node = new Mul(lhs,rhs);}
  |  ^(Div lhs=expression rhs=expression) {$node = new Div(lhs,rhs);}
  |  ^(UNARY_MINUS ex=expression) {$node = new Neg(ex);}
  |  ^(UNARY_NEGATE ex=expression) {$node = new Not(ex);}
  |  Int  {$node = new Int(Integer.parseInt($Int.text));}
  |  Ident {$node = new Ident($Ident.text);}
 // |  BooleanType {$node = new BoolType();}
  //|  MoneyType {$node = new MoneyType();}
  ;
		 
