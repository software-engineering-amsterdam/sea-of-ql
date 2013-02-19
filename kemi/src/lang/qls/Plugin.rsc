@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::qls::Plugin

import Configuration;
import IO;
import \ParseTree;
import lang::ql::Plugin;
import lang::qls::analysis::SemanticChecker;
import lang::qls::\ast::AST;
import lang::qls::compiler::PrettyPrinter;
import lang::qls::compiler::web::Web;
import lang::qls::ide::Outline;
import lang::qls::\syntax::QLS;
import lang::qls::util::ParseHelper;
import lang::qls::util::StyleHelper;
import util::IDE;
import util::Prompt;

private str actionBuild = "Build stylesheet and accompanying form";
private str actionFormat = "Format (removes comments)";

private set[Message] buildAndReturnMessages(start[Stylesheet] sheet, loc target) =
  buildAndReturnMessages(implode(sheet), target);
  
private set[Message] buildAndReturnMessages(Stylesheet sheet, loc target) {
  messages = semanticChecker(sheet);
  
  errors = {m | m <- messages, error(_, _) := m};
  
  if(errors != {}) {
    return messages;
  }
  
  form = getAccompanyingForm(sheet);
  
  formMessages = buildAndReturnMessages(form, target);
  formErrors = {m | m <- formMessages, error(_, _) := m};
  
  if(formErrors != {}) {
    return formMessages;
  }
  
  buildSheet(sheet, target);
  
  return {};
}

void build(Stylesheet sheet, loc source) {
  messages = buildAndReturnMessages(sheet, getCompileTarget());
  
  errors = {m | m <- messages, error(_, _) := m};
  
  if(errors != {}) {
    alert("The sheet cannot be built when it still contains errors.");
  } else {
    alert("The sheet is built in <getCompileTarget()>.");
  }
}

private void format(Stylesheet s, loc l) =
  writeFile(l, prettyPrint(s));

public void setupQLS() {
  registerLanguage(getQLSLangName(), getQLSLangExt(), Tree(str src, loc l) {
    return parse(src, l);
  });
  
  contribs = {
    outliner(node(Tree input) {
      return outlineStylesheet(implode(input));
    }),
    
    annotator(Tree (Tree input) {
      return input[@messages=semanticChecker(implode(input))];
    }),
    
    popup(
      menu(getQLSLangName(),[
        action(actionBuild, (Tree tree, loc source) {
          build(implode(tree), source);
        }),
        action(actionFormat, (Tree tree, loc source) {
          format(implode(tree), source);
        })
      ])
    ),
    
    builder(set[Message] (Tree input) {
      messages = buildAndReturnMessages(implode(input), getCompileTarget());
      return messages;
    })
  };
  
  registerContributions(getQLSLangName(), contribs);
}
