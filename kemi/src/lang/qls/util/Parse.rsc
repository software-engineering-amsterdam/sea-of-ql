module lang::qls::util::Parse

import lang::qls::syntax::QLS;
import ParseTree;

public start[Stylesheet] parse(str src, loc l) = parse(#start[Stylesheet], src, l);
