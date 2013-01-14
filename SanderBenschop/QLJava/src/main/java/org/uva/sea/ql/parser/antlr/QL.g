grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.nodetypes.primary.*;
import org.uva.sea.ql.ast.nodetypes.unary.*;
import org.uva.sea.ql.ast.nodetypes.binary.*;
import org.uva.sea.ql.ast.nodetypes.conditional.*;
import org.uva.sea.ql.ast.nodetypes.formelements.*;
}

@parser::members 
{
  private String removeOuterQuotes(String original) {
    return original.substring(1, original.length()-1);
  }
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}
    
statementList returns [List<QLStatement> result]
  @init
  {
    $result = new ArrayList<QLStatement>();
  }
  : (stmnt=statement '\n' {result.add(stmnt);})*
  ;

statement returns [QLStatement result]
  : question
  | conditional
  ;

question returns [Question result]
  : Ident ':' Str Datatype {
                              Ident ident = new Ident($Ident.text);
                              Str label = new Str(removeOuterQuotes($Str.text));
                              Str datatype = new Str($Datatype.text);
                              $result = new Question(ident, label, datatype);
                           }
  ;
  
conditional returns [Conditional result]
  : 'if' '(' condition=orExpr ')' BRACE_OPEN success=statementList BRACE_CLOSE
    ( ('else') => 'else' BRACE_OPEN failure=statementList BRACE_CLOSE
    | ( ) //No else
    ) {
      if (failure != null) {
        $result = new Conditional(condition, success, failure);
      } else {
        $result = new Conditional(condition, success);
      }
    }
  ;

primary returns [QLExpression result]
  : Int   { $result = new Int(Integer.parseInt($Int.text)); }
  | Bool  { $result = new Bool(Boolean.parseBoolean($Bool.text)); }
  | Ident { $result = new Ident($Ident.text); }
  | Str   { $result = new Str(removeOuterQuotes($Str.text)); }
  | '(' x=orExpr ')'{ $result = $x.result; }
  ;

unExpr returns [QLExpression result]
    :  '+' x=unExpr { $result = new Pos($x.result); }
    |  '-' x=unExpr { $result = new Neg($x.result); }
    |  '!' x=unExpr { $result = new Not($x.result); }
    |  x=primary    { $result = $x.result; }
    ;    
    
mulExpr returns [QLExpression result]
    :   lhs=unExpr { $result=$lhs.result; } ( op=( '*' | '/' ) rhs=unExpr 
    { 
      if ($op.text.equals("*")) {
        $result = new Mul($result, rhs);
      }
      if ($op.text.equals("/")) {
        $result = new Div($result, rhs);      
      }
    })*
    ;
    
  
addExpr returns [QLExpression result]
    :   lhs=mulExpr { $result=$lhs.result; } ( op=('+' | '-') rhs=mulExpr
    { 
      if ($op.text.equals("+")) {
        $result = new Add($result, rhs);
      }
      if ($op.text.equals("-")) {
        $result = new Sub($result, rhs);      
      }
    })*
    ;
  
relExpr returns [QLExpression result]
    :   lhs=addExpr { $result=$lhs.result; } ( op=('<'|'<='|'>'|'>='|'=='|'!=') rhs=addExpr 
    { 
      if ($op.text.equals("<")) {
        $result = new LT($result, rhs);
      }
      if ($op.text.equals("<=")) {
        $result = new LEq($result, rhs);      
      }
      if ($op.text.equals(">")) {
        $result = new GT($result, rhs);
      }
      if ($op.text.equals(">=")) {
        $result = new GEq($result, rhs);      
      }
      if ($op.text.equals("==")) {
        $result = new Eq($result, rhs);
      }
      if ($op.text.equals("!=")) {
        $result = new NEq($result, rhs);
      }
    })*
    ;
    
andExpr returns [QLExpression result]
    :   lhs=relExpr { $result=$lhs.result; } ( '&&' rhs=relExpr { $result = new And($result, rhs); } )*
    ;
    

orExpr returns [QLExpression result]
    :   lhs=andExpr { $result = $lhs.result; } ( '||' rhs=andExpr { $result = new Or($result, rhs); } )*
    ;
    
// Tokens

BRACE_OPEN : '{';
BRACE_CLOSE : '}';

WS  :	(' ' | '\t' | '\n' | '\r') { $channel=HIDDEN; }
    ;

COMMENT 
    : '/*' .* '*/' {$channel=HIDDEN;}
    | '//' ~('\n')* {$channel=HIDDEN;} 
    ;
    
Datatype: 'boolean' | 'string' | 'int';

Bool: 'true' | 'false';
Ident:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

Str: '"' (EscapedCharacterSequence | ~('\\' | '"'))* '"';
fragment
EscapedCharacterSequence: '\\' ('\"' | '\\');

Int: ('0'..'9')+;