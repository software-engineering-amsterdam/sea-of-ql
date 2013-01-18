module lang::ql::util::Parse

import lang::ql::syntax::QL;
import ParseTree;
import IO;

public start[Form] parse(str src, loc l) = parse(#start[Form], src, l);
