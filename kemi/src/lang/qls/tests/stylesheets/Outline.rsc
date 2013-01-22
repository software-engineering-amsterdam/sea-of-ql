module lang::qls::tests::stylesheets::Outline

import lang::qls::ast::AST;
import lang::qls::ide::Outline;
import lang::qls::tests::ParseHelper;
import IO;

private node outline(loc f) = 
  outlineStylesheet(parseStylesheet(f));

private node outline(str s) =
  outlineStylesheet(parseStylesheet(s));

public test bool testOutline1() =
  outline(|project://QL-R-kemi/stylesheets/proposedSyntax.qs|) > "outline"();
