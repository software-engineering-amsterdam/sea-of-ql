// $ANTLR 3.4 C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2013-03-18 20:18:23

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expressions.*;
import org.uva.sea.ql.ast.expressions.binaryExpressions.*;
import org.uva.sea.ql.ast.expressions.unaryExpressions.*;
import org.uva.sea.ql.ast.statements.*;
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BOOLEAN", "COMMENT", "IDENT", "INT", "STRING_LITERAL", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'boolean'", "'else'", "'form'", "'if'", "'int'", "'string'", "'{'", "'||'", "'}'"
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
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int BOOLEAN=4;
    public static final int COMMENT=5;
    public static final int IDENT=6;
    public static final int INT=7;
    public static final int STRING_LITERAL=8;
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
        this.state.ruleMemo = new HashMap[40+1];
         

    }

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g"; }



    // $ANTLR start "form"
    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:20:1: form returns [Form result] : 'form' IDENT b= blockOfStatements ;
    public final Form form() throws RecognitionException {
        Form result = null;

        int form_StartIndex = input.index();

        Token IDENT1=null;
        BlockOfStatements b =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:21:4: ( 'form' IDENT b= blockOfStatements )
            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:21:6: 'form' IDENT b= blockOfStatements
            {
            match(input,27,FOLLOW_27_in_form47); if (state.failed) return result;

            IDENT1=(Token)match(input,IDENT,FOLLOW_IDENT_in_form49); if (state.failed) return result;

            pushFollow(FOLLOW_blockOfStatements_in_form53);
            b=blockOfStatements();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new Form(new Ident((IDENT1!=null?IDENT1.getText():null)), b);}

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



    // $ANTLR start "blockOfStatements"
    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:24:1: blockOfStatements returns [BlockOfStatements result] : '{' (s= statement )+ '}' ;
    public final BlockOfStatements blockOfStatements() throws RecognitionException {
        BlockOfStatements result = null;

        int blockOfStatements_StartIndex = input.index();

        AStatement s =null;


         List<AStatement> stmts = new ArrayList<AStatement>(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:26:5: ( '{' (s= statement )+ '}' )
            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:26:7: '{' (s= statement )+ '}'
            {
            match(input,31,FOLLOW_31_in_blockOfStatements84); if (state.failed) return result;

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:26:11: (s= statement )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==IDENT||LA1_0==28) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:26:12: s= statement
            	    {
            	    pushFollow(FOLLOW_statement_in_blockOfStatements89);
            	    s=statement();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { stmts.add(s); }

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return result;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            match(input,33,FOLLOW_33_in_blockOfStatements96); if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new BlockOfStatements(stmts); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, blockOfStatements_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "blockOfStatements"



    // $ANTLR start "statement"
    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:29:1: statement returns [AStatement result] : (ifES= ifElseStatement |ifS= ifStatement |cQ= computedQuestion |q= question );
    public final AStatement statement() throws RecognitionException {
        AStatement result = null;

        int statement_StartIndex = input.index();

        ifElseStatement ifES =null;

        ifStatement ifS =null;

        ComputedQuestion cQ =null;

        Question q =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:30:5: (ifES= ifElseStatement |ifS= ifStatement |cQ= computedQuestion |q= question )
            int alt2=4;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==28) ) {
                int LA2_1 = input.LA(2);

                if ( (synpred2_QL()) ) {
                    alt2=1;
                }
                else if ( (synpred3_QL()) ) {
                    alt2=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return result;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA2_0==IDENT) ) {
                int LA2_2 = input.LA(2);

                if ( (synpred4_QL()) ) {
                    alt2=3;
                }
                else if ( (true) ) {
                    alt2=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return result;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 2, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:30:7: ifES= ifElseStatement
                    {
                    pushFollow(FOLLOW_ifElseStatement_in_statement121);
                    ifES=ifElseStatement();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = ifES; }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:31:7: ifS= ifStatement
                    {
                    pushFollow(FOLLOW_ifStatement_in_statement134);
                    ifS=ifStatement();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = ifS; }

                    }
                    break;
                case 3 :
                    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:32:7: cQ= computedQuestion
                    {
                    pushFollow(FOLLOW_computedQuestion_in_statement152);
                    cQ=computedQuestion();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = cQ; }

                    }
                    break;
                case 4 :
                    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:33:7: q= question
                    {
                    pushFollow(FOLLOW_question_in_statement166);
                    q=question();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = q; }

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
            if ( state.backtracking>0 ) { memoize(input, 3, statement_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "statement"



    // $ANTLR start "ifElseStatement"
    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:36:1: ifElseStatement returns [ifElseStatement result] : 'if' '(' x= orExpr ')' bIf= blockOfStatements 'else' bElse= blockOfStatements ;
    public final ifElseStatement ifElseStatement() throws RecognitionException {
        ifElseStatement result = null;

        int ifElseStatement_StartIndex = input.index();

        AExpr x =null;

        BlockOfStatements bIf =null;

        BlockOfStatements bElse =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:37:5: ( 'if' '(' x= orExpr ')' bIf= blockOfStatements 'else' bElse= blockOfStatements )
            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:37:7: 'if' '(' x= orExpr ')' bIf= blockOfStatements 'else' bElse= blockOfStatements
            {
            match(input,28,FOLLOW_28_in_ifElseStatement201); if (state.failed) return result;

            match(input,13,FOLLOW_13_in_ifElseStatement203); if (state.failed) return result;

            pushFollow(FOLLOW_orExpr_in_ifElseStatement207);
            x=orExpr();

            state._fsp--;
            if (state.failed) return result;

            match(input,14,FOLLOW_14_in_ifElseStatement209); if (state.failed) return result;

            pushFollow(FOLLOW_blockOfStatements_in_ifElseStatement213);
            bIf=blockOfStatements();

            state._fsp--;
            if (state.failed) return result;

            match(input,26,FOLLOW_26_in_ifElseStatement215); if (state.failed) return result;

            pushFollow(FOLLOW_blockOfStatements_in_ifElseStatement219);
            bElse=blockOfStatements();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new ifElseStatement(x, bIf, bElse); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, ifElseStatement_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "ifElseStatement"



    // $ANTLR start "ifStatement"
    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:41:1: ifStatement returns [ifStatement result] : 'if' '(' x= orExpr ')' b= blockOfStatements ;
    public final ifStatement ifStatement() throws RecognitionException {
        ifStatement result = null;

        int ifStatement_StartIndex = input.index();

        AExpr x =null;

        BlockOfStatements b =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:42:5: ( 'if' '(' x= orExpr ')' b= blockOfStatements )
            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:42:7: 'if' '(' x= orExpr ')' b= blockOfStatements
            {
            match(input,28,FOLLOW_28_in_ifStatement248); if (state.failed) return result;

            match(input,13,FOLLOW_13_in_ifStatement250); if (state.failed) return result;

            pushFollow(FOLLOW_orExpr_in_ifStatement254);
            x=orExpr();

            state._fsp--;
            if (state.failed) return result;

            match(input,14,FOLLOW_14_in_ifStatement256); if (state.failed) return result;

            pushFollow(FOLLOW_blockOfStatements_in_ifStatement260);
            b=blockOfStatements();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new ifStatement(x, b); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, ifStatement_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "ifStatement"



    // $ANTLR start "computedQuestion"
    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:45:1: computedQuestion returns [ComputedQuestion result] : IDENT ':' STRING_LITERAL type '(' x= orExpr ')' ;
    public final ComputedQuestion computedQuestion() throws RecognitionException {
        ComputedQuestion result = null;

        int computedQuestion_StartIndex = input.index();

        Token IDENT2=null;
        Token STRING_LITERAL3=null;
        AExpr x =null;

        AType type4 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:46:4: ( IDENT ':' STRING_LITERAL type '(' x= orExpr ')' )
            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:46:6: IDENT ':' STRING_LITERAL type '(' x= orExpr ')'
            {
            IDENT2=(Token)match(input,IDENT,FOLLOW_IDENT_in_computedQuestion282); if (state.failed) return result;

            match(input,19,FOLLOW_19_in_computedQuestion284); if (state.failed) return result;

            STRING_LITERAL3=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_computedQuestion286); if (state.failed) return result;

            pushFollow(FOLLOW_type_in_computedQuestion288);
            type4=type();

            state._fsp--;
            if (state.failed) return result;

            match(input,13,FOLLOW_13_in_computedQuestion290); if (state.failed) return result;

            pushFollow(FOLLOW_orExpr_in_computedQuestion294);
            x=orExpr();

            state._fsp--;
            if (state.failed) return result;

            match(input,14,FOLLOW_14_in_computedQuestion296); if (state.failed) return result;

            if ( state.backtracking==0 ) {
            	    result =
            	      new ComputedQuestion(new Ident((IDENT2!=null?IDENT2.getText():null)), (STRING_LITERAL3!=null?STRING_LITERAL3.getText():null),  type4, x);
            	  }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, computedQuestion_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "computedQuestion"



    // $ANTLR start "question"
    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:53:1: question returns [Question result] : IDENT ':' STRING_LITERAL type ;
    public final Question question() throws RecognitionException {
        Question result = null;

        int question_StartIndex = input.index();

        Token IDENT5=null;
        Token STRING_LITERAL6=null;
        AType type7 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:54:5: ( IDENT ':' STRING_LITERAL type )
            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:54:7: IDENT ':' STRING_LITERAL type
            {
            IDENT5=(Token)match(input,IDENT,FOLLOW_IDENT_in_question321); if (state.failed) return result;

            match(input,19,FOLLOW_19_in_question323); if (state.failed) return result;

            STRING_LITERAL6=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_question325); if (state.failed) return result;

            pushFollow(FOLLOW_type_in_question327);
            type7=type();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new Question(new Ident((IDENT5!=null?IDENT5.getText():null)), (STRING_LITERAL6!=null?STRING_LITERAL6.getText():null), type7); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, question_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "question"



    // $ANTLR start "type"
    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:58:1: type returns [AType result] : ( 'int' | 'boolean' | 'string' );
    public final AType type() throws RecognitionException {
        AType result = null;

        int type_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:59:5: ( 'int' | 'boolean' | 'string' )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt3=1;
                }
                break;
            case 25:
                {
                alt3=2;
                }
                break;
            case 30:
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
                    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:59:7: 'int'
                    {
                    match(input,29,FOLLOW_29_in_type354); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new IntType(); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:60:7: 'boolean'
                    {
                    match(input,25,FOLLOW_25_in_type368); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new BoolType(); }

                    }
                    break;
                case 3 :
                    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:61:7: 'string'
                    {
                    match(input,30,FOLLOW_30_in_type378); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new StringType(); }

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
            if ( state.backtracking>0 ) { memoize(input, 8, type_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "type"



    // $ANTLR start "primary"
    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:64:1: primary returns [AExpr result] : ( INT | IDENT | BOOLEAN | STRING_LITERAL | '(' x= orExpr ')' );
    public final AExpr primary() throws RecognitionException {
        AExpr result = null;

        int primary_StartIndex = input.index();

        Token INT8=null;
        Token IDENT9=null;
        Token BOOLEAN10=null;
        Token STRING_LITERAL11=null;
        AExpr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:65:5: ( INT | IDENT | BOOLEAN | STRING_LITERAL | '(' x= orExpr ')' )
            int alt4=5;
            switch ( input.LA(1) ) {
            case INT:
                {
                alt4=1;
                }
                break;
            case IDENT:
                {
                alt4=2;
                }
                break;
            case BOOLEAN:
                {
                alt4=3;
                }
                break;
            case STRING_LITERAL:
                {
                alt4=4;
                }
                break;
            case 13:
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
                    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:65:7: INT
                    {
                    INT8=(Token)match(input,INT,FOLLOW_INT_in_primary402); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new IntLiteral(Integer.parseInt((INT8!=null?INT8.getText():null))); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:66:6: IDENT
                    {
                    IDENT9=(Token)match(input,IDENT,FOLLOW_IDENT_in_primary423); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Ident((IDENT9!=null?IDENT9.getText():null)); }

                    }
                    break;
                case 3 :
                    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:67:6: BOOLEAN
                    {
                    BOOLEAN10=(Token)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_primary442); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new BoolLiteral(Boolean.parseBoolean((BOOLEAN10!=null?BOOLEAN10.getText():null))); }

                    }
                    break;
                case 4 :
                    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:68:6: STRING_LITERAL
                    {
                    STRING_LITERAL11=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_primary459); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new StrLiteral((STRING_LITERAL11!=null?STRING_LITERAL11.getText():null)); }

                    }
                    break;
                case 5 :
                    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:69:6: '(' x= orExpr ')'
                    {
                    match(input,13,FOLLOW_13_in_primary469); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_primary473);
                    x=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,14,FOLLOW_14_in_primary475); if (state.failed) return result;

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
            if ( state.backtracking>0 ) { memoize(input, 9, primary_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "primary"



    // $ANTLR start "unExpr"
    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:72:1: unExpr returns [AExpr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
    public final AExpr unExpr() throws RecognitionException {
        AExpr result = null;

        int unExpr_StartIndex = input.index();

        AExpr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:73:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
            int alt5=4;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt5=1;
                }
                break;
            case 17:
                {
                alt5=2;
                }
                break;
            case 10:
                {
                alt5=3;
                }
                break;
            case BOOLEAN:
            case IDENT:
            case INT:
            case STRING_LITERAL:
            case 13:
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
                    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:73:7: '+' x= unExpr
                    {
                    match(input,16,FOLLOW_16_in_unExpr500); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr504);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Pos(x); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:74:7: '-' x= unExpr
                    {
                    match(input,17,FOLLOW_17_in_unExpr514); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr518);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Neg(x); }

                    }
                    break;
                case 3 :
                    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:75:7: '!' x= unExpr
                    {
                    match(input,10,FOLLOW_10_in_unExpr528); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr532);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Not(x); }

                    }
                    break;
                case 4 :
                    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:76:7: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpr544);
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
            if ( state.backtracking>0 ) { memoize(input, 10, unExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "unExpr"



    // $ANTLR start "mulExpr"
    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:79:1: mulExpr returns [AExpr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final AExpr mulExpr() throws RecognitionException {
        AExpr result = null;

        int mulExpr_StartIndex = input.index();

        Token op=null;
        AExpr lhs =null;

        AExpr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:80:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:80:7: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr580);
            lhs=unExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:80:43: (op= ( '*' | '/' ) rhs= unExpr )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==15||LA6_0==18) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:80:45: op= ( '*' | '/' ) rhs= unExpr
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


            	    pushFollow(FOLLOW_unExpr_in_mulExpr600);
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
            if ( state.backtracking>0 ) { memoize(input, 11, mulExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "mulExpr"



    // $ANTLR start "addExpr"
    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:91:1: addExpr returns [AExpr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final AExpr addExpr() throws RecognitionException {
        AExpr result = null;

        int addExpr_StartIndex = input.index();

        Token op=null;
        AExpr lhs =null;

        AExpr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:92:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:92:7: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr636);
            lhs=mulExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:92:44: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0 >= 16 && LA7_0 <= 17)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:92:46: op= ( '+' | '-' ) rhs= mulExpr
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


            	    pushFollow(FOLLOW_mulExpr_in_addExpr654);
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
            if ( state.backtracking>0 ) { memoize(input, 12, addExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "addExpr"



    // $ANTLR start "relExpr"
    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:103:1: relExpr returns [AExpr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final AExpr relExpr() throws RecognitionException {
        AExpr result = null;

        int relExpr_StartIndex = input.index();

        Token op=null;
        AExpr lhs =null;

        AExpr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:104:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:104:7: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr687);
            lhs=addExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:104:44: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==11||(LA8_0 >= 20 && LA8_0 <= 24)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:104:46: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
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


            	    pushFollow(FOLLOW_addExpr_in_relExpr711);
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
            if ( state.backtracking>0 ) { memoize(input, 13, relExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "relExpr"



    // $ANTLR start "andExpr"
    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:127:1: andExpr returns [AExpr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final AExpr andExpr() throws RecognitionException {
        AExpr result = null;

        int andExpr_StartIndex = input.index();

        AExpr lhs =null;

        AExpr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return result; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:128:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:128:7: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr747);
            lhs=relExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:128:44: ( '&&' rhs= relExpr )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==12) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:128:46: '&&' rhs= relExpr
            	    {
            	    match(input,12,FOLLOW_12_in_andExpr753); if (state.failed) return result;

            	    pushFollow(FOLLOW_relExpr_in_andExpr757);
            	    rhs=relExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new And(result, rhs); }

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
            if ( state.backtracking>0 ) { memoize(input, 14, andExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "andExpr"



    // $ANTLR start "orExpr"
    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:132:1: orExpr returns [AExpr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final AExpr orExpr() throws RecognitionException {
        AExpr result = null;

        int orExpr_StartIndex = input.index();

        AExpr lhs =null;

        AExpr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return result; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:133:5: (lhs= andExpr ( '||' rhs= andExpr )* )
            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:133:7: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr790);
            lhs=andExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = lhs; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:133:46: ( '||' rhs= andExpr )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==32) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:133:48: '||' rhs= andExpr
            	    {
            	    match(input,32,FOLLOW_32_in_orExpr796); if (state.failed) return result;

            	    pushFollow(FOLLOW_andExpr_in_orExpr800);
            	    rhs=andExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new Or(result, rhs); }

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
            if ( state.backtracking>0 ) { memoize(input, 15, orExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "orExpr"

    // $ANTLR start synpred2_QL
    public final void synpred2_QL_fragment() throws RecognitionException {
        ifElseStatement ifES =null;


        // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:30:7: (ifES= ifElseStatement )
        // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:30:7: ifES= ifElseStatement
        {
        pushFollow(FOLLOW_ifElseStatement_in_synpred2_QL121);
        ifES=ifElseStatement();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred2_QL

    // $ANTLR start synpred3_QL
    public final void synpred3_QL_fragment() throws RecognitionException {
        ifStatement ifS =null;


        // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:31:7: (ifS= ifStatement )
        // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:31:7: ifS= ifStatement
        {
        pushFollow(FOLLOW_ifStatement_in_synpred3_QL134);
        ifS=ifStatement();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred3_QL

    // $ANTLR start synpred4_QL
    public final void synpred4_QL_fragment() throws RecognitionException {
        ComputedQuestion cQ =null;


        // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:32:7: (cQ= computedQuestion )
        // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:32:7: cQ= computedQuestion
        {
        pushFollow(FOLLOW_computedQuestion_in_synpred4_QL152);
        cQ=computedQuestion();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred4_QL

    // Delegated rules

    public final boolean synpred2_QL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_QL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_QL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_QL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_QL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_QL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_27_in_form47 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENT_in_form49 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_blockOfStatements_in_form53 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_blockOfStatements84 = new BitSet(new long[]{0x0000000010000040L});
    public static final BitSet FOLLOW_statement_in_blockOfStatements89 = new BitSet(new long[]{0x0000000210000040L});
    public static final BitSet FOLLOW_33_in_blockOfStatements96 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifElseStatement_in_statement121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_statement134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_computedQuestion_in_statement152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_question_in_statement166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ifElseStatement201 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ifElseStatement203 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_orExpr_in_ifElseStatement207 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ifElseStatement209 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_blockOfStatements_in_ifElseStatement213 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ifElseStatement215 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_blockOfStatements_in_ifElseStatement219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ifStatement248 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ifStatement250 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_orExpr_in_ifStatement254 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ifStatement256 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_blockOfStatements_in_ifStatement260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_computedQuestion282 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_computedQuestion284 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_computedQuestion286 = new BitSet(new long[]{0x0000000062000000L});
    public static final BitSet FOLLOW_type_in_computedQuestion288 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_computedQuestion290 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_orExpr_in_computedQuestion294 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_computedQuestion296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_question321 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_question323 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_question325 = new BitSet(new long[]{0x0000000062000000L});
    public static final BitSet FOLLOW_type_in_question327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_type354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_type368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_type378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_primary402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_primary423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_primary442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_primary459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_primary469 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_orExpr_in_primary473 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_primary475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_unExpr500 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_unExpr514 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_unExpr528 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr580 = new BitSet(new long[]{0x0000000000048002L});
    public static final BitSet FOLLOW_set_in_mulExpr588 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr600 = new BitSet(new long[]{0x0000000000048002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr636 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_set_in_addExpr644 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr654 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr687 = new BitSet(new long[]{0x0000000001F00802L});
    public static final BitSet FOLLOW_set_in_relExpr695 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_addExpr_in_relExpr711 = new BitSet(new long[]{0x0000000001F00802L});
    public static final BitSet FOLLOW_relExpr_in_andExpr747 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_andExpr753 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_relExpr_in_andExpr757 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr790 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_orExpr796 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_andExpr_in_orExpr800 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_ifElseStatement_in_synpred2_QL121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_synpred3_QL134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_computedQuestion_in_synpred4_QL152 = new BitSet(new long[]{0x0000000000000002L});

}