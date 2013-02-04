module Plugin

import ParseTree;
import util::IDE;

import lang::ql::util::Parse;
import lang::ql::util::Implode;
import lang::ql::ide::Outline;
import lang::ql::ide::Check;
import lang::ql::ide::Build;

import lang::qls::util::Parse;
import lang::qls::util::Implode;
import lang::qls::ide::Outline;
import lang::qls::ide::Check;
import lang::qls::ide::Build;

private str QL_LANG = "QL-R";
private str QL_EXT = "q";

private str QLS_LANG = "QLS-R";
private str QLS_EXT = "qs";


public void main() {
  registerLanguage(QL_LANG, QL_EXT, QLparser);
  registerContributions(QL_LANG, {getQLOutliner(), getQLAnnotator(), getQLBuilder()});

  registerLanguage(QLS_LANG, QLS_EXT, QLSparser);
  registerContributions(QLS_LANG, {getQLSOutliner(), getQLSAnnotator(), getQLSBuilder()});

}


private Tree QLparser(str src, loc l) = parseQL(src, l);

private Tree QLSparser(str src, loc l) = parseQLS(src, l);
