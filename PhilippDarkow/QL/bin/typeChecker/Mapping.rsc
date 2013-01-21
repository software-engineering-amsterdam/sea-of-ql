module typeChecker::Mapping

import Prelude;
import syntax::AbstractSyntax;
import typeChecker::TypeCheck;
import typeChecker::Eval;

alias QTENV = tuple[ map[QuestionId, Type] symbols, list[tuple[loc l, str msg]] errors];
alias QSTRING = tuple[ map[QuestionString, Type] symbols, list[tuple[loc l, str msg]] errors];

QSTRING addError(QSTRING qString, loc l, str msg) = qString[errors = qString.errors + <l, msg>];

str required(Type t, str got) = "Required <getName(t)>, got <got>";                 
str required(Type t1, Type t2) = required(t1, getName(t2));

// compile Expressions.
//QSTRING checkExp(exp:string(str B), Type req, QSTRING env) =                              
//  req == string() ? env : addError(env, exp@location, required(req, "string"));


public QTENV checkQuestion(list[Question] qNames) =   
   <(questionString : tp | qName(QuestionString questionString, Type tp) <- qNames),[]>;

/* Method to get the question ids
 * @param questionList a list with tuples of QuestionIds and QUE
 * @return idList a list with the question ids
 * @author Philipp
*/
public QTENV getQuestionIdsAndTypes(map[QuestionId QId, Question ques] questionList){
	set[QuestionId] idSet = questionList.QId;
	//println("QUESTIONLIST : <questionList.QId>");
	list[QuestionId] idList = toList(idSet);
	map[QuestionId QId, Type tp] temp = ();
	for(int n <- [0..size(idList) - 1]){
		QUE a = questionList[idList[n]];
		temp += (idList[n] : a.tp);
	}
	QTENV result = <( temp ), []>;
    return result;
}



public QSTRING checkQuestionString(map[QuestionId QId, Question ques] q){
	set[QuestionId] idSet = q.QId;
	//println("QUESTIONLIST : <questionList.QId>");
	list[QuestionId] idList = toList(idSet);
	map[QuestionString qString, Type tp] temp = ();
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


/* Method to map a questionId to the Type
 * @param q a map with questionId and QUE  
 * @return result a map with QuestionId and the Type
 * @author Philipp
*/
public QTENV mapQuestionIdToType2(map[QuestionId QId, Question ques] q){
    list[tuple[QuestionId QId, QUE ques]] questionList = toList(q);
    QTENV result = getQuestionIdsAndTypes(q);
    return result;
}


