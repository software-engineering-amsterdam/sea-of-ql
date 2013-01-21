module Load

import Prelude;
import concreteSyntax;
import abstractSyntax;

public PROGRAM load(str txt)= implode(#PROGRAM, parse(#PROGRAM, txt));