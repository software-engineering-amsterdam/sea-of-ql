module typeChecker::Load

import Prelude;
import syntax::ConcreteSyntax;
import syntax::AbstractSyntax;

public PROGRAM load(str txt) = implode(#PROGRAM, parse(#Program, txt));