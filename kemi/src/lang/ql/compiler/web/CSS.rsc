@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::ql::compiler::web::CSS

import Configuration;
import IO;
import lang::ql::\ast::AST;

public void CSS(Form f, loc dest) =
  writeFile(dest + getCSSStylesheetName(),
    ".error {
    '  float: none;
    '  color: red;
    '  padding-left: .5em;
    '  vertical-align: top;
    '}
    '
    'label {
    '  display: block;
    '}
    '"
  );
