/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scanner;

import buffer.TextInBuffer;
import common.Common;
import misc.Codes;
import tokens.Token;

/**
 *
 * @author Antonio
 */
public class TextScanner extends Scanner{
    
    protected TextInBuffer buffer;
    
    public TextScanner(TextInBuffer buffer){
        super();
        this.buffer=buffer;
        initializeCharacterCodeMap();
    }
    
    @Override
    public Token getToken(){
        Token token;
        skipWhiteSpace();
        
        char character=buffer.getCurrentChar();
        
        //If in case we end up ending in a end of LINE character
        if(character==Common.END_OF_LINE){
            character=buffer.getChar();
        }
        
        switch(Common.charCodeMap[character]){
            case LETTER:
                token=wordToken;
                break;
            case DIGIT:
                token=numberToken;
                break;
            case QUOTE:
                token=stringToken;
                break;
            case SPECIAL:
                token=specialToken;
                break;
            case END_OF_FILE:
                token=eofToken;
                break;
            default:
                token=errorToken;
                break;
        }
        token.getToken(buffer);
        return token;
    }
    
    public void skipWhiteSpace(){
        char character=buffer.getCurrentChar();
        if(character==Common.START_OF_FILE){
            character=buffer.getChar();
        }
        
        do{
            if(character == ' ' || character==Common.END_OF_LINE){
                //it is a blank space, get next character
                character=buffer.getChar();
            }
            else if(character=='{'){
                //Skip over the comment
                do{
                    character=buffer.getChar();
                }while((character != '}') && (character != Common.END_OF_FILE));
                
                if(character != Common.END_OF_FILE){
                    character=buffer.getChar();
                }else{
                    //Error(Error.UNEXPECTED_END_OF_FILE)
                }
            }
        }while(character == ' ' || character=='{');
    }
    
    private void initializeCharacterCodeMap(){
        int i;
        for(i=0; i<127; ++i){
            Common.charCodeMap[i]=Codes.CharCode.ERROR;
        }
        
        for (i='a'; i<= 'z'; ++i){
            Common.charCodeMap[i]=Codes.CharCode.LETTER;
        }
        
        for (i='A'; i<= 'Z'; ++i){
            Common.charCodeMap[i]=Codes.CharCode.LETTER;
        }
        
        for (i='0'; i<= '9'; ++i){
            Common.charCodeMap[i]=Codes.CharCode.DIGIT;
        }
        
        Common.charCodeMap['+']=Common.charCodeMap['-']=Codes.CharCode.SPECIAL;
        Common.charCodeMap['*']=Common.charCodeMap['/']=Codes.CharCode.SPECIAL;
        Common.charCodeMap['=']=Common.charCodeMap['^']=Codes.CharCode.SPECIAL;
        Common.charCodeMap['.']=Common.charCodeMap[',']=Codes.CharCode.SPECIAL;
        Common.charCodeMap['<']=Common.charCodeMap['>']=Codes.CharCode.SPECIAL;
        Common.charCodeMap['(']=Common.charCodeMap[')']=Codes.CharCode.SPECIAL;
        Common.charCodeMap['[']=Common.charCodeMap[']']=Codes.CharCode.SPECIAL;
        Common.charCodeMap['{']=Common.charCodeMap['}']=Codes.CharCode.SPECIAL;
        Common.charCodeMap[':']=Common.charCodeMap[';']=Codes.CharCode.SPECIAL;
        Common.charCodeMap[' ']=Common.charCodeMap['\t']=Codes.CharCode.SPECIAL;
        Common.charCodeMap['\n']=Common.charCodeMap['\0']=Codes.CharCode.SPECIAL;
        Common.charCodeMap['\'']=Codes.CharCode.QUOTE;
        Common.charCodeMap[Common.END_OF_FILE]=Codes.CharCode.END_OF_FILE;
        
    }
}
