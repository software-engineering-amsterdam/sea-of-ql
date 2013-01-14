module lang::ql::util::LocationSpan

import List;

import lang::ql::ast::AST;

public loc getLocationSpan(list[Statement] items) {
  h = head(items);
  t = last(items);

  // Rascal breaks at the following: ()
  //return |h@location.uri|( h@location.offset, 100, <h@location.begin.line, h@location.begin.column> , <t@location.end.line, t@location.end.column>);
  // The one below is a temp fix, but incorrect
  return |file:///-|( h@location.offset, 10, <h@location.begin.line, h@location.begin.column> , <t@location.end.line, t@location.end.column>);
}
