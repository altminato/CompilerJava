/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokens;

import buffer.TextInBuffer;
import common.*;
import misc.Codes;
import misc.Codes.TokenCode;

/**
 *
 * @author Antonio
 */
public class WordToken extends Token {
    
    public static final int MIN_RES_WORD_LENGTH=2;
    public static final int MAX_RES_WORD_LENGTH=9;
    
    public static class ReservedWord{
        private String word;
        private TokenCode code;
        
        public ReservedWord(String word, TokenCode code){
            this.word=word;
            this.code=code;
        }
        
        public String getWord(){
            return word;
        }
        
        public TokenCode getCode(){
            return code;
        }
    }
    
    public static final ReservedWord[] RESERVED_WORD_ROW_2={
        new ReservedWord("do", TokenCode.DO), new ReservedWord("if", TokenCode.IF), new ReservedWord("in", TokenCode.IN), new ReservedWord("of", TokenCode.OF),
        new ReservedWord("or", TokenCode.OR), new ReservedWord("to", TokenCode.TO)
    };
    
    public static final ReservedWord[] RESERVED_WORD_ROW_3={
        new ReservedWord("and", TokenCode.AND), new ReservedWord("div", TokenCode.DIV), new ReservedWord("end", TokenCode.END), new ReservedWord("for", TokenCode.FOR),
        new ReservedWord("mod", TokenCode.MOD), new ReservedWord("nil", TokenCode.NIL), new ReservedWord("not", TokenCode.NOT), new ReservedWord("set", TokenCode.SET),
        new ReservedWord("var", TokenCode.VAR)
    };
    
    public static final ReservedWord[] RESERVED_WORD_ROW_4={
        new ReservedWord("case", TokenCode.CASE), new ReservedWord("else", TokenCode.ELSE), new ReservedWord("file", TokenCode.TYPE),
        new ReservedWord("goto", TokenCode.GOTO), new ReservedWord("then", TokenCode.THEN), new ReservedWord("type", TokenCode.FILE),
        new ReservedWord("with", TokenCode.WITH)
    };
    
    public static final ReservedWord[] RESERVED_WORD_ROW_5={
        new ReservedWord("array", TokenCode.ARRAY), new ReservedWord("begin", TokenCode.BEGIN), new ReservedWord("const", TokenCode.CONST),
        new ReservedWord("label", TokenCode.LABEL), new ReservedWord("until", TokenCode.UNTIL), new ReservedWord("while", TokenCode.WHILE)
    };
    
    public static final ReservedWord[] RESERVED_WORD_ROW_6={
        new ReservedWord("downto", TokenCode.DOWNTO), new ReservedWord("packed", TokenCode.PACKED), new ReservedWord("record", TokenCode.RECORD),
        new ReservedWord("repeat", TokenCode.REPEAT)
    };
    
    public static final ReservedWord[] RESERVED_WORD_ROW_7={
        new ReservedWord("program", TokenCode.PROGRAM)
    };
    
    public static final ReservedWord[] RESERVED_WORD_ROW_8={
        new ReservedWord("function", TokenCode.FUNCTION)
    };
    
    public static final ReservedWord[] RESERVED_WORD_ROW_9={
        new ReservedWord("procedure", TokenCode.PROCEDURE)
    };
    
    public static final ReservedWord[][] RESERVED_WORD_TABLE={
        null,null,RESERVED_WORD_ROW_2,RESERVED_WORD_ROW_3,RESERVED_WORD_ROW_4,RESERVED_WORD_ROW_5,RESERVED_WORD_ROW_6,RESERVED_WORD_ROW_7,RESERVED_WORD_ROW_8,RESERVED_WORD_ROW_9
    };
    
    
    
    public WordToken(){
        super();
    }

    @Override
    public void getToken(TextInBuffer buffer){
        char character=buffer.getCurrentChar();
        String temporalWord="";
        
        do{
            temporalWord+=character;
            character=buffer.getChar();
        }while((Common.charCodeMap[character]) == Codes.CharCode.LETTER
                || (Common.charCodeMap[character]) == Codes.CharCode.DIGIT);
        
        string=temporalWord;
        
        checkForReservedWord();
    }
    
    @Override
    public boolean isDelimiter(){
        return false;
    }

    @Override
    public void Print(){
        if(code== TokenCode.IDENTIFIER){
            System.out.println("\t>> identifier:\t\t"+string);
        }else{
            System.out.println("\t>> reserved word:\t\t"+string);
        }
        Common.getListBuffer().putLine();
    }
    
    private void checkForReservedWord(){
        int length=string.length();
        ReservedWord reservedWord;
        
        if(length >= MIN_RES_WORD_LENGTH && length <= MAX_RES_WORD_LENGTH){
            //It has a valid lenght
            ReservedWord[] reservedWordRow=RESERVED_WORD_TABLE[length];
            
            for(ReservedWord rWord:reservedWordRow){
                
                if(rWord.getWord().equals(string)){
                    code=rWord.getCode();
                    return;
                }
            }
        }
    }
}