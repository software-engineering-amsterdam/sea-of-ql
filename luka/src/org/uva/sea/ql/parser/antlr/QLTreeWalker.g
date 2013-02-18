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
import org.antlr.runtime.debug.DebugEventListener;
}


@members{
 
	 public QLTreeWalker(CommonTreeNodeStream nodes) { 
	 super(nodes,new RecognizerSharedState()); 
	  } 
	 
}




walk returns [Questionnaire root]
@init{
Block statBlock = new Block();
}
@after{
root = new Questionnaire($formName.text,statBlock);
}
	:  ^(formName=Ident {System.out.println("Start walking");}
	^(BLOCK (blockItem {statBlock.addStatement($blockItem.stat);})*)) 
	{System.out.println("End walking");}
	;
	
blockItem returns [Stat stat]
	:(questionDeclaration {stat = $questionDeclaration.stat; }
	| variableDeclaration  {stat = $variableDeclaration.stat; }
	| ifBlock  {stat = $ifBlock.stat; } ) ; 
	

questionDeclaration returns [Stat stat]
	: ^(ASSIGNMENT ^(IDENT Ident) ^(ASSIGNMENT_TYPE identType) ^(QUESTION_LABEL  Str) 
	{stat = new AnswerableStat(new Ident($Ident.text),$Str.text,$identType.type);}
	//Computed question:
	  (^(ASSIGNMENT_EXPRESSION expression) 
	  {stat = new VisibleComputetStat(new Ident($Ident.text),$Str.text,$expression.result,$identType.type);} )?) 
		
	 ;


variableDeclaration returns [Stat stat]
	: ^(ASSIGNMENT ^(IDENT Ident ) ^(ASSIGNMENT_TYPE identType) ^(ASSIGNMENT_EXPRESSION  expression))
	{stat = new HiddenComputetStat(new Ident($Ident.text),$expression.result,$identType.type);} 
	;
	 

ifBlock returns [Stat stat]
@init{
Block ifBl = new Block();
Block elseBl = new Block();
}
	: ^(IF_STATEMENT  ^(IF_CONDITION expression ) ^(IF_BLOCK_TRUE ^(BLOCK (ifBlockItems=blockItem {ifBl. addStatement($ifBlockItems.stat);})*)) {$stat = new IfThenStat($expression.result,ifBl);}
	(^(IF_BLOCK_FALSE ^(BLOCK (elseBlockItems=blockItem {elseBl.addStatement($elseBlockItems.stat);})*)) {$stat = new IfThenElseStat($expression.result,ifBl,elseBl);} )?) 
	;
	
	
identType returns [Type type]
	:  BooleanType {$type = new BoolType();} 
	|  MoneyType  {$type = new MoneyType();}
	| IntegerType {$type = new IntType();} 
	| StringType {$type = new StringType();} 
	| DoubleType {$type = new DoubleType();}
	;	

expression returns [Expr result]
  : 
     (^(Or lhs=expression {$result = $lhs.result;} rhs=expression {$result = new Or($result,rhs);}) 
     | ^(And lhs=expression {$result = $lhs.result;} rhs=expression {$result = new And($result,rhs);}) 
     | ^(Equ lhs=expression {$result = $lhs.result;} rhs=expression {$result = new Eq($result,rhs);}) 
     | ^(NotEqu lhs=expression {$result = $lhs.result;} rhs=expression {$result = new NEq($result,rhs);}) 
     | ^(GTEqu lhs=expression {$result = $lhs.result;} rhs=expression {$result = new GEq($result,rhs);}) 
     | ^(LTEqu lhs=expression {$result = $lhs.result;} rhs=expression {$result = new LEq($result,rhs);}) 
     | ^(GT lhs=expression {$result = $lhs.result;} rhs=expression {$result = new GT($result,rhs);}) 
     | ^(LT lhs=expression {$result = $lhs.result;} rhs=expression {$result = new LT($result,rhs);}) 
     | ^(Add lhs=expression {$result = $lhs.result;} rhs=expression {$result = new Add($result,rhs);}) 
     | ^(Sub lhs=expression {$result = $lhs.result;} rhs=expression {$result = new Sub($result,rhs);}) 
     | ^(Mul lhs=expression {$result = $lhs.result;} rhs=expression {$result = new Mul($result,rhs);}) 
     | ^(Div lhs=expression {$result = $lhs.result;} rhs=expression {$result = new Div($result,rhs);}) 
     | ^(UNARY_MINUS ex=expression {$result = new Neg($ex.result);} ) 
     | ^(UNARY_NEGATE ex=expression {$result = new Not($ex.result);}) 
     | Ident {$result = new Ident($Ident.text);}
     | Int  {$result = new Int(Integer.parseInt($Int.text));} 
     | Doub  {$result = new Doub(Double.parseDouble($Doub.text));} 
     | Str {$result = new Str($Str.text);} 
    
     )
  ;
		 
