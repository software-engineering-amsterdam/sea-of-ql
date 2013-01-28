// $ANTLR 3.2 Sep 23, 2009 12:02:23 C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2013-01-24 19:10:05

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class QLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Ident", "Int", "WS", "COMMENT", "'form'", "'{'", "'}'", "'\"'", "':'", "'if ('", "')'", "'='", "'('", "'+'", "'-'", "'!'", "'*'", "'/'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'&&'", "'||'"
    };
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int T__9=9;
    public static final int T__8=8;
    public static final int Int=5;
    public static final int T__19=19;
    public static final int WS=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int Ident=4;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__10=10;
    public static final int COMMENT=7;

    // delegates
    // delegators


        public QLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public QLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[33+1];
             
             
        }
        

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g"; }



    // $ANTLR start "form"
    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:15:1: form : 'form' Ident '{' ( question )* '}' ;
    public final void form() throws RecognitionException {
        int form_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return ; }
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:16:5: ( 'form' Ident '{' ( question )* '}' )
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:17:7: 'form' Ident '{' ( question )* '}'
            {
            match(input,8,FOLLOW_8_in_form60); if (state.failed) return ;
            match(input,Ident,FOLLOW_Ident_in_form62); if (state.failed) return ;
            match(input,9,FOLLOW_9_in_form64); if (state.failed) return ;
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:17:24: ( question )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:0:0: question
            	    {
            	    pushFollow(FOLLOW_question_in_form66);
            	    question();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match(input,10,FOLLOW_10_in_form69); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 1, form_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "form"


    // $ANTLR start "question"
    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:38:1: question : '\"' ( . )* '\"' ( condition | calculation ) ;
    public final void question() throws RecognitionException {
        int question_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return ; }
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:39:5: ( '\"' ( . )* '\"' ( condition | calculation ) )
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:40:7: '\"' ( . )* '\"' ( condition | calculation )
            {
            match(input,11,FOLLOW_11_in_question105); if (state.failed) return ;
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:40:11: ( . )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==11) ) {
                    int LA2_1 = input.LA(2);

                    if ( (synpred2_QL()) ) {
                        alt2=1;
                    }


                }
                else if ( ((LA2_0>=Ident && LA2_0<=10)||(LA2_0>=12 && LA2_0<=29)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:0:0: .
            	    {
            	    matchAny(input); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match(input,11,FOLLOW_11_in_question110); if (state.failed) return ;
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:40:18: ( condition | calculation )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==Ident) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==12) ) {
                    alt3=1;
                }
                else if ( (LA3_1==15) ) {
                    alt3=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:40:19: condition
                    {
                    pushFollow(FOLLOW_condition_in_question113);
                    condition();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:40:31: calculation
                    {
                    pushFollow(FOLLOW_calculation_in_question117);
                    calculation();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 2, question_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "question"


    // $ANTLR start "condition"
    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:43:1: condition : Ident ':' Ident ( 'if (' Ident ')' '{' ( question )* '}' )* ;
    public final void condition() throws RecognitionException {
        int condition_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return ; }
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:44:5: ( Ident ':' Ident ( 'if (' Ident ')' '{' ( question )* '}' )* )
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:45:7: Ident ':' Ident ( 'if (' Ident ')' '{' ( question )* '}' )*
            {
            match(input,Ident,FOLLOW_Ident_in_condition144); if (state.failed) return ;
            match(input,12,FOLLOW_12_in_condition146); if (state.failed) return ;
            match(input,Ident,FOLLOW_Ident_in_condition148); if (state.failed) return ;
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:45:23: ( 'if (' Ident ')' '{' ( question )* '}' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==13) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:45:24: 'if (' Ident ')' '{' ( question )* '}'
            	    {
            	    match(input,13,FOLLOW_13_in_condition151); if (state.failed) return ;
            	    match(input,Ident,FOLLOW_Ident_in_condition153); if (state.failed) return ;
            	    match(input,14,FOLLOW_14_in_condition155); if (state.failed) return ;
            	    match(input,9,FOLLOW_9_in_condition157); if (state.failed) return ;
            	    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:45:45: ( question )*
            	    loop4:
            	    do {
            	        int alt4=2;
            	        int LA4_0 = input.LA(1);

            	        if ( (LA4_0==11) ) {
            	            alt4=1;
            	        }


            	        switch (alt4) {
            	    	case 1 :
            	    	    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:0:0: question
            	    	    {
            	    	    pushFollow(FOLLOW_question_in_condition159);
            	    	    question();

            	    	    state._fsp--;
            	    	    if (state.failed) return ;

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop4;
            	        }
            	    } while (true);

            	    match(input,10,FOLLOW_10_in_condition162); if (state.failed) return ;

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
            if ( state.backtracking>0 ) { memoize(input, 3, condition_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "condition"


    // $ANTLR start "calculation"
    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:49:1: calculation : Ident '=' primary ;
    public final void calculation() throws RecognitionException {
        int calculation_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return ; }
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:50:5: ( Ident '=' primary )
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:51:7: Ident '=' primary
            {
            match(input,Ident,FOLLOW_Ident_in_calculation190); if (state.failed) return ;
            match(input,15,FOLLOW_15_in_calculation192); if (state.failed) return ;
            pushFollow(FOLLOW_primary_in_calculation194);
            primary();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 4, calculation_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "calculation"


    // $ANTLR start "primary"
    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:56:1: primary returns [Expr result] : ( Int | Ident | '(' x= orExpr ')' );
    public final Expr primary() throws RecognitionException {
        Expr result = null;
        int primary_StartIndex = input.index();
        Token Int1=null;
        Token Ident2=null;
        Expr x = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:57:5: ( Int | Ident | '(' x= orExpr ')' )
            int alt6=3;
            switch ( input.LA(1) ) {
            case Int:
                {
                alt6=1;
                }
                break;
            case Ident:
                {
                alt6=2;
                }
                break;
            case 16:
                {
                alt6=3;
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
                    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:58:9: Int
                    {
                    Int1=(Token)match(input,Int,FOLLOW_Int_in_primary225); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = new Int(Integer.parseInt((Int1!=null?Int1.getText():null))); 
                    }

                    }
                    break;
                case 2 :
                    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:59:7: Ident
                    {
                    Ident2=(Token)match(input,Ident,FOLLOW_Ident_in_primary237); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = new Ident((Ident2!=null?Ident2.getText():null)); 
                    }

                    }
                    break;
                case 3 :
                    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:60:7: '(' x= orExpr ')'
                    {
                    match(input,16,FOLLOW_16_in_primary247); if (state.failed) return result;
                    pushFollow(FOLLOW_orExpr_in_primary251);
                    x=orExpr();

                    state._fsp--;
                    if (state.failed) return result;
                    match(input,14,FOLLOW_14_in_primary253); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = x; 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 5, primary_StartIndex); }
        }
        return result;
    }
    // $ANTLR end "primary"


    // $ANTLR start "unExpr"
    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:63:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr | x= primary );
    public final Expr unExpr() throws RecognitionException {
        Expr result = null;
        int unExpr_StartIndex = input.index();
        Expr x = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:64:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr | x= primary )
            int alt7=4;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt7=1;
                }
                break;
            case 18:
                {
                alt7=2;
                }
                break;
            case 19:
                {
                alt7=3;
                }
                break;
            case Ident:
            case Int:
            case 16:
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
                    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:65:9: '+' x= unExpr
                    {
                    match(input,17,FOLLOW_17_in_unExpr286); if (state.failed) return result;
                    pushFollow(FOLLOW_unExpr_in_unExpr290);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = new Pos(x); 
                    }

                    }
                    break;
                case 2 :
                    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:66:9: '-' x= unExpr
                    {
                    match(input,18,FOLLOW_18_in_unExpr303); if (state.failed) return result;
                    pushFollow(FOLLOW_unExpr_in_unExpr307);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = new Neg(x); 
                    }

                    }
                    break;
                case 3 :
                    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:67:9: '!' x= unExpr
                    {
                    match(input,19,FOLLOW_19_in_unExpr320); if (state.failed) return result;
                    pushFollow(FOLLOW_unExpr_in_unExpr324);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = new Not(x); 
                    }

                    }
                    break;
                case 4 :
                    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:68:13: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpr343);
                    x=primary();

                    state._fsp--;
                    if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = x; 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 6, unExpr_StartIndex); }
        }
        return result;
    }
    // $ANTLR end "unExpr"


    // $ANTLR start "mulExpr"
    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:71:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expr mulExpr() throws RecognitionException {
        Expr result = null;
        int mulExpr_StartIndex = input.index();
        Token op=null;
        Expr lhs = null;

        Expr rhs = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:72:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:73:7: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr382);
            lhs=unExpr();

            state._fsp--;
            if (state.failed) return result;
            if ( state.backtracking==0 ) {
               result =lhs; 
            }
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:73:43: (op= ( '*' | '/' ) rhs= unExpr )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=20 && LA8_0<=21)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:73:45: op= ( '*' | '/' ) rhs= unExpr
            	    {
            	    op=(Token)input.LT(1);
            	    if ( (input.LA(1)>=20 && input.LA(1)<=21) ) {
            	        input.consume();
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_unExpr_in_mulExpr402);
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
            if ( state.backtracking>0 ) { memoize(input, 7, mulExpr_StartIndex); }
        }
        return result;
    }
    // $ANTLR end "mulExpr"


    // $ANTLR start "addExpr"
    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:85:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expr addExpr() throws RecognitionException {
        Expr result = null;
        int addExpr_StartIndex = input.index();
        Token op=null;
        Expr lhs = null;

        Expr rhs = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:86:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:87:7: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr448);
            lhs=mulExpr();

            state._fsp--;
            if (state.failed) return result;
            if ( state.backtracking==0 ) {
               result =lhs; 
            }
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:87:44: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=17 && LA9_0<=18)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:87:46: op= ( '+' | '-' ) rhs= mulExpr
            	    {
            	    op=(Token)input.LT(1);
            	    if ( (input.LA(1)>=17 && input.LA(1)<=18) ) {
            	        input.consume();
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_mulExpr_in_addExpr466);
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
            if ( state.backtracking>0 ) { memoize(input, 8, addExpr_StartIndex); }
        }
        return result;
    }
    // $ANTLR end "addExpr"


    // $ANTLR start "relExpr"
    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:98:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expr relExpr() throws RecognitionException {
        Expr result = null;
        int relExpr_StartIndex = input.index();
        Token op=null;
        Expr lhs = null;

        Expr rhs = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:99:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:100:7: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr509);
            lhs=addExpr();

            state._fsp--;
            if (state.failed) return result;
            if ( state.backtracking==0 ) {
               result =lhs; 
            }
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:100:44: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=22 && LA10_0<=27)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:100:46: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
            	    {
            	    op=(Token)input.LT(1);
            	    if ( (input.LA(1)>=22 && input.LA(1)<=27) ) {
            	        input.consume();
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_addExpr_in_relExpr533);
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
            if ( state.backtracking>0 ) { memoize(input, 9, relExpr_StartIndex); }
        }
        return result;
    }
    // $ANTLR end "relExpr"


    // $ANTLR start "andExpr"
    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:123:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expr andExpr() throws RecognitionException {
        Expr result = null;
        int andExpr_StartIndex = input.index();
        Expr lhs = null;

        Expr rhs = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:124:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:125:7: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr576);
            lhs=relExpr();

            state._fsp--;
            if (state.failed) return result;
            if ( state.backtracking==0 ) {
               result =lhs; 
            }
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:125:44: ( '&&' rhs= relExpr )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==28) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:125:46: '&&' rhs= relExpr
            	    {
            	    match(input,28,FOLLOW_28_in_andExpr582); if (state.failed) return result;
            	    pushFollow(FOLLOW_relExpr_in_andExpr586);
            	    rhs=relExpr();

            	    state._fsp--;
            	    if (state.failed) return result;
            	    if ( state.backtracking==0 ) {
            	       result = new And(result, rhs); 
            	    }

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
            if ( state.backtracking>0 ) { memoize(input, 10, andExpr_StartIndex); }
        }
        return result;
    }
    // $ANTLR end "andExpr"


    // $ANTLR start "orExpr"
    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:128:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final Expr orExpr() throws RecognitionException {
        Expr result = null;
        int orExpr_StartIndex = input.index();
        Expr lhs = null;

        Expr rhs = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:129:5: (lhs= andExpr ( '||' rhs= andExpr )* )
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:130:7: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr620);
            lhs=andExpr();

            state._fsp--;
            if (state.failed) return result;
            if ( state.backtracking==0 ) {
               result = lhs; 
            }
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:130:46: ( '||' rhs= andExpr )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==29) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:130:48: '||' rhs= andExpr
            	    {
            	    match(input,29,FOLLOW_29_in_orExpr626); if (state.failed) return result;
            	    pushFollow(FOLLOW_andExpr_in_orExpr630);
            	    rhs=andExpr();

            	    state._fsp--;
            	    if (state.failed) return result;
            	    if ( state.backtracking==0 ) {
            	       result = new Or(result, rhs); 
            	    }

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
            if ( state.backtracking>0 ) { memoize(input, 11, orExpr_StartIndex); }
        }
        return result;
    }
    // $ANTLR end "orExpr"

    // $ANTLR start synpred2_QL
    public final void synpred2_QL_fragment() throws RecognitionException {   
        // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:40:11: ( . )
        // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:40:11: .
        {
        matchAny(input); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_QL

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


 

    public static final BitSet FOLLOW_8_in_form60 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Ident_in_form62 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_form64 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_question_in_form66 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_10_in_form69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_question105 = new BitSet(new long[]{0x000000003FFFFFF0L});
    public static final BitSet FOLLOW_11_in_question110 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_condition_in_question113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_calculation_in_question117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_condition144 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_condition146 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Ident_in_condition148 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_condition151 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Ident_in_condition153 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_condition155 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_condition157 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_question_in_condition159 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_10_in_condition162 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_Ident_in_calculation190 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_calculation192 = new BitSet(new long[]{0x0000000000010030L});
    public static final BitSet FOLLOW_primary_in_calculation194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Int_in_primary225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_primary237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_primary247 = new BitSet(new long[]{0x00000000000F0030L});
    public static final BitSet FOLLOW_orExpr_in_primary251 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_primary253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_unExpr286 = new BitSet(new long[]{0x00000000000F0030L});
    public static final BitSet FOLLOW_unExpr_in_unExpr290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_unExpr303 = new BitSet(new long[]{0x00000000000F0030L});
    public static final BitSet FOLLOW_unExpr_in_unExpr307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_unExpr320 = new BitSet(new long[]{0x00000000000F0030L});
    public static final BitSet FOLLOW_unExpr_in_unExpr324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr382 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_set_in_mulExpr390 = new BitSet(new long[]{0x00000000000F0030L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr402 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr448 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_set_in_addExpr456 = new BitSet(new long[]{0x00000000000F0030L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr466 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr509 = new BitSet(new long[]{0x000000000FC00002L});
    public static final BitSet FOLLOW_set_in_relExpr517 = new BitSet(new long[]{0x00000000000F0030L});
    public static final BitSet FOLLOW_addExpr_in_relExpr533 = new BitSet(new long[]{0x000000000FC00002L});
    public static final BitSet FOLLOW_relExpr_in_andExpr576 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_andExpr582 = new BitSet(new long[]{0x00000000000F0030L});
    public static final BitSet FOLLOW_relExpr_in_andExpr586 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr620 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_orExpr626 = new BitSet(new long[]{0x00000000000F0030L});
    public static final BitSet FOLLOW_andExpr_in_orExpr630 = new BitSet(new long[]{0x0000000020000002L});

}