module util::Parse

import syntax::ConcreteSyntax;
import ParseTree;
import Prelude;

public start[Expression] parse(str src, loc l) = parse(#start[Expression], src, l);

public start[Statement] parse(str src, loc l) = parse(#start[Statement], src, l);