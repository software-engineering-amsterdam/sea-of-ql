grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}

primary returns [Expr result]
    : Bool    { $result = new Bool(Boolean.parseBoolean($Bool.text)); }
    | Int     { $result = new Int(Integer.parseInt($Int.text)); }
    | strExpr { $result = $strExpr.result; }
    | Ident   { $result = new Ident($Ident.text); }
    | '(' x=orExpr ')'{ $result = $x.result; }
    ;
    
strExpr returns [Str result]
    : Str   { $result = new Str($Str.text.substring(1, $Str.text.length() - 1)); }
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

form returns [Form result]
    : 'form' Ident '{' formElements '}' { 
        $result = new Form(new Ident($Ident.text), $formElements.result); 
      }
    ;
    
formElements returns [List<FormElement> result]
    @init {
        result = new ArrayList<FormElement>();
    }
    : (formElement { result.add($formElement.result); })*
    ;
    
formElement returns [FormElement result]
    : questionFormElement { $result = $questionFormElement.result; }
    | ifFormElement { $result = $ifFormElement.result; }
    | computedFormElement { $result = $computedFormElement.result; }
    ;
    
questionFormElement returns [Question result]
    : strExpr Ident ':' Type { $result = new Question($strExpr.result.getValue(), new Ident($Ident.text), $Type.text); }
    ;

computedFormElement returns [Computed result]
    : strExpr orExpr { $result = new Computed($strExpr.result.getValue(), $orExpr.result); }
    ;
    
ifFormElement returns [If result]
    : 'if' '(' orExpr ')' '{' ifElements = formElements '}' 'else' elseElement = ifFormElement 
        { $result = new If($orExpr.result, $formElements.result, java.util.Arrays.asList((FormElement)$elseElement.result)); }
    | 'if' '(' orExpr ')' '{' ifElements = formElements '}' 'else' '{' elseElements = formElements'}' 
        { $result = new If($orExpr.result, $ifElements.result, $elseElements.result); }
    | 'if' '(' orExpr ')' '{' formElements '}' 
        { $result = new If($orExpr.result, $formElements.result, new ArrayList<FormElement>()); }
    ;
    
// Tokens
WS  :	(' ' | '\t' | '\n' | '\r') { $channel=HIDDEN; }
    ;

COMMENT
    : '/*' .* '*/' {$channel=HIDDEN;}
    | '//' ~NewLine* {$channel=HIDDEN;}
    ;

NewLine: '\n' | '\r\n';

Bool: 'true'|'false';

Type: 'string'|'boolean'|'integer';

Str: '\"' ('\\"'|~'\"')* '\"';

Ident:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

Int: ('0'..'9')+;