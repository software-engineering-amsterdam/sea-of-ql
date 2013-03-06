@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module util::StringHelper

import String;

public str unquote(str string) =
  substring(string, 1, size(string) - 1)
    when string[0] == "\"" && string[size(string) - 1] == "\"";

public default str unquote(str string) = string;
