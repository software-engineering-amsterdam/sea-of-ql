module bugs::ModuleCacheBug

import Grammar;
import IO;
import Set;
import lang::rascal::\syntax::RascalRascal;
import lang::rascal::grammar::definition::Keywords;

// @ Jimi: I can't seem to replicate it.
public void main() {
  println("There are <size(keywords)> keywords.");
}

public set[str] keywords = {
  y |
  /prod(_, literal, _) <- getKeywords(grammar({}, #Module.definitions)), 
  lit(y) <- literal
};
