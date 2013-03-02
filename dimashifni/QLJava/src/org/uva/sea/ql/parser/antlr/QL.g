grammar QL;
options 
{
backtrack=true; 
memoize=true;
output=AST;
ASTLabelType= CommonTree;
}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.ast.statement.*;
import org.uva.sea.ql.type.*;
import org.uva.sea.ql.value.*;
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}

form
: 'form'! Ident^ '{'! block '}'!
;

block returns [Block node]
@init
{
    Block block = new Block();
    $node = block;
}
: (statement {block.addStatement($statement.statement);})*
;

statement returns [Statement statement]
: ifStatement {$statement = $ifStatement.node;}
| assignment {$statement = $assignment.node;}
;

// TODO check Bart's IfNode
ifStatement returns [IfStatement node]
@init
{
    IfStatement ifStatement = new IfStatement();
    $node = ifStatement;
}
: 'if'^ orExpression '{'! block ifBlock=block '}'!
  {
    ifStatement.addOrExpression($orExpression.result);
    ifStatement.addIfBlock($ifBlock.node);
  }
  ('else'^ '{'! block elseBlock=block '}'! { ifStatement.addElseBlock($elseBlock.node);}
  )?
;

assignment returns [Assignment node]
: Ident ':'^ StringLiteral type { $node = new Assignment(new Ident($Ident.text), $StringLiteral.text, $type.type); }
;

//TODO check and test code snippet
type returns [Type type]
: 'integer' {$type = new IntType();}
| 'boolean' {$type = new BoolType();}
| 'string'  {$type = new StringType();}
| 'money'   {$type = new NumericType();}
;

primary returns [Expr result]
: Int           { $result = new Int(Integer.parseInt($Int.text)); }
| Money         { $result = new Money(Double.parseDouble($Money.text)); }
| Bool          { $result = new Bool(Boolean.parseBoolean($Bool.text)); }
| StringLiteral { $result = new StringLiteral($StringLiteral.text); }
| Ident         { $result = new Ident($Ident.text); }
| '('! x=orExpression ')'! { $result = $x.result; }
;
    
unaryExpression returns [Expr result]
: '+'^ x=unaryExpression { $result = new Pos($x.result); }
| '-'^ x=unaryExpression { $result = new Neg($x.result); }
| '!'^ x=unaryExpression { $result = new Not($x.result); }
| y=primary { $result = $y.result; }
;
   
multiplyExpression returns [Expr result]
: lhs=unaryExpression { $result=$lhs.result; }
  (('*'^ rhs=unaryExpression {$result = new Mul($result, $rhs.result);}
  | '/'^ rhs=unaryExpression {$result = new Div($result, $rhs.result);})
  )*
;

addExpression returns [Expr result]
: lhs=multiplyExpression { $result=$lhs.result; }
  (('+'^ rhs=multiplyExpression { $result = new Add($result, $rhs.result); }
  | '-'^ rhs=multiplyExpression {$result = new Sub($result, $rhs.result); }))*
;
  
relExpression returns [Expr result]
: lhs=addExpression { $result=$lhs.result; }
  (('<'^ rhs=addExpression {$result = new LT($result, $rhs.result);}
  |'<='^ rhs=addExpression {$result = new LEq($result, $rhs.result);}
  |'>'^  rhs=addExpression {$result = new GT($result, $rhs.result);}
  |'>='^ rhs=addExpression {$result = new GEq($result, $rhs.result);}
  |'=='^ rhs=addExpression {$result = new Eq($result, $rhs.result);}
  |'!='^ rhs=addExpression {$result = new NEq($result, $rhs.result);}))*
;
    
andExpression returns [Expr result]
: lhs=relExpression { $result=$lhs.result; } ( '&&'^ rhs=relExpression { $result = new And($result, $rhs.result); } )*
;

orExpression returns [Expr result]
: lhs=andExpression { $result = $lhs.result; } ( '||'^ rhs=andExpression { $result = new Or($result, $rhs.result); } )*
;
    
// Tokens
WS  
: (' ' | '\t' | '\n' | '\r' | '\f')+ { $channel=HIDDEN; }
;

Comment 
: '/*' .* '*/' {$channel=HIDDEN;}
;
    
StringLiteral: '"' 
			{ StringBuilder stringBuilder = new StringBuilder(); } 
			(
				'"' '"'  {stringBuilder.appendCodePoint('"');} 
				|
				c=~('"'| '\r' | '\n')  {stringBuilder.appendCodePoint(c);}
			)* 
			'"'
			{setText(stringBuilder.toString());} 
			;

Bool
: 'true'
| 'false'
;
			    
Ident: ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

Int: ('0'..'9')+;

Money: Int '.' Int;