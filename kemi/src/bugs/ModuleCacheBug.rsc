module bugs::ModuleCacheBug

import Grammar;
import IO;
import Set;
import lang::rascal::grammar::definition::Keywords;

import bugs::ExtendSyntax;

/*
 * When extending a syntax definition, something weird happens. The first time
 * this file is run, it will report that the rascal grammar has 71 or so keywords,
 * including the extended 'bug' keyword from the "ExtendedSyntax" module.
 * 
 * Now, as soon as this file is edited and saved, only the extended keyword will 
 * be detected. Do note, no line of code has to be changed. In order to be able 
 * to correctly detect al keywords again, the associated rascal console has to 
 * be terminated and the module must be reloaded in a new console.  
 */

public void main() {
  int kc = size(keywords);
  
  if(kc == 1)
    println("The only keyword is <keywords>");  
  else
    println("There are <kc> keywords.");
}

private set[str] keywords = {
  y |
  /prod(_, literal, _) <- getKeywords(grammar({}, #Module.definitions)), 
  lit(y) <- literal
};
