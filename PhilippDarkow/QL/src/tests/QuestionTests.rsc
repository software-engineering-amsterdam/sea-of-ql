module tests::QuestionTests

import util::Parse;
import util::Implode;
import syntax::ConcreteSyntax;
import Prelude;

private Question p(str src) = implode(parseQuestion(src, |file:///test.q|)); 