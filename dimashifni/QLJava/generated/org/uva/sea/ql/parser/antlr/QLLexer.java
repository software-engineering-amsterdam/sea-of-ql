// $ANTLR 3.4 src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-23 22:34:19

package org.uva.sea.ql.parser.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLLexer extends Lexer {
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
    public static final int Comment=5;
    public static final int Ident=6;
    public static final int Int=7;
    public static final int StringLiteral=8;
    public static final int WS=9;

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
    public String getGrammarFileName() { return "src/org/uva/sea/ql/parser/antlr/QL.g"; }

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/uva/sea/ql/parser/antlr/QL.g:6:7: ( '!' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:6:9: '!'
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
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/uva/sea/ql/parser/antlr/QL.g:7:7: ( '!=' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:7:9: '!='
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
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/uva/sea/ql/parser/antlr/QL.g:8:7: ( '&&' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:8:9: '&&'
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
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/uva/sea/ql/parser/antlr/QL.g:9:7: ( '(' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:9:9: '('
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
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/uva/sea/ql/parser/antlr/QL.g:10:7: ( ')' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:10:9: ')'
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
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/uva/sea/ql/parser/antlr/QL.g:11:7: ( '*' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:11:9: '*'
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
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/uva/sea/ql/parser/antlr/QL.g:12:7: ( '+' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:12:9: '+'
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
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/uva/sea/ql/parser/antlr/QL.g:13:7: ( '-' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:13:9: '-'
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
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/uva/sea/ql/parser/antlr/QL.g:14:7: ( '/' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:14:9: '/'
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
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/uva/sea/ql/parser/antlr/QL.g:15:7: ( ':' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:15:9: ':'
            {
            match(':'); 

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
            // src/org/uva/sea/ql/parser/antlr/QL.g:16:7: ( '<' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:16:9: '<'
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
            // src/org/uva/sea/ql/parser/antlr/QL.g:17:7: ( '<=' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:17:9: '<='
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
            // src/org/uva/sea/ql/parser/antlr/QL.g:18:7: ( '==' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:18:9: '=='
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
            // src/org/uva/sea/ql/parser/antlr/QL.g:19:7: ( '>' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:19:9: '>'
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
            // src/org/uva/sea/ql/parser/antlr/QL.g:20:7: ( '>=' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:20:9: '>='
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
            // src/org/uva/sea/ql/parser/antlr/QL.g:21:7: ( 'Boolean' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:21:9: 'Boolean'
            {
            match("Boolean"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/uva/sea/ql/parser/antlr/QL.g:22:7: ( 'Integer' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:22:9: 'Integer'
            {
            match("Integer"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/uva/sea/ql/parser/antlr/QL.g:23:7: ( 'StringLiteral' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:23:9: 'StringLiteral'
            {
            match("StringLiteral"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/uva/sea/ql/parser/antlr/QL.g:24:7: ( 'form' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:24:9: 'form'
            {
            match("form"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/uva/sea/ql/parser/antlr/QL.g:25:7: ( 'if' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:25:9: 'if'
            {
            match("if"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/uva/sea/ql/parser/antlr/QL.g:26:7: ( '{' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:26:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/uva/sea/ql/parser/antlr/QL.g:27:7: ( '||' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:27:9: '||'
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
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/uva/sea/ql/parser/antlr/QL.g:28:7: ( '}' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:28:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/uva/sea/ql/parser/antlr/QL.g:139:3: ( ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+ )
            // src/org/uva/sea/ql/parser/antlr/QL.g:139:3: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+
            {
            // src/org/uva/sea/ql/parser/antlr/QL.g:139:3: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '\t' && LA1_0 <= '\n')||(LA1_0 >= '\f' && LA1_0 <= '\r')||LA1_0==' ') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // src/org/uva/sea/ql/parser/antlr/QL.g:
            	    {
            	    if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
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
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


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

    // $ANTLR start "Comment"
    public final void mComment() throws RecognitionException {
        try {
            int _type = Comment;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/uva/sea/ql/parser/antlr/QL.g:143:3: ( '/*' ( . )* '*/' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:143:3: '/*' ( . )* '*/'
            {
            match("/*"); 



            // src/org/uva/sea/ql/parser/antlr/QL.g:143:8: ( . )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='*') ) {
                    int LA2_1 = input.LA(2);

                    if ( (LA2_1=='/') ) {
                        alt2=2;
                    }
                    else if ( ((LA2_1 >= '\u0000' && LA2_1 <= '.')||(LA2_1 >= '0' && LA2_1 <= '\uFFFF')) ) {
                        alt2=1;
                    }


                }
                else if ( ((LA2_0 >= '\u0000' && LA2_0 <= ')')||(LA2_0 >= '+' && LA2_0 <= '\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // src/org/uva/sea/ql/parser/antlr/QL.g:143:8: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop2;
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
    // $ANTLR end "Comment"

    // $ANTLR start "StringLiteral"
    public final void mStringLiteral() throws RecognitionException {
        try {
            int _type = StringLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            int c;

            // src/org/uva/sea/ql/parser/antlr/QL.g:146:14: ( '\"' ( '\"' '\"' |c=~ ( '\"' | '\\r' | '\\n' ) )* '\"' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:146:16: '\"' ( '\"' '\"' |c=~ ( '\"' | '\\r' | '\\n' ) )* '\"'
            {
            match('\"'); 

             StringBuilder stringBuilder = new StringBuilder(); 

            // src/org/uva/sea/ql/parser/antlr/QL.g:148:4: ( '\"' '\"' |c=~ ( '\"' | '\\r' | '\\n' ) )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\"') ) {
                    int LA3_1 = input.LA(2);

                    if ( (LA3_1=='\"') ) {
                        alt3=1;
                    }


                }
                else if ( ((LA3_0 >= '\u0000' && LA3_0 <= '\t')||(LA3_0 >= '\u000B' && LA3_0 <= '\f')||(LA3_0 >= '\u000E' && LA3_0 <= '!')||(LA3_0 >= '#' && LA3_0 <= '\uFFFF')) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // src/org/uva/sea/ql/parser/antlr/QL.g:149:5: '\"' '\"'
            	    {
            	    match('\"'); 

            	    match('\"'); 

            	    stringBuilder.appendCodePoint('"');

            	    }
            	    break;
            	case 2 :
            	    // src/org/uva/sea/ql/parser/antlr/QL.g:151:5: c=~ ( '\"' | '\\r' | '\\n' )
            	    {
            	    c= input.LA(1);

            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    stringBuilder.appendCodePoint(c);

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            match('\"'); 

            setText(stringBuilder.toString());

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "StringLiteral"

    // $ANTLR start "Bool"
    public final void mBool() throws RecognitionException {
        try {
            int _type = Bool;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/uva/sea/ql/parser/antlr/QL.g:158:3: ( 'true' | 'false' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='t') ) {
                alt4=1;
            }
            else if ( (LA4_0=='f') ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }
            switch (alt4) {
                case 1 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:158:3: 'true'
                    {
                    match("true"); 



                    }
                    break;
                case 2 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:159:3: 'false'
                    {
                    match("false"); 



                    }
                    break;

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
            // src/org/uva/sea/ql/parser/antlr/QL.g:162:6: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // src/org/uva/sea/ql/parser/antlr/QL.g:162:8: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // src/org/uva/sea/ql/parser/antlr/QL.g:162:27: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= '0' && LA5_0 <= '9')||(LA5_0 >= 'A' && LA5_0 <= 'Z')||LA5_0=='_'||(LA5_0 >= 'a' && LA5_0 <= 'z')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // src/org/uva/sea/ql/parser/antlr/QL.g:
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
    // $ANTLR end "Ident"

    // $ANTLR start "Int"
    public final void mInt() throws RecognitionException {
        try {
            int _type = Int;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/uva/sea/ql/parser/antlr/QL.g:164:4: ( ( '0' .. '9' )+ )
            // src/org/uva/sea/ql/parser/antlr/QL.g:164:6: ( '0' .. '9' )+
            {
            // src/org/uva/sea/ql/parser/antlr/QL.g:164:6: ( '0' .. '9' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // src/org/uva/sea/ql/parser/antlr/QL.g:
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
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
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

    public void mTokens() throws RecognitionException {
        // src/org/uva/sea/ql/parser/antlr/QL.g:1:8: ( T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | WS | Comment | StringLiteral | Bool | Ident | Int )
        int alt7=29;
        alt7 = dfa7.predict(input);
        switch (alt7) {
            case 1 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:10: T__10
                {
                mT__10(); 


                }
                break;
            case 2 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:16: T__11
                {
                mT__11(); 


                }
                break;
            case 3 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:22: T__12
                {
                mT__12(); 


                }
                break;
            case 4 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:28: T__13
                {
                mT__13(); 


                }
                break;
            case 5 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:34: T__14
                {
                mT__14(); 


                }
                break;
            case 6 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:40: T__15
                {
                mT__15(); 


                }
                break;
            case 7 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:46: T__16
                {
                mT__16(); 


                }
                break;
            case 8 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:52: T__17
                {
                mT__17(); 


                }
                break;
            case 9 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:58: T__18
                {
                mT__18(); 


                }
                break;
            case 10 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:64: T__19
                {
                mT__19(); 


                }
                break;
            case 11 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:70: T__20
                {
                mT__20(); 


                }
                break;
            case 12 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:76: T__21
                {
                mT__21(); 


                }
                break;
            case 13 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:82: T__22
                {
                mT__22(); 


                }
                break;
            case 14 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:88: T__23
                {
                mT__23(); 


                }
                break;
            case 15 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:94: T__24
                {
                mT__24(); 


                }
                break;
            case 16 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:100: T__25
                {
                mT__25(); 


                }
                break;
            case 17 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:106: T__26
                {
                mT__26(); 


                }
                break;
            case 18 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:112: T__27
                {
                mT__27(); 


                }
                break;
            case 19 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:118: T__28
                {
                mT__28(); 


                }
                break;
            case 20 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:124: T__29
                {
                mT__29(); 


                }
                break;
            case 21 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:130: T__30
                {
                mT__30(); 


                }
                break;
            case 22 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:136: T__31
                {
                mT__31(); 


                }
                break;
            case 23 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:142: T__32
                {
                mT__32(); 


                }
                break;
            case 24 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:148: WS
                {
                mWS(); 


                }
                break;
            case 25 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:151: Comment
                {
                mComment(); 


                }
                break;
            case 26 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:159: StringLiteral
                {
                mStringLiteral(); 


                }
                break;
            case 27 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:173: Bool
                {
                mBool(); 


                }
                break;
            case 28 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:178: Ident
                {
                mIdent(); 


                }
                break;
            case 29 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:184: Int
                {
                mInt(); 


                }
                break;

        }

    }


    protected DFA7 dfa7 = new DFA7(this);
    static final String DFA7_eotS =
        "\1\uffff\1\33\6\uffff\1\35\1\uffff\1\37\1\uffff\1\41\5\30\5\uffff"+
        "\1\30\12\uffff\5\30\1\56\6\30\1\uffff\4\30\1\71\1\30\1\73\3\30\1"+
        "\uffff\1\73\1\uffff\3\30\1\102\1\103\1\30\2\uffff\5\30\1\112\1\uffff";
    static final String DFA7_eofS =
        "\113\uffff";
    static final String DFA7_minS =
        "\1\11\1\75\6\uffff\1\52\1\uffff\1\75\1\uffff\1\75\1\157\1\156\1"+
        "\164\1\141\1\146\5\uffff\1\162\12\uffff\1\157\1\164\2\162\1\154"+
        "\1\60\1\165\1\154\1\145\1\151\1\155\1\163\1\uffff\2\145\1\147\1"+
        "\156\1\60\1\145\1\60\1\141\1\145\1\147\1\uffff\1\60\1\uffff\1\156"+
        "\1\162\1\114\2\60\1\151\2\uffff\1\164\1\145\1\162\1\141\1\154\1"+
        "\60\1\uffff";
    static final String DFA7_maxS =
        "\1\175\1\75\6\uffff\1\52\1\uffff\1\75\1\uffff\1\75\1\157\1\156\1"+
        "\164\1\157\1\146\5\uffff\1\162\12\uffff\1\157\1\164\2\162\1\154"+
        "\1\172\1\165\1\154\1\145\1\151\1\155\1\163\1\uffff\2\145\1\147\1"+
        "\156\1\172\1\145\1\172\1\141\1\145\1\147\1\uffff\1\172\1\uffff\1"+
        "\156\1\162\1\114\2\172\1\151\2\uffff\1\164\1\145\1\162\1\141\1\154"+
        "\1\172\1\uffff";
    static final String DFA7_acceptS =
        "\2\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\12\1\uffff\1\15\6\uffff"+
        "\1\25\1\26\1\27\1\30\1\32\1\uffff\1\34\1\35\1\2\1\1\1\31\1\11\1"+
        "\14\1\13\1\17\1\16\14\uffff\1\24\12\uffff\1\23\1\uffff\1\33\6\uffff"+
        "\1\20\1\21\6\uffff\1\22";
    static final String DFA7_specialS =
        "\113\uffff}>";
    static final String[] DFA7_transitionS = {
            "\2\25\1\uffff\2\25\22\uffff\1\25\1\1\1\26\3\uffff\1\2\1\uffff"+
            "\1\3\1\4\1\5\1\6\1\uffff\1\7\1\uffff\1\10\12\31\1\11\1\uffff"+
            "\1\12\1\13\1\14\2\uffff\1\30\1\15\6\30\1\16\11\30\1\17\7\30"+
            "\6\uffff\5\30\1\20\2\30\1\21\12\30\1\27\6\30\1\22\1\23\1\24",
            "\1\32",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\34",
            "",
            "\1\36",
            "",
            "\1\40",
            "\1\42",
            "\1\43",
            "\1\44",
            "\1\46\15\uffff\1\45",
            "\1\47",
            "",
            "",
            "",
            "",
            "",
            "\1\50",
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
            "\1\51",
            "\1\52",
            "\1\53",
            "\1\54",
            "\1\55",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\1\57",
            "\1\60",
            "\1\61",
            "\1\62",
            "\1\63",
            "\1\64",
            "",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\1\72",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\1\74",
            "\1\75",
            "\1\76",
            "",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "",
            "\1\77",
            "\1\100",
            "\1\101",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\1\104",
            "",
            "",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            ""
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | WS | Comment | StringLiteral | Bool | Ident | Int );";
        }
    }
 

}