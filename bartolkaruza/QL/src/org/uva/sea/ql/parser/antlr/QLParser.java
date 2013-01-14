// $ANTLR 3.4 src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-09 20:35:19

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expr.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "IF", "Ident", "Int", "TYPE", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'\\\"'", "'form'", "'{'", "'||'", "'}'"
    };

    public static final int EOF=-1;
    public static final int T__10=10;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int COMMENT=4;
    public static final int IF=5;
    public static final int Ident=6;
    public static final int Int=7;
    public static final int TYPE=8;
    public static final int WS=9;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public QLParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public QLParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.ruleMemo = new HashMap[32+1];
         

    }

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "src/org/uva/sea/ql/parser/antlr/QL.g"; }



    // $ANTLR start "form"
    // src/org/uva/sea/ql/parser/antlr/QL.g:16:1: form returns [Form result] : 'form' lbl= Ident '{' qs= questions '}' ;
    public final Form form() throws RecognitionException {
        Form result = null;

        int form_StartIndex = input.index();

        Token lbl=null;
        Questions qs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:17:5: ( 'form' lbl= Ident '{' qs= questions '}' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:17:7: 'form' lbl= Ident '{' qs= questions '}'
            {
            match(input,26,FOLLOW_26_in_form49); if (state.failed) return result;

            lbl=(Token)match(input,Ident,FOLLOW_Ident_in_form53); if (state.failed) return result;

            match(input,27,FOLLOW_27_in_form55); if (state.failed) return result;

            pushFollow(FOLLOW_questions_in_form59);
            qs=questions();

            state._fsp--;
            if (state.failed) return result;

            match(input,29,FOLLOW_29_in_form61); if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new Form((lbl!=null?lbl.getText():null), qs ); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 1, form_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "form"



    // $ANTLR start "questions"
    // src/org/uva/sea/ql/parser/antlr/QL.g:20:1: questions returns [Questions result] : (q= question qs= questions |s= statement qs= questions |);
    public final Questions questions() throws RecognitionException {
        Questions result = null;

        int questions_StartIndex = input.index();

        QuestionElement q =null;

        Questions qs =null;

        Stmt s =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:21:4: (q= question qs= questions |s= statement qs= questions |)
            int alt1=3;
            switch ( input.LA(1) ) {
            case Ident:
                {
                alt1=1;
                }
                break;
            case IF:
                {
                alt1=2;
                }
                break;
            case EOF:
            case 29:
                {
                alt1=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }

            switch (alt1) {
                case 1 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:21:6: q= question qs= questions
                    {
                    pushFollow(FOLLOW_question_in_questions85);
                    q=question();

                    state._fsp--;
                    if (state.failed) return result;

                    pushFollow(FOLLOW_questions_in_questions89);
                    qs=questions();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) {result = new Questions(); result.add(q); result.add(qs); }

                    }
                    break;
                case 2 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:22:6: s= statement qs= questions
                    {
                    pushFollow(FOLLOW_statement_in_questions100);
                    s=statement();

                    state._fsp--;
                    if (state.failed) return result;

                    pushFollow(FOLLOW_questions_in_questions104);
                    qs=questions();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) {result = new Questions(s); result.add(qs); }

                    }
                    break;
                case 3 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:23:6: 
                    {
                    if ( state.backtracking==0 ) {return null; }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, questions_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "questions"



    // $ANTLR start "question"
    // src/org/uva/sea/ql/parser/antlr/QL.g:26:1: question returns [Question result] : label= Ident ':' '\\\"' (text= Ident )* '\\\"' TYPE ;
    public final QuestionElement question() throws RecognitionException {
        QuestionElement result = null;

        int question_StartIndex = input.index();

        Token label=null;
        Token text=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:27:5: (label= Ident ':' '\\\"' (text= Ident )* '\\\"' TYPE )
            // src/org/uva/sea/ql/parser/antlr/QL.g:27:7: label= Ident ':' '\\\"' (text= Ident )* '\\\"' TYPE
            {
            label=(Token)match(input,Ident,FOLLOW_Ident_in_question137); if (state.failed) return result;

            match(input,19,FOLLOW_19_in_question138); if (state.failed) return result;

            match(input,25,FOLLOW_25_in_question140); if (state.failed) return result;

            // src/org/uva/sea/ql/parser/antlr/QL.g:27:31: (text= Ident )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Ident) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // src/org/uva/sea/ql/parser/antlr/QL.g:27:31: text= Ident
            	    {
            	    text=(Token)match(input,Ident,FOLLOW_Ident_in_question144); if (state.failed) return result;

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            match(input,25,FOLLOW_25_in_question147); if (state.failed) return result;

            match(input,TYPE,FOLLOW_TYPE_in_question149); if (state.failed) return result;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, question_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "question"



    // $ANTLR start "statement"
    // src/org/uva/sea/ql/parser/antlr/QL.g:30:1: statement returns [Stmt result] : IF (x= expr ) '{' qs= questions '}' ;
    public final Stmt statement() throws RecognitionException {
        Stmt result = null;

        int statement_StartIndex = input.index();

        Expr x =null;

        Questions qs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:31:5: ( IF (x= expr ) '{' qs= questions '}' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:31:7: IF (x= expr ) '{' qs= questions '}'
            {
            match(input,IF,FOLLOW_IF_in_statement175); if (state.failed) return result;

            // src/org/uva/sea/ql/parser/antlr/QL.g:31:10: (x= expr )
            // src/org/uva/sea/ql/parser/antlr/QL.g:31:11: x= expr
            {
            pushFollow(FOLLOW_expr_in_statement180);
            x=expr();

            state._fsp--;
            if (state.failed) return result;

            }


            match(input,27,FOLLOW_27_in_statement183); if (state.failed) return result;

            pushFollow(FOLLOW_questions_in_statement187);
            qs=questions();

            state._fsp--;
            if (state.failed) return result;

            match(input,29,FOLLOW_29_in_statement189); if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new Stmt(x, qs); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, statement_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "statement"



    // $ANTLR start "primary"
    // src/org/uva/sea/ql/parser/antlr/QL.g:34:1: primary returns [Expr result] : ( Int | Ident | '(' x= orExpr ')' );
    public final Expr primary() throws RecognitionException {
        Expr result = null;

        int primary_StartIndex = input.index();

        Token Int1=null;
        Token Ident2=null;
        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:35:4: ( Int | Ident | '(' x= orExpr ')' )
            int alt3=3;
            switch ( input.LA(1) ) {
            case Int:
                {
                alt3=1;
                }
                break;
            case Ident:
                {
                alt3=2;
                }
                break;
            case 13:
                {
                alt3=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }

            switch (alt3) {
                case 1 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:35:6: Int
                    {
                    Int1=(Token)match(input,Int,FOLLOW_Int_in_primary211); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int1!=null?Int1.getText():null))); }

                    }
                    break;
                case 2 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:36:6: Ident
                    {
                    Ident2=(Token)match(input,Ident,FOLLOW_Ident_in_primary222); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Ident((Ident2!=null?Ident2.getText():null)); }

                    }
                    break;
                case 3 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:37:6: '(' x= orExpr ')'
                    {
                    match(input,13,FOLLOW_13_in_primary231); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_primary235);
                    x=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,14,FOLLOW_14_in_primary237); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = x; }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, primary_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "primary"



    // $ANTLR start "unExpr"
    // src/org/uva/sea/ql/parser/antlr/QL.g:40:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
    public final Expr unExpr() throws RecognitionException {
        Expr result = null;

        int unExpr_StartIndex = input.index();

        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:41:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
            int alt4=4;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt4=1;
                }
                break;
            case 17:
                {
                alt4=2;
                }
                break;
            case 10:
                {
                alt4=3;
                }
                break;
            case Ident:
            case Int:
            case 13:
                {
                alt4=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }

            switch (alt4) {
                case 1 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:41:8: '+' x= unExpr
                    {
                    match(input,16,FOLLOW_16_in_unExpr263); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr267);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Pos(x); }

                    }
                    break;
                case 2 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:42:8: '-' x= unExpr
                    {
                    match(input,17,FOLLOW_17_in_unExpr278); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr282);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Neg(x); }

                    }
                    break;
                case 3 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:43:8: '!' x= unExpr
                    {
                    match(input,10,FOLLOW_10_in_unExpr293); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr297);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Not(x); }

                    }
                    break;
                case 4 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:44:8: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpr310);
                    x=primary();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = x; }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, unExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "unExpr"



    // $ANTLR start "mulExpr"
    // src/org/uva/sea/ql/parser/antlr/QL.g:47:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expr mulExpr() throws RecognitionException {
        Expr result = null;

        int mulExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:48:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // src/org/uva/sea/ql/parser/antlr/QL.g:48:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr348);
            lhs=unExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:48:45: (op= ( '*' | '/' ) rhs= unExpr )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==15||LA5_0==18) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // src/org/uva/sea/ql/parser/antlr/QL.g:48:47: op= ( '*' | '/' ) rhs= unExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==15||input.LA(1)==18 ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_unExpr_in_mulExpr368);
            	    rhs=unExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { 
            	          if ((op!=null?op.getText():null).equals("*")) {
            	            result = new Mul(result, rhs);
            	          }
            	          if ((op!=null?op.getText():null).equals("<=")) {
            	            result = new Div(result, rhs);      
            	          }
            	        }

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, mulExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "mulExpr"



    // $ANTLR start "addExpr"
    // src/org/uva/sea/ql/parser/antlr/QL.g:59:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expr addExpr() throws RecognitionException {
        Expr result = null;

        int addExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:60:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // src/org/uva/sea/ql/parser/antlr/QL.g:60:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr404);
            lhs=mulExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:60:46: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0 >= 16 && LA6_0 <= 17)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // src/org/uva/sea/ql/parser/antlr/QL.g:60:48: op= ( '+' | '-' ) rhs= mulExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( (input.LA(1) >= 16 && input.LA(1) <= 17) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_mulExpr_in_addExpr422);
            	    rhs=mulExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { 
            	          if ((op!=null?op.getText():null).equals("+")) {
            	            result = new Add(result, rhs);
            	          }
            	          if ((op!=null?op.getText():null).equals("-")) {
            	            result = new Sub(result, rhs);      
            	          }
            	        }

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 8, addExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "addExpr"



    // $ANTLR start "relExpr"
    // src/org/uva/sea/ql/parser/antlr/QL.g:71:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expr relExpr() throws RecognitionException {
        Expr result = null;

        int relExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:72:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // src/org/uva/sea/ql/parser/antlr/QL.g:72:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr457);
            lhs=addExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:72:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==11||(LA7_0 >= 20 && LA7_0 <= 24)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // src/org/uva/sea/ql/parser/antlr/QL.g:72:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==11||(input.LA(1) >= 20 && input.LA(1) <= 24) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_addExpr_in_relExpr481);
            	    rhs=addExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { 
            	          if ((op!=null?op.getText():null).equals("<")) {
            	            result = new LT(result, rhs);
            	          }
            	          if ((op!=null?op.getText():null).equals("<=")) {
            	            result = new LEq(result, rhs);      
            	          }
            	          if ((op!=null?op.getText():null).equals(">")) {
            	            result = new GT(result, rhs);
            	          }
            	          if ((op!=null?op.getText():null).equals(">=")) {
            	            result = new GEq(result, rhs);      
            	          }
            	          if ((op!=null?op.getText():null).equals("==")) {
            	            result = new Eq(result, rhs);
            	          }
            	          if ((op!=null?op.getText():null).equals("!=")) {
            	            result = new NEq(result, rhs);
            	          }
            	        }

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 9, relExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "relExpr"



    // $ANTLR start "andExpr"
    // src/org/uva/sea/ql/parser/antlr/QL.g:95:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expr andExpr() throws RecognitionException {
        Expr result = null;

        int andExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:96:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // src/org/uva/sea/ql/parser/antlr/QL.g:96:9: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr519);
            lhs=relExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:96:46: ( '&&' rhs= relExpr )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==12) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // src/org/uva/sea/ql/parser/antlr/QL.g:96:48: '&&' rhs= relExpr
            	    {
            	    match(input,12,FOLLOW_12_in_andExpr525); if (state.failed) return result;

            	    pushFollow(FOLLOW_relExpr_in_andExpr529);
            	    rhs=relExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new And(result, rhs); }

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 10, andExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "andExpr"



    // $ANTLR start "orExpr"
    // src/org/uva/sea/ql/parser/antlr/QL.g:99:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final Expr orExpr() throws RecognitionException {
        Expr result = null;

        int orExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:100:5: (lhs= andExpr ( '||' rhs= andExpr )* )
            // src/org/uva/sea/ql/parser/antlr/QL.g:100:9: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr559);
            lhs=andExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = lhs; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:100:48: ( '||' rhs= andExpr )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==28) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // src/org/uva/sea/ql/parser/antlr/QL.g:100:50: '||' rhs= andExpr
            	    {
            	    match(input,28,FOLLOW_28_in_orExpr565); if (state.failed) return result;

            	    pushFollow(FOLLOW_andExpr_in_orExpr569);
            	    rhs=andExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new Or(result, rhs); }

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 11, orExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "orExpr"



    // $ANTLR start "expr"
    // src/org/uva/sea/ql/parser/antlr/QL.g:103:1: expr returns [Expr result] : e= orExpr ;
    public final Expr expr() throws RecognitionException {
        Expr result = null;

        int expr_StartIndex = input.index();

        Expr e =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:104:5: (e= orExpr )
            // src/org/uva/sea/ql/parser/antlr/QL.g:104:7: e= orExpr
            {
            pushFollow(FOLLOW_orExpr_in_expr601);
            e=orExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = e; }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 12, expr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "expr"

    // Delegated rules


 

    public static final BitSet FOLLOW_26_in_form49 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Ident_in_form53 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_form55 = new BitSet(new long[]{0x0000000020000060L});
    public static final BitSet FOLLOW_questions_in_form59 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_form61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_question_in_questions85 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_questions_in_questions89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_questions100 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_questions_in_questions104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_question137 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_question138 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_question140 = new BitSet(new long[]{0x0000000002000040L});
    public static final BitSet FOLLOW_Ident_in_question144 = new BitSet(new long[]{0x0000000002000040L});
    public static final BitSet FOLLOW_25_in_question147 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TYPE_in_question149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_statement175 = new BitSet(new long[]{0x00000000000324C0L});
    public static final BitSet FOLLOW_expr_in_statement180 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_statement183 = new BitSet(new long[]{0x0000000020000060L});
    public static final BitSet FOLLOW_questions_in_statement187 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_statement189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Int_in_primary211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_primary222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_primary231 = new BitSet(new long[]{0x00000000000324C0L});
    public static final BitSet FOLLOW_orExpr_in_primary235 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_primary237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_unExpr263 = new BitSet(new long[]{0x00000000000324C0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_unExpr278 = new BitSet(new long[]{0x00000000000324C0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_unExpr293 = new BitSet(new long[]{0x00000000000324C0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr348 = new BitSet(new long[]{0x0000000000048002L});
    public static final BitSet FOLLOW_set_in_mulExpr356 = new BitSet(new long[]{0x00000000000324C0L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr368 = new BitSet(new long[]{0x0000000000048002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr404 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_set_in_addExpr412 = new BitSet(new long[]{0x00000000000324C0L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr422 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr457 = new BitSet(new long[]{0x0000000001F00802L});
    public static final BitSet FOLLOW_set_in_relExpr465 = new BitSet(new long[]{0x00000000000324C0L});
    public static final BitSet FOLLOW_addExpr_in_relExpr481 = new BitSet(new long[]{0x0000000001F00802L});
    public static final BitSet FOLLOW_relExpr_in_andExpr519 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_andExpr525 = new BitSet(new long[]{0x00000000000324C0L});
    public static final BitSet FOLLOW_relExpr_in_andExpr529 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr559 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_orExpr565 = new BitSet(new long[]{0x00000000000324C0L});
    public static final BitSet FOLLOW_andExpr_in_orExpr569 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_orExpr_in_expr601 = new BitSet(new long[]{0x0000000000000002L});

}