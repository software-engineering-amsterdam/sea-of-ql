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
	import org.uva.sea.ql.ast.IfNode;
	import org.uva.sea.ql.ast.BlockNode;
	import org.uva.sea.ql.ast.AssignmentNode;
	import org.uva.sea.ql.ast.VariableScope;
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

@members
{
    VariableScope currentScope = new VariableScope();
}

walk
    :   form
    ;   
   
form
	:	^(FORM Identifier ^(BLOCK block))
	;

block returns [Node node]
@init
{
    final BlockNode blockNode = new BlockNode();
    $node = blockNode;
    final VariableScope scope = new VariableScope(this.currentScope);
    currentScope = scope;
}
@after
{
    currentScope = currentScope.getParent();
}
    :   (statement { blockNode.addStatement($statement.node); })*
    ;

statement returns [Node node]
	:	ifStatement { $node = $ifStatement.node; }
		| assignmentStatement { $node = $assignmentStatement.node; }
	;

ifStatement returns [Node node]
@init
{
    final IfNode ifNode = new IfNode();
    $node = ifNode;
}
	:   ^(IF
	        (^(EXPRESSION expression ^(BLOCK b1=block)) { ifNode.addBranch($expression.node, $b1.node); })+
	        (^(EXPRESSION ^(BLOCK b2=block)) { ifNode.addBranch(new BooleanNode("true"), $b2.node); })?
	     )
	;

assignmentStatement returns [Node node]
	:	^(ASSIGNMENT Identifier type) { $node = new AssignmentNode($Identifier.text, $type.node, currentScope); }
	;

type returns [Node node]
// TODO check with immutable value object
	:	'boolean' {$node = new BooleanNode("false"); }
		| 'integer' {$node = new IntegerNode(0); }
		| 'string' {$node = new StringNode("");}
		| 'money' {$node = new MoneyNode("0");}
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
    