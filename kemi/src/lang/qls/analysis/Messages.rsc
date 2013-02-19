@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::qls::analysis::Messages

import util::IDE;
import util::LocationHelper;

public Message pageAlreadyDefined(loc old, loc cur) = 
  warning("Page already used at line <old.begin.line>", cur);

public Message sectionAlreadyDefined(loc old, loc cur) = 
  warning("Section already used at line <old.begin.line>", cur);
  
public Message defaultAlreadyDefined(loc location) =
  warning("Default already declared at this level", location);

public Message questionUnused(str ident, loc location) =
  warning("Question <ident> is not defined in the stylesheet", location);

public Message questionAlreadyDefined(loc old, loc cur) = 
  error("Question already used at line <old.begin.line>", cur);

public Message accompanyingFormNotFound(str name, loc location) =
  error("No form found with name <name>", location);

public Message stylesheetDoesNotMatchFilename(str name, loc location) = 
  error("Stylesheet name (<name>) does not match filename " + 
    "(<basename(location)>)", location);

public Message questionUndefinedInForm(loc location) =
  error("Question undefined in form", location);

public Message typeWithInvalidAttr(str attr, str \type, loc location) =
  error("Attr <attr> not allowed for type <\type>", location);

public Message typeWithInvalidWidget(str widget, str \type, loc location) =
  error("Widget <widget> not allowed for type <\type>", location);

public Message invalidRangeType(str \type, loc location) =
  error("Decimal ranges not allowed for type <\type>", location);
