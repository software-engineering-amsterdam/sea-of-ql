module lang::qls::analysis::SemanticChecker

import List;
import Set;
import String;
import util::IDE;

import lang::qls::ast::AST;
import lang::qls::compiler::PrettyPrinter;

import IO;
import lang::qls::tests::ParseHelper;

public set[Message] semanticChecker(Stylesheet s) = 
  alreadyUsedQuestionErrors(s) +
  doubleNameWarnings(s) +
  defaultRedefinitionWarnings(s);


public set[Message] alreadyUsedQuestionErrors(Stylesheet s) {
  errors = {};
  questionDefinitions = getQuestionDefinitions(s);
  idents = [];
  for(d <- questionDefinitions) {
    i = indexOf(idents, d.ident);
    if(i >= 0) {
      errors += error(
        "Question already used at line <questionDefinitions[i]@location.begin.line>",
        d@location
      );
    }
    idents += d.ident;
  }
  return errors;
}

public set[Message] doubleNameWarnings(Stylesheet s) {
  return doublePageNameWarnings(s) +
    doubleSectionNameWarnings(s);
}

public set[Message] doublePageNameWarnings(Stylesheet s) {
  warnings = {};
  pageDefinitions = getPageDefinitions(s);
  names = [];
  for(d <- pageDefinitions) {
    i = indexOf(names, d.ident);
    if(i >= 0) {
      warnings += warning(
        "Page name already used at line <pageDefinitions[i]@location.begin.line>",
        d@location
      );
    }
    names += d.ident;
  }
  return warnings;
}

public set[Message] doubleSectionNameWarnings(Stylesheet s) {
  warnings = {};
  sectionDefinitions = getSectionDefinitions(s);
  names = [];
  for(d <- sectionDefinitions) {
    i = indexOf(names, d.ident);
    if(i >= 0) {
      warnings += warning(
        "Section name already used at line <sectionDefinitions[i]@location.begin.line>",
        d@location
      );
    }
    names += d.ident;
  }
  return warnings;
}

public set[Message] defaultRedefinitionWarnings(Stylesheet s) {
  warnings = {};
  for(r <- getDefaultRedefinitions(s.definitions))
    warnings += warning(
      "Default already declared at this level",
      r@location
    );
  top-down visit(s) {
    case pageDefinition(_, rules):
      for(r <- getDefaultRedefinitions(rules))
        warnings += warning(
          "Default already declared at this level",
          r@location
        );
    case sectionDefinition(_, rules):
      for(r <- getDefaultRedefinitions(rules))
        warnings += warning(
          "Default already declared at this level",
          r@location
        );
  }
  return warnings;
}

private list[DefaultDefinition] getDefaultRedefinitions(list[&T] definitions) {
  idents = [];
  redefinitions = [];
  for(def <- definitions) {
    if(!def.defaultDefinition?) continue;
    
    d = def.defaultDefinition;
    i = indexOf(idents, d.ident);
    if(i >= 0) redefinitions += d;
    idents += d.ident;
  }
  return redefinitions;
}

public list[QuestionDefinition] getQuestionDefinitions(Stylesheet s) =
  [d | /QuestionDefinition d <- s];

public list[PageDefinition] getPageDefinitions(Stylesheet s) =
  [d | /PageDefinition d <- s];

public list[str] getPageNames(Stylesheet s) =
  [name | /PageDefinition d:pageDefinition(name, _) <- s];

public list[SectionDefinition] getSectionDefinitions(Stylesheet s) =
  [d | /SectionDefinition d <- s];

public list[str] getSectionNames(Stylesheet s) =
  [name | /SectionDefinition d:sectionDefinition(name, _) <- s];


public void main() {
  s = parseStylesheet(|project://QL-R-kemi/stylesheets/proposedSyntax.qs|);
  //iprintln(getQuestionDefinitions(s));
  //iprintln(getPageNames(s));
  //iprintln(getSectionNames(s));
  errors = semanticChecker(s);
  iprintln(errors);
}
