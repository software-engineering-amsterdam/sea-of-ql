@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::ql::analysis::Messages

import lang::ql::\ast::AST;
import util::IDE;
import util::LocationHelper;

public Message alreadyDeclaredMessage(str name, loc \loc) =
  error("Identifier <name> is already declared.", \loc);
  
public Message redeclaredMessage(loc \loc) = 
  error("Identifier is being redeclared with a different type.", \loc);

public Message labelError(loc \loc) =
  warning("This question is already defined", \loc);

public Message invalidAssignmentMessage(Type decl, Type eval, \loc) = 
  error("Declared type is <decl.name>, evaluates to <eval.name>.", \loc);

public Message invalidTypeMessage(loc \loc) =
  error("Invalid types in expression.", \loc);
  
public Message undeclaredIdentifierMessage(str ident, loc \loc) = 
  error("Identifier <ident> is undeclared.", \loc);

public Message formIdentifierDoesNotMatchFilename(IdentDefinition ident) =
  error(
    "Form name (<ident.ident>) does not match filename " +
      "(<basename(ident@location)>)",
    ident@location
  );
