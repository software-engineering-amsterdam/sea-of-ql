grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.literals.*;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.statements.*;
import org.uva.sea.ql.ast.operators.*;
import java.util.LinkedList;
}
 
@members {
    private List<String> errors = new LinkedList<String>();
    public void displayRecognitionError(String[] tokenNames,
                                        RecognitionException e) {
        String hdr = getErrorHeader(e);
        String msg = getErrorMessage(e, tokenNames);
        errors.add(hdr + " " + msg);
    }
    public List<String> getErrors() {
        return errors;
    }
    public int getErrorCount() {
        return errors.size() ;
    }
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}

qlprogram returns [QLProgram result]
    : 'form' Ident  cb=compoundStatement { $result = new QLProgram($Ident, cb) ; } 
    ;

compoundStatement returns [Statement result]
  @init { CompoundStatement compoundStatement = new CompoundStatement() ; }
    : LBRACE 
      (st=statement  { compoundStatement.addStatement($st.result) ; } )* 
      RBRACE    { $result = compoundStatement ; }
    ;    

statement returns [Statement result]     
    : Ident COLON StringLiteral type ('(' x=orExpr ')')? 
          { $result = new LineStatement(new Ident($Ident),$StringLiteral,$type.result,x); }
    | 'if' '(' ex=orExpr ')' ctrue=compoundStatement ('else' cfalse=compoundStatement)? 
          { $result = new ConditionalStatement(ex,ctrue,cfalse) ; }
    |  cst=compoundStatement { $result = cst ;}  
    ;

type returns [Type result]
    : 'boolean' { $result = new BooleanType() ;}
    | 'string'  { $result = new StringType() ;}
    | 'money'   { $result = new MoneyType() ;}
    | 'integer' { $result = new IntegerType() ;}
    ; 

primary returns [Expr result] 
  : IntegerLiteral      { $result = new IntegerLiteral($IntegerLiteral.text); }
  | MoneyLiteral        { $result = new MoneyLiteral($MoneyLiteral.text); }
  | BooleanLiteral      { $result = new BooleanLiteral($BooleanLiteral.text) ;}
  | StringLiteral       { $result = new StringLiteral($StringLiteral.text) ;}
  | Ident               { $result = new Ident($Ident); }
  | '(' x=orExpr ')'    { $result = $x.result; }
  ;
    
unExpr returns [Expr result]
    :  '+' x=unExpr { $result = new Pos($x.result); }
    |  '-' x=unExpr { $result = new Neg($x.result); }
    |  '!' x=unExpr { $result = new Not($x.result); }
    |  x=primary    { $result = $x.result; }
    ;    
    
mulExpr returns [Expr result]
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
    
addExpr returns [Expr result]
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
  
relExpr returns [Expr result]
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
    
andExpr returns [Expr result]
    :   lhs=relExpr { $result=$lhs.result; } ( '&&' rhs=relExpr { $result = new And($result, rhs); } )*
    ;
    
orExpr returns [Expr result]
    :   lhs=andExpr { $result = $lhs.result; } ( '||' rhs=andExpr { $result = new Or($result, rhs); } )*
    ;
    
// Lexer Tokens
WS  :	(' ' | '\t' | '\n' | '\r') { $channel=HIDDEN; }
    ;

// Get string with quotes removed
StringLiteral : '"' ~('\n' | '\r' | '\f' | '"')* '"'  {setText(getText().substring(1, getText().length()-1));} ;

COLON  : ':' ;
LBRACE : '{' ;
RBRACE : '}' ;

COMMENT 
    : '/*' .* '*/'    {$channel=HIDDEN;}
    | '//' ( ~'\n' )* {$channel=HIDDEN;}
    ;

BooleanLiteral
    : 'true'| 'false' | 'TRUE' | 'FALSE'
    ;
        
Ident:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

IntegerLiteral: ('0'..'9')+;

MoneyLiteral: ('0'..'9')+ ('.' ('0'..'9')+) ;

