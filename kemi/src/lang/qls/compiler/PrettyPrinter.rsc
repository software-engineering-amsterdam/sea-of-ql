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
  typeStyleDefinition(str ident, list[StyleRule] styleRules)) = 
    "<ident> {<for(e <- styleRules) {>
    '  <prettyPrint(e)><}>
    '}
    '";

public str prettyPrint(Statement s: 
  classStyleDefinition(str ident, list[StyleRule] styleRules)) = 
    "<ident> {<for(e <- styleRules) {>
    '  <prettyPrint(e)><}>
    '}
    '";

public str prettyPrint(Statement s: 
  identStyleDefinition(str ident, list[StyleRule] styleRules)) = 
    "<ident> {<for(e <- styleRules) {>
    '  <prettyPrint(e)><}>
    '}
    '";

public str prettyPrint(ClassRule r: 
  classRule(str ident)) =
    "<ident>";

public str prettyPrint(StyleRule r: 
  styleRule(str attr, StyleAttrValue \value)) =
    "<attr> <prettyPrint(\value)>";

public str prettyPrint(StyleAttrValue v: 
  styleAttrValue(str \value)) =
    "<\value>";
