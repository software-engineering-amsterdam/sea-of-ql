grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.type.*;
import org.uva.sea.ql.ast.statement.*;
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}

primary returns [Expr result] 
    : Int   { $result = new Int(Integer.parseInt($Int.text)); }
    | Ident { $result = new Ident($Ident.text); }
    | BOOL  { $result = new Bool(Boolean.parseBoolean($BOOL.text)); }
    | String{ $result = new StringNode($String.text); }
    | '(' x=orExpr ')'{ $result = $x.result; }
    ;
    
unExpr returns [Expr result] 
    : '+' x=unExpr { $result = new Pos($x.result); }
    | '-' x=unExpr { $result = new Neg($x.result); }
    | '!' x=unExpr { $result = new Not($x.result); }
    | x=primary    { $result = $x.result; }
    ;    
    
mulExpr returns [Expr result] 
    : lhs=unExpr { $result=$lhs.result; } ( op=( '*' | '/' ) rhs=unExpr 
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
    : lhs=mulExpr { $result=$lhs.result; } ( op=('+' | '-') rhs=mulExpr
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
    : lhs=addExpr { $result=$lhs.result; } ( op=('<'|'<='|'>'|'>='|'=='|'!=') rhs=addExpr 
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
    : lhs=relExpr { $result=$lhs.result; } ( '&&' rhs=relExpr { $result = new And($result, rhs); } )*
    ;
    

orExpr returns [Expr result] 
    : lhs=andExpr { $result = $lhs.result; } ( '||' rhs=andExpr { $result = new Or($result, rhs); } )*
    ;

form returns [Statement result] 
      @init { List<Statement> formParts = new ArrayList<Statement>();}
    : 'form' Ident '{' (formPart {formParts.add($formPart.result);})+ '}' { $result = new Form(new Ident($Ident.text), formParts);}
    ;
    
formPart returns [Statement result]
    : question {$result = $question.result;}
    | ifThenStatement {$result = $ifThenStatement.result;}
    | ifStatement {$result = $ifStatement.result;}
    ;
    
ifStatement returns[Statement result]
      @init { List<Statement> formParts = new ArrayList<Statement>();}
    : 'if' '(' orExpr ')' '{' (formPart {formParts.add($formPart.result);})+ '}' {$result = new If($orExpr.result, formParts);}
    ;
    
ifThenStatement returns [Statement result]
      @init { List<Statement> ifFormParts = new ArrayList<Statement>();
              List<Statement> elseFormParts = new ArrayList<Statement>();}
    : 'if' '(' orExpr ')' '{' (f1=formPart {ifFormParts.add($f1.result);})+ '}' 'else' '{' (f2=formPart {elseFormParts.add($f2.result);})+ '}'
      {$result = new IfThenElse($orExpr.result, ifFormParts, elseFormParts);}  
    ;
  
question returns [Question result] 
    : Ident ':' String returnType '(' orExpr ')' {$result = new ComputedQuestion(new Ident($Ident.text), $String.text, $returnType.result, $orExpr.result);}
    | Ident ':' String returnType {$result = new Question(new Ident($Ident.text), $String.text, $returnType.result);}
    ;
    
returnType returns [Type result] //TODO String ,boolen met or expressie, orexpr hoort bij de question. 
    : 'boolean' { $result = new BoolType(); }
    | 'money' {$result = new Money();} 
    | 'string'{$result = new StringType();}
    ;
    
BOOL	
    : ('true' | 'false')
    ;    

WS 
    :	(' ' | '\t' | '\n' | '\r') { $channel=HIDDEN; }
    ;

COMMENT 
    : ( '/*' .* '*/' | '//' .* '\n') {$channel=HIDDEN;}
    ;

String  
    : ('"' .* '"') 
    ;

Ident
    : ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

Int 
    : ('0'..'9')+
    ;