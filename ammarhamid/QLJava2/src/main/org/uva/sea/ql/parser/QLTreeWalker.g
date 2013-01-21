tree grammar QLTreeWalker;

options
{
	tokenVocab = QL;
	output = AST;
    ASTLabelType = CommonTree;
}
  
@header
{
	package org.uva.sea.ql.parser;
	import org.uva.sea.ql.ast.Node;
	import org.uva.sea.ql.ast.expression.ExprNode;
	import org.uva.sea.ql.ast.expression.impl.AddNode;
	import org.uva.sea.ql.ast.expression.impl.AndNode;
	import org.uva.sea.ql.ast.expression.impl.OrNode;
	import org.uva.sea.ql.ast.expression.impl.EqualNode;
	import org.uva.sea.ql.ast.expression.impl.NotEqualNode;
	import org.uva.sea.ql.ast.expression.impl.LessThanNode;
	import org.uva.sea.ql.ast.expression.impl.LessEqualNode;
	import org.uva.sea.ql.ast.expression.impl.GreaterThanNode;
	import org.uva.sea.ql.ast.expression.impl.GreaterEqualNode;
	import org.uva.sea.ql.ast.expression.impl.MultiplyNode;
	import org.uva.sea.ql.ast.expression.impl.DivideNode;
	import org.uva.sea.ql.ast.expression.impl.SubtractNode;
	import org.uva.sea.ql.ast.expression.impl.NotNode;
	import org.uva.sea.ql.ast.expression.impl.NegateNode;
	import org.uva.sea.ql.ast.expression.impl.IdentifierNode;
	import org.uva.sea.ql.ast.value.ValueNode;
	import org.uva.sea.ql.ast.value.impl.IntegerNode;
	import org.uva.sea.ql.ast.value.impl.BooleanNode;
	import org.uva.sea.ql.ast.value.impl.MoneyNode;
	import org.uva.sea.ql.ast.value.impl.StringNode;
}

walk
    :   form
    ;   
   
form
	:	^(FORM Identifier ^(STATEMENTS statementBlock*))
	;

statementBlock
	:	ifStatement
		| assignmentStatement
	;

ifStatement
	:   ^(IF
	        (^(EXPRESSION expression ^(STATEMENTS statementBlock+)))+
	        (^(EXPRESSION ^(STATEMENTS statementBlock+)))
	     )
	;

assignmentStatement
	:	^(ASSIGNMENT Identifier type)
	;

type
	:	'boolean'
		| 'integer'
		| 'string'
		| 'money'
	;

expression returns [ExprNode node]
    :   ^('&&' lhs=expression rhs=expression) {$node = new AndNode($lhs.node, $rhs.node);}
    |   ^('||' lhs=expression rhs=expression) {$node = new OrNode($lhs.node, $rhs.node);}
    |   ^('==' lhs=expression rhs=expression) {$node = new EqualNode($lhs.node, $rhs.node);}
    |   ^('!=' lhs=expression rhs=expression) {$node = new NotEqualNode($lhs.node, $rhs.node);}
    |   ^('<' lhs=expression rhs=expression) {$node = new LessThanNode($lhs.node, $rhs.node);}
    |   ^('<=' lhs=expression rhs=expression) {$node = new LessEqualNode($lhs.node, $rhs.node);}
    |   ^('>=' lhs=expression rhs=expression) {$node = new GreaterEqualNode($lhs.node, $rhs.node);}
    |   ^('>' lhs=expression rhs=expression) {$node = new GreaterThanNode($lhs.node, $rhs.node);}
    |   ^('+' lhs=expression rhs=expression) {$node = new AddNode($lhs.node, $rhs.node);}
    |   ^('-' lhs=expression rhs=expression) {$node = new SubtractNode($lhs.node, $rhs.node);}
    |   ^('*' lhs=expression rhs=expression) {$node = new MultiplyNode($lhs.node, $rhs.node);}
    |   ^('/' lhs=expression rhs=expression) {$node = new DivideNode($lhs.node, $rhs.node);}
    |   ^(NOT op=expression) {$node = new NotNode($op.node);}
    |   ^(NEGATION op=expression) {$node = new NegateNode($op.node);}
    |   Boolean  {$node = new BooleanNode($Boolean.text);}
    |   Integer {$node = new IntegerNode($Integer.text);}
    |   Money {$node = new MoneyNode($Money.text);}
    |   StringLiteral {$node = new StringNode($StringLiteral.text);}
    |   Identifier {$node = new IdentifierNode($Identifier.text);}
    ;
    