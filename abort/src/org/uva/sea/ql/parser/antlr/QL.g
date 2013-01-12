grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.parser.antlr.types.*;
import org.uva.sea.ql.parser.antlr.operators.*;
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}

// TODO: comment out = successful tests
@lexer::members {
  @Override
  public void reportError(RecognitionException e) {
    throw new RuntimeException(e.getMessage()); 
  }
}

// TODO: comment out = successful tests
@parser::members {
  @Override
  public void reportError(RecognitionException e) {
    throw new RuntimeException(e.getMessage()); 
  }
}
// Change the start symbol of the parser to parse forms, instead of Expressions.

primary returns [Expression result]
  : Int   { $result = new Int(Integer.parseInt($Int.text)); }
  | Money { $result = new Money($Money.text); }
  | Bool { $result = new Bool(Boolean.parseBoolean($Bool.text)); }
  | Ident { $result = new Ident($Ident.text); }
  | String { $result = new StringLiteral($String.text.substring(1, $String.text.length() - 1)); }
  | '(' x=orExpression ')'{ $result = $x.result; }
  | ifExpression { $result = $ifExpression.result; }
  ;
        
//    | '(' Bool ')' { $result = new If($x.result); };

ifExpression returns [If result]
    : 'if' '(' statement=orExpression ')' '{' successStatements=orExpression '}'
    {
      $result = new If($statement.result, $successStatements.result);
    };  
    
    
unExpression returns [Expression result]
    :  '+' x=unExpression { $result = new Pos($x.result); }
    |  '-' x=unExpression { $result = new Neg($x.result); }
    |  '!' x=unExpression { $result = new Not($x.result); }
    |  x=primary    { $result = $x.result; }
    ;    
    
mulExpression returns [Expression result]
    :   lhs=unExpression { $result=$lhs.result; } ( op=( '*' | '/' ) rhs=unExpression 
    { 
      if ($op.text.equals("*")) {
        $result = new Mul($result, rhs);
      }
      if ($op.text.equals("<=")) {
        $result = new Div($result, rhs);      
      }
    })*
    ;
    
  
addExpression returns [Expression result]
    :   lhs=mulExpression { $result=$lhs.result; } ( op=('+' | '-') rhs=mulExpression
    { 
      if ($op.text.equals("+")) {
        $result = new Add($result, rhs);
      }
      if ($op.text.equals("-")) {
        $result = new Sub($result, rhs);      
      }
    })*
    ;
  
relExpression returns [Expression result]
    :   lhs=addExpression { $result=$lhs.result; } ( op=('<'|'<='|'>'|'>='|'=='|'!=') rhs=addExpression 
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
    
andExpression returns [Expression result]
    :   lhs=relExpression { $result=$lhs.result; } ( '&&' rhs=relExpression { $result = new And($result, rhs); } )*
    ;
    

orExpression returns [Expression result]
    :   lhs=andExpression { $result = $lhs.result; } ( '||' rhs=andExpression { $result = new Or($result, rhs); } )*
    ;


// Tokens
COMMENT 
     : '/*' .* '*/' { $channel=HIDDEN; }  // multi line
     | '//' ~('\n'|'\r')* { $channel=HIDDEN; } // single line
;

WS  :	(' ' | '\t' | '\n' | '\r') { $channel=HIDDEN; }
    ;

/*IF: 'if \(';
THEN: '\) then';
ENDIF: 'endif';
*/
Bool: ('TRUE' | 'FALSE' | 'true' | 'false');

Type: 'string' | 'integer' | 'boolean' | 'money';

Ident:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

Int: ('0'..'9')+;

Money: ('0'..'9')+ ('.' ('0'..'9')+)?;

//String: '"'~('"');


String: '"' (EscapedCharacterSequence | ~('\\' | '"'))* '"';
fragment
EscapedCharacterSequence: '\\' ('\"' | '\\')
;