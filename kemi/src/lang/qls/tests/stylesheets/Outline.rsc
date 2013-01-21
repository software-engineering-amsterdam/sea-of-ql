module lang::qls::tests::stylesheets::Outline

import lang::qls::ast::AST;
import lang::qls::ide::Outline;
import lang::qls::tests::ParseHelper;
import IO;

private node outline(str s) = outlineStylesheet(parseStylesheet(s));

public node main() =
  outline(readFile(|project://QL-R-kemi/stylesheets/proposedSyntax.qs|));
