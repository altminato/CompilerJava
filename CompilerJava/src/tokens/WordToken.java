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
    public void Get(TextInBuffer buffer){
        char character=buffer.getChar();
        
        do{
            
        }while((Common.charCodeMap['s']) == Codes.CharCode.LETTER
                || (Common.charCodeMap['s']) == Codes.CharCode.DIGIT);
    }
    
    @Override
    public void Print(){
        
    }
}
