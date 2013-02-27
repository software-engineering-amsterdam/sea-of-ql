@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::ql::compiler::web::Web

import Configuration;
import IO;
import lang::ql::\ast::AST;
import lang::ql::compiler::web::HTML;
import lang::ql::compiler::web::JS;
import lang::ql::compiler::web::PHP;

public loc buildForm(Form form, loc destFolder) {
  destFolder += "<form.formName.ident>/";
  
  if(!exists(destFolder))
    mkDirectory(destFolder);
  
  // Copy static files
  for(e <- listEntries(getStaticSourceLoc()))
    writeFile(destFolder + e, readFile(getStaticSourceLoc() + e));
  
  html(form, destFolder);
  js(form, destFolder);
  php(form, destFolder);
  
  return destFolder;
}
