// $ANTLR 3.4 /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-20 16:08:50

package org.uva.sea.ql.parser.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLLexer extends Lexer {
    public static final int EOF=-1;
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
    public static final int Bool=4;
    public static final int COMMENT=5;
    public static final int Ident=6;
    public static final int Int=7;
    public static final int NEWLINE=8;
    public static final int STRING=9;
    public static final int WS=10;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public QLLexer() {} 
    public QLLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public QLLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "/home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g"; }

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:6:7: ( '!' )
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:6:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:7:7: ( '!=' )
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:7:9: '!='
            {
            match("!="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:8:7: ( '&&' )
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:8:9: '&&'
            {
            match("&&"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:9:7: ( '(' )
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:9:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:10:7: ( ')' )
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:10:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:11:7: ( '*' )
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:11:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:12:7: ( '+' )
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:12:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:13:7: ( '-' )
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:13:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:14:7: ( '/' )
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:14:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:15:7: ( '<' )
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:15:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:16:7: ( '<=' )
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:16:9: '<='
            {
            match("<="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:17:7: ( '==' )
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:17:9: '=='
            {
            match("=="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:18:7: ( '>' )
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:18:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:19:7: ( '>=' )
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:19:9: '>='
            {
            match(">="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:20:7: ( '||' )
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:20:9: '||'
            {
            match("||"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:112:9: ( ( '\\n' | '\\r' ) )
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:
            {
            if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NEWLINE"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:115:5: ( ( ' ' | '\\t' | '\\n' | '\\r' ) )
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:115:7: ( ' ' | '\\t' | '\\n' | '\\r' )
            {
            if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


             _channel=HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:119:6: ( '/*' ( . )* '*/' )
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:119:8: '/*' ( . )* '*/'
            {
            match("/*"); 



            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:119:13: ( . )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='*') ) {
                    int LA1_1 = input.LA(2);

                    if ( (LA1_1=='/') ) {
                        alt1=2;
                    }
                    else if ( ((LA1_1 >= '\u0000' && LA1_1 <= '.')||(LA1_1 >= '0' && LA1_1 <= '\uFFFF')) ) {
                        alt1=1;
                    }


                }
                else if ( ((LA1_0 >= '\u0000' && LA1_0 <= ')')||(LA1_0 >= '+' && LA1_0 <= '\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:119:13: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            match("*/"); 



            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "Bool"
    public final void mBool() throws RecognitionException {
        try {
            int _type = Bool;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:121:5: ( ( 'true' | 'false' ) )
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:121:7: ( 'true' | 'false' )
            {
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:121:7: ( 'true' | 'false' )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='t') ) {
                alt2=1;
            }
            else if ( (LA2_0=='f') ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:121:8: 'true'
                    {
                    match("true"); 



                    }
                    break;
                case 2 :
                    // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:121:17: 'false'
                    {
                    match("false"); 



                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Bool"

    // $ANTLR start "Ident"
    public final void mIdent() throws RecognitionException {
        try {
            int _type = Ident;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:123:6: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:123:10: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:123:29: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '0' && LA3_0 <= '9')||(LA3_0 >= 'A' && LA3_0 <= 'Z')||LA3_0=='_'||(LA3_0 >= 'a' && LA3_0 <= 'z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Ident"

    // $ANTLR start "Int"
    public final void mInt() throws RecognitionException {
        try {
            int _type = Int;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:125:4: ( ( '0' .. '9' )+ )
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:125:6: ( '0' .. '9' )+
            {
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:125:6: ( '0' .. '9' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Int"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:128:8: ( ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:128:10: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:128:10: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= '0' && LA5_0 <= '9')||(LA5_0 >= 'A' && LA5_0 <= 'Z')||LA5_0=='_'||(LA5_0 >= 'a' && LA5_0 <= 'z')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING"

    public void mTokens() throws RecognitionException {
        // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:1:8: ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | NEWLINE | WS | COMMENT | Bool | Ident | Int | STRING )
        int alt6=22;
        alt6 = dfa6.predict(input);
        switch (alt6) {
            case 1 :
                // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:1:10: T__11
                {
                mT__11(); 


                }
                break;
            case 2 :
                // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:1:16: T__12
                {
                mT__12(); 


                }
                break;
            case 3 :
                // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:1:22: T__13
                {
                mT__13(); 


                }
                break;
            case 4 :
                // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:1:28: T__14
                {
                mT__14(); 


                }
                break;
            case 5 :
                // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:1:34: T__15
                {
                mT__15(); 


                }
                break;
            case 6 :
                // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:1:40: T__16
                {
                mT__16(); 


                }
                break;
            case 7 :
                // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:1:46: T__17
                {
                mT__17(); 


                }
                break;
            case 8 :
                // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:1:52: T__18
                {
                mT__18(); 


                }
                break;
            case 9 :
                // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:1:58: T__19
                {
                mT__19(); 


                }
                break;
            case 10 :
                // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:1:64: T__20
                {
                mT__20(); 


                }
                break;
            case 11 :
                // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:1:70: T__21
                {
                mT__21(); 


                }
                break;
            case 12 :
                // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:1:76: T__22
                {
                mT__22(); 


                }
                break;
            case 13 :
                // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:1:82: T__23
                {
                mT__23(); 


                }
                break;
            case 14 :
                // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:1:88: T__24
                {
                mT__24(); 


                }
                break;
            case 15 :
                // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:1:94: T__25
                {
                mT__25(); 


                }
                break;
            case 16 :
                // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:1:100: NEWLINE
                {
                mNEWLINE(); 


                }
                break;
            case 17 :
                // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:1:108: WS
                {
                mWS(); 


                }
                break;
            case 18 :
                // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:1:111: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 19 :
                // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:1:119: Bool
                {
                mBool(); 


                }
                break;
            case 20 :
                // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:1:124: Ident
                {
                mIdent(); 


                }
                break;
            case 21 :
                // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:1:130: Int
                {
                mInt(); 


                }
                break;
            case 22 :
                // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:1:134: STRING
                {
                mSTRING(); 


                }
                break;

        }

    }


    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA6_eotS =
        "\1\23\1\25\6\uffff\1\27\1\31\1\uffff\1\33\3\uffff\3\37\1\41\12\uffff"+
        "\2\37\1\uffff\1\37\1\uffff\2\37\1\46\1\37\1\uffff\1\46";
    static final String DFA6_eofS =
        "\50\uffff";
    static final String DFA6_minS =
        "\1\11\1\75\6\uffff\1\52\1\75\1\uffff\1\75\3\uffff\4\60\12\uffff"+
        "\2\60\1\uffff\1\60\1\uffff\4\60\1\uffff\1\60";
    static final String DFA6_maxS =
        "\1\174\1\75\6\uffff\1\52\1\75\1\uffff\1\75\3\uffff\4\172\12\uffff"+
        "\2\172\1\uffff\1\172\1\uffff\4\172\1\uffff\1\172";
    static final String DFA6_acceptS =
        "\2\uffff\1\3\1\4\1\5\1\6\1\7\1\10\2\uffff\1\14\1\uffff\1\17\1\20"+
        "\1\21\4\uffff\1\26\1\2\1\1\1\22\1\11\1\13\1\12\1\16\1\15\1\20\2"+
        "\uffff\1\24\1\uffff\1\25\4\uffff\1\23\1\uffff";
    static final String DFA6_specialS =
        "\50\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\16\1\15\2\uffff\1\15\22\uffff\1\16\1\1\4\uffff\1\2\1\uffff"+
            "\1\3\1\4\1\5\1\6\1\uffff\1\7\1\uffff\1\10\12\22\2\uffff\1\11"+
            "\1\12\1\13\2\uffff\32\21\6\uffff\5\21\1\20\15\21\1\17\6\21\1"+
            "\uffff\1\14",
            "\1\24",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\26",
            "\1\30",
            "",
            "\1\32",
            "",
            "",
            "",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\21\36\1\35\10\36",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\1\40\31\36",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\22\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\24\36\1\42\5\36",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\13\36\1\43\16\36",
            "",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\4\36\1\44\25\36",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\22\36\1\45\7\36",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\4\36\1\47\25\36",
            "",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36"
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | NEWLINE | WS | COMMENT | Bool | Ident | Int | STRING );";
        }
    }
 

}