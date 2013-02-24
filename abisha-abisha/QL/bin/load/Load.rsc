module load::Load

import Prelude;
import syntax::Concrete;
import syntax::Abstract;
import ParseTree;

public Form load(str txt) = implode(#Form, parse(#start[Form], txt));