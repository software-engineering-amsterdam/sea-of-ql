module lang::qls::compiler::PrettyPrinter

import lang::qls::ast::AST;

public str prettyPrint(Stylesheet s) =
  "<for(e <- s.statements) {><prettyPrint(e)>
  '<}>";

public str prettyPrint(Statement s: 
  classDefinition(str ident, list[ClassRule] questionIdent)) = 
    "class <ident> {<for(e <- questionIdent) {>
    '  <prettyPrint(e)><}>
    '}
    '";

public str prettyPrint(Statement s: 
  styleDefinition(Ident: typeIdent(ident), list[StyleRule] styleRules)) = 
    "<ident> {<for(e <- styleRules) {>
    '  <prettyPrint(e)><}>
    '}
    '";

public str prettyPrint(Statement s: 
  styleDefinition(Ident: classIdent(ident), list[StyleRule] styleRules)) = 
    "<ident> {<for(e <- styleRules) {>
    '  <prettyPrint(e)><}>
    '}
    '";

public str prettyPrint(Statement s: 
  styleDefinition(Ident: questionIdent(ident), list[StyleRule] styleRules)) = 
    "<ident> {<for(e <- styleRules) {>
    '  <prettyPrint(e)><}>
    '}
    '";

public str prettyPrint(ClassRule r: 
  classRule(str ident)) =
    "<ident>";

public str prettyPrint(StyleRule r: 
  typeStyleRule(str attr, TypeStyleValue \value: radio())) =
    "<attr> radio";

public str prettyPrint(StyleRule r: 
  typeStyleRule(str attr, TypeStyleValue \value: checkbox())) =
    "<attr> checkbox";

public str prettyPrint(StyleRule r: 
  widthStyleRule(str attr, int \value)) =
    "<attr> <\value>";

