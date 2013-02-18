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

import IO;
import ParseTree;
import lang::ql::Plugin;
import lang::qls::analysis::SemanticChecker;
import lang::qls::ast::AST;
import lang::qls::compiler::PrettyPrinter;
import lang::qls::compiler::web::Web;
import lang::qls::ide::Outline;
import lang::qls::syntax::QLS;
import lang::qls::util::ParseHelper;
import lang::qls::util::StyleHelper;
import util::IDE;
import util::Prompt;

private str LANG = "QLS-R";
private str EXT = "qs";
private str ACTION_FORMAT = "Format (removes comments)";
private str ACTION_BUILD = "Build stylesheet and accompanying form";
private loc SHEET_TARGET = |project://QL-R-kemi/output/|;

private set[Message] buildAndReturnMessages(start[Stylesheet] sheet, loc target) =
  buildAndReturnMessages(implode(sheet), target);
  
private set[Message] buildAndReturnMessages(Stylesheet sheet, loc target) {
  messages = semanticChecker(sheet);
  if(messages != {}) {
    return messages;
  }
  
  form = getAccompanyingForm(sheet);
  
  formMessages = buildAndReturnMessages(form, target);
  if(formMessages != {}) {
    return formMessages;
  }
  
  buildSheet(sheet, target);
  
  return {};
}

private void build(start[Stylesheet] sheet, loc source) {
  messages = buildAndReturnMessages(sheet, SHEET_TARGET);
  
  if(messages != {}) {
    alert("The sheet cannot be built when it still contains errors.");
  } else {
    alert("The sheet is built in <SHEET_TARGET>.");
  }
  return;
}

private void format(start[Stylesheet] s, loc l) =
  writeFile(l, prettyPrint(implode(s)));

public void setupQLS() {
  registerLanguage(LANG, EXT, Tree(str src, loc l) {
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
      menu(LANG,[
        action(ACTION_BUILD, build),
        action(ACTION_FORMAT, format)
      ])
    ),
    
    builder(set[Message] (Tree input) {
      messages = buildAndReturnMessages(implode(input), SHEET_TARGET);
      return messages;
    })
  };
  
  registerContributions(LANG, contribs);
}
