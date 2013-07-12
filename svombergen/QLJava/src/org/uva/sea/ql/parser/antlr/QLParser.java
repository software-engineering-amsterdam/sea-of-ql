// $ANTLR 3.4 QL.g 2013-07-12 02:19:18

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.unaryexpr.*;
import org.uva.sea.ql.ast.binaryexpr.*;
import org.uva.sea.ql.ast.primaryexpr.*;
import org.uva.sea.ql.ast.statements.*;
import org.uva.sea.ql.ast.statements.types.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Bool", "COMMENT", "Ident", "Int", "Str", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'boolean'", "'form'", "'if'", "'int'", "'string'", "'{'", "'||'", "'}'"
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
    public static final int Bool=4;
    public static final int COMMENT=5;
    public static final int Ident=6;
    public static final int Int=7;
    public static final int Str=8;
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
        this.state.ruleMemo = new HashMap[37+1];
         

    }

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "QL.g"; }


        @Override
        public void reportError(RecognitionException e) {
            throw new RuntimeException(e);
        }



    // $ANTLR start "form"
    // QL.g:26:1: form returns [Form result] : 'form' Ident '{' (s= statement )* '}' EOF ;
    public final Form form() throws RecognitionException {
        Form result = null;

        int form_StartIndex = input.index();

        Token Ident1=null;
        Statement s =null;


         List<Statement> list = new ArrayList<Statement>(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

            // QL.g:28:2: ( 'form' Ident '{' (s= statement )* '}' EOF )
            // QL.g:28:4: 'form' Ident '{' (s= statement )* '}' EOF
            {
            match(input,26,FOLLOW_26_in_form59); if (state.failed) return result;

            Ident1=(Token)match(input,Ident,FOLLOW_Ident_in_form61); if (state.failed) return result;

            match(input,30,FOLLOW_30_in_form63); if (state.failed) return result;

            // QL.g:28:21: (s= statement )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==Ident||LA1_0==27) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // QL.g:28:22: s= statement
            	    {
            	    pushFollow(FOLLOW_statement_in_form68);
            	    s=statement();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) {list.add(s);}

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            match(input,32,FOLLOW_32_in_form74); if (state.failed) return result;

            match(input,EOF,FOLLOW_EOF_in_form76); if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new Form(new Ident((Ident1!=null?Ident1.getText():null)), list); }

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



    // $ANTLR start "statement"
    // QL.g:31:1: statement returns [Statement result] : (q= question |i= ifStatement );
    public final Statement statement() throws RecognitionException {
        Statement result = null;

        int statement_StartIndex = input.index();

        Question q =null;

        IfStatement i =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

            // QL.g:32:2: (q= question |i= ifStatement )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==Ident) ) {
                alt2=1;
            }
            else if ( (LA2_0==27) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // QL.g:32:4: q= question
                    {
                    pushFollow(FOLLOW_question_in_statement96);
                    q=question();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = q; }

                    }
                    break;
                case 2 :
                    // QL.g:33:4: i= ifStatement
                    {
                    pushFollow(FOLLOW_ifStatement_in_statement105);
                    i=ifStatement();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = i; }

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
            if ( state.backtracking>0 ) { memoize(input, 2, statement_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "statement"



    // $ANTLR start "ifStatement"
    // QL.g:36:1: ifStatement returns [IfStatement result] : 'if' '(' x= orExpr ')' '{' (s= statement )* '}' ;
    public final IfStatement ifStatement() throws RecognitionException {
        IfStatement result = null;

        int ifStatement_StartIndex = input.index();

        Expr x =null;

        Statement s =null;


        List<Statement> list = new ArrayList<Statement>(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

            // QL.g:38:2: ( 'if' '(' x= orExpr ')' '{' (s= statement )* '}' )
            // QL.g:38:4: 'if' '(' x= orExpr ')' '{' (s= statement )* '}'
            {
            match(input,27,FOLLOW_27_in_ifStatement128); if (state.failed) return result;

            match(input,13,FOLLOW_13_in_ifStatement130); if (state.failed) return result;

            pushFollow(FOLLOW_orExpr_in_ifStatement134);
            x=orExpr();

            state._fsp--;
            if (state.failed) return result;

            match(input,14,FOLLOW_14_in_ifStatement136); if (state.failed) return result;

            match(input,30,FOLLOW_30_in_ifStatement138); if (state.failed) return result;

            // QL.g:38:30: (s= statement )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==Ident||LA3_0==27) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // QL.g:38:31: s= statement
            	    {
            	    pushFollow(FOLLOW_statement_in_ifStatement143);
            	    s=statement();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) {list.add(s);}

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            match(input,32,FOLLOW_32_in_ifStatement149); if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new IfStatement(x, list); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, ifStatement_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "ifStatement"



    // $ANTLR start "question"
    // QL.g:41:1: question returns [Question result] : ( Ident ':' Str type primary | Ident ':' Str type );
    public final Question question() throws RecognitionException {
        Question result = null;

        int question_StartIndex = input.index();

        Token Ident2=null;
        Token Str4=null;
        Token Ident6=null;
        Token Str8=null;
        Type type3 =null;

        Expr primary5 =null;

        Type type7 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

            // QL.g:42:2: ( Ident ':' Str type primary | Ident ':' Str type )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==Ident) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==19) ) {
                    int LA4_2 = input.LA(3);

                    if ( (LA4_2==Str) ) {
                        switch ( input.LA(4) ) {
                        case 25:
                            {
                            switch ( input.LA(5) ) {
                            case Bool:
                            case Int:
                            case Str:
                            case 13:
                                {
                                alt4=1;
                                }
                                break;
                            case Ident:
                                {
                                int LA4_8 = input.LA(6);

                                if ( (LA4_8==19) ) {
                                    alt4=2;
                                }
                                else if ( (LA4_8==EOF||LA4_8==Ident||LA4_8==27||LA4_8==32) ) {
                                    alt4=1;
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return result;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 4, 8, input);

                                    throw nvae;

                                }
                                }
                                break;
                            case EOF:
                            case 27:
                            case 32:
                                {
                                alt4=2;
                                }
                                break;
                            default:
                                if (state.backtracking>0) {state.failed=true; return result;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 4, 4, input);

                                throw nvae;

                            }

                            }
                            break;
                        case 28:
                            {
                            switch ( input.LA(5) ) {
                            case Bool:
                            case Int:
                            case Str:
                            case 13:
                                {
                                alt4=1;
                                }
                                break;
                            case Ident:
                                {
                                int LA4_8 = input.LA(6);

                                if ( (LA4_8==19) ) {
                                    alt4=2;
                                }
                                else if ( (LA4_8==EOF||LA4_8==Ident||LA4_8==27||LA4_8==32) ) {
                                    alt4=1;
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return result;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 4, 8, input);

                                    throw nvae;

                                }
                                }
                                break;
                            case EOF:
                            case 27:
                            case 32:
                                {
                                alt4=2;
                                }
                                break;
                            default:
                                if (state.backtracking>0) {state.failed=true; return result;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 4, 5, input);

                                throw nvae;

                            }

                            }
                            break;
                        case 29:
                            {
                            switch ( input.LA(5) ) {
                            case Bool:
                            case Int:
                            case Str:
                            case 13:
                                {
                                alt4=1;
                                }
                                break;
                            case Ident:
                                {
                                int LA4_8 = input.LA(6);

                                if ( (LA4_8==19) ) {
                                    alt4=2;
                                }
                                else if ( (LA4_8==EOF||LA4_8==Ident||LA4_8==27||LA4_8==32) ) {
                                    alt4=1;
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return result;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 4, 8, input);

                                    throw nvae;

                                }
                                }
                                break;
                            case EOF:
                            case 27:
                            case 32:
                                {
                                alt4=2;
                                }
                                break;
                            default:
                                if (state.backtracking>0) {state.failed=true; return result;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 4, 6, input);

                                throw nvae;

                            }

                            }
                            break;
                        default:
                            if (state.backtracking>0) {state.failed=true; return result;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 4, 3, input);

                            throw nvae;

                        }

                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return result;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 2, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return result;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }
            switch (alt4) {
                case 1 :
                    // QL.g:42:4: Ident ':' Str type primary
                    {
                    Ident2=(Token)match(input,Ident,FOLLOW_Ident_in_question167); if (state.failed) return result;

                    match(input,19,FOLLOW_19_in_question169); if (state.failed) return result;

                    Str4=(Token)match(input,Str,FOLLOW_Str_in_question171); if (state.failed) return result;

                    pushFollow(FOLLOW_type_in_question173);
                    type3=type();

                    state._fsp--;
                    if (state.failed) return result;

                    pushFollow(FOLLOW_primary_in_question175);
                    primary5=primary();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new ComputableQuestion(new Ident((Ident2!=null?Ident2.getText():null), type3), new Str((Str4!=null?Str4.getText():null)), type3, primary5); }

                    }
                    break;
                case 2 :
                    // QL.g:43:4: Ident ':' Str type
                    {
                    Ident6=(Token)match(input,Ident,FOLLOW_Ident_in_question183); if (state.failed) return result;

                    match(input,19,FOLLOW_19_in_question185); if (state.failed) return result;

                    Str8=(Token)match(input,Str,FOLLOW_Str_in_question187); if (state.failed) return result;

                    pushFollow(FOLLOW_type_in_question189);
                    type7=type();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new AnswerableQuestion(new Ident((Ident6!=null?Ident6.getText():null), type7), new Str((Str8!=null?Str8.getText():null)), type7); }

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
            if ( state.backtracking>0 ) { memoize(input, 4, question_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "question"



    // $ANTLR start "type"
    // QL.g:46:1: type returns [Type result] : ( 'boolean' | 'int' | 'string' );
    public final Type type() throws RecognitionException {
        Type result = null;

        int type_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

            // QL.g:47:2: ( 'boolean' | 'int' | 'string' )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt5=1;
                }
                break;
            case 28:
                {
                alt5=2;
                }
                break;
            case 29:
                {
                alt5=3;
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
                    // QL.g:47:4: 'boolean'
                    {
                    match(input,25,FOLLOW_25_in_type206); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new BoolType(); }

                    }
                    break;
                case 2 :
                    // QL.g:48:4: 'int'
                    {
                    match(input,28,FOLLOW_28_in_type213); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new IntType(); }

                    }
                    break;
                case 3 :
                    // QL.g:49:4: 'string'
                    {
                    match(input,29,FOLLOW_29_in_type220); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new StrType(); }

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
            if ( state.backtracking>0 ) { memoize(input, 5, type_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "type"



    // $ANTLR start "primary"
    // QL.g:52:1: primary returns [Expr result] : ( Int | Str | Bool | Ident | '(' x= orExpr ')' );
    public final Expr primary() throws RecognitionException {
        Expr result = null;

        int primary_StartIndex = input.index();

        Token Int9=null;
        Token Str10=null;
        Token Bool11=null;
        Token Ident12=null;
        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

            // QL.g:53:3: ( Int | Str | Bool | Ident | '(' x= orExpr ')' )
            int alt6=5;
            switch ( input.LA(1) ) {
            case Int:
                {
                alt6=1;
                }
                break;
            case Str:
                {
                alt6=2;
                }
                break;
            case Bool:
                {
                alt6=3;
                }
                break;
            case Ident:
                {
                alt6=4;
                }
                break;
            case 13:
                {
                alt6=5;
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
                    // QL.g:53:5: Int
                    {
                    Int9=(Token)match(input,Int,FOLLOW_Int_in_primary238); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int9!=null?Int9.getText():null))); }

                    }
                    break;
                case 2 :
                    // QL.g:54:5: Str
                    {
                    Str10=(Token)match(input,Str,FOLLOW_Str_in_primary248); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Str((Str10!=null?Str10.getText():null)); }

                    }
                    break;
                case 3 :
                    // QL.g:55:5: Bool
                    {
                    Bool11=(Token)match(input,Bool,FOLLOW_Bool_in_primary258); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Bool(Boolean.parseBoolean((Bool11!=null?Bool11.getText():null))); }

                    }
                    break;
                case 4 :
                    // QL.g:56:5: Ident
                    {
                    Ident12=(Token)match(input,Ident,FOLLOW_Ident_in_primary267); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Ident((Ident12!=null?Ident12.getText():null)); }

                    }
                    break;
                case 5 :
                    // QL.g:57:5: '(' x= orExpr ')'
                    {
                    match(input,13,FOLLOW_13_in_primary275); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_primary279);
                    x=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,14,FOLLOW_14_in_primary281); if (state.failed) return result;

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
            if ( state.backtracking>0 ) { memoize(input, 6, primary_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "primary"



    // $ANTLR start "unExpr"
    // QL.g:60:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
    public final Expr unExpr() throws RecognitionException {
        Expr result = null;

        int unExpr_StartIndex = input.index();

        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

            // QL.g:61:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
            int alt7=4;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt7=1;
                }
                break;
            case 17:
                {
                alt7=2;
                }
                break;
            case 10:
                {
                alt7=3;
                }
                break;
            case Bool:
            case Ident:
            case Int:
            case Str:
            case 13:
                {
                alt7=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }

            switch (alt7) {
                case 1 :
                    // QL.g:61:8: '+' x= unExpr
                    {
                    match(input,16,FOLLOW_16_in_unExpr306); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr310);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Pos(x); }

                    }
                    break;
                case 2 :
                    // QL.g:62:8: '-' x= unExpr
                    {
                    match(input,17,FOLLOW_17_in_unExpr321); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr325);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Neg(x); }

                    }
                    break;
                case 3 :
                    // QL.g:63:8: '!' x= unExpr
                    {
                    match(input,10,FOLLOW_10_in_unExpr336); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr340);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Not(x); }

                    }
                    break;
                case 4 :
                    // QL.g:64:8: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpr353);
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
            if ( state.backtracking>0 ) { memoize(input, 7, unExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "unExpr"



    // $ANTLR start "mulExpr"
    // QL.g:67:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expr mulExpr() throws RecognitionException {
        Expr result = null;

        int mulExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

            // QL.g:68:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // QL.g:68:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr391);
            lhs=unExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // QL.g:68:45: (op= ( '*' | '/' ) rhs= unExpr )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==15||LA8_0==18) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // QL.g:68:47: op= ( '*' | '/' ) rhs= unExpr
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


            	    pushFollow(FOLLOW_unExpr_in_mulExpr411);
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
            if ( state.backtracking>0 ) { memoize(input, 8, mulExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "mulExpr"



    // $ANTLR start "addExpr"
    // QL.g:80:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expr addExpr() throws RecognitionException {
        Expr result = null;

        int addExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

            // QL.g:81:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // QL.g:81:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr452);
            lhs=mulExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // QL.g:81:46: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0 >= 16 && LA9_0 <= 17)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // QL.g:81:48: op= ( '+' | '-' ) rhs= mulExpr
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


            	    pushFollow(FOLLOW_mulExpr_in_addExpr470);
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
            if ( state.backtracking>0 ) { memoize(input, 9, addExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "addExpr"



    // $ANTLR start "relExpr"
    // QL.g:92:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expr relExpr() throws RecognitionException {
        Expr result = null;

        int relExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

            // QL.g:93:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // QL.g:93:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr505);
            lhs=addExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // QL.g:93:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==11||(LA10_0 >= 20 && LA10_0 <= 24)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // QL.g:93:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
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


            	    pushFollow(FOLLOW_addExpr_in_relExpr529);
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
            if ( state.backtracking>0 ) { memoize(input, 10, relExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "relExpr"



    // $ANTLR start "andExpr"
    // QL.g:116:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expr andExpr() throws RecognitionException {
        Expr result = null;

        int andExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

            // QL.g:117:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // QL.g:117:9: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr567);
            lhs=relExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // QL.g:117:46: ( '&&' rhs= relExpr )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==12) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // QL.g:117:48: '&&' rhs= relExpr
            	    {
            	    match(input,12,FOLLOW_12_in_andExpr573); if (state.failed) return result;

            	    pushFollow(FOLLOW_relExpr_in_andExpr577);
            	    rhs=relExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new And(result, rhs); }

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
            if ( state.backtracking>0 ) { memoize(input, 11, andExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "andExpr"



    // $ANTLR start "orExpr"
    // QL.g:121:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final Expr orExpr() throws RecognitionException {
        Expr result = null;

        int orExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

            // QL.g:122:5: (lhs= andExpr ( '||' rhs= andExpr )* )
            // QL.g:122:9: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr612);
            lhs=andExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = lhs; }

            // QL.g:122:48: ( '||' rhs= andExpr )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==31) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // QL.g:122:50: '||' rhs= andExpr
            	    {
            	    match(input,31,FOLLOW_31_in_orExpr618); if (state.failed) return result;

            	    pushFollow(FOLLOW_andExpr_in_orExpr622);
            	    rhs=andExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new Or(result, rhs); }

            	    }
            	    break;

            	default :
            	    break loop12;
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
            if ( state.backtracking>0 ) { memoize(input, 12, orExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "orExpr"

    // Delegated rules


 

    public static final BitSet FOLLOW_26_in_form59 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Ident_in_form61 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_form63 = new BitSet(new long[]{0x0000000108000040L});
    public static final BitSet FOLLOW_statement_in_form68 = new BitSet(new long[]{0x0000000108000040L});
    public static final BitSet FOLLOW_32_in_form74 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_form76 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_question_in_statement96 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_statement105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ifStatement128 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ifStatement130 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_orExpr_in_ifStatement134 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ifStatement136 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ifStatement138 = new BitSet(new long[]{0x0000000108000040L});
    public static final BitSet FOLLOW_statement_in_ifStatement143 = new BitSet(new long[]{0x0000000108000040L});
    public static final BitSet FOLLOW_32_in_ifStatement149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_question167 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_question169 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_Str_in_question171 = new BitSet(new long[]{0x0000000032000000L});
    public static final BitSet FOLLOW_type_in_question173 = new BitSet(new long[]{0x00000000000021D0L});
    public static final BitSet FOLLOW_primary_in_question175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_question183 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_question185 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_Str_in_question187 = new BitSet(new long[]{0x0000000032000000L});
    public static final BitSet FOLLOW_type_in_question189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_type206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_type213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_type220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Int_in_primary238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Str_in_primary248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Bool_in_primary258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_primary267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_primary275 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_orExpr_in_primary279 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_primary281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_unExpr306 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_unExpr321 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_unExpr336 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr391 = new BitSet(new long[]{0x0000000000048002L});
    public static final BitSet FOLLOW_set_in_mulExpr399 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr411 = new BitSet(new long[]{0x0000000000048002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr452 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_set_in_addExpr460 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr470 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr505 = new BitSet(new long[]{0x0000000001F00802L});
    public static final BitSet FOLLOW_set_in_relExpr513 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_addExpr_in_relExpr529 = new BitSet(new long[]{0x0000000001F00802L});
    public static final BitSet FOLLOW_relExpr_in_andExpr567 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_andExpr573 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_relExpr_in_andExpr577 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr612 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_orExpr618 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_andExpr_in_orExpr622 = new BitSet(new long[]{0x0000000080000002L});

}