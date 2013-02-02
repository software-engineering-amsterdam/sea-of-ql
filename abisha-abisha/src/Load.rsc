module Load

import Prelude;
import ConcreteSyntax;
import AbstractSyntax;

public FORM load(str txt)= implode(#FORM, parse(#FORM, txt));