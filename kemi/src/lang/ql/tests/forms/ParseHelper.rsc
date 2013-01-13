module lang::ql::tests::forms::ParseHelper

import IO;
import lang::ql::ast::AST;
import lang::ql::util::Implode;
import lang::ql::util::Parse;

public Form parse(str src) = implode(parse(src, |file:///-|));
public Form parse(loc f) = parse(readFile(f));
