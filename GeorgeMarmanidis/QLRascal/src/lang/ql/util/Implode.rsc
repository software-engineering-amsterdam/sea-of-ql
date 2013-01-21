@contributor{George Marmanidis -geo.marmani@gmail.com}
module lang::ql::util::Implode

import ParseTree;
import lang::ql::util::Parse;
import lang::ql::ast::AST;
import IO;


public Form implode(Tree t) = implode(#Form, t);
public Form load(loc l) = implode(parse(readFile(l), l));
public Form load(str src) = implode(parse(src,|file:///-|));
