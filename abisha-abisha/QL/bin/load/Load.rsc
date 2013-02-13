module load::Load

import Prelude;
import syntax::abstractSyntax;
import syntax::ConcreteSyntax;
import ParseTree;

public Program load(str txt)= implode(#Program, parse(#start[Program], txt));