// $ANTLR 3.4 /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g 2013-01-13 16:17:07

	package org.uva.sea.ql.parser;
	import org.uva.sea.ql.ast.Add;
	import org.uva.sea.ql.ast.And;
	import org.uva.sea.ql.ast.Div;
	import org.uva.sea.ql.ast.Eq;
	import org.uva.sea.ql.ast.Expr;
	import org.uva.sea.ql.ast.GEq;
	import org.uva.sea.ql.ast.GT;
	import org.uva.sea.ql.ast.Ident;
	import org.uva.sea.ql.ast.Int;
	import org.uva.sea.ql.ast.LEq;
	import org.uva.sea.ql.ast.LT;
	import org.uva.sea.ql.ast.Mul;
	import org.uva.sea.ql.ast.Neg;
	import org.uva.sea.ql.ast.NEq;
	import org.uva.sea.ql.ast.Not;
	import org.uva.sea.ql.ast.Or;
	import org.uva.sea.ql.ast.Pos;
	import org.uva.sea.ql.ast.Sub;
	import org.uva.sea.ql.parser.exception.ParserException;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "DIGIT", "IDENTIFIER", "INTEGER", "LETTER", "MULTILINE_COMMENT", "STRING_LITERAL", "WHITESPACE", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'boolean'", "'else'", "'form'", "'if'", "'integer'", "'{'", "'||'", "'}'"
    };

    public static final int EOF=-1;
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
    public static final int T__34=34;
    public static final int COMMENT=4;
    public static final int DIGIT=5;
    public static final int IDENTIFIER=6;
    public static final int INTEGER=7;
    public static final int LETTER=8;
    public static final int MULTILINE_COMMENT=9;
    public static final int STRING_LITERAL=10;
    public static final int WHITESPACE=11;

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
    public String getGrammarFileName() { return "/Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g"; }


    	@Override
    	public void reportError(RecognitionException e) {
    		super.reportError(e);
    		throw new ParserException(e.getMessage()); 
    	}



    // $ANTLR start "form"
    // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:48:1: form : 'form' IDENTIFIER '{' ( statement )* '}' ;
    public final void form() throws RecognitionException {
        int form_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return ; }

            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:49:2: ( 'form' IDENTIFIER '{' ( statement )* '}' )
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:49:4: 'form' IDENTIFIER '{' ( statement )* '}'
            {
            match(input,29,FOLLOW_29_in_form75); if (state.failed) return ;

            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_form77); if (state.failed) return ;

            match(input,32,FOLLOW_32_in_form82); if (state.failed) return ;

            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:51:4: ( statement )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==IDENTIFIER||LA1_0==30) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:51:4: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_form87);
            	    statement();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            match(input,34,FOLLOW_34_in_form93); if (state.failed) return ;

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
        return ;
    }
    // $ANTLR end "form"



    // $ANTLR start "statement"
    // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:55:1: statement : ( assignmentStatement | ifStatement );
    public final void statement() throws RecognitionException {
        int statement_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return ; }

            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:56:2: ( assignmentStatement | ifStatement )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==IDENTIFIER) ) {
                alt2=1;
            }
            else if ( (LA2_0==30) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:56:4: assignmentStatement
                    {
                    pushFollow(FOLLOW_assignmentStatement_in_statement106);
                    assignmentStatement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:57:5: ifStatement
                    {
                    pushFollow(FOLLOW_ifStatement_in_statement112);
                    ifStatement();

                    state._fsp--;
                    if (state.failed) return ;

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
        return ;
    }
    // $ANTLR end "statement"



    // $ANTLR start "assignmentStatement"
    // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:60:1: assignmentStatement : IDENTIFIER ':' STRING_LITERAL type ;
    public final void assignmentStatement() throws RecognitionException {
        int assignmentStatement_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return ; }

            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:61:2: ( IDENTIFIER ':' STRING_LITERAL type )
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:61:4: IDENTIFIER ':' STRING_LITERAL type
            {
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_assignmentStatement124); if (state.failed) return ;

            match(input,21,FOLLOW_21_in_assignmentStatement126); if (state.failed) return ;

            match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_assignmentStatement128); if (state.failed) return ;

            pushFollow(FOLLOW_type_in_assignmentStatement130);
            type();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, assignmentStatement_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "assignmentStatement"



    // $ANTLR start "type"
    // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:64:1: type : ( 'boolean' | 'integer' );
    public final void type() throws RecognitionException {
        int type_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return ; }

            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:65:2: ( 'boolean' | 'integer' )
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:
            {
            if ( input.LA(1)==27||input.LA(1)==31 ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


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
        return ;
    }
    // $ANTLR end "type"



    // $ANTLR start "ifStatement"
    // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:69:1: ifStatement : 'if' orExpr '{' ( statement )+ '}' ( 'else' 'if' orExpr '{' ( statement )+ '}' )* ( 'else' '{' ( statement )+ '}' )? ;
    public final void ifStatement() throws RecognitionException {
        int ifStatement_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return ; }

            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:70:2: ( 'if' orExpr '{' ( statement )+ '}' ( 'else' 'if' orExpr '{' ( statement )+ '}' )* ( 'else' '{' ( statement )+ '}' )? )
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:70:4: 'if' orExpr '{' ( statement )+ '}' ( 'else' 'if' orExpr '{' ( statement )+ '}' )* ( 'else' '{' ( statement )+ '}' )?
            {
            match(input,30,FOLLOW_30_in_ifStatement159); if (state.failed) return ;

            pushFollow(FOLLOW_orExpr_in_ifStatement161);
            orExpr();

            state._fsp--;
            if (state.failed) return ;

            match(input,32,FOLLOW_32_in_ifStatement163); if (state.failed) return ;

            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:70:20: ( statement )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==IDENTIFIER||LA3_0==30) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:70:20: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_ifStatement165);
            	    statement();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            match(input,34,FOLLOW_34_in_ifStatement168); if (state.failed) return ;

            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:71:3: ( 'else' 'if' orExpr '{' ( statement )+ '}' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==28) ) {
                    int LA5_1 = input.LA(2);

                    if ( (LA5_1==30) ) {
                        alt5=1;
                    }


                }


                switch (alt5) {
            	case 1 :
            	    // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:71:4: 'else' 'if' orExpr '{' ( statement )+ '}'
            	    {
            	    match(input,28,FOLLOW_28_in_ifStatement173); if (state.failed) return ;

            	    match(input,30,FOLLOW_30_in_ifStatement175); if (state.failed) return ;

            	    pushFollow(FOLLOW_orExpr_in_ifStatement177);
            	    orExpr();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    match(input,32,FOLLOW_32_in_ifStatement179); if (state.failed) return ;

            	    // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:71:27: ( statement )+
            	    int cnt4=0;
            	    loop4:
            	    do {
            	        int alt4=2;
            	        int LA4_0 = input.LA(1);

            	        if ( (LA4_0==IDENTIFIER||LA4_0==30) ) {
            	            alt4=1;
            	        }


            	        switch (alt4) {
            	    	case 1 :
            	    	    // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:71:27: statement
            	    	    {
            	    	    pushFollow(FOLLOW_statement_in_ifStatement181);
            	    	    statement();

            	    	    state._fsp--;
            	    	    if (state.failed) return ;

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt4 >= 1 ) break loop4;
            	    	    if (state.backtracking>0) {state.failed=true; return ;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(4, input);
            	                throw eee;
            	        }
            	        cnt4++;
            	    } while (true);


            	    match(input,34,FOLLOW_34_in_ifStatement184); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:72:3: ( 'else' '{' ( statement )+ '}' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==28) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:72:4: 'else' '{' ( statement )+ '}'
                    {
                    match(input,28,FOLLOW_28_in_ifStatement191); if (state.failed) return ;

                    match(input,32,FOLLOW_32_in_ifStatement193); if (state.failed) return ;

                    // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:72:15: ( statement )+
                    int cnt6=0;
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==IDENTIFIER||LA6_0==30) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:72:15: statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_ifStatement195);
                    	    statement();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt6 >= 1 ) break loop6;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(6, input);
                                throw eee;
                        }
                        cnt6++;
                    } while (true);


                    match(input,34,FOLLOW_34_in_ifStatement198); if (state.failed) return ;

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
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, ifStatement_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "ifStatement"



    // $ANTLR start "primary"
    // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:75:1: primary returns [Expr result] : ( INTEGER | IDENTIFIER | '(' x= orExpr ')' );
    public final Expr primary() throws RecognitionException {
        Expr result = null;

        int primary_StartIndex = input.index();

        Token INTEGER1=null;
        Token IDENTIFIER2=null;
        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:76:2: ( INTEGER | IDENTIFIER | '(' x= orExpr ')' )
            int alt8=3;
            switch ( input.LA(1) ) {
            case INTEGER:
                {
                alt8=1;
                }
                break;
            case IDENTIFIER:
                {
                alt8=2;
                }
                break;
            case 15:
                {
                alt8=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }

            switch (alt8) {
                case 1 :
                    // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:76:4: INTEGER
                    {
                    INTEGER1=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_primary215); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((INTEGER1!=null?INTEGER1.getText():null))); }

                    }
                    break;
                case 2 :
                    // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:77:4: IDENTIFIER
                    {
                    IDENTIFIER2=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_primary222); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Ident((IDENTIFIER2!=null?IDENTIFIER2.getText():null)); }

                    }
                    break;
                case 3 :
                    // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:78:4: '(' x= orExpr ')'
                    {
                    match(input,15,FOLLOW_15_in_primary229); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_primary233);
                    x=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,16,FOLLOW_16_in_primary235); if (state.failed) return result;

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
    // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:81:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
    public final Expr unExpr() throws RecognitionException {
        Expr result = null;

        int unExpr_StartIndex = input.index();

        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:82:2: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
            int alt9=4;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt9=1;
                }
                break;
            case 19:
                {
                alt9=2;
                }
                break;
            case 12:
                {
                alt9=3;
                }
                break;
            case IDENTIFIER:
            case INTEGER:
            case 15:
                {
                alt9=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }

            switch (alt9) {
                case 1 :
                    // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:82:4: '+' x= unExpr
                    {
                    match(input,18,FOLLOW_18_in_unExpr256); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr260);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Pos(x); }

                    }
                    break;
                case 2 :
                    // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:83:4: '-' x= unExpr
                    {
                    match(input,19,FOLLOW_19_in_unExpr267); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr271);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Neg(x); }

                    }
                    break;
                case 3 :
                    // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:84:4: '!' x= unExpr
                    {
                    match(input,12,FOLLOW_12_in_unExpr278); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr282);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Not(x); }

                    }
                    break;
                case 4 :
                    // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:85:4: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpr291);
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
    // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:88:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expr mulExpr() throws RecognitionException {
        Expr result = null;

        int mulExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:89:2: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:89:4: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr317);
            lhs=unExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:89:40: (op= ( '*' | '/' ) rhs= unExpr )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==17||LA10_0==20) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:89:42: op= ( '*' | '/' ) rhs= unExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==17||input.LA(1)==20 ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_unExpr_in_mulExpr337);
            	    rhs=unExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { 
            	          		if ((op!=null?op.getText():null).equals("*")) 
            	          		{
            	            		result = new Mul(result, rhs);
            	          		}
            	          		if ((op!=null?op.getText():null).equals("/")) 
            	          		{
            	            		result = new Div(result, rhs);      
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
            if ( state.backtracking>0 ) { memoize(input, 8, mulExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "mulExpr"



    // $ANTLR start "addExpr"
    // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:102:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expr addExpr() throws RecognitionException {
        Expr result = null;

        int addExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:103:2: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:103:4: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr374);
            lhs=mulExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:103:41: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0 >= 18 && LA11_0 <= 19)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:103:43: op= ( '+' | '-' ) rhs= mulExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( (input.LA(1) >= 18 && input.LA(1) <= 19) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_mulExpr_in_addExpr392);
            	    rhs=mulExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { 
            	    			if ((op!=null?op.getText():null).equals("+")) 
            	    			{
            	    				result = new Add(result, rhs);
            	    			}
            	    			if ((op!=null?op.getText():null).equals("-")) 
            	    			{
            	    				result = new Sub(result, rhs);      
            	    			}
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
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 9, addExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "addExpr"



    // $ANTLR start "relExpr"
    // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:116:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expr relExpr() throws RecognitionException {
        Expr result = null;

        int relExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:117:2: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:117:4: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr420);
            lhs=addExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:117:41: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==13||(LA12_0 >= 22 && LA12_0 <= 26)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:117:43: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==13||(input.LA(1) >= 22 && input.LA(1) <= 26) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_addExpr_in_relExpr444);
            	    rhs=addExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { 
            	    			if ((op!=null?op.getText():null).equals("<")) 
            	    			{
            	    				result = new LT(result, rhs);
            	    			}
            	    			if ((op!=null?op.getText():null).equals("<=")) 
            	    			{
            	            		result = new LEq(result, rhs);      
            	          		}
            	          		if ((op!=null?op.getText():null).equals(">")) 
            	          		{
            	            		result = new GT(result, rhs);
            	          		}
            	          		if ((op!=null?op.getText():null).equals(">=")) 
            	          		{
            	            		result = new GEq(result, rhs);      
            	          		}
            	          		if ((op!=null?op.getText():null).equals("==")) 
            	          		{
            	           			result = new Eq(result, rhs);
            	          		}
            	          		if ((op!=null?op.getText():null).equals("!=")) 
            	          		{
            	            		result = new NEq(result, rhs);
            	          		}
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
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 10, relExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "relExpr"



    // $ANTLR start "andExpr"
    // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:146:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expr andExpr() throws RecognitionException {
        Expr result = null;

        int andExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:147:2: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:147:4: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr475);
            lhs=relExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:147:41: ( '&&' rhs= relExpr )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==14) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:147:43: '&&' rhs= relExpr
            	    {
            	    match(input,14,FOLLOW_14_in_andExpr481); if (state.failed) return result;

            	    pushFollow(FOLLOW_relExpr_in_andExpr485);
            	    rhs=relExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new And(result, rhs); }

            	    }
            	    break;

            	default :
            	    break loop13;
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
    // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:151:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final Expr orExpr() throws RecognitionException {
        Expr result = null;

        int orExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:152:2: (lhs= andExpr ( '||' rhs= andExpr )* )
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:152:4: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr512);
            lhs=andExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = lhs; }

            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:152:43: ( '||' rhs= andExpr )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==33) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:152:45: '||' rhs= andExpr
            	    {
            	    match(input,33,FOLLOW_33_in_orExpr518); if (state.failed) return result;

            	    pushFollow(FOLLOW_andExpr_in_orExpr522);
            	    rhs=andExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new Or(result, rhs); }

            	    }
            	    break;

            	default :
            	    break loop14;
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


 

    public static final BitSet FOLLOW_29_in_form75 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_form77 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_form82 = new BitSet(new long[]{0x0000000440000040L});
    public static final BitSet FOLLOW_statement_in_form87 = new BitSet(new long[]{0x0000000440000040L});
    public static final BitSet FOLLOW_34_in_form93 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentStatement_in_statement106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_statement112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_assignmentStatement124 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_assignmentStatement126 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_assignmentStatement128 = new BitSet(new long[]{0x0000000088000000L});
    public static final BitSet FOLLOW_type_in_assignmentStatement130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ifStatement159 = new BitSet(new long[]{0x00000000000C90C0L});
    public static final BitSet FOLLOW_orExpr_in_ifStatement161 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ifStatement163 = new BitSet(new long[]{0x0000000040000040L});
    public static final BitSet FOLLOW_statement_in_ifStatement165 = new BitSet(new long[]{0x0000000440000040L});
    public static final BitSet FOLLOW_34_in_ifStatement168 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_ifStatement173 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ifStatement175 = new BitSet(new long[]{0x00000000000C90C0L});
    public static final BitSet FOLLOW_orExpr_in_ifStatement177 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ifStatement179 = new BitSet(new long[]{0x0000000040000040L});
    public static final BitSet FOLLOW_statement_in_ifStatement181 = new BitSet(new long[]{0x0000000440000040L});
    public static final BitSet FOLLOW_34_in_ifStatement184 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_ifStatement191 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ifStatement193 = new BitSet(new long[]{0x0000000040000040L});
    public static final BitSet FOLLOW_statement_in_ifStatement195 = new BitSet(new long[]{0x0000000440000040L});
    public static final BitSet FOLLOW_34_in_ifStatement198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_primary215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_primary222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_primary229 = new BitSet(new long[]{0x00000000000C90C0L});
    public static final BitSet FOLLOW_orExpr_in_primary233 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_primary235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_unExpr256 = new BitSet(new long[]{0x00000000000C90C0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_unExpr267 = new BitSet(new long[]{0x00000000000C90C0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_unExpr278 = new BitSet(new long[]{0x00000000000C90C0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr317 = new BitSet(new long[]{0x0000000000120002L});
    public static final BitSet FOLLOW_set_in_mulExpr325 = new BitSet(new long[]{0x00000000000C90C0L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr337 = new BitSet(new long[]{0x0000000000120002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr374 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_set_in_addExpr382 = new BitSet(new long[]{0x00000000000C90C0L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr392 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr420 = new BitSet(new long[]{0x0000000007C02002L});
    public static final BitSet FOLLOW_set_in_relExpr428 = new BitSet(new long[]{0x00000000000C90C0L});
    public static final BitSet FOLLOW_addExpr_in_relExpr444 = new BitSet(new long[]{0x0000000007C02002L});
    public static final BitSet FOLLOW_relExpr_in_andExpr475 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_andExpr481 = new BitSet(new long[]{0x00000000000C90C0L});
    public static final BitSet FOLLOW_relExpr_in_andExpr485 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr512 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_orExpr518 = new BitSet(new long[]{0x00000000000C90C0L});
    public static final BitSet FOLLOW_andExpr_in_orExpr522 = new BitSet(new long[]{0x0000000200000002L});

}