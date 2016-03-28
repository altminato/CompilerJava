/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokens;

import buffer.TextInBuffer;
import common.*;
import misc.Codes;

/**
 *
 * @author Antonio
 */
public class WordToken extends Token {
    public WordToken(){
        super();
    }
    
    @Override
    public void getToken(TextInBuffer buffer){
        char character=buffer.getCurrentChar();
        String temporalWord="";
        temporalWord+=character;
        do{
            character=buffer.getCurrentChar();
            temporalWord+=character;
        }while((Common.charCodeMap[character]) == Codes.CharCode.LETTER
                || (Common.charCodeMap[character]) == Codes.CharCode.DIGIT);
        
        string=temporalWord;
        code=Codes.TokenCode.WORD;
    }
    
    @Override
    public void Print(){
        System.out.println(getList().getText()+"\t word: "+string);
        getList().putLine();
    }
}
