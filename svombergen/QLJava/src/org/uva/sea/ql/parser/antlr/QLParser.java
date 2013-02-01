// $ANTLR 3.4 QL.g 2013-01-31 16:32:30

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.boolexpr.*;
import org.uva.sea.ql.ast.relationalexpr.*;
import org.uva.sea.ql.ast.unaryexpr.*;
import org.uva.sea.ql.ast.binaryexpr.*;
import org.uva.sea.ql.ast.types.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "Ident", "Int", "Str", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'boolean'", "'form'", "'if'", "'int'", "'money'", "'money('", "'string'", "'{'", "'||'", "'}'"
    };

    public static final int EOF=-1;
    public static final int T__9=9;
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
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int COMMENT=4;
    public static final int Ident=5;
    public static final int Int=6;
    public static final int Str=7;
    public static final int WS=8;

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
        this.state.ruleMemo = new HashMap[36+1];
         

    }

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "QL.g"; }


        @Override
        public void reportError(RecognitionException e) {
            throw new RuntimeException(e);
        }



    // $ANTLR start "form"
    // QL.g:26:1: form returns [Form result] : 'form' Ident '{' (q= question )* ifStatement '}' EOF ;
    public final Form form() throws RecognitionException {
        Form result = null;

        int form_StartIndex = input.index();

        Token Ident1=null;
        Question q =null;

        IfStatement ifStatement2 =null;


         List<Question> list = new ArrayList<Question>(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

            // QL.g:28:2: ( 'form' Ident '{' (q= question )* ifStatement '}' EOF )
            // QL.g:28:4: 'form' Ident '{' (q= question )* ifStatement '}' EOF
            {
            match(input,25,FOLLOW_25_in_form59); if (state.failed) return result;

            Ident1=(Token)match(input,Ident,FOLLOW_Ident_in_form61); if (state.failed) return result;

            match(input,31,FOLLOW_31_in_form63); if (state.failed) return result;

            // QL.g:28:21: (q= question )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==Ident) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // QL.g:28:22: q= question
            	    {
            	    pushFollow(FOLLOW_question_in_form68);
            	    q=question();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) {list.add(q);}

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            pushFollow(FOLLOW_ifStatement_in_form74);
            ifStatement2=ifStatement();

            state._fsp--;
            if (state.failed) return result;

            match(input,33,FOLLOW_33_in_form76); if (state.failed) return result;

            match(input,EOF,FOLLOW_EOF_in_form78); if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new Form(new Ident((Ident1!=null?Ident1.getText():null)), list, ifStatement2); }

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



    // $ANTLR start "ifStatement"
    // QL.g:31:1: ifStatement returns [IfStatement result] : ( 'if' '(' x= orExpr ')' '{' (q= question )* '}' |);
    public final IfStatement ifStatement() throws RecognitionException {
        IfStatement result = null;

        int ifStatement_StartIndex = input.index();

        Expr x =null;

        Question q =null;


        List<Question> list = new ArrayList<Question>(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

            // QL.g:33:2: ( 'if' '(' x= orExpr ')' '{' (q= question )* '}' |)
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==26) ) {
                alt3=1;
            }
            else if ( (LA3_0==33) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // QL.g:33:4: 'if' '(' x= orExpr ')' '{' (q= question )* '}'
                    {
                    match(input,26,FOLLOW_26_in_ifStatement101); if (state.failed) return result;

                    match(input,12,FOLLOW_12_in_ifStatement103); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_ifStatement107);
                    x=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,13,FOLLOW_13_in_ifStatement109); if (state.failed) return result;

                    match(input,31,FOLLOW_31_in_ifStatement111); if (state.failed) return result;

                    // QL.g:33:30: (q= question )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==Ident) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // QL.g:33:31: q= question
                    	    {
                    	    pushFollow(FOLLOW_question_in_ifStatement116);
                    	    q=question();

                    	    state._fsp--;
                    	    if (state.failed) return result;

                    	    if ( state.backtracking==0 ) {list.add(q);}

                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


                    match(input,33,FOLLOW_33_in_ifStatement122); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new IfStatement(x, list); }

                    }
                    break;
                case 2 :
                    // QL.g:34:4: 
                    {
                    if ( state.backtracking==0 ) { result = null; }

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
            if ( state.backtracking>0 ) { memoize(input, 2, ifStatement_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "ifStatement"



    // $ANTLR start "question"
    // QL.g:37:1: question returns [Question result] : Ident ':' Str type ;
    public final Question question() throws RecognitionException {
        Question result = null;

        int question_StartIndex = input.index();

        Token Ident3=null;
        Token Str4=null;
        Type type5 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

            // QL.g:38:2: ( Ident ':' Str type )
            // QL.g:38:4: Ident ':' Str type
            {
            Ident3=(Token)match(input,Ident,FOLLOW_Ident_in_question145); if (state.failed) return result;

            match(input,18,FOLLOW_18_in_question147); if (state.failed) return result;

            Str4=(Token)match(input,Str,FOLLOW_Str_in_question149); if (state.failed) return result;

            pushFollow(FOLLOW_type_in_question151);
            type5=type();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new Question(new Ident((Ident3!=null?Ident3.getText():null)), new Str((Str4!=null?Str4.getText():null)), type5); }

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



    // $ANTLR start "type"
    // QL.g:41:1: type returns [Type result] : ( 'boolean' | 'int' | 'string' | 'money' | 'money(' x= addExpr ')' );
    public final Type type() throws RecognitionException {
        Type result = null;

        int type_StartIndex = input.index();

        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

            // QL.g:42:2: ( 'boolean' | 'int' | 'string' | 'money' | 'money(' x= addExpr ')' )
            int alt4=5;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt4=1;
                }
                break;
            case 27:
                {
                alt4=2;
                }
                break;
            case 30:
                {
                alt4=3;
                }
                break;
            case 28:
                {
                alt4=4;
                }
                break;
            case 29:
                {
                alt4=5;
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
                    // QL.g:42:4: 'boolean'
                    {
                    match(input,24,FOLLOW_24_in_type168); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new BoolType(); }

                    }
                    break;
                case 2 :
                    // QL.g:43:4: 'int'
                    {
                    match(input,27,FOLLOW_27_in_type175); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new IntType(); }

                    }
                    break;
                case 3 :
                    // QL.g:44:4: 'string'
                    {
                    match(input,30,FOLLOW_30_in_type182); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new StrType(); }

                    }
                    break;
                case 4 :
                    // QL.g:45:4: 'money'
                    {
                    match(input,28,FOLLOW_28_in_type189); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new MoneyType(); }

                    }
                    break;
                case 5 :
                    // QL.g:46:4: 'money(' x= addExpr ')'
                    {
                    match(input,29,FOLLOW_29_in_type196); if (state.failed) return result;

                    pushFollow(FOLLOW_addExpr_in_type200);
                    x=addExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,13,FOLLOW_13_in_type202); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new MoneyExprType(x); }

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
            if ( state.backtracking>0 ) { memoize(input, 4, type_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "type"



    // $ANTLR start "primary"
    // QL.g:49:1: primary returns [Expr result] : ( Int | Ident | Str | '(' x= orExpr ')' );
    public final Expr primary() throws RecognitionException {
        Expr result = null;

        int primary_StartIndex = input.index();

        Token Int6=null;
        Token Ident7=null;
        Token Str8=null;
        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

            // QL.g:50:3: ( Int | Ident | Str | '(' x= orExpr ')' )
            int alt5=4;
            switch ( input.LA(1) ) {
            case Int:
                {
                alt5=1;
                }
                break;
            case Ident:
                {
                alt5=2;
                }
                break;
            case Str:
                {
                alt5=3;
                }
                break;
            case 12:
                {
                alt5=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }

            switch (alt5) {
                case 1 :
                    // QL.g:50:5: Int
                    {
                    Int6=(Token)match(input,Int,FOLLOW_Int_in_primary220); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int6!=null?Int6.getText():null))); }

                    }
                    break;
                case 2 :
                    // QL.g:51:5: Ident
                    {
                    Ident7=(Token)match(input,Ident,FOLLOW_Ident_in_primary230); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Ident((Ident7!=null?Ident7.getText():null)); }

                    }
                    break;
                case 3 :
                    // QL.g:52:5: Str
                    {
                    Str8=(Token)match(input,Str,FOLLOW_Str_in_primary238); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Str((Str8!=null?Str8.getText():null)); }

                    }
                    break;
                case 4 :
                    // QL.g:53:5: '(' x= orExpr ')'
                    {
                    match(input,12,FOLLOW_12_in_primary248); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_primary252);
                    x=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,13,FOLLOW_13_in_primary254); if (state.failed) return result;

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
    // QL.g:56:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
    public final Expr unExpr() throws RecognitionException {
        Expr result = null;

        int unExpr_StartIndex = input.index();

        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

            // QL.g:57:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
            int alt6=4;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt6=1;
                }
                break;
            case 16:
                {
                alt6=2;
                }
                break;
            case 9:
                {
                alt6=3;
                }
                break;
            case Ident:
            case Int:
            case Str:
            case 12:
                {
                alt6=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }

            switch (alt6) {
                case 1 :
                    // QL.g:57:8: '+' x= unExpr
                    {
                    match(input,15,FOLLOW_15_in_unExpr279); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr283);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Pos(x); }

                    }
                    break;
                case 2 :
                    // QL.g:58:8: '-' x= unExpr
                    {
                    match(input,16,FOLLOW_16_in_unExpr294); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr298);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Neg(x); }

                    }
                    break;
                case 3 :
                    // QL.g:59:8: '!' x= unExpr
                    {
                    match(input,9,FOLLOW_9_in_unExpr309); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr313);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Not(x); }

                    }
                    break;
                case 4 :
                    // QL.g:60:8: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpr326);
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
    // QL.g:63:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expr mulExpr() throws RecognitionException {
        Expr result = null;

        int mulExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

            // QL.g:64:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // QL.g:64:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr364);
            lhs=unExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // QL.g:64:45: (op= ( '*' | '/' ) rhs= unExpr )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==14||LA7_0==17) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // QL.g:64:47: op= ( '*' | '/' ) rhs= unExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==14||input.LA(1)==17 ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_unExpr_in_mulExpr384);
            	    rhs=unExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { 
            	          if ((op!=null?op.getText():null).equals("*")) {
            	            result = new Mul(result, rhs);
            	          }
            	          if ((op!=null?op.getText():null).equals("/")) {
            	            result = new Div(result, rhs);      
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
            if ( state.backtracking>0 ) { memoize(input, 7, mulExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "mulExpr"



    // $ANTLR start "addExpr"
    // QL.g:76:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expr addExpr() throws RecognitionException {
        Expr result = null;

        int addExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

            // QL.g:77:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // QL.g:77:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr425);
            lhs=mulExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // QL.g:77:46: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0 >= 15 && LA8_0 <= 16)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // QL.g:77:48: op= ( '+' | '-' ) rhs= mulExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( (input.LA(1) >= 15 && input.LA(1) <= 16) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_mulExpr_in_addExpr443);
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
            if ( state.backtracking>0 ) { memoize(input, 8, addExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "addExpr"



    // $ANTLR start "relExpr"
    // QL.g:88:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expr relExpr() throws RecognitionException {
        Expr result = null;

        int relExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

            // QL.g:89:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // QL.g:89:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr478);
            lhs=addExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // QL.g:89:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==10||(LA9_0 >= 19 && LA9_0 <= 23)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // QL.g:89:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==10||(input.LA(1) >= 19 && input.LA(1) <= 23) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_addExpr_in_relExpr502);
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
            if ( state.backtracking>0 ) { memoize(input, 9, relExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "relExpr"



    // $ANTLR start "andExpr"
    // QL.g:112:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expr andExpr() throws RecognitionException {
        Expr result = null;

        int andExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

            // QL.g:113:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // QL.g:113:9: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr540);
            lhs=relExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // QL.g:113:46: ( '&&' rhs= relExpr )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==11) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // QL.g:113:48: '&&' rhs= relExpr
            	    {
            	    match(input,11,FOLLOW_11_in_andExpr546); if (state.failed) return result;

            	    pushFollow(FOLLOW_relExpr_in_andExpr550);
            	    rhs=relExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new And(result, rhs); }

            	    }
            	    break;

            	default :
            	    break loop10;
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
    // QL.g:117:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final Expr orExpr() throws RecognitionException {
        Expr result = null;

        int orExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

            // QL.g:118:5: (lhs= andExpr ( '||' rhs= andExpr )* )
            // QL.g:118:9: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr585);
            lhs=andExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = lhs; }

            // QL.g:118:48: ( '||' rhs= andExpr )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==32) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // QL.g:118:50: '||' rhs= andExpr
            	    {
            	    match(input,32,FOLLOW_32_in_orExpr591); if (state.failed) return result;

            	    pushFollow(FOLLOW_andExpr_in_orExpr595);
            	    rhs=andExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new Or(result, rhs); }

            	    }
            	    break;

            	default :
            	    break loop11;
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

    // Delegated rules


 

    public static final BitSet FOLLOW_25_in_form59 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_Ident_in_form61 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_form63 = new BitSet(new long[]{0x0000000204000020L});
    public static final BitSet FOLLOW_question_in_form68 = new BitSet(new long[]{0x0000000204000020L});
    public static final BitSet FOLLOW_ifStatement_in_form74 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_form76 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_form78 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ifStatement101 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ifStatement103 = new BitSet(new long[]{0x00000000000192E0L});
    public static final BitSet FOLLOW_orExpr_in_ifStatement107 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ifStatement109 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ifStatement111 = new BitSet(new long[]{0x0000000200000020L});
    public static final BitSet FOLLOW_question_in_ifStatement116 = new BitSet(new long[]{0x0000000200000020L});
    public static final BitSet FOLLOW_33_in_ifStatement122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_question145 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_question147 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_Str_in_question149 = new BitSet(new long[]{0x0000000079000000L});
    public static final BitSet FOLLOW_type_in_question151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_type168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_type175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_type182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_type189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_type196 = new BitSet(new long[]{0x00000000000192E0L});
    public static final BitSet FOLLOW_addExpr_in_type200 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_type202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Int_in_primary220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_primary230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Str_in_primary238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_primary248 = new BitSet(new long[]{0x00000000000192E0L});
    public static final BitSet FOLLOW_orExpr_in_primary252 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_primary254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_unExpr279 = new BitSet(new long[]{0x00000000000192E0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_unExpr294 = new BitSet(new long[]{0x00000000000192E0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_9_in_unExpr309 = new BitSet(new long[]{0x00000000000192E0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr364 = new BitSet(new long[]{0x0000000000024002L});
    public static final BitSet FOLLOW_set_in_mulExpr372 = new BitSet(new long[]{0x00000000000192E0L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr384 = new BitSet(new long[]{0x0000000000024002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr425 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_set_in_addExpr433 = new BitSet(new long[]{0x00000000000192E0L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr443 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr478 = new BitSet(new long[]{0x0000000000F80402L});
    public static final BitSet FOLLOW_set_in_relExpr486 = new BitSet(new long[]{0x00000000000192E0L});
    public static final BitSet FOLLOW_addExpr_in_relExpr502 = new BitSet(new long[]{0x0000000000F80402L});
    public static final BitSet FOLLOW_relExpr_in_andExpr540 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_11_in_andExpr546 = new BitSet(new long[]{0x00000000000192E0L});
    public static final BitSet FOLLOW_relExpr_in_andExpr550 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_andExpr_in_orExpr585 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_orExpr591 = new BitSet(new long[]{0x00000000000192E0L});
    public static final BitSet FOLLOW_andExpr_in_orExpr595 = new BitSet(new long[]{0x0000000100000002L});

}