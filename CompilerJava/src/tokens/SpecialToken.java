/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokens;

import buffer.TextInBuffer;
import common.Common;
import misc.Codes.TokenCode;

/**
 *
 * @author Antonio
 */
public class SpecialToken extends Token{
    public SpecialToken(){
        super();
    }
    
    @Override
    public void getToken(TextInBuffer buffer){
        char character=buffer.getCurrentChar();
        String specialToken="";
        specialToken=character+"";
        
        switch(character){
            case '^': code= TokenCode.UP_ARROW;     buffer.getChar(); break;
            case '*': code= TokenCode.STAR;         buffer.getChar(); break;
            case '(': code= TokenCode.L_PAREN;      buffer.getChar(); break;
            case ')': code= TokenCode.R_PAREN;      buffer.getChar(); break;
            case '-': code= TokenCode.MINUS;        buffer.getChar(); break;
            case '+': code= TokenCode.PLUS;         buffer.getChar(); break;
            case '=': code= TokenCode.EQUAL;        buffer.getChar(); break;
            case '[': code= TokenCode.L_BRACKET;    buffer.getChar(); break;
            case ']': code= TokenCode.R_BRACKET;    buffer.getChar(); break;
            case ';': code= TokenCode.SEMICOLON;    buffer.getChar(); break;
            case ',': code= TokenCode.COMMA;        buffer.getChar(); break;
            case '/': code= TokenCode.SLASH;        buffer.getChar(); break;
            
            case ':': character=buffer.getChar();
            
            if(character == '='){
                specialToken+=character;
                code=TokenCode.COLONEQUAL;
                buffer.getChar();
            }else{
                code=TokenCode.COLON;
            }
            
            break;
            
            case '<': character=buffer.getChar();
            if(character=='='){
                specialToken+=character;
                code=TokenCode.LE;
                buffer.getChar();
            }else if(character=='>'){
                specialToken+=character;
                code = TokenCode.NE;
                buffer.getChar();
            }else{
                code=TokenCode.LT;
            }
            break;
            
            case '>': character=buffer.getChar();
            if(character=='='){
                specialToken+=character;
                code=TokenCode.GE;
                buffer.getChar();
            }else{
                code=TokenCode.GT;
            }
            break;
            
            case '.': character=buffer.getChar();
            if(character=='.'){
                specialToken +=character;
                code=TokenCode.DOTDOT;
                buffer.getChar();
            }else{
                code=TokenCode.PERIOD;
            }
            break;
            
            default: code=TokenCode.ERROR;
            buffer.getChar();
            //Error()
            break;
        }
        string=specialToken;
    }
    
    @Override
    public boolean isDelimiter(){
        return true;
    }
    
    @Override
    public void Print(){
        System.out.println("\t>> special:\t\t"+string);
        Common.getListBuffer().putLine();
    }
}
