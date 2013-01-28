module lang::qls::tests::stylesheets::PrettyPrinter

import lang::qls::ast::AST;
import lang::qls::compiler::PrettyPrinter;
import lang::qls::tests::ParseHelper;

private bool prettyPrintAndCompare(loc f) = 
  parseStylesheet(f) == parseStylesheet(prettyPrint(parseStylesheet(f)));

private bool prettyPrintAndCompare(str s) = 
  parseStylesheet(s) == parseStylesheet(prettyPrint(parseStylesheet(s)));

public test bool testProposedSyntax() = 
  prettyPrintAndCompare(|project://QL-R-kemi/stylesheets/proposedSyntax.qs|);
