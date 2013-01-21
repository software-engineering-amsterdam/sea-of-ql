grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.type.*;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.expr.value.*;
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}

primary returns [Expr result]
    : Bool    { $result = new org.uva.sea.ql.ast.expr.value.Bool(Boolean.parseBoolean($Bool.text)); }
    | Int     { $result = new org.uva.sea.ql.ast.expr.value.Int(Integer.parseInt($Int.text)); }
    | strExpr { $result = $strExpr.result; }
    | Ident   { $result = new Ident($Ident.text); }
    | '(' x=orExpr ')'{ $result = $x.result; }
    ;
    
strExpr returns [org.uva.sea.ql.ast.expr.value.Str result]
    : Str   { $result = new org.uva.sea.ql.ast.expr.value.Str($Str.text.substring(1, $Str.text.length() - 1)); }
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

form returns [Form result]
    : 'form' Ident '{' formElements '}' { 
        $result = new Form(new Ident($Ident.text), $formElements.result); 
      }
    ;
    
formElements returns [FormElement result]
    @init {
        ArrayList<FormElement> formElements = new ArrayList<FormElement>();
    }
    @after {
        if(formElements.isEmpty())
            result = new NullFormElement();
        else if(formElements.size() == 1)
            result = formElements.get(0);
        else
            result = new CompositeFormElement(formElements);
    }
    : (formElement { formElements.add($formElement.result); })*
    ;
    
formElement returns [FormElement result]
    : ifFormElement { $result = $ifFormElement.result; }
    | questionFormElement { $result = $questionFormElement.result; }
    | computedFormElement { $result = $computedFormElement.result; }
    ;
    
questionFormElement returns [Question result]
    : strExpr Ident ':' typeDeclaration { 
        $result = new Question($strExpr.result.getValue(), new Ident($Ident.text), $typeDeclaration.result); }
    ;

Type: 'string'|'boolean'|'integer'; 
typeDeclaration returns [Type result]
    : Type {
        if($Type.text.equals("boolean"))
          $result = new org.uva.sea.ql.ast.type.Bool();
        else if($Type.text.equals("integer"))
          $result = new org.uva.sea.ql.ast.type.Int();
        else if($Type.text.equals("string"))
          $result = new org.uva.sea.ql.ast.type.Str();
      }
    ;

computedFormElement returns [Computed result]
    : strExpr orExpr { $result = new Computed($strExpr.result.getValue(), $orExpr.result); }
    ;
   
ifFormElement returns [If result]
    : 'if' '(' orExpr ')' '{' ifElements = formElements '}' 'else' elseElement = ifFormElement 
        { $result = new If($orExpr.result, $ifElements.result, $elseElement.result); }
    | 'if' '(' orExpr ')' '{' ifElements = formElements '}' 'else' '{' elseElements = formElements'}' 
        { $result = new If($orExpr.result, $ifElements.result, $elseElements.result); }
    | 'if' '(' orExpr ')' '{' formElements '}' 
        { $result = new If($orExpr.result, $formElements.result, new NullFormElement()); }
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

Str: '\"' ('\\"'|~'\"')* '\"';

Ident:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

Int: ('0'..'9')+;