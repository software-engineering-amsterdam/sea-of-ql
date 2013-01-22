module lang::qls::compiler::PrettyPrinter

import lang::qls::ast::AST;

public str prettyPrint(Stylesheet s) =
  "<for(e <- s.statements) {><prettyPrint(e)>
  '<}>";

public str prettyPrint(Statement s: 
  classDefinition(str ident, set[ClassRule] questionStyleIdent)) = 
    "class <ident> {<for(e <- questionStyleIdent) {>
    '  <prettyPrint(e)><}>
    '}
    '";

public str prettyPrint(Statement s: 
  styleDefinition(StyleIdent: typeStyleIdent(ident), set[StyleRule] styleRules)) = 
    "<ident> {<for(e <- styleRules) {>
    '  <prettyPrint(e)><}>
    '}
    '";

public str prettyPrint(Statement s: 
  styleDefinition(StyleIdent: classStyleIdent(ident), set[StyleRule] styleRules)) = 
    "<ident> {<for(e <- styleRules) {>
    '  <prettyPrint(e)><}>
    '}
    '";

public str prettyPrint(Statement s: 
  styleDefinition(StyleIdent: questionStyleIdent(ident), set[StyleRule] styleRules)) = 
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

