module lang::ql::util::Parse

import lang::ql::syntax::QL;
import ParseTree;

public start[Form] parse(str src, loc l) = 
  parse(#start[Form], src, l);
