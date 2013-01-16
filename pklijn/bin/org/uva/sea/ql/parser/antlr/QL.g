grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.form.*;
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}

form returns [Form result]
@init { List<FormItem> formItems = new ArrayList(); }
  : 'form' Ident '{'
    formItem {formItems.addAll($formItem.result);}
    '}' { $result = new Form($Ident.text,formItems); }
  ;


formItem returns [List<FormItem> result]
@init { List<FormItem> formItems = new ArrayList(); }
  : (i=ifStatement { formItems.add($i.result); } | q=question { formItems.add($q.result); })+ { $result = formItems; }
//  : (i=ifStatement { $result = $i.result; } | q=question{ $result = $q.result; })+
//  : (i=ifStatement { formItems.add($i.result); } | q=question{formItems.add($q.result); })+ { $result = formItems; }
  ;
 
ifStatement returns [IfStatement result]
//  @init { List<FormItem> formItems = new ArrayList(); }
//  : 'if' '(' Ident ')' '{' (formItem { formItems.add($formItem.result); })+ '}' { $result = new IfStatement($Ident,formItems); }
  : 'if' '(' Ident ')' '{' formItem '}' { $result = new IfStatement($Ident.text,$formItem.result); }
  ;

question returns [Question result]
  : Ident ':' String {$result = new Question($Ident.text, $String.text);}
  ;

//formItem returns [List<formItem> result]
//@init { List<formItem> formItems = new ArrayList(); }
//  : (
//      question {formItems.add($question.result); }
//      | 'if' '(' Ident ')' '{' frmItm=formItem '}' {formItems.addAll($frmItm.result);}
//      )+ { $result = formItems; }
//  ;

//questionType
//  : 'boolean'
//  ;

primary returns [Expr result]
  : Int   { $result = new Int(Integer.parseInt($Int.text)); }
  | Ident { $result = new Ident($Ident.text); }
  | '(' x=orExpr ')'{ $result = $x.result; }
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
      if ($op.text.equals("<=")) {
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

    
// Tokens
WS  :	(' ' | '\t' | '\n' | '\r') { $channel=HIDDEN; }
    ;

COMMENT 
     : '/*' .* '*/' {$channel=HIDDEN;}
    ;

Ident:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

Int: ('0'..'9')+;

String: '"' .* '"';