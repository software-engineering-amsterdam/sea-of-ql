@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::qls::compiler::web::Web

import IO;
import lang::ql::\ast::AST;
import lang::qls::\ast::AST;
import lang::qls::compiler::web::CSS;
import lang::qls::compiler::web::JS;

public loc buildSheet(Stylesheet sheet, loc destFolder) {
  destFolder += "<sheet.ident.name>/";
  
  if(!exists(destFolder))
    mkDirectory(destFolder);
  
  css(sheet, destFolder);
  js(sheet, destFolder);
  
  return destFolder;
}
