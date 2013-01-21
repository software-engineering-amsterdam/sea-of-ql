module typeChecker::Mapping

import Prelude;
import syntax::AbstractSyntax;
import typeChecker::TypeCheck;
import typeChecker::Eval;

alias QTENV = tuple[ map[QuestionId, TYPE] symbols, list[tuple[loc l, str msg]] errors];
alias QSTRING = tuple[ map[QuestionString, TYPE] symbols, list[tuple[loc l, str msg]] errors];

QSTRING addError(QSTRING qString, loc l, str msg) = qString[errors = qString.errors + <l, msg>];

str required(TYPE t, str got) = "Required <getName(t)>, got <got>";                 
str required(TYPE t1, TYPE t2) = required(t1, getName(t2));

// compile Expressions.
QSTRING checkExp(exp:strQue(str B), TYPE req, QSTRING env) =                              
  req == string() ? env : addError(env, exp@location, required(req, "string"));


public QTENV checkQuestion(list[QUE] qNames) =   
   <(questionString : tp | qName(QuestionString questionString, TYPE tp) <- qNames),[]>;

/* Method to get the question ids
 * @param questionList a list with tuples of QuestionIds and QUE
 * @return idList a list with the question ids
 * @author Philipp
*/
public QTENV getQuestionIdsAndTypes(map[QuestionId QId, QUE ques] questionList){
	set[QuestionId] idSet = questionList.QId;
	//println("QUESTIONLIST : <questionList.QId>");
	list[QuestionId] idList = toList(idSet);
	map[QuestionId QId, TYPE tp] temp = ();
	for(int n <- [0..size(idList) - 1]){
		QUE a = questionList[idList[n]];
		temp += (idList[n] : a.tp);
	}
	QTENV result = <( temp ), []>;
    return result;
}



public QSTRING checkQuestionString(map[QuestionId QId, QUE ques] q){
	set[QuestionId] idSet = q.QId;
	//println("QUESTIONLIST : <questionList.QId>");
	list[QuestionId] idList = toList(idSet);
	map[QuestionString qString, TYPE tp] temp = ();
	for(int n <- [0..size(idList) - 1]){
		QUE a = q[idList[n]];
		println(a.questionString);
		checkExp(a.questionString);
		//temp += (a.questionString : "string()");
	}
	QString result = <( temp ), []>;
	println("QSTRING : <result>");
	return result;
}


/* Method to map a questionId to the type
 * @param q a map with questionId and QUE  
 * @return result a map with QuestionId and the type
 * @author Philipp
*/
public QTENV mapQuestionIdToType2(map[QuestionId QId, QUE ques] q){
    list[tuple[QuestionId QId, QUE ques]] questionList = toList(q);
    QTENV result = getQuestionIdsAndTypes(q);
    return result;
}


